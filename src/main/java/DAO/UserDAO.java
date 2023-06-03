package DAO;

import model.User;

import java.sql.Connection;
import java.util.List;

public class UserDAO {
    private final Connection connection= MyConnection.getConnection();
//    private final ClassesService classesService=ClassesService.getInstance();
    private final String SELECT_ALL_USER = "select * from students;";
    private final String SELECT_BY_ID_USER = "select * from students where id = ?;";
    private final String INSERT_INTO_USER = "insert into students(name,age,gender,address,classes_id ) value (?,?,?,?,?);";
    private final String UPDATE_BY_ID_USER = "update students set name = ?,age = ?,gender = ?,address = ?,classes_id = ?  where id = ?;";
    private final String DELETE_BY_ID_USER = "delete from students where id = ?";

    public UserDAO() {
    }
    public List<User> getUserList(){
        return null;
    }
    public void createUser(User user){

    }
    public  void updateUser(User user){

    }
    public User getUserByID(int id){
        return null;
    }
    public void deleteById(int id){

    }

}
