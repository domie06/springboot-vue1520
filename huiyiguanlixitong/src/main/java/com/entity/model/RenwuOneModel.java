package com.entity.model;

import com.entity.RenwuOneEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 任务管理
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 * @author 
 * @email
 * @date 2021-03-16
 */
public class RenwuOneModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 发布人
     */
    private Integer fabuyonghuId;


    /**
     * 接收人
     */
    private Integer jieshouyonghuId;


    /**
     * 任务类型
     */
    private Integer renwuOneTypes;


    /**
     * 任务内容
     */
    private String renwuOneContent;


    /**
     * 接收人是否查看
     */
    private Integer chakanTypes;


    /**
     * 添加时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 设置：主键
	 */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：发布人
	 */
    public Integer getFabuyonghuId() {
        return fabuyonghuId;
    }


    /**
	 * 设置：发布人
	 */
    public void setFabuyonghuId(Integer fabuyonghuId) {
        this.fabuyonghuId = fabuyonghuId;
    }
    /**
	 * 获取：接收人
	 */
    public Integer getJieshouyonghuId() {
        return jieshouyonghuId;
    }


    /**
	 * 设置：接收人
	 */
    public void setJieshouyonghuId(Integer jieshouyonghuId) {
        this.jieshouyonghuId = jieshouyonghuId;
    }
    /**
	 * 获取：任务类型
	 */
    public Integer getRenwuOneTypes() {
        return renwuOneTypes;
    }


    /**
	 * 设置：任务类型
	 */
    public void setRenwuOneTypes(Integer renwuOneTypes) {
        this.renwuOneTypes = renwuOneTypes;
    }
    /**
	 * 获取：任务内容
	 */
    public String getRenwuOneContent() {
        return renwuOneContent;
    }


    /**
	 * 设置：任务内容
	 */
    public void setRenwuOneContent(String renwuOneContent) {
        this.renwuOneContent = renwuOneContent;
    }
    /**
	 * 获取：接收人是否查看
	 */
    public Integer getChakanTypes() {
        return chakanTypes;
    }


    /**
	 * 设置：接收人是否查看
	 */
    public void setChakanTypes(Integer chakanTypes) {
        this.chakanTypes = chakanTypes;
    }
    /**
	 * 获取：添加时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：添加时间
	 */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
