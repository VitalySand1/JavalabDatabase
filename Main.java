import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;


import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;



public class Main {
    public static void main(String args[]) throws SQLException {
        Abonent A = new Abonent("Vitaly", "Sand",380380380, LocalDate.of(1998,12,14),1);
        //insertAbonent(A);
        PhoneBook P = new PhoneBook(300,"Green","Lviv",LocalDate.of(2016,05,11));
        //insertPhoneBook(P);
        //List<Abonent> ab = new ArrayList<Abonent>();
        //ab = getAllAbonents();
        //System.out.println(ab.get(0).getNomer_telefona());
        //clearAllAbonents();
    }
    public static Connection getConnection() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/laba6bd","root","root");
        return connection;
    }
    public static void  insertAbonent (Abonent a ) throws SQLException {
        Connection conn= getConnection();
        PreparedStatement statement = conn.prepareStatement("insert into abonent (Name,Surname,PhoneNumber,DateOfBirth,PhoneBookID) values('"+a.getImya()+"','"+a.getFamiliya()+"','"+a.getNomer_telefona()+"','"+a.getDateofbirth()+"','"+a.getPhonebookID()+"')");
        statement.execute();
        conn.close();
    }
    public static  List<Abonent> getAllAbonents() throws SQLException {
        List<Abonent> res = new ArrayList<Abonent>();
        Connection conn= getConnection();
        Statement statement = conn.createStatement();
        ResultSet rs = statement.executeQuery("SELECT * FROM abonent;");
        while(rs.next()){
            Abonent p = new Abonent(rs.getString("Name"),rs.getString("Surname"),rs.getInt("PhoneNumber"),rs.getTimestamp("DateOfBirth").toLocalDateTime().toLocalDate(),rs.getInt("PhoneBookID"));
            res.add(p);
        }
        return res;
    }
    public static void  insertPhoneBook (PhoneBook p ) throws SQLException {
        Connection conn= getConnection();
        PreparedStatement statement = conn.prepareStatement("insert into phonebook (CountOfPages,Color,State,YearOfPublishing) values('"+p.getCountOfPages()+"','"+p.getColor()+"','"+p.getState()+"','"+p.getYearOfPublishing()+"')");
        statement.execute();
        conn.close();
    }
    public static  List<PhoneBook> getAllPhoneBooks() throws SQLException {
        List<PhoneBook> res = new ArrayList<PhoneBook>();
        Connection conn= getConnection();
        Statement statement = conn.createStatement();
        ResultSet rs = statement.executeQuery("SELECT * FROM phonebook;");
        while(rs.next()){
            PhoneBook p = new PhoneBook(rs.getInt("CountOfPages"),rs.getString("Color"),rs.getString("State"),rs.getTimestamp("YearOfPublishing").toLocalDateTime().toLocalDate());
            res.add(p);
        }
        return res;
    }
    public static void clearAllAbonents() throws SQLException {
        Connection conn= getConnection();
        Statement statement = conn.createStatement();
        statement.execute("delete from laba6bd.abonent where idabonent>0;");
        conn.close();
    }
    public static void clearPhoneBooks() throws SQLException {
        Connection conn= getConnection();
        Statement statement = conn.createStatement();
        statement.execute("delete from laba6bd.phonebook where idphonebook>0;");
        conn.close();
    }
}
