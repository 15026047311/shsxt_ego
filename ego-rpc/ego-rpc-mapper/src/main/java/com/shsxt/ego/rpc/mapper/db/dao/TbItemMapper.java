package com.shsxt.ego.rpc.mapper.db.dao;

import com.shsxt.ego.rpc.pojo.TbItem;
import com.shsxt.ego.rpc.query.ItemQuery;

import java.util.List;
import java.util.Map;

public interface TbItemMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TbItem record);

    int insertSelective(TbItem record);

    TbItem selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TbItem record);

    int updateByPrimaryKey(TbItem record);
//查询商品详情,传入的参数
    public List<TbItem> queryItemsByParams(ItemQuery itemQuery);
    //商品的批量更新
   int updateItemStatusBatch(Map<String,Object> map);
   //商品删除(实际是更新)
    int deleteItemBatch(Map<String,Object> param);

}