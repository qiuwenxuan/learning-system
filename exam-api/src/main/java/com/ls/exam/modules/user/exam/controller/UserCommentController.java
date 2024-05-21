package com.ls.exam.modules.user.exam.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ls.exam.core.api.ApiRest;
import com.ls.exam.core.api.controller.BaseController;
import com.ls.exam.core.api.dto.BaseIdReqDTO;
import com.ls.exam.core.api.dto.BaseIdsReqDTO;
import com.ls.exam.core.api.dto.PagingReqDTO;
import com.ls.exam.modules.user.UserUtils;
import com.ls.exam.modules.user.exam.entity.UserComment;
import com.ls.exam.modules.user.exam.service.UserCommentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
* <p>
* 评论记录
* </p>
*
* 
* 
*/
@Api(tags={"评论记录"})
@RestController
@RequestMapping("/exam/api/userComment")
public class UserCommentController extends BaseController {

    @Autowired
    private UserCommentService baseService;


    /**
     * 分页查找
     * @param reqDTO reqDTO
     * @return ApiRest<IPage<UserPost>>
     */
    @ApiOperation(value = "分页查找")
    @RequestMapping(value = "/paging", method = { RequestMethod.POST})
    public ApiRest<IPage<UserComment>> paging(@RequestBody PagingReqDTO<UserComment> reqDTO) {
        //分页查询并转换
        IPage<UserComment> page = baseService.paging(reqDTO);
        return super.success(page);
    }

    /**
     * 批量删除
     * @param reqDTO reqDTO
     * @return ApiRest<Void>
     */
    @ApiOperation(value = "批量删除")
    @RequestMapping(value = "/delete", method = { RequestMethod.POST})
    public ApiRest<Void> edit(@RequestBody BaseIdsReqDTO reqDTO) {
        //根据ID删除
        baseService.removeByIds(reqDTO.getIds());
        return super.success();
    }

    /**
     * 查找详情
     * @param reqDTO reqDTO
     * @return ApiRest<UserPost>
     */
    @ApiOperation(value = "查找详情")
    @RequestMapping(value = "/detail", method = { RequestMethod.POST})
    public ApiRest<UserComment> find(@RequestBody BaseIdReqDTO reqDTO) {
        UserComment entity = baseService.getById(reqDTO.getId());
        return super.success(entity);
    }

    /**
     * 添加或修改
     * @param reqDTO reqDTO
     * @return ApiRest<Void>
     */
    @ApiOperation(value = "添加或修改")
    @RequestMapping(value = "/save", method = { RequestMethod.POST})
    public ApiRest<Void> save(@RequestBody UserComment reqDTO) {
        if(reqDTO.getId()!=null) {
            // 修改
            baseService.updateById(reqDTO);
        } else {
            // 关联当前用户id
            reqDTO.setUserId(UserUtils.getUserId());
            baseService.save(reqDTO);
        }
        return super.success();
    }


}
