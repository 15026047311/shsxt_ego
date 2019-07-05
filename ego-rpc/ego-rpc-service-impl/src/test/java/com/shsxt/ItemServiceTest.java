package com.shsxt;

import com.shsxt.ego.rpc.pojo.TbItemCat;
import com.shsxt.ego.rpc.pojo.TbItemParam;
import com.shsxt.ego.rpc.query.ItemQuery;
import com.shsxt.ego.rpc.service.ItemParamService;
import org.apache.zookeeper.data.Id;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2019/7/3 0003.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/applicationContext-dao.xml"
        ,"classpath:spring/applicationContext-dubbo.xml"
        ,"classpath:spring/applicationContext-service.xml"
        ,"classpath:spring/applicationContext-tx.xml"})
public class ItemServiceTest {
    @Resource
    private ItemParamService itemParamService;
    @Test
    public void test01(){

        ItemQuery itemQuery = new ItemQuery();

       itemParamService.queryItemsListByParams(itemQuery);

    }
}
