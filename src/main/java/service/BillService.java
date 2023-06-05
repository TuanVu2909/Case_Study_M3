package service;

import DAO.BillDAO;
import DAO.RoleDAO;
import model.Bill;
import model.Role;

import java.util.ArrayList;
import java.util.List;

public class BillService implements Service<Bill> {
    private final List<Bill> billList;
    private static BillService billService;
    private final BillDAO billDAO;
    private BillService() {
        billList = new ArrayList<>();
        billDAO=new BillDAO();
    }

    public static BillService getInstance() {
        if (billService == null) {
            billService = new BillService();
        }
        return billService;
    }


    @Override
    public List<Bill> getList() {
        return null;
    }

    @Override
    public void create(Bill bill) {
        billDAO.create(bill);
    }

    @Override
    public void update(Bill bill) {

    }

    @Override
    public void delete() {

    }

    @Override
    public void displayALL() {

    }
}
