package service;

import DAO.ActionDAO;
import DAO.RoleDAO;
import model.Action;
import model.Role;

import java.util.ArrayList;
import java.util.List;

public class ActionService  implements Service<Action> {
    private final List<Action> actionList;
    private static ActionService actionService;
    private final ActionDAO actionDAO;

    private ActionService() {
        actionList = new ArrayList<>();
        actionDAO=new ActionDAO();
    }

    public static ActionService getInstance() {
        if (actionService == null) {
            actionService = new ActionService();
        }
        return actionService;
    }
    public Action getById(int id){
        return actionDAO.getById(id);
    }


    @Override
    public List<Action> getList(BookingService bookingService) {
        return actionDAO.getActionList();
    }

    @Override
    public void create(Action action) {

    }

    @Override
    public void update(Action action) {

    }

    @Override
    public void delete() {

    }

    @Override
    public void displayALL() {

    }
}
