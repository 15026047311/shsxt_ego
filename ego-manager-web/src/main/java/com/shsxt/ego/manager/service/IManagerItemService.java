package com.shsxt.ego.manager.service;

import com.shsxt.ego.common.model.EgoResult;
import com.shsxt.ego.common.model.PageResult;
import com.shsxt.ego.rpc.pojo.TbItem;
import com.shsxt.ego.rpc.query.ItemQuery;

public interface IManagerItemService {
    //查询
    public PageResult<TbItem> itemList(ItemQuery itemQuery);
    //商品上架接口
    public EgoResult reshelf(Long[] ids);
    //商品下架接口
    public EgoResult instock(Long[] ids);
    //商品的批量删除
   public EgoResult deleteItemBatch(Long[] ids);
   //商品新增
    public EgoResult saveItem(TbItem item,String itemDesc,String paramData);
}
