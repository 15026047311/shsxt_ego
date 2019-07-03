package com.shsxt.ego.manager.service;

import com.shsxt.ego.common.model.PageResult;
import com.shsxt.ego.rpc.pojo.TbItemParam;
import com.shsxt.ego.rpc.query.ItemQuery;

/**
 * Created by Administrator on 2019/7/3 0003.
 */
public interface IManagerItemParamService {
    public PageResult<TbItemParam> itemList(ItemQuery itemQuery);
}
