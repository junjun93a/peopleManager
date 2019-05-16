package service.impl;

import dao.RecruitDao;
import model.Recruit;
import org.springframework.stereotype.Service;
import service.RecruitService;

import javax.annotation.Resource;
import java.util.List;
@Service
public class RecruitServiceImpl implements RecruitService {
    @Resource
    private RecruitDao recruitDao;

    public boolean insertRecruit(Recruit recruit) {
        return true;
    }

    public boolean updateRecruit(Recruit recruit) {
        return true;
    }

    public boolean deleteRecruit(Integer id) {
        return true;
    }

    public List<Recruit> selectAllLaunchRecruit() {
        return recruitDao.selectAllLaunchRecruit();
    }
}
