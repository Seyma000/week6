import java.sql.*;

public class JDBC {
    public static final String DB_URL = "jdbc:mysql://localhost/JDBC";
    public static final String DB_USERNAME = "root";
    public static final String DB_PASSWORD = "mysql";

    public static void main(String[] args) {

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
             Statement st = conn.createStatement()) {

            // Statement ile Insert İşlemi
            String updateQuery1 = "INSERT INTO employees (name, position, salary) VALUES ('Şeyma' , 'CEO CoFounder' , 90000.00)";
            String updateQuery2 = "INSERT INTO employees (name, position, salary) VALUES ('Nida' , 'Backend Developer' , 1000.00)";
            String updateQuery3 = "INSERT INTO employees (name, position, salary) VALUES ('Abdulkerim' , 'FullBack Developer' , 1000.00)";
            String updateQuery4 = "INSERT INTO employees (name, position, salary) VALUES ('Barış' , 'software' , 10.000)";
            String updateQuery5 = "INSERT INTO employees (name, position, salary) VALUES ('Göksu' , 'Software Developer' , 50.000)";

//            st.executeUpdate(updateQuery1);
//            st.executeUpdate(updateQuery2);
//            st.executeUpdate(updateQuery3);
//            st.executeUpdate(updateQuery4);
//            st.executeUpdate(updateQuery5);

            // Statement ile Delete İşlemi
            String deleteQuery = "DELETE FROM employees WHERE id BETWEEN 6 AND 9"  ;
            st.executeUpdate(deleteQuery);


            // Verileri okuma
            ResultSet resultSet = st.executeQuery("SELECT * FROM employees");
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String position = resultSet.getString("position");
                int salary = resultSet.getInt("salary");

                // Okunan verileri ekrana yazdırma
                System.out.println("ID : " + id);
                System.out.println("Adı : " + name);
                System.out.println("Pozisyon : " + position);
                System.out.println("Maaş : " + salary);
                System.out.println("#################");
            }
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
    }
}
