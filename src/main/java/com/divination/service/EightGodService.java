package com.divination.service;

import com.divination.domain.dto.UserBirthDTO;
import com.divination.domain.vo.EightGodVO;
import com.divination.util.JsonResult;

public interface EightGodService {

    /**
     * 八字测算
     * @param query
     * @return
     */
    JsonResult<EightGodVO> getEightGodCount(UserBirthDTO userBirthDTO);
}
