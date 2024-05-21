package com.ls.exam.modules.user.exam.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ls.exam.core.api.dto.PagingReqDTO;
import com.ls.exam.modules.user.exam.entity.UserLearningPlan;
import com.ls.exam.modules.user.exam.mapper.UserLearningPlanMapper;
import com.ls.exam.modules.user.exam.service.UserLearningPlanService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;


@Service
public class UserLearningPlanServiceImpl extends ServiceImpl<UserLearningPlanMapper, UserLearningPlan> implements
    UserLearningPlanService {

    @Override
    public IPage<UserLearningPlan> paging(PagingReqDTO<UserLearningPlan> reqDTO) {
        UserLearningPlan params= reqDTO.getParams();
        return this.page(reqDTO.toPage(), new QueryWrapper<UserLearningPlan>()
            .eq(reqDTO.getUserId() != null, "user_id", reqDTO.getUserId())
            .like(StringUtils.isNotBlank(params.getPlanName()), "plan_name", params.getPlanName())
            .orderByDesc("create_time"));
     }


}
