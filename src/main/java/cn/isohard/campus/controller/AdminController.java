package cn.isohard.campus.controller;

import cn.isohard.campus.entities.Category;
import cn.isohard.campus.entities.Goods;
import cn.isohard.campus.entities.User;
import cn.isohard.campus.service.AdminService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
public class AdminController {

    @Autowired
    private AdminService adminService;

    //************************************************************************************
    //************************************************************************************
    //管理员登陆

    /**
     * 管理员登陆页面
     * @return
     */
    @GetMapping({"/admin/login", "/admin/","/admin"})
    public String loginGet() {
        return "/admin/login";
    }

    /**
     * 管理员登陆校验
     * @param name
     * @param password
     * @return
     */
    @PostMapping({"/admin/login", "/admin/","/admin"})
    public String loginPost(@RequestParam("name") String name, @RequestParam("password") String password, Map<String, Object> map, HttpSession session) {
        if(adminService.rightToLogin(name, password)) {
            session.setAttribute("loginAdmin", name);
            return "redirect:/admin/users";
        }
        else {
            map.put("msg", "用户名或密码错误");
            return "/admin/login";
        }
    }

    /******************************************************************************************
     * ******************************************************************************************
     * 用户的操作
     */
    /**
     * 全部用户展示
     * @return
     */
    @GetMapping("/admin/users")
    public String userList(Model model, @RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "5") Integer pageSize) {
        List<User> users = adminService.getAllUser(pageNum, pageSize);
        PageInfo pageInfo = new PageInfo(users);
        Page page = (Page) users;
        model.addAttribute("pageinfo", page);
        model.addAttribute("users", users);
        return "/admin/user/list";
    }


    @GetMapping("/admin/user/{userid}")
    public String userEdit(@PathVariable("userid") Integer userid) {
        return "";
    }

    @DeleteMapping("/admin/user/{userid}")
    public String userDelete(@PathVariable("userid") Integer userid) {
        adminService.deleteUserByUserid(userid);
        return "redirect:/admin/users";
    }
    /*************************************************************************************************
     * ***********************************************************************************************
     * 信息的操作
     */

    /**
     * 全部信息展示
     * @return
     */
    @GetMapping("/admin/goodses")
    public String goodsesList(Model model, @RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "5") Integer pageSize) {
        List<Goods> goodses = adminService.getAllGoodses(pageNum, pageSize);
        PageInfo pageInfo = new PageInfo(goodses);
        Page page = (Page) goodses;
        model.addAttribute("pageinfo", page);
        model.addAttribute("goodses", goodses);
        return "/admin/goods/list";
    }

    //*****************************************************************************************
    //*****************************************************************************************
    //分类的操作

    /**
     * 全部分类展示
     * @return
     */
    @GetMapping("/admin/categories")
    public String categoryList(Model model, @RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "5") Integer pageSize) {
        List<Category> categories = adminService.getAllCategory(pageNum, pageSize);
        PageInfo pageInfo = new PageInfo(categories);
        Page page = (Page) categories;
        model.addAttribute("pageinfo", page);
        model.addAttribute("categories", categories);
        return "/admin/category/list";
    }

    /**
     * 来到添加分类页面
     * @return
     */
    @GetMapping("/admin/category")
    public String categoryAddPage() {
        return "/admin/category/add";
    }

    /**
     * 添加分类
     * @param category
     * @return
     */
    @PostMapping("/admin/category")
    public String categoryAdd(Category category) {
        adminService.categoryInsert(category);
        return "redirect:/admin/categories";
    }

    /**
     * 来到修改页面，查出当前分类，在页面回显
     * @param categoryid
     * @param model
     * @return
     */
    @GetMapping("/admin/category/{categoryid}")
    public String categoryEditPage(@PathVariable("categoryid") Integer categoryid, Model model) {
        Category category = adminService.getCategoryByCategoryid(categoryid);
        model.addAttribute("category", category);
        return "/admin/category/add";
    }

    /**
     *分类修改，需要提交分类id
     * @param category
     * @return
     */
    @PutMapping("/admin/category")
    public String categoryUpdate(Category category) {
        adminService.categoryUpdate(category);
        return "redirect:/admin/categories";
    }

    @DeleteMapping("/admin/category/{categoryid}")
    public String categoryDelete(@PathVariable("categoryid") Integer categoryid) {
        adminService.categoryDelete(categoryid);
        return "redirect:/admin/categories";
    }
}
