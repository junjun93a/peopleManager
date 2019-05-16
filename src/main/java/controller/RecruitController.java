package controller;

import model.Recruit;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import service.RecruitService;
import utils.CurrentPage;
import utils.GetTotalPage;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class RecruitController {

    @Resource
    private RecruitService recruitService;

    @RequestMapping("tovrecruit")
    public String tovsuccess(@RequestParam(name = "currentPage",required = false)Integer currentPage, HttpServletRequest request, HttpSession session, HttpServletResponse resp){
        resp.setContentType("text/html;charset=UTF-8");
        List<Recruit> recruits = recruitService.selectAllLaunchRecruit();
        int cp = 0;
        int pageSize=5;//每页尺寸
        if (currentPage!=null){
            cp = currentPage;
        }else {
            cp=1;
        }
        List<Recruit> currentrecruits=null;
        int totalPage=1;
        if(recruits!=null){
            int totalRows = recruits.size();
            totalPage = GetTotalPage.getTp(totalRows,pageSize);
            currentrecruits=new ArrayList<>(recruits);
            List<List<Recruit>> list = CurrentPage.split(Recruit.class, currentrecruits, pageSize);
            List<Recruit> recruitList = CurrentPage.getSplit(Recruit.class, list, cp);
            session.setAttribute("recruitlist",recruitList);
            session.setAttribute("tp",totalPage);

            return "vrecruit";
        }else {
            session.setAttribute("recruitlist",null);
            session.setAttribute("tp",totalPage);
            return "vrecruit";
        }
    }
}
