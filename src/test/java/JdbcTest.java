import lombok.SneakyThrows;
import org.junit.jupiter.api.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class JdbcTest {

    Connection connection;

    @BeforeAll @SneakyThrows
    public void startConn(){
        connection= DriverManager.getConnection("jdbc:h2:D:\\STEP-UP\\JDBC\\Office.db");
        if (connection!=null)
            System.out.println("Connection open");
        else
            System.out.println("Connection failes");
    }

    @Test @SneakyThrows
    @DisplayName("1. Найдите ID сотрудника с именем Ann. Если такой сотрудник только один, то установите его департамент в HR.")
    public void task1(){
        int size=0;
        Statement statement=connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
        ResultSet rs=statement.executeQuery("select ID from Employee when Name='Ann'");
        if (rs != null)
        {
            rs.last();
            size = rs.getRow();
        }
        if (size==1){
            //Если такой сотрудник только один, то установите его департамент в HR.
            int dep=getDepart("HR");
            if (dep!=0)
                rs.updateInt("DepartmentID",dep);
        }

    }

    @SneakyThrows
    private int getDepart(String name) {
        int dep=0;
        Statement statement=connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
        ResultSet rs=statement.executeQuery("select ID from Department when Name='"+name+"'");
        if (rs != null)
        {
            rs.next();
            dep=rs.getInt("ID");
        }
        return dep;
    }

    @AfterAll @SneakyThrows
    public void stopConn(){
        connection= DriverManager.getConnection("jdbc:h2:~\\Office");
        if (connection!=null)
            connection.close();
        else
            System.out.println("Connection is null");
    }
}
