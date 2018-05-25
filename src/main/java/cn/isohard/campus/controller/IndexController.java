package cn.isohard.campus.controller;

import cn.isohard.campus.entities.Goods;
import cn.isohard.campus.service.GoodsService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;



@Controller
public class IndexController {

    @Autowired
    private GoodsService goodsService;


    @GetMapping({"/index", "/"})
    public String Index(Model model, @RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "5") Integer pageSize) {
        List<Goods> goodses = goodsService.getAllGoodsByPage(pageNum, pageSize);
        model.addAttribute("goodses", goodses);
        PageInfo pageInfo = new PageInfo(goodses);
        Page page = (Page) goodses;
        model.addAttribute("pageinfo", page);
        if(pageNum < 1) {
            return "redirect:/index?pageNum=1";
        }
        else if(pageNum > page.getPages()) {
            return "redirect:/index?pageNum=" + page.getPages();
        }
        return "/index";
    }
}
