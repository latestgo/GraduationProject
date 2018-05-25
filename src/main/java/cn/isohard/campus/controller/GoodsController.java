package cn.isohard.campus.controller;

import cn.isohard.campus.entities.Goods;
import cn.isohard.campus.service.FavoriteService;
import cn.isohard.campus.service.GoodsService;
import cn.isohard.campus.service.UserService;
import org.apache.ibatis.annotations.Insert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

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
        String username = String.valueOf(session.getAttribute("loginUser"));
        Integer userid = userService.getUseriddByUsername(username);
        boolean isfavorite = favoriteService.isFavorite(userid, goodsid);
        model.addAttribute("isfavorite", isfavorite);
        return "/detail";
    }

    //查看发布的信息
    @GetMapping("/mygoods")
    public String listMyGoods(Model model, HttpSession session) {
        String username = String.valueOf(session.getAttribute("loginUser"));
        Integer userid = userService.getUseriddByUsername(username);
        List<Goods> ListGoods= goodsService.getGoodsByUserid(userid);
        System.out.println(ListGoods);
        model.addAttribute("ListGoods", ListGoods);
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
