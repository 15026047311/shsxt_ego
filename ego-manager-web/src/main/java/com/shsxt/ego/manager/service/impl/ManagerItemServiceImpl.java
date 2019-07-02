package com.shsxt.ego.manager.service.impl;

import com.shsxt.ego.common.model.EgoResult;
import com.shsxt.ego.common.model.PageResult;
import com.shsxt.ego.manager.service.IManagerItemService;
import com.shsxt.ego.rpc.pojo.TbItem;
import com.shsxt.ego.rpc.query.ItemQuery;
import com.shsxt.ego.rpc.service.IItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ManagerItemServiceImpl implements IManagerItemService {
    //注入代理类
    @Resource
    private IItemService itemServiceProxy;
    //分页查询的方法
    @Override
    public PageResult<TbItem> itemList(ItemQuery itemQuery) {
        return itemServiceProxy.queryItemsListByParams(itemQuery);
    }
//商品上架
    @Override
    public EgoResult reshelf(Long[] ids) {
        //通过代理类,获得想要的服务,调用service层的实现方法
        return itemServiceProxy.updateItemStatusBatch(ids,1);

    }
//商品下架
    @Override
    public EgoResult instock(Long[] ids) {
        //通过代理类,获得想要的服务,调用service层的实现方法
        return itemServiceProxy.updateItemStatusBatch(ids,2);
    }
    //商品批量删除
    @Override
    public EgoResult deleteItemBatch(Long[] ids) {
        return itemServiceProxy.deleteItemBatch(ids);
    }


}
