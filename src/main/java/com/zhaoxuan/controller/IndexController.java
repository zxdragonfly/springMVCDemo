package com.zhaoxuan.controller;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.zhaoxuan.entity.User;
import com.zhaoxuan.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by zhaoxuan
 * 2017/12/7 14:55
 */
@Controller
@RequestMapping("index")
public class IndexController {
    private final Logger LOG = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private UserService userService;
    @RequestMapping(value = "", method = RequestMethod.GET)
    public String index(){
        //根据id获取
        System.out.println(userService.getUserById(1));
        List<User> aList = Lists.newArrayList();
        aList.add(new User("2","1",1));
        aList.add(new User("2","3",4));
        //批量插入
        userService.batchSaveUser(aList);

        List<User> list = userService.listAllUser();
        for(User u:list){
            System.out.println(u);
        }
        //跟新
        User user =  new User(1,"小名","",23);
        LOG.info(userService.updateUser(user)+"");

        return "index";
    }
    @RequestMapping("/toRankPage")
    public String toRankPage(HttpServletRequest request, HttpSession session){
        String accessToken = request.getParameter("accessToken");
        session.setAttribute("accessToken",accessToken);
        return "index";
    }
    @RequestMapping(value = "/getAccessToken",method = RequestMethod.GET)
    @ResponseBody
    public String getAccessToken(HttpSession session){
        String accessToken = (String) session.getAttribute("accessToken");
        accessToken = JSON.toJSONString(accessToken);
        return accessToken;
    }

}
