package models;

public class Student implements DTO {
    private Integer id;
    private String first_name;
    private String last_name;
    private Integer age;
    private String grade;

    public Student(){}

    public Student(String first_name, String last_name, Integer age, String grade){
        this.first_name=first_name;
        this.last_name=last_name;
        this.age=age;
        this.grade=grade;
    }


    public Student (Integer id, String first_name, String last_name, Integer age, String grade){
        this.id = id;
        this.first_name=first_name;
        this.last_name=last_name;
        this.age=age;
        this.grade=grade;

    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }


    public Integer getId(){
        return id;
    }
}
