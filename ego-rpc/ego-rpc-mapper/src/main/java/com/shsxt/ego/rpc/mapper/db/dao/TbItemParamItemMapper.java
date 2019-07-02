package com.shsxt.ego.rpc.mapper.db.dao;

import com.shsxt.ego.rpc.pojo.TbItemParamItem;

import java.util.Map;

public interface TbItemParamItemMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TbItemParamItem record);

    int insertSelective(TbItemParamItem record);

    TbItemParamItem selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TbItemParamItem record);

    int updateByPrimaryKeyWithBLOBs(TbItemParamItem record);

    int updateByPrimaryKey(TbItemParamItem record);
    //批量删除商品接口,真删除
    int deleteItemParamItemBatch(Map<String,Object> param);

}