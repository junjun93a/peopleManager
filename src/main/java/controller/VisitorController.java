package controller;

import model.Visitor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import service.VisitorService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class VisitorController {

    @Resource
    private VisitorService visitorService;

    @RequestMapping("loginv")
    public String loginv(Visitor visitor, HttpSession session, HttpServletResponse resp)throws Exception{
        resp.setContentType("text/html;charset=UTF-8");
        Visitor visitor1 = visitorService.login(visitor);
        if(visitor1!=null){
            session.setAttribute("visitor",visitor1);
            return "vsuccess";
        }
        return "loginview";
    }

    @RequestMapping("tologinview")
    public String tologinv()throws Exception{
        return "loginview";
    }

    @RequestMapping("registerS")
    public void RegisterServlet(Visitor visitor,HttpServletRequest req, HttpServletResponse resp)throws Exception{
        resp.setContentType("text/html;charset=UTF-8");
        if(visitorService.insertvisitor(visitor)) {
            resp.getWriter().write("<script>alert(\"注册成功\");window.location.href='toindex';</script>");
        }else {
            resp.getWriter().write("<script>alert(\"注册失败\");window.location.href='toindex';</script>");
        }
    }

    @RequestMapping("toindex")
    public String toindex()throws Exception{
        return "../../index";
    }

    @RequestMapping("toregisterv")
    public String toregisterv()throws Exception{
        return "registerview";
    }

}
