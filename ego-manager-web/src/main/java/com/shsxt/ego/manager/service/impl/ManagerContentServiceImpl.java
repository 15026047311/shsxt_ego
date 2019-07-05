package com.shsxt.ego.manager.service.impl;

import com.shsxt.ego.common.model.PageResult;
import com.shsxt.ego.manager.service.IManagerContentService;
import com.shsxt.ego.rpc.pojo.TbContent;
import com.shsxt.ego.rpc.query.ContentQuery;
import com.shsxt.ego.rpc.service.IContentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ManagerContentServiceImpl implements IManagerContentService {

    @Resource
    private IContentService contentServiceProxy;
    @Override
    public PageResult<TbContent> queryContentsByParams(ContentQuery contentQuery) {
        return contentServiceProxy.queryContentsByParams(contentQuery);
    }
}
