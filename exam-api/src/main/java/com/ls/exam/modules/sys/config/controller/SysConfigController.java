package com.ls.exam.modules.sys.config.controller;

import com.ls.exam.core.api.ApiRest;
import com.ls.exam.core.api.controller.BaseController;
import com.ls.exam.core.api.dto.BaseIdRespDTO;
import com.ls.exam.core.utils.BeanMapper;
import com.ls.exam.modules.sys.config.dto.SysConfigDTO;
import com.ls.exam.modules.sys.config.entity.SysConfig;
import com.ls.exam.modules.sys.config.service.SysConfigService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
* <p>
* 通用配置控制器
* </p>
*
* 
* 
*/
@Api(tags={"通用配置"})
@RestController
@RequestMapping("/exam/api/sys/config")
public class SysConfigController extends BaseController {

    @Autowired
    private SysConfigService baseService;

    /**
    * 添加或修改
    * @param reqDTO
    * @return
    */
    @ApiOperation(value = "添加或修改")
    @RequestMapping(value = "/save", method = { RequestMethod.POST})
    public ApiRest<BaseIdRespDTO> save(@RequestBody SysConfigDTO reqDTO) {
        //复制参数
        SysConfig entity = new SysConfig();
        BeanMapper.copy(reqDTO, entity);
        baseService.saveOrUpdate(entity);
        return super.success(new BaseIdRespDTO(entity.getId()));
    }

    /**
    * 查找详情
    * @return
    */
    @ApiOperation(value = "查找详情")
    @RequestMapping(value = "/detail", method = { RequestMethod.POST})
    public ApiRest<SysConfigDTO> find() {
        SysConfigDTO dto = baseService.find();
        return super.success(dto);
    }
}
