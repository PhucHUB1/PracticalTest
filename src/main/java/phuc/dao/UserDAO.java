package phuc.dao;

import phuc.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class UserDAO {
    private final Connection connection;

    public UserDAO(Connection connection) {
        super();
        this.connection = connection;
    }

    public boolean userRegister(User user) {
        boolean isSuccess = false;

        try {
            // insert user in db
            String sql = "insert into phuc.user(fullName, email, password) values(?,?,?)";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, user.getFullName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getPassword());

            preparedStatement.executeUpdate();
            isSuccess = true; // if query execute successfully then isSuccess becomes true otherwise false...

        } catch (Exception e) {
            e.printStackTrace();
        }

        return isSuccess;
    }

    // when call loginUser() method, it checks that particular user available or
    // not?
    // if not available then return null user object.
    // and if particular user available then, create User object(i.e user) and fetch
    // all the data of that user from db
    // and return that specific users object.
    public User loginUser(String email, String password) {

        User user = null;

        try {
            String sql = "select * from phuc.user where email=? and password=?";

            PreparedStatement pstmt = this.connection.prepareStatement(sql);
            pstmt.setString(1, email);
            pstmt.setString(2, password);

            ResultSet resultSet = pstmt.executeQuery();
            while (resultSet.next()) {
                // if any row available, then fetch the data of that row...

                // create new user object
                user = new User();
                user.setId(resultSet.getInt("id"));
                user.setFullName(resultSet.getString("fullName"));
                user.setEmail(resultSet.getString("email"));
                user.setPassword(resultSet.getString("password"));

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return user;

    }

    /*Check old password*/
    public boolean checkOldPassword(int userId, String oldPassword) {
        boolean isSuccess = false;

        try {

            String sql = "select * from phuc.user where id=? and password=?";
            PreparedStatement pstmt = this.connection.prepareStatement(sql);
            pstmt.setInt(1, userId);
            pstmt.setString(2, oldPassword);

            ResultSet resultSet = pstmt.executeQuery();
            //System.out.println(resultSet);
            while (resultSet.next()) {
                isSuccess = true;
            }


        } catch (Exception e) {
            e.printStackTrace();
        }

        return isSuccess;
    }

    //change password
    public boolean changePassword(int userId, String newPassword) {

        boolean isSuccess = false;

        try {

            String sql = "update phuc.user set password=? where id=?";
            PreparedStatement pstmt = this.connection.prepareStatement(sql);
            pstmt.setString(1, newPassword);
            pstmt.setInt(2, userId);

            pstmt.executeUpdate();

            isSuccess = true;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return isSuccess;
    }

}