package com.ls.exam.modules.sys.config.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ls.exam.modules.sys.config.dto.SysConfigDTO;
import com.ls.exam.modules.sys.config.entity.SysConfig;

/**
* <p>
* 通用配置业务类
* </p>
*
* 
* 
*/
public interface SysConfigService extends IService<SysConfig> {

    /**
     * 查找配置信息
     * @return
     */
    SysConfigDTO find();
}
