package com.shsxt.ego.rpc.mapper.db.dao;

import com.shsxt.ego.rpc.pojo.TbItem;
import com.shsxt.ego.rpc.pojo.TbItemParam;
import com.shsxt.ego.rpc.query.ItemQuery;

import java.util.List;

public interface TbItemParamMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TbItemParam record);

    int insertSelective(TbItemParam record);

    TbItemParam selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TbItemParam record);

    int updateByPrimaryKeyWithBLOBs(TbItemParam record);

    int updateByPrimaryKey(TbItemParam record);
    //分页查询
    public List<TbItemParam> queryItemsByParams(ItemQuery itemQuery);
    //添加操作,判断数据是否重复
    TbItemParam queryItemParamByItemCatId(Long itemCatId);
    //批量删除
    int deleteItemParamBatch(Long[] ids);

}