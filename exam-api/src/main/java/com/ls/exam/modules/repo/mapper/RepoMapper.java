package com.ls.exam.modules.repo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ls.exam.modules.repo.dto.request.RepoReqDTO;
import com.ls.exam.modules.repo.dto.response.RepoRespDTO;
import com.ls.exam.modules.repo.entity.Repo;
import org.apache.ibatis.annotations.Param;

/**
* <p>
* 题库Mapper
* </p>
*
* 
* 
*/
public interface RepoMapper extends BaseMapper<Repo> {

    /**
     * 分页查询题库
     * @param page
     * @param query
     * @return
     */
    IPage<RepoRespDTO> paging(Page page, @Param("query") RepoReqDTO query);

}
