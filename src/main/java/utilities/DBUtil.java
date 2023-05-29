package utilities;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBUtil {

    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;

    public void establishConnection(String url, String username, String password, String query) {
        try {
            connection = DriverManager.getConnection(url, username, password);
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }

    public List<String> getRequiredColumnValues() throws SQLException {
        List<String> stringValues = new ArrayList<>();
        while (resultSet.next()) {
            stringValues.add(resultSet.getString("ID").concat(",")
                    + resultSet.getString("Name").concat(",")
                    + resultSet.getString("CountryCode").concat(",")
                    + resultSet.getString("District").concat(",")
                    + resultSet.getString("Population"));
        }
        return stringValues;
    }

    public void closeConnections() throws SQLException {
        resultSet.close();
        statement.close();
        connection.close();
    }

}
