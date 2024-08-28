package com.divination.service;

import com.divination.domain.dto.UserBirthDTO;
import com.divination.domain.dto.UserTimeDTO;
import com.divination.domain.vo.EightGodTimeVO;
import com.divination.domain.vo.EightGodVO;
import com.divination.util.JsonResult;

public interface EightGodService {

    /**
     * 八字测算
     * @param userBirthDTO 八字入参
     * @return
     */
    JsonResult<EightGodVO> getEightGodCount(UserBirthDTO userBirthDTO);

    /**
     * 获取大运
     * @param timeDTO 大运入参
     * @return
     */
    JsonResult<EightGodTimeVO> getEightGodTime(UserTimeDTO timeDTO);
}
