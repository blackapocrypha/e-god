package com.divination.controller;


import com.divination.domain.dto.UserBirthDTO;
import com.divination.domain.dto.UserTimeDTO;
import com.divination.domain.vo.EightGodTimeVO;
import com.divination.domain.vo.EightGodVO;
import com.divination.service.EightGodService;
import com.divination.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@CrossOrigin
public class DivinationController {

    @Autowired
    private EightGodService eightGodService;

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
     * 排大运
     * @param timeDTO   大运入参
     * @return JsonResult<EightGodVO> 大运信息
     */
    @GetMapping("/getLucky")
    public JsonResult<EightGodTimeVO> getEightTime(@ModelAttribute UserTimeDTO timeDTO){
        return eightGodService.getEightGodTime(timeDTO);
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
