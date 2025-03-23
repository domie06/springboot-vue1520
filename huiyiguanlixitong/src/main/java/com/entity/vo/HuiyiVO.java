package com.entity.vo;

import com.entity.HuiyiEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 会议管理
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 * @author 
 * @email
 * @date 2021-03-16
 */
@TableName("huiyi")
public class HuiyiVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

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

    @TableField(value = "kaishi_time")
    private Date kaishiTime;


    /**
     * 会议结束时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "jieshu_time")
    private Date jieshuTime;


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

}
