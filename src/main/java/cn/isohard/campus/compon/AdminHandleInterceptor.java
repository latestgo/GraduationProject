package cn.isohard.campus.compon;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 登录检查
 */
public class AdminHandleInterceptor implements HandlerInterceptor {

    //目标方法执行之前
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object admin = request.getSession().getAttribute("loginAdmin");
        if(admin == null) {
            //未登录
            String host = request.getServerName();
            String port = String.valueOf(request.getServerPort());
            String uri = request.getServletPath();
            String url = "http://" + host + ":" + port + uri;
            System.out.println(url);
            //request.getSession().setAttribute("url", url);
            request.setAttribute("msg", "请先登录");
            request.getRequestDispatcher("/admin/login").forward(request, response);
        } else {
            //request.getSession().removeAttribute("url");
            return true;
        }

        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
