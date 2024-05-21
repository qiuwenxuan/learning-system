package com.ls.exam.modules.user.exam.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ls.exam.core.api.dto.PagingReqDTO;
import com.ls.exam.modules.sys.user.entity.SysUser;
import com.ls.exam.modules.sys.user.service.SysUserService;
import com.ls.exam.modules.user.exam.entity.UserComment;
import com.ls.exam.modules.user.exam.mapper.UserCommentMapper;
import com.ls.exam.modules.user.exam.service.UserCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserCommentServiceImpl extends ServiceImpl<UserCommentMapper, UserComment> implements
    UserCommentService {

    @Autowired
    private SysUserService sysUserService;

    @Override
    public IPage<UserComment> paging(PagingReqDTO<UserComment> reqDTO) {
        UserComment params= reqDTO.getParams();
        IPage<UserComment> iPage = this.page(reqDTO.toPage(), new QueryWrapper<UserComment>()
            .eq(params.getUserId() != null, "user_id", params.getUserId())
            .eq(params.getReplyToUserId() != null, "reply_to_user_id", params.getReplyToUserId())
            .eq(params.getPostId() != null, "post_id", params.getPostId())
            .orderByDesc("create_time"));

        // 补全回复对象的用户信息
        for (UserComment comment : iPage.getRecords()) {
            if (comment.getReplyToUserId() != null) {
                // 查询回复对象的用户信息
                SysUser replyToUser = sysUserService.getById(comment.getReplyToUserId());
                // 设置回复对象的用户信息到评论对象中
                comment.setReplyToUser(replyToUser);

                // 查询用户信息
                SysUser author = sysUserService.getById(comment.getUserId());
                comment.setAuthor(author);
            }
        }

        return iPage;
     }


}
