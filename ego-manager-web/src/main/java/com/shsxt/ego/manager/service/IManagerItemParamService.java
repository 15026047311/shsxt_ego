package com.shsxt.ego.manager.service;

import com.shsxt.ego.common.model.EgoResult;
import com.shsxt.ego.common.model.PageResult;
import com.shsxt.ego.rpc.pojo.TbItemParam;
import com.shsxt.ego.rpc.query.ItemQuery;

/**
 * Created by Administrator on 2019/7/3 0003.
 */
public interface IManagerItemParamService {
    //分页查询的方法
    public PageResult<TbItemParam> itemList(ItemQuery itemQuery);
    //判断商品规格信息是否重复存在
    public EgoResult queryItemParamByItemCatId(Long itemCatId);
    //新增商品规格信息,保存按钮
    public EgoResult saveItem(Long itemCatId,String paramData);
    //批量删除操作
    public EgoResult deleteItemParamBatch(Long[] ids);

}
