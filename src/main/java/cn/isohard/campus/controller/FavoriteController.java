package cn.isohard.campus.controller;

import cn.isohard.campus.entities.Goods;
import cn.isohard.campus.service.FavoriteService;
import cn.isohard.campus.service.GoodsService;
import cn.isohard.campus.service.UserService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class FavoriteController {

    @Autowired
    private FavoriteService favoriteService;

    @Autowired
    private UserService userService;

    @Autowired
    private GoodsService goodsService;

    @GetMapping("/favorite")
    public String listFavorite(Model model, HttpSession session, @RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "5") Integer pageSize) {
        String username = String.valueOf(session.getAttribute("loginUser"));
        List<Integer> favoriteGoodsesId = favoriteService.getFavoriteGoods(username, pageNum, pageSize);
        PageInfo pageInfo = new PageInfo(favoriteGoodsesId);
        Page page = (Page) favoriteGoodsesId;
        model.addAttribute("pageinfo", page);
        List<Goods> favoriteGoodses = new ArrayList<>();
        for(Integer goodsideach : favoriteGoodsesId) {
            favoriteGoodses.add(goodsService.getGoodsById(goodsideach));
        }
        model.addAttribute("favoriteGoodses", favoriteGoodses);
        if(pageNum < 1) {
            return "favorite:/favorite?pageNum=1";
        }
        else if(pageNum > page.getPages()) {
            return "redirect:/favorite?pageNum=" + page.getPages();
        }
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
    public String addFavorite(@PathVariable("goodsid") Integer goodsid, HttpSession session ) {
        String username = String.valueOf(session.getAttribute("loginUser"));
        Integer userid = userService.getUseriddByUsername(username);
        favoriteService.addFavorite(userid, goodsid);
        return "redirect:/goods/" + goodsid;
    }
}