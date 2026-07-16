package com.divination.controller;


import com.alibaba.fastjson.JSON;
import com.divination.domain.dto.UserBirthDTO;
import com.divination.domain.dto.UserTimeDTO;
import com.divination.domain.vo.EightGodTimeVO;
import com.divination.domain.vo.EightGodVO;
import com.divination.domain.vo.FullYearMonthDaysVO;
import com.divination.service.AssistantService;
import com.divination.service.EightGodService;
import com.divination.util.JsonResult;
import com.divination.util.LunarCalendarUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@CrossOrigin
public class DivinationController {

    @Autowired
    private EightGodService eightGodService;

    @Autowired
    private AssistantService assistantService;


    /**
     * 获取八字
     * @param userBirthDTO 生辰入参
     * @return JsonResult<EightGodVO> 八字信息
     */
    @GetMapping("/getEight")
    public JsonResult<EightGodVO> getEight(@ModelAttribute UserBirthDTO userBirthDTO){
        return eightGodService.getEightGodCount(userBirthDTO);
    }

    /**
     * 排大运流年
     * @param timeDTO   大运入参
     * @return JsonResult<EightGodVO> 大运信息
     */
    @GetMapping("/getLucky")
    public JsonResult<EightGodTimeVO> getEightTime(@ModelAttribute UserTimeDTO timeDTO){
        return eightGodService.getEightGodTime(timeDTO);
    }

    /**
     * 聊天
     * @param userBirthDTO 用户数据
     * @return String 响应
     */
    @GetMapping(value = "/chat", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<String> chat(@ModelAttribute UserBirthDTO userBirthDTO) {
        // 1. 获取八字数据
        JsonResult<EightGodVO> result = eightGodService.getEightGodCount(userBirthDTO);
        if (!result.isSuccess()) {
            // 如果失败，直接返回一个包含错误信息的单元素 Flux
            return Flux.just("调用失败");
        }

        // 2. 构建问题
        String question = JSON.toJSONString(result.getData()) + "这是我的结构化数据，请根据这个信息简单批一下这个八字的性格、婚姻、财富、健康等情况";

        return assistantService.chatStreamWithEightMaster(question);
    }

    /**
     * 获取选定年份全部的流月流日
     * @param year 年份
     * @return JsonResult<List<FullYearMonthDaysVO>> 流月流日
     */
    @GetMapping("/getFullYearMonthDays")
    public JsonResult<List<FullYearMonthDaysVO>> getFullYearMonthDays(@RequestParam(value = "year") Integer year){
        JsonResult<List<FullYearMonthDaysVO>> result = new JsonResult<>();
        result.buildTrue();
        result.setData(LunarCalendarUtil.getFullYearMonthDays(year));
        return result;
    }



    /**
     * 表单提交 Date类型数据绑定
     * <功能详细描述>
     *
     * @param binder 网页数据绑定
     * @see [类、类#方法、类#成员]
     */
    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

}
