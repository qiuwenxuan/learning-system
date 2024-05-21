package com.ls.exam.modules.repo.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ls.exam.core.api.dto.PagingReqDTO;
import com.ls.exam.modules.repo.dto.RepoDTO;
import com.ls.exam.modules.repo.dto.request.RepoReqDTO;
import com.ls.exam.modules.repo.dto.response.RepoRespDTO;
import com.ls.exam.modules.repo.entity.Repo;

/**
* <p>
* 题库业务类
* </p>
*
* 
* 
*/
public interface RepoService extends IService<Repo> {

    /**
    * 分页查询数据
    * @param reqDTO
    * @return
    */
    IPage<RepoRespDTO> paging(PagingReqDTO<RepoReqDTO> reqDTO);


    /**
     * 保存
     * @param reqDTO
     */
    void save(RepoDTO reqDTO);
}
