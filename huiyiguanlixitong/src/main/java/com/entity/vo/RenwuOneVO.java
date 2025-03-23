package com.entity.vo;

import com.entity.RenwuOneEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 任务管理
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 * @author 
 * @email
 * @date 2021-03-16
 */
@TableName("renwu_one")
public class RenwuOneVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 发布人
     */

    @TableField(value = "fabuyonghu_id")
    private Integer fabuyonghuId;


    /**
     * 接收人
     */

    @TableField(value = "jieshouyonghu_id")
    private Integer jieshouyonghuId;


    /**
     * 任务类型
     */

    @TableField(value = "renwu_one_types")
    private Integer renwuOneTypes;


    /**
     * 任务内容
     */

    @TableField(value = "renwu_one_content")
    private String renwuOneContent;


    /**
     * 接收人是否查看
     */

    @TableField(value = "chakan_types")
    private Integer chakanTypes;


    /**
     * 添加时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：发布人
	 */
    public Integer getFabuyonghuId() {
        return fabuyonghuId;
    }


    /**
	 * 获取：发布人
	 */

    public void setFabuyonghuId(Integer fabuyonghuId) {
        this.fabuyonghuId = fabuyonghuId;
    }
    /**
	 * 设置：接收人
	 */
    public Integer getJieshouyonghuId() {
        return jieshouyonghuId;
    }


    /**
	 * 获取：接收人
	 */

    public void setJieshouyonghuId(Integer jieshouyonghuId) {
        this.jieshouyonghuId = jieshouyonghuId;
    }
    /**
	 * 设置：任务类型
	 */
    public Integer getRenwuOneTypes() {
        return renwuOneTypes;
    }


    /**
	 * 获取：任务类型
	 */

    public void setRenwuOneTypes(Integer renwuOneTypes) {
        this.renwuOneTypes = renwuOneTypes;
    }
    /**
	 * 设置：任务内容
	 */
    public String getRenwuOneContent() {
        return renwuOneContent;
    }


    /**
	 * 获取：任务内容
	 */

    public void setRenwuOneContent(String renwuOneContent) {
        this.renwuOneContent = renwuOneContent;
    }
    /**
	 * 设置：接收人是否查看
	 */
    public Integer getChakanTypes() {
        return chakanTypes;
    }


    /**
	 * 获取：接收人是否查看
	 */

    public void setChakanTypes(Integer chakanTypes) {
        this.chakanTypes = chakanTypes;
    }
    /**
	 * 设置：添加时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：添加时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
