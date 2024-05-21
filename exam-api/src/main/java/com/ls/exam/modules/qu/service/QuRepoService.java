package com.ls.exam.modules.qu.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ls.exam.core.api.dto.PagingReqDTO;
import com.ls.exam.modules.qu.dto.QuRepoDTO;
import com.ls.exam.modules.qu.dto.request.QuRepoBatchReqDTO;
import com.ls.exam.modules.qu.entity.QuRepo;

import java.util.List;

/**
* <p>
* 试题题库业务类
* </p>
*
* 
* 
*/
public interface QuRepoService extends IService<QuRepo> {

    /**
    * 分页查询数据
    * @param reqDTO
    * @return
    */
    IPage<QuRepoDTO> paging(PagingReqDTO<QuRepoDTO> reqDTO);

    /**
     * 保存全部列表
     * @param quId
     * @param quType
     * @param ids
     */
    void saveAll(String quId, Integer quType, List<String> ids);

    /**
     * 根据问题查找题库
     * @param quId
     * @return
     */
    List<String> listByQu(String quId);

    /**
     * 根据题库查找题目ID列表
     * @param repoId
     * @param quType
     * @param rand
     * @return
     */
    List<String> listByRepo(String repoId, Integer quType, boolean rand);

    /**
     * 批量操作
     * @param reqDTO
     */
    void batchAction(QuRepoBatchReqDTO reqDTO);

}
