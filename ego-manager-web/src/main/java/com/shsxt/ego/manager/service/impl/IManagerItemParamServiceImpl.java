package com.shsxt.ego.manager.service.impl;

import com.shsxt.ego.common.model.PageResult;
import com.shsxt.ego.manager.service.IManagerItemParamService;
import com.shsxt.ego.rpc.pojo.TbItemParam;
import com.shsxt.ego.rpc.query.ItemQuery;
import com.shsxt.ego.rpc.service.ItemParamService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

/**
 * Created by Administrator on 2019/7/3 0003.
 */
@Service
public class IManagerItemParamServiceImpl implements IManagerItemParamService {
    @Resource
    private ItemParamService itemParamServiceProxy;

    @Override
    public PageResult<TbItemParam> itemList(ItemQuery itemQuery) {
        return itemParamServiceProxy.queryItemsListByParams(itemQuery);
    }
}
