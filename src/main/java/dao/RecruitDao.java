package dao;

import model.Recruit;

import java.util.List;

public interface RecruitDao {
    Integer insertRecruit(Recruit recruit);
    Integer updateRecruit(Recruit recruit);
    Integer deleteRecruit(Integer id);
    List<Recruit> selectAllLaunchRecruit();



}
