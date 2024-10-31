package com.dao;

import com.entity.DiscussshujiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DiscussshujiVO;
import com.entity.view.DiscussshujiView;


/**
 * 库存评论表
 * 
 * @author 
 * @email 
 * @date 2021-12-16 15:36:18
 */
public interface DiscussshujiDao extends BaseMapper<DiscussshujiEntity> {
	
	List<DiscussshujiVO> selectListVO(@Param("ew") Wrapper<DiscussshujiEntity> wrapper);
	
	DiscussshujiVO selectVO(@Param("ew") Wrapper<DiscussshujiEntity> wrapper);
	
	List<DiscussshujiView> selectListView(@Param("ew") Wrapper<DiscussshujiEntity> wrapper);

	List<DiscussshujiView> selectListView(Pagination page,@Param("ew") Wrapper<DiscussshujiEntity> wrapper);
	
	DiscussshujiView selectView(@Param("ew") Wrapper<DiscussshujiEntity> wrapper);
	
}
