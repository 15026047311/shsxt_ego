package com.shsxt.ego.manager.controller;

import com.shsxt.ego.rpc.pojo.TbUser;
import com.shsxt.ego.rpc.service.IUserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;


/**
 * Created by Administrator on 2019/7/1 0001.
 */
@Controller
public class UserController {
  @Resource
    private IUserService userServiceProxy;
   @RequestMapping("user/queryUserByUserId/{userId}")
    @ResponseBody
    public TbUser queryUserByUserId(@PathVariable Long userId){
       return userServiceProxy.queryUserByUserId(userId);
   }

}
