package com.ls.exam.modules.user.exam.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ls.exam.core.api.dto.PagingReqDTO;
import com.ls.exam.modules.user.exam.entity.UserPost;

/**
* <p>
* 话题
* </p>
*
* 
* 
*/
public interface UserPostService extends IService<UserPost> {

    /**
    * 分页查询数据
    * @param reqDTO
    * @return
    */
    IPage<UserPost> paging(PagingReqDTO<UserPost> reqDTO);

}
