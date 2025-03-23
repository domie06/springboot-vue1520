package com.entity.model;

import com.entity.HuiyiwenjianEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 会议文件管理
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 * @author 
 * @email
 * @date 2021-03-16
 */
public class HuiyiwenjianModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 会议id
     */
    private Integer huiyiId;


    /**
     * 文件名
     */
    private String huiyiwenjianName;


    /**
     * 文件大致简介
     */
    private String huiyiwenjianContent;


    /**
     * 会议文件
     */
    private String huiyiwenjianFile;


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
	 * 获取：会议id
	 */
    public Integer getHuiyiId() {
        return huiyiId;
    }


    /**
	 * 设置：会议id
	 */
    public void setHuiyiId(Integer huiyiId) {
        this.huiyiId = huiyiId;
    }
    /**
	 * 获取：文件名
	 */
    public String getHuiyiwenjianName() {
        return huiyiwenjianName;
    }


    /**
	 * 设置：文件名
	 */
    public void setHuiyiwenjianName(String huiyiwenjianName) {
        this.huiyiwenjianName = huiyiwenjianName;
    }
    /**
	 * 获取：文件大致简介
	 */
    public String getHuiyiwenjianContent() {
        return huiyiwenjianContent;
    }


    /**
	 * 设置：文件大致简介
	 */
    public void setHuiyiwenjianContent(String huiyiwenjianContent) {
        this.huiyiwenjianContent = huiyiwenjianContent;
    }
    /**
	 * 获取：会议文件
	 */
    public String getHuiyiwenjianFile() {
        return huiyiwenjianFile;
    }


    /**
	 * 设置：会议文件
	 */
    public void setHuiyiwenjianFile(String huiyiwenjianFile) {
        this.huiyiwenjianFile = huiyiwenjianFile;
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
