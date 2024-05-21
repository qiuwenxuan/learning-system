package com.ls.exam.modules.user.exam.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.util.Date;
import lombok.Data;

/**
* <p>
* 用户学习规划实体类
* </p>
*
* 
* 
*/
@Data
@TableName("el_user_learning_plan")
public class UserLearningPlan extends Model<UserLearningPlan> {

    private static final long serialVersionUID = 1L;
    
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private String id;
    
    /**
    * 用户ID
    */
    @TableField("user_id")
    private String userId;


    /**
    * 规划名称
     */
    @TableField("plan_name")
    private String planName;
    /**
     * 规划描述
     */
    @TableField("description")
    private String description;
    /**
     * 开始日期
     */
    @TableField("start_date")
    private Date startDate;
    /**
     * 结束日期
     */
    @TableField("end_date")
    private Date endDate;
    /**
     * 完成状态，0表示未完成，1表示已完成
     */
    @TableField("completion_status")
    private Integer completionStatus;
    /**
     * 完成时间
     */
    @TableField("completion_time")
    private Date completionTime;


    
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
    
}
