package com.shsxt.ego.rpc.service.impl;

import com.shsxt.ego.rpc.mapper.db.dao.TbItemDescMapper;
import com.shsxt.ego.rpc.pojo.TbItemDesc;
import com.shsxt.ego.rpc.service.IItemDescService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2019/7/3 0003.
 */
@Service
public class ItemDescServiceImpl implements IItemDescService {
    @Autowired
    private TbItemDescMapper itemDescMapper;
    @Override
    public TbItemDesc queryItemDescByItemId(Long itemId) {
        //查询新增数据
       return itemDescMapper.selectByPrimaryKey(itemId);
    }
}
