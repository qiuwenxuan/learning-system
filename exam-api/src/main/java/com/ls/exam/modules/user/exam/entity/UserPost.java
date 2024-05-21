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
* 话题表
* </p>
*
* 
* 
*/
@Data
@TableName("el_user_post")
public class UserPost extends Model<UserPost> {

    private static final long serialVersionUID = 1L;
    
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private String id;
    
    /**
    * 用户ID
    */
    @TableField("user_id")
    private String userId;

    /**
     * 话题标题
     */
    @TableField("title")
    private String title;

    /**
     * 话题内容
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
     * 评论数量
     */
    @TableField(exist = false)
    private Integer commentCount;

    /**
     * 发布人
     */
    @TableField(exist = false)
    private SysUser author;
    
}
