package FastFood.dao;

import FastFood.model.Receipts;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component("DB")
public class doa {
    private static final String URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String Username = "postgres";
    private static final String Password = "postgres";

    private static Connection connection;
    public List<Receipts> receiptsArr = new ArrayList<>();
    static {
        try {
            Class.forName("org.postgresql.Driver");
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }

        try {
            connection = DriverManager.getConnection(URL,Username,Password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void getBD(){
        try {
            Statement statement = connection.createStatement();
            String SQL = "SELECT * from receipts";
            ResultSet resultSet = statement.executeQuery(SQL);

            while (resultSet.next()){
                Receipts receipt = new Receipts();
                receipt.setId(resultSet.getInt("id"));
                receipt.setName(resultSet.getString("name"));
                receipt.setSum(resultSet.getInt("sum"));
                receiptsArr.add(receipt);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void AddToDB(int id, String Name, int sum){
        try {
            String SQL = "INSERT INTO  values (?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, Name);
            preparedStatement.setInt(3, sum);
            preparedStatement.execute();
            System.out.println("New receipt add!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
