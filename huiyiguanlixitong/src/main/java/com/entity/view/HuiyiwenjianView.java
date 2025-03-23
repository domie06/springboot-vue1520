package com.entity.view;

import com.entity.HuiyiwenjianEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;

/**
 * 会议文件管理
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email
 * @date 2021-03-16
 */
@TableName("huiyiwenjian")
public class HuiyiwenjianView extends HuiyiwenjianEntity implements Serializable {
    private static final long serialVersionUID = 1L;



		//级联表 huiyi
			/**
			* 会议室
			*/
			private Integer huiyishiTypes;
				/**
				* 会议室的值
				*/
				private String huiyishiValue;
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
				* 会议状态的值
				*/
				private String huiyiValue;
			/**
			* 会议内容
			*/
			private String huiyiContent;
			/**
			* 会议开始时间
			*/
			private Date kaishiTime;
			/**
			* 会议结束时间
			*/
			private Date jieshuTime;

	public HuiyiwenjianView() {

	}

	public HuiyiwenjianView(HuiyiwenjianEntity huiyiwenjianEntity) {
		try {
			BeanUtils.copyProperties(this, huiyiwenjianEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}









				//级联表的get和set huiyi
					/**
					* 获取： 会议室
					*/
					public Integer getHuiyishiTypes() {
						return huiyishiTypes;
					}
					/**
					* 设置： 会议室
					*/
					public void setHuiyishiTypes(Integer huiyishiTypes) {
						this.huiyishiTypes = huiyishiTypes;
					}


						/**
						* 获取： 会议室的值
						*/
						public String getHuiyishiValue() {
							return huiyishiValue;
						}
						/**
						* 设置： 会议室的值
						*/
						public void setHuiyishiValue(String huiyishiValue) {
							this.huiyishiValue = huiyishiValue;
						}
					/**
					* 获取： 会议名
					*/
					public String getHuiyiName() {
						return huiyiName;
					}
					/**
					* 设置： 会议名
					*/
					public void setHuiyiName(String huiyiName) {
						this.huiyiName = huiyiName;
					}
					/**
					* 获取： 会议缘由
					*/
					public String getHuiyiyuanyouContent() {
						return huiyiyuanyouContent;
					}
					/**
					* 设置： 会议缘由
					*/
					public void setHuiyiyuanyouContent(String huiyiyuanyouContent) {
						this.huiyiyuanyouContent = huiyiyuanyouContent;
					}
					/**
					* 获取： 会议发起人id
					*/
					public Integer getYonghuId() {
						return yonghuId;
					}
					/**
					* 设置： 会议发起人id
					*/
					public void setYonghuId(Integer yonghuId) {
						this.yonghuId = yonghuId;
					}
					/**
					* 获取： 会议状态
					*/
					public Integer getHuiyiTypes() {
						return huiyiTypes;
					}
					/**
					* 设置： 会议状态
					*/
					public void setHuiyiTypes(Integer huiyiTypes) {
						this.huiyiTypes = huiyiTypes;
					}


						/**
						* 获取： 会议状态的值
						*/
						public String getHuiyiValue() {
							return huiyiValue;
						}
						/**
						* 设置： 会议状态的值
						*/
						public void setHuiyiValue(String huiyiValue) {
							this.huiyiValue = huiyiValue;
						}
					/**
					* 获取： 会议内容
					*/
					public String getHuiyiContent() {
						return huiyiContent;
					}
					/**
					* 设置： 会议内容
					*/
					public void setHuiyiContent(String huiyiContent) {
						this.huiyiContent = huiyiContent;
					}
					/**
					* 获取： 会议开始时间
					*/
					public Date getKaishiTime() {
						return kaishiTime;
					}
					/**
					* 设置： 会议开始时间
					*/
					public void setKaishiTime(Date kaishiTime) {
						this.kaishiTime = kaishiTime;
					}
					/**
					* 获取： 会议结束时间
					*/
					public Date getJieshuTime() {
						return jieshuTime;
					}
					/**
					* 设置： 会议结束时间
					*/
					public void setJieshuTime(Date jieshuTime) {
						this.jieshuTime = jieshuTime;
					}














}
