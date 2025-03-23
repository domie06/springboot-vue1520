package com.entity.model;

import com.entity.HuiyiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 会议管理
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 * @author 
 * @email
 * @date 2021-03-16
 */
public class HuiyiModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 会议室
     */
    private Integer huiyishiTypes;


    /**
     * 会议名
     */
    private String huiyiName;


    /**
     * 会议缘由
     */
    private String huiyiyuanyouContent;


    /**
     * 会议发起人id
     */
    private Integer yonghuId;


    /**
     * 会议状态
     */
    private Integer huiyiTypes;


    /**
     * 会议内容
     */
    private String huiyiContent;


    /**
     * 会议开始时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date kaishiTime;


    /**
     * 会议结束时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date jieshuTime;


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
	 * 获取：会议室
	 */
    public Integer getHuiyishiTypes() {
        return huiyishiTypes;
    }


    /**
	 * 设置：会议室
	 */
    public void setHuiyishiTypes(Integer huiyishiTypes) {
        this.huiyishiTypes = huiyishiTypes;
    }
    /**
	 * 获取：会议名
	 */
    public String getHuiyiName() {
        return huiyiName;
    }


    /**
	 * 设置：会议名
	 */
    public void setHuiyiName(String huiyiName) {
        this.huiyiName = huiyiName;
    }
    /**
	 * 获取：会议缘由
	 */
    public String getHuiyiyuanyouContent() {
        return huiyiyuanyouContent;
    }


    /**
	 * 设置：会议缘由
	 */
    public void setHuiyiyuanyouContent(String huiyiyuanyouContent) {
        this.huiyiyuanyouContent = huiyiyuanyouContent;
    }
    /**
	 * 获取：会议发起人id
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 设置：会议发起人id
	 */
    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 获取：会议状态
	 */
    public Integer getHuiyiTypes() {
        return huiyiTypes;
    }


    /**
	 * 设置：会议状态
	 */
    public void setHuiyiTypes(Integer huiyiTypes) {
        this.huiyiTypes = huiyiTypes;
    }
    /**
	 * 获取：会议内容
	 */
    public String getHuiyiContent() {
        return huiyiContent;
    }


    /**
	 * 设置：会议内容
	 */
    public void setHuiyiContent(String huiyiContent) {
        this.huiyiContent = huiyiContent;
    }
    /**
	 * 获取：会议开始时间
	 */
    public Date getKaishiTime() {
        return kaishiTime;
    }


    /**
	 * 设置：会议开始时间
	 */
    public void setKaishiTime(Date kaishiTime) {
        this.kaishiTime = kaishiTime;
    }
    /**
	 * 获取：会议结束时间
	 */
    public Date getJieshuTime() {
        return jieshuTime;
    }


    /**
	 * 设置：会议结束时间
	 */
    public void setJieshuTime(Date jieshuTime) {
        this.jieshuTime = jieshuTime;
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
