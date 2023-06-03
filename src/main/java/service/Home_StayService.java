package service;

import DAO.Home_StayDAO;
import model.Home_Stay;


import java.util.ArrayList;
import java.util.List;

public class Home_StayService implements Service<Home_Stay> {
    private final List<Home_Stay> home_stayList;
    private static Home_StayService home_stayService;
    private final Home_StayDAO home_stayDAO;

    private Home_StayService() {
        home_stayList = new ArrayList<>();
        home_stayDAO=new Home_StayDAO();
    }

    public static Home_StayService getInstance() {
        if (home_stayService == null) {
            home_stayService = new Home_StayService();
        }
        return home_stayService;
    }

    @Override
    public List<Home_Stay> getList() {
        return null;
    }

    @Override
    public void create(Home_Stay homeStay) {

    }

    @Override
    public void update(Home_Stay homeStay) {

    }

    @Override
    public void delete() {

    }

    @Override
    public void displayALL() {

    }
}
