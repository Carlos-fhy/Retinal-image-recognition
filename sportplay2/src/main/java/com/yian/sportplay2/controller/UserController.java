package com.yian.sportplay2.controller;

import com.alibaba.fastjson.JSON;
import com.yian.sportplay2.bean.QueryInfo;
import com.yian.sportplay2.bean.User;
import com.yian.sportplay2.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserDao udao;

    @RequestMapping("/alluser")
    public String getUserList(QueryInfo queryInfo){
        int numbers = udao.getUserCounts("%"+queryInfo.getQuery()+"%");// 获取数据总数
        int pageStart = (queryInfo.getPageNum()-1)*queryInfo.getPageSize();
        List<User> users = udao.getAllUser("%"+queryInfo.getQuery()+"%",pageStart,queryInfo.getPageSize());
        HashMap<String, Object> res = new HashMap<>();
        res.put("numbers",numbers);
        res.put("data",users);
        String res_string = JSON.toJSONString(res);
        return res_string;
    }

    @RequestMapping(value = "/userstate",method = RequestMethod.PUT)
    public String updateUserState(@RequestParam("id")Integer id,
                              @RequestParam("state")Boolean state){
        int i = udao.updateState(id, state);
        return i > 0 ? "success":"error";
    }

    @RequestMapping(value = "/adduser",method = RequestMethod.POST)
    public String addUser(@RequestBody User user){
        user.setRole("普通用户");
        user.setState(false);
        int i = udao.addUser(user);
        return i > 0?"success":"error";
    }

    @RequestMapping("/deleteuser")
    public String deleteUser(int id){
        int i = udao.deleteUser(id);
        return i > 0 ?"success":"error";
    }

    @RequestMapping("/getupdate")
    public String getUpdateUser(int id){
        User user =udao.getUpdateUser(id);
        String string = JSON.toJSONString(user);
        return string;
    }

    @RequestMapping("/edituser")
    public String editUser(@RequestBody User user){
        int i = udao.editUser(user);
        return i >0?"success":"error";
    }
}
