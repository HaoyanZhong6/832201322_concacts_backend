package com.entity.view;

import com.entity.ShujifenleiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 库存分类
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2021-12-16 15:36:17
 */
@TableName("kucunfenlei")
public class ShujifenleiView  extends ShujifenleiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public ShujifenleiView(){
	}
 
 	public ShujifenleiView(ShujifenleiEntity shujifenleiEntity){
 	try {
			BeanUtils.copyProperties(this, shujifenleiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
