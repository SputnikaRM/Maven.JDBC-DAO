package daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import models.Student;

public class Daoconcrete implements Dao{



    public Object findById(Integer id) {
        Connection connection = ConnectionFactory.getConnection();

        try{
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM students where id=" + id);

            if (rs.next()){

               return extractStudentFromResultSet(rs);
            }

        }   catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    private Student extractStudentFromResultSet(ResultSet rs) throws SQLException{
        Student student = new Student();

        student.setId(  rs.getInt("id"));
        student.setGrade(rs.getString("grade"));
        student.setLast_name(   rs.getString("last_name"));
        student.setFirst_name(rs.getString("first_name"));
        student.setAge( rs.getInt("age"));

        return student;
    }



    public List findAll() {
        return null;
    }

    public Object update(Object dto) {
        return null;
    }

    public Object create(Object dto) {
        return null;
    }

    public void delete(Integer id) {

    }
}
