package com.ls.exam.modules.user.exam.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ls.exam.core.api.dto.PagingReqDTO;
import com.ls.exam.modules.user.exam.entity.UserComment;

/**
* <p>
* 评论记录
* </p>
*
* 
* 
*/
public interface UserCommentService extends IService<UserComment> {

    /**
    * 分页查询数据
    * @param reqDTO
    * @return
    */
    IPage<UserComment> paging(PagingReqDTO<UserComment> reqDTO);

}
