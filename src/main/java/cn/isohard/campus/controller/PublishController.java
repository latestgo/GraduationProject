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
        return "publish";
    }

    @PostMapping(value = "/publish")
    public String toPublish(Goods goods, HttpSession session, Map<String, Object> map) {
        String username = (String) session.getAttribute("loginUser");
        System.out.println(username + "+" + goods);
        Integer userid = userService.getUseriddByUsername(username);
        goods.setUserid(userid);
        goodsService.addGoods(goods.getUserid(), goods.getCategoryid(), goods.getTitle(), goods.getDescription(), goods.getPrice());

        map.put("msg", "发布成功");
        return "publish";
    }
}
