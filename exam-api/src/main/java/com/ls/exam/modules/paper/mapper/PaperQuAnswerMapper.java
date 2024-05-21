package com.ls.exam.modules.paper.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ls.exam.modules.paper.dto.ext.PaperQuAnswerExtDTO;
import com.ls.exam.modules.paper.entity.PaperQuAnswer;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* <p>
* 试卷考题备选答案Mapper
* </p>
*
* 
* 
*/
public interface PaperQuAnswerMapper extends BaseMapper<PaperQuAnswer> {

    /**
     * 查找试卷试题答案列表
     * @param paperId
     * @param quId
     * @return
     */
    List<PaperQuAnswerExtDTO> list(@Param("paperId") String paperId, @Param("quId") String quId);
}
