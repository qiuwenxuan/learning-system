package com.ls.exam.modules.user.exam.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ls.exam.core.api.dto.PagingReqDTO;
import com.ls.exam.modules.sys.user.entity.SysUser;
import com.ls.exam.modules.sys.user.service.SysUserService;
import com.ls.exam.modules.user.exam.entity.UserComment;
import com.ls.exam.modules.user.exam.entity.UserPost;
import com.ls.exam.modules.user.exam.mapper.UserPostMapper;
import com.ls.exam.modules.user.exam.service.UserCommentService;
import com.ls.exam.modules.user.exam.service.UserPostService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserPostServiceImpl extends ServiceImpl<UserPostMapper, UserPost> implements
    UserPostService {

    @Autowired
    private UserCommentService userCommentService;

    @Autowired
    private SysUserService sysUserService;



    @Override
    public IPage<UserPost> paging(PagingReqDTO<UserPost> reqDTO) {
        UserPost params= reqDTO.getParams();
        IPage<UserPost> iPage = this.page(reqDTO.toPage(), new QueryWrapper<UserPost>()
            .eq(params.getUserId() != null, "user_id", params.getUserId())
            .like(StringUtils.isNotBlank(params.getTitle()), "title", params.getTitle())
            .orderByDesc("create_time"));

        // 统计每个话题的评论数量和作者信息并添加到话题对象中
        for (UserPost post : iPage.getRecords()) {
            Integer commentCount = userCommentService.count(new QueryWrapper<UserComment>()
                .eq("post_id", post.getId()));
            post.setCommentCount(commentCount);

            // 查询用户信息
            SysUser author = sysUserService.getById(post.getUserId());
            post.setAuthor(author);
        }

        return iPage;
     }


}
