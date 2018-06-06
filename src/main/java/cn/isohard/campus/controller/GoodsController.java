package cn.isohard.campus.controller;

import cn.isohard.campus.entities.Goods;
import cn.isohard.campus.service.FavoriteService;
import cn.isohard.campus.service.GoodsService;
import cn.isohard.campus.service.UserService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Insert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    @Autowired
    private UserService userService;

    @Autowired
    private FavoriteService favoriteService;

    //查看goods详情
    @GetMapping("/goods/{goodsid}")
    public String detail(@PathVariable("goodsid") Integer goodsid, Model model, HttpSession session) {
        model.addAttribute("goods", goodsService.getGoodsById(goodsid));
        model.addAttribute("user",userService.getUserByUserid(goodsService.getUseridByGoodsid(goodsid)));
        String username = String.valueOf(session.getAttribute("loginUser"));
        Integer userid = userService.getUseriddByUsername(username);
        boolean isfavorite = favoriteService.isFavorite(userid, goodsid);
        model.addAttribute("isfavorite", isfavorite);
        return "/detail";
    }

    //查看mine发布的信息
    @GetMapping("/mygoods")
    public String listMyGoods(Model model, HttpSession session, @RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "10") Integer pageSize) {
        String username = String.valueOf(session.getAttribute("loginUser"));
        Integer userid = userService.getUseriddByUsername(username);
        List<Goods> goodses= goodsService.getMyGoodsByPage(userid, pageNum, pageSize);
        PageInfo pageInfo = new PageInfo(goodses);
        Page page = (Page) goodses;
        model.addAttribute("pageinfo", page);
        model.addAttribute("goodses", goodses);
        if(pageNum < 1) {
            return "redirect:/mygoods?pageNum=1";
        }
        else if(pageNum > page.getPages()) {
            return "redirect:/mygoods?pageNum=" + page.getPages();
        }
        return "/mygoods";
    }

    /**
     * 删除信息By goodsid
     * @param goodsid
     * @return
     */
    @DeleteMapping("/mygoods/{goodsid}")
    public String deletePublished(@PathVariable("goodsid") Integer goodsid) {
        goodsService.deleteGoodsByGoodsid(goodsid);
        return "redirect:/mygoods";
    }

    //首先来到修改页面
    @GetMapping("/mygoods/{goodsid}")
    public String editPublished(@PathVariable("goodsid") Integer goodsid, Model model) {
        Goods goods = goodsService.getGoodsById(goodsid);
        model.addAttribute("goods", goods);
        return "/publish";
    }
}
