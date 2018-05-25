package cn.isohard.campus.controller;

import cn.isohard.campus.entities.Goods;
import cn.isohard.campus.service.GoodsService;
import cn.isohard.campus.service.UserService;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class PublishController {

    @Autowired
    private GoodsService goodsService;

    @Autowired
    private UserService userService;

    @GetMapping("/publish")
    public String publishPage() {
        return "/publish";
    }

    @GetMapping("/publish/{s}")
    public String publishedPage(@PathVariable("s") String s, Map<String, Object> map) {
        if(s.equals("1"))
            map.put("msg", "发布成功");
        return "/publish";
    }


    @PostMapping(value = "/publish")
    public String toPublish(Goods goods, HttpSession session) {
        String username = (String) session.getAttribute("loginUser");
        System.out.println(username + "+" + goods);
        Integer userid = userService.getUseriddByUsername(username);
        goods.setUserid(userid);
        goodsService.addGoods(goods);

        return "redirect:/publish/1";
    }

    /**
     *修改操作
     * @param goods
     * @return
     */
    @PutMapping("/publish")
    public String putPublished(Goods goods) {
        System.out.println(goods);
        goodsService.updateGoods(goods);
        return "redirect:/mygoods";
    }
}
