package com.ls.exam.modules.paper.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ls.exam.core.api.dto.PagingReqDTO;
import com.ls.exam.modules.paper.dto.PaperQuAnswerDTO;
import com.ls.exam.modules.paper.dto.ext.PaperQuAnswerExtDTO;
import com.ls.exam.modules.paper.entity.PaperQuAnswer;

import java.util.List;

/**
* <p>
* 试卷考题备选答案业务类
* </p>
*
* 
* 
*/
public interface PaperQuAnswerService extends IService<PaperQuAnswer> {

    /**
    * 分页查询数据
    * @param reqDTO
    * @return
    */
    IPage<PaperQuAnswerDTO> paging(PagingReqDTO<PaperQuAnswerDTO> reqDTO);

    /**
     * 查找试卷试题答案列表
     * @param paperId
     * @param quId
     * @return
     */
    List<PaperQuAnswerExtDTO> listForExam(String paperId, String quId);

    /**
     * 查找答案列表，用来填充
     * @param paperId
     * @param quId
     * @return
     */
    List<PaperQuAnswer> listForFill(String paperId, String quId);
}
