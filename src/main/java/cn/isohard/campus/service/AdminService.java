package cn.isohard.campus.service;

import cn.isohard.campus.entities.Category;
import cn.isohard.campus.entities.Goods;
import cn.isohard.campus.entities.User;
import cn.isohard.campus.mapper.AdminMapper;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AdminService {

    @Autowired
    private AdminMapper adminMapper;

    /**
     * 判断管理登陆
     * @param adminname
     * @param adminpassword
     * @return
     */
    public Boolean rightToLogin(String adminname, String adminpassword) {
//        System.out.println("3、" + adminname + " " + adminpassword);
        String adminpasswordBySelect = adminMapper.getAdminpasswordByAdminname(adminname);
//        System.out.println("4、" + adminpasswordBySelect);
        if(adminpasswordBySelect == null)
            return false;
        else if(adminpasswordBySelect.equals(adminpassword))
            return true;
        else
            return false;
    }


    /**
     * 查询出所有的用户
     * @return
     */
    public List<User> getAllUser(Integer pageNum, Integer pageSize) {
        Integer startRow = (pageNum - 1) * pageSize;
        PageHelper.offsetPage(startRow, pageSize);
        return adminMapper.getAllUser();
    }

    /**
     * 通过Userid删除用户
     * @param userid
     */
    public void deleteUserByUserid(Integer userid) {
        adminMapper.deleteUserofFavoriteByUserid(userid);
        adminMapper.deleteUserofGoodsByUserid(userid);
        adminMapper.deleteUserByUserid(userid);
    }

    /**
     * 查询出所有的二手物品信息
     * @return
     */
    public List<Goods> getAllGoodses(Integer pageNum, Integer pageSize) {
        Integer startRow = (pageNum - 1) * pageSize;
        PageHelper.offsetPage(startRow, pageSize);
        return adminMapper.getAllGoodses();
    }

    /**
     * 所有分类信息
     * @param pageNum
     * @param pageSize
     * @return
     */
    public List<Category> getAllCategory(Integer pageNum, Integer pageSize) {
        Integer startRow = (pageNum - 1) * pageSize;
        PageHelper.offsetPage(startRow, pageSize);
        return adminMapper.getAllCategory();
    }

    /**
     * 根据分类id查找分类信息
     * @param categoryid
     * @return
     */
    public Category getCategoryByCategoryid(Integer categoryid) {
        return adminMapper.getCategoryByCategoryid(categoryid);
    }

    /**
     * 插入一条分类信息
     * @param category
     */
    public void categoryInsert(Category category) {
        adminMapper.categoryInsert(category);
    }

    /**
     * 更新一条分类信息
     * @param category
     */
     public void categoryUpdate(Category category) {
        adminMapper.categoryUpdate(category);
        System.out.println("更新分类信息");
        System.out.println(category);
     }

     public void categoryDelete(Integer categoryid) {
         adminMapper.categoryDelete(categoryid);
     }


}


