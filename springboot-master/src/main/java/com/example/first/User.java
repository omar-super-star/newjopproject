package com.example.first;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
public class User {
    private Connection connect()  {

        // SQLite connection string
        String connectionUrl = "jdbc:sqlserver://localhost:1433;" +
                "databaseName=DataBike;" +
                "Trusted_Connection=True;" +
                "integratedSecurity=false";
        Connection connection=null;

        try  {
            connection = DriverManager.getConnection(connectionUrl,"omar","nermein2020");
            System.out.println("connect");
        }
        // Handle any errors that may have occurred.
        catch (SQLException e) {
            e.printStackTrace();
            System.out.println("error");
        }
        return connection;
    }
    public void insertDataBike(String name,
                               String brand,
                               Double ph,
                               MultipartFile file) throws IOException {
            byte[] bytes= file.getBytes();
            String sql = "INSERT INTO tabledata(name,brand,perhour,image) VALUES(?,?,?,?)";
            try (Connection conn = this.connect();
                 PreparedStatement pstmt = conn.prepareStatement(sql))
            {
                 pstmt.setString(1, name);
                 pstmt.setString(2, brand);
                 pstmt.setDouble(3, ph);
                 pstmt.setBytes(4, bytes);
                 pstmt.executeUpdate();
                System.out.println("insert good");
            }
            catch (SQLException e)
            {
                System.out.println(e.getMessage());
                System.out.println("error2");
            }

    }
    public void selectDataBike(){
        String sql = "SELECT name, brand,perhour,image FROM databike";

        try (Connection conn = this.connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql))
        {

            // loop through the result set
            while (rs.next()) {
                System.out.println(rs.getInt("id") +  "\t" +
                        rs.getString("name") + "\t" +
                        rs.getDouble("capacity"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
