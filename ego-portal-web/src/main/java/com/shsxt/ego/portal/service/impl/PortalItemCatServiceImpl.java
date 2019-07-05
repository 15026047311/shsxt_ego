package com.shsxt.ego.portal.service.impl;

import com.shsxt.ego.common.model.CatNode;
import com.shsxt.ego.portal.service.IPortalItemCatService;
import com.shsxt.ego.rpc.pojo.TbContent;
import com.shsxt.ego.rpc.pojo.TbItemCat;
import com.shsxt.ego.rpc.pojo.TbItemParam;
import com.shsxt.ego.rpc.service.IItemCatService;
import jdk.nashorn.internal.ir.CatchNode;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2019/7/5 0005.
 */
@Service
public class PortalItemCatServiceImpl implements IPortalItemCatService {
    @Resource
    private IItemCatService itemCatServiceProxy;

    //查询商品信息
    @Override
    public Map<String, Object> getAllItemCats() {
        List<TbItemCat> list = itemCatServiceProxy.queryAllItemCats();
        //分类数据处理
        List result = getChilddren(0L, list);
        Map<String, Object> map = new HashMap<>();
        map.put("data", result);
        return map;
    }

    private List getChilddren(long parentId, List<TbItemCat> list) {
        List result = new ArrayList();
        //循环获取数据
        for (TbItemCat itemCat : list) {
            if (itemCat.getParentId().equals(parentId)) {
                if (itemCat.getIsParent()) {
                    //判断是否是否是一级类目
                    CatNode catNode = new CatNode();
                    if (itemCat.getParentId().equals(0L)) {
                        //一级分类
                        catNode.setName("<a href='/products/" + itemCat.getId() + ".html'>" + itemCat.getName() + "</a>");
                    } else {
                        //二级分类
                        catNode.setName(itemCat.getName());
                    }
                    catNode.setUrl("/porducts/" + itemCat.getId() + ".html");
                    catNode.setList(getChilddren(itemCat.getId(), list));
                    result.add(catNode);

                } else {
                    //三级节点
                    result.add("/products/" + itemCat.getId() + ".html|" + itemCat.getName());
                }
            }
        }
        return result;
    }
}
