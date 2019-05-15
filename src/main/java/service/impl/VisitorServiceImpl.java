package service.impl;

import dao.VisitorDao;
import model.Visitor;
import org.springframework.stereotype.Service;
import service.VisitorService;

import javax.annotation.Resource;

@Service
public class VisitorServiceImpl implements VisitorService {
    @Resource
    private VisitorDao visitorDao;


    public Boolean insertvisitor(Visitor visitor) {
        if (visitor==null){
            return false;
        }
        Integer i = visitorDao.insertvisitor(visitor);

        if(i!=0){
            return true;
        }else {
            return false;
        }
    }

    public Visitor login(Visitor visitor) {
        if(visitor==null ){
            return null;
        }
        return visitorDao.selectvisitorbyaccountpass(visitor);
    }
}
