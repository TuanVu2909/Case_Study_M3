//package DAO;
//
//import model.Home_Stay;
//import model.User;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
//
//public class Home_StayDAO {
//    private final Connection connection;
//    private final String SELECT_ALL = "select * from home_stay;";
//    private final String SELECT_BY_ID = "select * from home_stay where id = ?;";
//    private final String INSERT_INTO = "insert into home_stay(name,address,depict,price,avatar,admin_id) value (?,?,?,?,?,?);";
//    private final String UPDATE_BY_ID = "update product set name = ?,address= ?,depict=?,price = ?,avatar = ?, admin_id = ? where id = ?;";
//    private final String DELETE_BY_ID = "delete from home_stay where id = ?";
//    private final String SEARCH_NAME = "select * from home_stay where name like ?;";
//
//    public Home_StayDAO() {
//        connection = MyConnection.getConnection();
//    }
//    public List<Home_Stay> findAll() {
//        List<Home_Stay> productList = new ArrayList<>();
//        try(PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL)){
//            ResultSet resultSet = preparedStatement.executeQuery();
//            while (resultSet.next()){
//                int id = resultSet.getInt("id");
//                String name = resultSet.getString("name");
//                String address = resultSet.getString("address");
//                String depict = resultSet.getString("depict");
//                double price = resultSet.getDouble("price");
//                String  avatar = resultSet.getString("avatar");
//                int admin_id = resultSet.getInt("admin_id");
//                User user = categoryService.getById(categoryId) ;
//                Product product = new Product(id,name,price,quantity,category);
//                productList.add(product);
//            }
//        }catch (SQLException e){
//            e.printStackTrace();
//        }
//        return productList;
//    }
//
//    public Product findById(Long id) {
//        Product product = null;
//        try(PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_ID)){
//            preparedStatement.setLong(1,id);
//            ResultSet resultSet = preparedStatement.executeQuery();
//            while (resultSet.next()){
//                String name = resultSet.getString("name");
//                double price = resultSet.getDouble("price");
//                int  quantity = resultSet.getInt("quantity");
//                Long categoryId = resultSet.getLong("category_id");
//                Category category = categoryService.getById(categoryId);
//                product = new Product(id,name,price,quantity,category);
//            }
//        }catch (SQLException e){
//            e.printStackTrace();
//        }
//        return product;
//    }
//
//    public void addProduct(Product product) {
//        try(PreparedStatement preparedStatement = connection.prepareStatement(INSERT_INTO)) {
//            preparedStatement.setString(1, product.getName());
//            preparedStatement.setDouble(2, product.getPrice());
//            preparedStatement.setInt(3, product.getQuantity());
//            preparedStatement.setLong(4, product.getCategory().getId());
//            preparedStatement.executeUpdate();
//        }catch (SQLException e){
//            e.printStackTrace();
//        }
//    }
//
//    public void updateProduct(Product product) {
//        try(PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_BY_ID)) {
//            preparedStatement.setLong(5,product.getId());
//            preparedStatement.setString(1,product.getName());
//            preparedStatement.setDouble(2,product.getPrice());
//            preparedStatement.setInt(3,product.getQuantity());
//            preparedStatement.setLong(4,product.getCategory().getId());
//            preparedStatement.executeUpdate();
//        }catch (SQLException e){
//            e.printStackTrace();
//        }
//    }
//
//    public void deleteById(Long id) {
//        try(PreparedStatement preparedStatement = connection.prepareStatement(DELETE_BY_ID)){
//            preparedStatement.setLong(1,id);
//            preparedStatement.executeUpdate();
//        }catch (SQLException e){
//            e.printStackTrace();
//        }
//    }
//    public List<Product> searchName(String name){
//        List<Product> productList = new ArrayList<>();
//        try(PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_NAME)) {
//            preparedStatement.setString(1,"%" + name + "%" );
//            ResultSet resultSet = preparedStatement.executeQuery();
//            while (resultSet.next()){
//                Long id = resultSet.getLong("id");
//                String name1 = resultSet.getString("name");
//                double price = resultSet.getDouble("price");
//                int  quantity = resultSet.getInt("quantity");
//                Long categoryId = resultSet.getLong("category_id");
//                Category category = categoryService.getById(categoryId);
//                Product product = new Product(id,name1,price,quantity,category);
//                productList.add(product);
//            }
//        }catch (SQLException e){
//            e.printStackTrace();
//        }
//        return productList;
//    }
//
//}