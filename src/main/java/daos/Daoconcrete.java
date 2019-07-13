package daos;

import java.sql.*;
import java.util.ArrayList;
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
        Connection conn = ConnectionFactory.getConnection();

        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT  * FROM students");

            List<Student> students = new ArrayList<Student>();

            while (rs.next())
            {
                Student student = extractStudentFromResultSet(rs);
                students.add(student);
            }
            return students;

        } catch (SQLException ex){
            ex.printStackTrace();
        }

        return null;
    }

    public Boolean update(Student student) {
        Connection conn = ConnectionFactory.getConnection();

        try {
            PreparedStatement ps = conn.prepareStatement("UPDATE student SET first_name=?, last_name=?,age=?,grade=? where id=?");
            ps.setString(1,student.getFirst_name());
            ps.setString(2,student.getLast_name());
            ps.setInt(3,student.getAge());
            ps.setString(4,student.getGrade());
            ps.setInt(5,student.getId());
            int x = ps.executeUpdate();

            if(x ==1){
                return true;
            }
        }   catch (SQLException ex){
            ex.printStackTrace();
        }
        return false;
    }

    public Object create(Student student) {
        Connection conn = ConnectionFactory.getConnection();
        try{
            PreparedStatement ps = conn.prepareStatement("INSERT into student VALUES (?,?,?,?,?)");
            ps.setInt(1,student.getId());
            ps.setString(2,student.getGrade());
            ps.setString(3,student.getLast_name());
            ps.setString(4,student.getFirst_name());
            ps.setInt(5,student.getAge());
            int x = ps.executeUpdate();

            if(x==1){
                return true;
            }
        }

        catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public Boolean delete(Integer id) {
        Connection conn = ConnectionFactory.getConnection();

        try{
            Statement stmt = conn.createStatement();
            int x = stmt.executeUpdate("DELETE FROM student where id=" + id);

            if(x==1){
                return true;
            }
        } catch (SQLException ex){
            ex.printStackTrace();;
        }
        return false;
    }
}
