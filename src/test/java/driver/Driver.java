package driver;

import utilities.CSVReader;
import utilities.DBUtil;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class Driver {

    public static void main(String[] args) throws  SQLException, IOException {
        DBUtil dbUtil = new DBUtil();
        dbUtil.establishConnection("jdbc:mysql://localhost:3306/world", "root", "synechron1234", "SELECT * from world.city LIMIT 10");
        List<String> names = dbUtil.getRequiredColumnValues();
        System.out.println("Printing City names --" + names);
        dbUtil.closeConnections();
        List<String> records = CSVReader.readData("src/test/resources/Data.csv");
        System.out.println(names.equals(records));
    }


}
