package com.shsxt.ego.manager.service;

import com.shsxt.ego.common.model.EgoResult;
import com.shsxt.ego.rpc.dto.TreeDto;
import com.shsxt.ego.rpc.pojo.TbContentCategory;

import java.util.List;

/**
 * Created by Administrator on 2019/7/4 0004.
 */
public interface IManagerContentCategoryService {
    //显示树形数据
    public List<TreeDto> queryContentCategoryListByParentId(Long id);
    //修改数据
    EgoResult save(TbContentCategory contentCategory);
}
