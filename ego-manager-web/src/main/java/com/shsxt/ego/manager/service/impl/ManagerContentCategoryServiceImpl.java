package com.shsxt.ego.manager.service.impl;

import com.shsxt.ego.common.model.EgoResult;
import com.shsxt.ego.common.model.PageResult;
import com.shsxt.ego.manager.service.IManagerContentCategoryService;
import com.shsxt.ego.manager.service.IManagerItemParamService;
import com.shsxt.ego.rpc.dto.TreeDto;
import com.shsxt.ego.rpc.pojo.TbContentCategory;
import com.shsxt.ego.rpc.pojo.TbItemParam;
import com.shsxt.ego.rpc.query.ItemQuery;
import com.shsxt.ego.rpc.service.IContentCategoryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2019/7/4 0004.
 */
@Service
public class ManagerContentCategoryServiceImpl implements IManagerContentCategoryService {
    @Resource
    private IContentCategoryService contentCategoryServiceProxy;//代理类
    @Override
    public List<TreeDto> queryContentCategoryListByParentId(Long id) {
        return contentCategoryServiceProxy.queryContentCategoryListByParentId(id);
    }
//更新数据,
    @Override
    public EgoResult save(TbContentCategory contentCategory) {
        Date time = new Date();
        contentCategory.setCreated(time);
        contentCategory.setUpdated(time);
        contentCategory.setIsParent(false);//1为true父节点,0为false叶子节点
        contentCategory.setSortOrder(1);
        return contentCategoryServiceProxy.save(contentCategory);
    }
}
