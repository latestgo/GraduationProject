package cn.isohard.campus.controller;

import cn.isohard.campus.entities.Goods;
import cn.isohard.campus.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
public class IndexController {

    @Autowired
    private GoodsService goodsService;

    @GetMapping({"/index", "/"})
    public String Index(Model model) {
        model.addAttribute("goodses", goodsService.getGoodsAll());
        return "index";
    }

    public List<Goods> Index1() {
        return goodsService.getGoodsAll();
    }
}
