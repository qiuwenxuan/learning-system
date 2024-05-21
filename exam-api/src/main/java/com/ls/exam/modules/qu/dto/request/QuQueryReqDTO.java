package com.ls.exam.modules.qu.dto.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
* <p>
* 问题题目请求类
* </p>
*
* 
* 
*/
@Data
@ApiModel(value="题目查询请求类", description="题目查询请求类")
public class QuQueryReqDTO implements Serializable {

    private static final long serialVersionUID = 1L;


    @ApiModelProperty(value = "题目类型")
    private Integer quType;

    @ApiModelProperty(value = "归属题库")
    private List<String> repoIds;

    @ApiModelProperty(value = "题目内容")
    private String content;

    @ApiModelProperty(value = "排除ID列表")
    private List<String> excludes;

    
}
