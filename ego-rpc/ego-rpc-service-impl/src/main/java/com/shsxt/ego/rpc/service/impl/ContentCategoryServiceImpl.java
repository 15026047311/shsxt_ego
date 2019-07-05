package com.shsxt.ego.rpc.service.impl;

import com.shsxt.ego.common.model.EgoResult;
import com.shsxt.ego.rpc.dto.TreeDto;
import com.shsxt.ego.rpc.mapper.db.dao.TbContentCategoryMapper;
import com.shsxt.ego.rpc.pojo.TbContentCategory;
import com.shsxt.ego.rpc.service.IContentCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2019/7/4 0004.
 */
@Service
public class ContentCategoryServiceImpl implements IContentCategoryService {
    @Autowired
    TbContentCategoryMapper contentCategoryMapper;
    @Override
    public List<TreeDto> queryContentCategoryListByParentId(Long id) {

        return contentCategoryMapper.queryContentCategoryListByParentId(id);
    }

    @Override
    public EgoResult save(TbContentCategory contentCategory) {
        //查询对应节点,如果节点不存在,设置is_parent=1
        //查询parent_id下是否存在子节点
        int count = contentCategoryMapper.countContentCategoryByParentId(contentCategory.getParentId());//获取父节点的数量
      //如果没有父节点,把父节点
        if (count == 0){
            //更新父节点
            TbContentCategory parentContentCategory = new TbContentCategory();
            parentContentCategory.setId(contentCategory.getParentId());
            parentContentCategory.setIsParent(true);//1为true,0为false
            parentContentCategory.setUpdated(new Date());
            contentCategoryMapper.updateByPrimaryKeySelective(parentContentCategory);
        }
        contentCategoryMapper.insertSelective(contentCategory);

        return  new EgoResult();
    }
}
