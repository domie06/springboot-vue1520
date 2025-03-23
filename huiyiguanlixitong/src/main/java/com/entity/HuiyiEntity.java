package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * 会议管理
 *
 * @author 
 * @email
 * @date 2021-03-16
 */
@TableName("huiyi")
public class HuiyiEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public HuiyiEntity() {

	}

	public HuiyiEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @TableField(value = "id")

    private Integer id;


    /**
     * 会议室
     */
    @TableField(value = "huiyishi_types")

    private Integer huiyishiTypes;


    /**
     * 会议名
     */
    @TableField(value = "huiyi_name")

    private String huiyiName;


    /**
     * 会议缘由
     */
    @TableField(value = "huiyiyuanyou_content")

    private String huiyiyuanyouContent;


    /**
     * 会议发起人id
     */
    @TableField(value = "yonghu_id")

    private Integer yonghuId;


    /**
     * 会议状态
     */
    @TableField(value = "huiyi_types")

    private Integer huiyiTypes;


    /**
     * 会议内容
     */
    @TableField(value = "huiyi_content")

    private String huiyiContent;


    /**
     * 会议开始时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "kaishi_time",fill = FieldFill.UPDATE)

    private Date kaishiTime;


    /**
     * 会议结束时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "jieshu_time",fill = FieldFill.UPDATE)

    private Date jieshuTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "create_time",fill = FieldFill.INSERT)

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
	 * 设置：会议室
	 */
    public Integer getHuiyishiTypes() {
        return huiyishiTypes;
    }


    /**
	 * 获取：会议室
	 */

    public void setHuiyishiTypes(Integer huiyishiTypes) {
        this.huiyishiTypes = huiyishiTypes;
    }
    /**
	 * 设置：会议名
	 */
    public String getHuiyiName() {
        return huiyiName;
    }


    /**
	 * 获取：会议名
	 */

    public void setHuiyiName(String huiyiName) {
        this.huiyiName = huiyiName;
    }
    /**
	 * 设置：会议缘由
	 */
    public String getHuiyiyuanyouContent() {
        return huiyiyuanyouContent;
    }


    /**
	 * 获取：会议缘由
	 */

    public void setHuiyiyuanyouContent(String huiyiyuanyouContent) {
        this.huiyiyuanyouContent = huiyiyuanyouContent;
    }
    /**
	 * 设置：会议发起人id
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 获取：会议发起人id
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 设置：会议状态
	 */
    public Integer getHuiyiTypes() {
        return huiyiTypes;
    }


    /**
	 * 获取：会议状态
	 */

    public void setHuiyiTypes(Integer huiyiTypes) {
        this.huiyiTypes = huiyiTypes;
    }
    /**
	 * 设置：会议内容
	 */
    public String getHuiyiContent() {
        return huiyiContent;
    }


    /**
	 * 获取：会议内容
	 */

    public void setHuiyiContent(String huiyiContent) {
        this.huiyiContent = huiyiContent;
    }
    /**
	 * 设置：会议开始时间
	 */
    public Date getKaishiTime() {
        return kaishiTime;
    }


    /**
	 * 获取：会议开始时间
	 */

    public void setKaishiTime(Date kaishiTime) {
        this.kaishiTime = kaishiTime;
    }
    /**
	 * 设置：会议结束时间
	 */
    public Date getJieshuTime() {
        return jieshuTime;
    }


    /**
	 * 获取：会议结束时间
	 */

    public void setJieshuTime(Date jieshuTime) {
        this.jieshuTime = jieshuTime;
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

    @Override
    public String toString() {
        return "Huiyi{" +
            "id=" + id +
            ", huiyishiTypes=" + huiyishiTypes +
            ", huiyiName=" + huiyiName +
            ", huiyiyuanyouContent=" + huiyiyuanyouContent +
            ", yonghuId=" + yonghuId +
            ", huiyiTypes=" + huiyiTypes +
            ", huiyiContent=" + huiyiContent +
            ", kaishiTime=" + kaishiTime +
            ", jieshuTime=" + jieshuTime +
            ", createTime=" + createTime +
        "}";
    }
}
