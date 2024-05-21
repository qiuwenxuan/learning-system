package com.ls.exam.ability.upload.service;

import com.ls.exam.ability.upload.dto.UploadReqDTO;
import com.ls.exam.ability.upload.dto.UploadRespDTO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 阿里云OSS业务类
 * 
 * 
 */
public interface UploadService {

    /**
     * 文件上传
     * @param reqDTO
     * @return
     */
    UploadRespDTO upload(UploadReqDTO reqDTO);

    /**
     * 下载文件
     * @param request
     * @param response
     */
    void download(HttpServletRequest request, HttpServletResponse response);

}
