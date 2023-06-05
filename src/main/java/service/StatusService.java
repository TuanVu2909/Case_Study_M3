package service;

import DAO.StatusDAO;
import model.Role;
import model.Status;


import java.util.ArrayList;
import java.util.List;

public class StatusService implements Service<Status> {
    private final List<Status> statusList;
    private static StatusService statusService;
    private final StatusDAO statusDAO;

    private StatusService() {
        statusList = new ArrayList<>();
        statusDAO=new StatusDAO();
    }

    public static StatusService getInstance() {
        if (statusService == null) {
            statusService = new StatusService();
        }
        return statusService;
    }
    public Status getById(int id){
        return statusDAO.getById(id);
    }

    @Override
    public List<Status> getList() {
        return statusDAO.getStatusList();
    }

    @Override
    public void create(Status status) {

    }

    @Override
    public void update(Status status) {

    }

    @Override
    public void delete() {

    }

    @Override
    public void displayALL() {

    }
}
