package service;

import DAO.RoleDAO;
import model.Role;

import java.util.ArrayList;
import java.util.List;

public class RoleService implements Service<Role> {
    private final List<Role> roleList;
    private static RoleService roleService;
    private final RoleDAO roleDAO;

    private RoleService() {
        roleList = new ArrayList<>();
        roleDAO=new RoleDAO();
    }

    public static RoleService getInstance() {
        if (roleService == null) {
            roleService = new RoleService();
        }
        return roleService;
    }
    public Role getById(int id){
        for (Role r:roleList) {
            if(r.getId() == id){
                return r;
            }
        }return null;
    }

    @Override
    public List<Role> getList() {
        return null;
    }

    @Override
    public void create(Role role) {

    }

    @Override
    public void update(Role role) {

    }

    @Override
    public void delete() {

    }

    @Override
    public void displayALL() {

    }
}
