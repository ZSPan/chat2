package com.chat2.controller;

import com.chat2.model.User;
import com.chat2.service.UserService;
import com.chat2.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import java.util.List;


@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    //跳转到添加用户界面
    @RequestMapping("/toAddUser")
    public String toAddUser() {
        return "addUser";
    }

    //添加用户并重定向
    @RequestMapping("/addUser")
    public String addUser(Model model, User user) {
        if (user != null) {
            userService.saveUser(user);
        }
        return "redirect:/user/userInfo";
    }

    //修改用户
    @RequestMapping("/updateUser")
    public String UpdateUser(Model model, User user) {
        if (userService.updateUser(user)) {
            user = userService.findUserById(user.getId());
            model.addAttribute("user", user);
            return "redirect:/user/userInfo";
        }
        return "/error";
    }

    //查询所有用户
    @RequestMapping("/getAllUser")
    public String getAllUser(Model model) {
        List<User> user = userService.findAll();
        model.addAttribute("userList", user);
        return "allUser";
    }

    //查询单个用户
    @RequestMapping("/getUser")
    public String getUser(int id, Model model) {
        model.addAttribute("user", userService.findUserById(id));
        return "editUser";
    }

    //根据id删除用户
    @RequestMapping("/delUser")
    public String deleteUser(int id, Model model) {
        model.addAttribute("user", userService.deleteUser(id));
        return "redirect:/user/userInfo";
    }


    //分页查询用户信息
    @RequestMapping("/userInfo")
    public String getUsers(@RequestParam(value = "pn", defaultValue = "1") Integer pn, Model model) {
        System.out.println("解析test。html");
        //从第一条开始 每页查询五条数据
        PageHelper.startPage(pn, 5);
        List<User> users = userService.findAll();
        //将用户信息放入PageInfo对象里
        PageInfo page = new PageInfo(users, 6);
        model.addAttribute("pageInfo", page);
        System.out.println("列表用户数："+ users.size());
        System.out.println("列表用户数1：" + page.getList().size());
        return "allUser";
    }

    @RequestMapping("/userInfo1")
    public String getUsers1(@RequestParam(value = "pn", defaultValue = "1") Integer pn, Model model) {
        System.out.println("解析test。html");
        //从第一条开始 每页查询五条数据
//        PageHelper.startPage(pn, 5);
        List<User> users = userService.findAll();
        //将用户信息放入PageInfo对象里
        PageBean<User> page = new PageBean<User>(users,pn,6,5);
        model.addAttribute("pageInfo", page);
        System.out.println("列表用户数："+ users.size());
        System.out.println("列表用户数1：" + page.getList().size());
        return "allUser";
    }
}
