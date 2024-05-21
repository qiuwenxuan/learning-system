package com.ls.exam.modules.user.exam.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ls.exam.core.api.dto.PagingReqDTO;
import com.ls.exam.modules.user.exam.entity.UserLearningPlan;

/**
* <p>
* 用户学习规划
* </p>
*
* 
* 
*/
public interface UserLearningPlanService extends IService<UserLearningPlan> {

    /**
    * 分页查询数据
    * @param reqDTO
    * @return
    */
    IPage<UserLearningPlan> paging(PagingReqDTO<UserLearningPlan> reqDTO);

}
