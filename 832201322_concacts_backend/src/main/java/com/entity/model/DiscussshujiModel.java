package com.entity.model;

import com.entity.DiscussshujiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 库存评论表
 * 接收传参的实体类  
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了） 
 * 取自ModelAndView 的model名称
 * @author 
 * @email 
 * @date 2021-12-16 15:36:18
 */
public class DiscussshujiModel  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 评论内容
	 */
	
	private String content;
		
	/**
	 * 联系人id
	 */
	
	private Long userid;
				
	
	/**
	 * 设置：评论内容
	 */
	 
	public void setContent(String content) {
		this.content = content;
	}
	
	/**
	 * 获取：评论内容
	 */
	public String getContent() {
		return content;
	}
				
	
	/**
	 * 设置：联系人id
	 */
	 
	public void setUserid(Long userid) {
		this.userid = userid;
	}
	
	/**
	 * 获取：联系人id
	 */
	public Long getUserid() {
		return userid;
	}
			
}
