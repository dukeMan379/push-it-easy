package utilities;

import java.sql.*;

public class DataBaseConnection {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        String dbURL = "jdbc:mysql://localhost:3306/hr";
        //String dbURL1 = "jdbc:postgresql://localhost:5432/dvdrental";
        String userName = "root"; // admin
        //String userName1 = "admin";
        String password = "admin";

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            //Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(dbURL,userName,password);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM employees WHERE last_name LIKE 'S%' LIMIT 1");
            //ResultSet resultSet = statement.executeQuery("SELECT * FROM actor WHERE first_name='Julia'");

            while (resultSet.next()){
                int employeeID = resultSet.getInt("EMPLOYEE_ID");
                //int actorID = resultSet.getInt("ACTOR_ID");
                String firstName = resultSet.getString("FIRST_NAME");
                String lastName = resultSet.getString("LAST_NAME");
                System.out.println(employeeID + " "+ firstName + " "+lastName);
            }
            connection.close();



/*
            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();

            // Print column headers
            for (int i = 1; i <= columnCount; i++) {
                System.out.print(metaData.getColumnName(i) + "\t");
            }
            System.out.println();

            // Print all rows dynamically
            while (resultSet.next()) {
                for (int i = 1; i <= columnCount; i++) {
                    System.out.print(resultSet.getString(i) + "\t");
                }
                System.out.println();
            }

 */

        }
        catch (Exception e){
            System.out.println(e);
        }




    }




}
