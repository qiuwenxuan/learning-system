package com.ls.exam.modules.exam.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ls.exam.modules.exam.dto.ext.ExamRepoExtDTO;
import com.ls.exam.modules.exam.entity.ExamRepo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* <p>
* 考试题库Mapper
* </p>
*
* 
* 
*/
public interface ExamRepoMapper extends BaseMapper<ExamRepo> {

    /**
     * 查找考试题库列表
     * @param examId
     * @return
     */
    List<ExamRepoExtDTO> listByExam(@Param("examId") String examId);
}
