package controller;

import model.Resume;
import model.Send;
import model.Visitor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import service.ResumeService;
import service.SendService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class SendController {

    @Resource
    private SendService sendService;
    @Resource
    private ResumeService resumeService;

    @RequestMapping("tosend")
    public String tosend(Integer rid,HttpSession session, HttpServletRequest req, HttpServletResponse resp)throws Exception{
        Visitor visitor =(Visitor) session.getAttribute("visitor");
        List<Resume> resumes = resumeService.selectResumebyvid(visitor.getT_ID());
        session.setAttribute("sendrid",rid);
        session.setAttribute("resumes",resumes);
        return "choiceresume";
    }

    @RequestMapping("addsend")
    public void addsend(Integer resumeid,HttpSession session, HttpServletRequest req, HttpServletResponse resp)throws Exception{
        resp.setContentType("text/html;charset=UTF-8");
        Integer recuriteid =(Integer) session.getAttribute("sendrid");
        Visitor visitor =(Visitor) session.getAttribute("visitor");
        Send send=new Send(recuriteid,visitor.getT_ID(),resumeid,0);
        if(sendService.insertSend(send)){
            resp.getWriter().write("<script>alert(\"投递成功\");window.location.href='tovrecruit';</script>");
        }else {
            resp.getWriter().write("<script>alert(\"投递失败\");window.location.href='tovrecruit';</script>");
        }
    }
    @RequestMapping("tosendview")
    public void sendview( HttpServletRequest req, HttpServletResponse resp)throws Exception{
        req.getRequestDispatcher("/WEB-INF/page/sendview.jsp").forward(req,resp);
    }


}
