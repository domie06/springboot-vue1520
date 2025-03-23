package com.entity.view;

import com.entity.RenwuOneEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;

/**
 * 任务管理
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email
 * @date 2021-03-16
 */
@TableName("renwu_one")
public class RenwuOneView extends RenwuOneEntity implements Serializable {
    private static final long serialVersionUID = 1L;
		/**
		 * 任务类型的值
		 */
		private String renwuOneValue;
		/**
		* 接收人是否查看的值
		*/
		private String chakanValue;



		//级联表 fabuyonghu
			/**
			* 姓名
			*/
			private String fabuname;
			/**
			* 手机号
			*/
			private String fabuphone;
			/**
			* 身份证号
			*/
			private String fabuidNumber;

		//级联表 jieshouyonghu
			/**
			* 姓名
			*/
			private String jieshouname;
			/**
			* 手机号
			*/
			private String jieshouphone;
			/**
			* 身份证号
			*/
			private String jieshouidNumber;

	public RenwuOneView() {

	}

	public RenwuOneView(RenwuOneEntity renwuOneEntity) {
		try {
			BeanUtils.copyProperties(this, renwuOneEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



			/**
			* 获取： 接收人是否查看的值
			*/
			public String getChakanValue() {
				return chakanValue;
			}
			/**
			* 设置： 接收人是否查看的值
			*/
			public void setChakanValue(String chakanValue) {
				this.chakanValue = chakanValue;
			}


	public String getFabuname() {
		return fabuname;
	}

	public void setFabuname(String fabuname) {
		this.fabuname = fabuname;
	}

	public String getFabuphone() {
		return fabuphone;
	}

	public void setFabuphone(String fabuphone) {
		this.fabuphone = fabuphone;
	}

	public String getFabuidNumber() {
		return fabuidNumber;
	}

	public void setFabuidNumber(String fabuidNumber) {
		this.fabuidNumber = fabuidNumber;
	}

	public String getJieshouname() {
		return jieshouname;
	}

	public void setJieshouname(String jieshouname) {
		this.jieshouname = jieshouname;
	}

	public String getJieshouphone() {
		return jieshouphone;
	}

	public void setJieshouphone(String jieshouphone) {
		this.jieshouphone = jieshouphone;
	}

	public String getJieshouidNumber() {
		return jieshouidNumber;
	}

	public void setJieshouidNumber(String jieshouidNumber) {
		this.jieshouidNumber = jieshouidNumber;
	}

	public String getRenwuOneValue() {
		return renwuOneValue;
	}

	public void setRenwuOneValue(String renwuOneValue) {
		this.renwuOneValue = renwuOneValue;
	}
}
