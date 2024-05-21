package com.ls.exam.modules.user.exam.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.ls.exam.modules.sys.user.entity.SysUser;
import java.util.Date;
import lombok.Data;

/**
* <p>
* 评论记录表
* </p>
*
* 
* 
*/
@Data
@TableName("el_user_comment")
public class UserComment extends Model<UserComment> {

    private static final long serialVersionUID = 1L;
    
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private String id;
    
    /**
    * 用户ID
    */
    @TableField("user_id")
    private String userId;

    /**
     * 话题ID
     */
    @TableField("post_id")
    private String postId;

    /**
     * 回复对象的用户ID
     */
    @TableField("reply_to_user_id")
    private String replyToUserId;


    /**
     * 内容
     */
    @TableField("content")
    private String content;
    
    /**
    * 创建时间
    */
    @TableField("create_time")
    private Date createTime;
    
    /**
    * 更新时间
    */
    @TableField("update_time")
    private Date updateTime;

    /**
     * 回复对象的用户信息
     */
    @TableField(exist = false)
    private SysUser replyToUser;

    /**
     * 发布人
     */
    @TableField(exist = false)
    private SysUser author;
    
}
