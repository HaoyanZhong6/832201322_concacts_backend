package com.entity.view;

import com.entity.ShujiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 库存
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2021-12-16 15:36:18
 */
@TableName("kucun")
public class ShujiView  extends ShujiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public ShujiView(){
	}
 
 	public ShujiView(ShujiEntity shujiEntity){
 	try {
			BeanUtils.copyProperties(this, shujiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
