package cn.isohard.campus.controller;

import cn.isohard.campus.entities.User;
import cn.isohard.campus.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    //登录页面
    @GetMapping("/signin")
    public String login(HttpSession session) {
        session.removeAttribute("url");
        return "/login";
    }

    //登录校验
    @PostMapping(value = "/signin")
    public String login(@RequestParam("username") String username,
                         @RequestParam("password") String password,
                         Map<String, Object> map, HttpSession session) {
        if(userService.isLogin(username, password)) {
            session.setAttribute("loginUser", username); System.out.println(username);
            String url = String.valueOf(session.getAttribute("url")); System.out.println(url);
            if(url == "null")
                return "redirect:/index";
            else
                return "redirect:"+url;
        }else {
            //登录失败
            map.put("msg", "用户名或密码错误");
            return "/login";
        }
    }

    //退出
    @GetMapping("/signout")
    public String signout(HttpSession session) {
        session.removeAttribute("loginUser");
        session.removeAttribute("url");
        return "redirect:/index";
    }

    //注册页面
    @GetMapping("/signup")
    public String signup() {
        return "signup";
    }

    //注册校验
    @PostMapping("/signup")
    public String singupCheck(User user, Map<String, Object> map) {
        if (userService.isValidUsername(user.getUsername())){
            userService.insertUser(user.getUsername(), user.getPassword());
            map.put("msg" , "注册成功，请登录");
            return "/login";
        }else {
            //用户名重复
            map.put("msg", "用户名已存在");
            return "/signup";
        }
    }

    @GetMapping("/profile")
    public void profilepage() {
        return "/profile";
    }
}
