package service;

import model.Recruit;

import java.util.List;

public interface RecruitService {
    boolean insertRecruit(Recruit recruit);
    boolean updateRecruit(Recruit recruit);
    boolean deleteRecruit(Integer id);
    List<Recruit> selectAllLaunchRecruit();
}
