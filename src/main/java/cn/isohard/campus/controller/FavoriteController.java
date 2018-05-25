package cn.isohard.campus.controller;

import cn.isohard.campus.service.FavoriteService;
import cn.isohard.campus.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class FavoriteController {

    @Autowired
    private FavoriteService favoriteService;

    @Autowired
    private UserService userService;

    @GetMapping("/favorite")
    public String listFavorite(Model model, HttpSession session) {
        model.addAttribute("favoriteGoodses", favoriteService.getFavoriteGoods((String) session.getAttribute("loginUser")));
        return "/favorite";
    }

    @DeleteMapping(value = "/favorite/{goodsid}")
    public String deleteFavorite(@PathVariable("goodsid") Integer goodsid) {
        favoriteService.deleteFavoriteByGoodsid(goodsid);
        return "redirect:/favorite";
    }

    /**
     * 添加收藏
     * @param goodsid
     * @param session
     */
    @GetMapping("/favorite/{goodsid}")
    public String addFavorite(@PathVariable("goodsid") Integer goodsid, HttpSession session) {
        String username = String.valueOf(session.getAttribute("loginUser"));
        Integer userid = userService.getUseriddByUsername(username);
        favoriteService.addFavorite(userid, goodsid);
        return "redirect:/goods/" + goodsid;
    }
}