package service;

import DAO.Home_StayDAO;
import model.Home_Stay;
import model.User;


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
        return home_stayDAO.getList();
    }
    public Home_Stay getHomeById(int id){
        return home_stayDAO.getHomeStayByID(id);
    }

    @Override
    public void create(Home_Stay homeStay) {
        home_stayDAO.create(homeStay);
    }


    @Override
    public void update(Home_Stay homeStay) {
        home_stayDAO.update(homeStay);
    }

    @Override
    public void delete() {

    }
    public void deleteById(int id){
        home_stayDAO.deleteById(id);
    }
    public List<Home_Stay> searchName(String name){
        return home_stayDAO.searchName(name);
    }
<<<<<<< HEAD
=======
    public List<Home_Stay> searchByStatus2(){
        return home_stayDAO.getStatus2();
    }
>>>>>>> 96410e93dc257137265f93baa71695a8fb76565c

    @Override
    public void displayALL() {

    }
}
