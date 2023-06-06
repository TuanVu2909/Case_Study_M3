package service;

import DAO.Home_StayDAO;
import model.Home_Stay;
import model.Status;
import model.User;


import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

public class Home_StayService implements Service<Home_Stay> {
    private final List<Home_Stay> home_stayList;
    private static Home_StayService home_stayService;
    private static StatusService statusService = StatusService.getInstance();
    private static UserService userService = UserService.getInstance();
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
    public List<Home_Stay> searchByStatus2(){
        return home_stayDAO.getStatus2();
    }

    @Override
    public void displayALL() {

    }
    public boolean checkID(int id){
        Home_Stay home_stay = home_stayDAO.getHomeStayByID(id);
        return  home_stay != null;
    }
    public void save(HttpServletRequest request){
        String id =request.getParameter("id");
        String home_name = request.getParameter("home_name");
        String address = request.getParameter("address");
        String depict = request.getParameter("depict");
        double price = Double.parseDouble(request.getParameter("price"));
        String  avatar = request.getParameter("avatar");
        int admin_id = Integer.parseInt(request.getParameter("admin_id"));
        int status_id = Integer.parseInt(request.getParameter("status_id"));
        User user = userService.getUserByID(admin_id) ;
        Status status = statusService.getById(status_id);

        if(id != null){
            int idUpdate = Integer.parseInt(id);
            Home_Stay homeStay = new Home_Stay(idUpdate,home_name,address,depict,price,avatar,user,status);
            home_stayDAO.update(homeStay);
        }else {
            Home_Stay homeStay = new Home_Stay(home_name,address,depict,price,avatar,user,status);
            home_stayDAO.create(homeStay);
        }

    }
}
