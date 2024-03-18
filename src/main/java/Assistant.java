import javax.swing.*;
import java.util.ArrayList;

public class Assistant extends  Account {


    ArrayList<Student> student;

    ArrayList<Teacher> teacher;

    ArrayList<Courses> courses;


    //Constructor
    public Assistant(String Name, String password,ArrayList<Student> student,ArrayList<Teacher> teacher ,ArrayList<Courses> courses) {
        super(Name, password);
        student = new ArrayList<>(student);
        teacher = new ArrayList<>(teacher);
        courses = new ArrayList<>(courses);
    }



    //---------------------------
    public void addStudent(String Name ,String LastName  ,String userName ,String password) {
        Student student=new Student(Name,LastName,userName,password);
            this.student.add(student);
    }

    public void addTeacher(String Name,String usernaem ,String password) {
        Teacher teacher=new Teacher(Name,usernaem,password);
            this.teacher.add(teacher);
    }

    public void addCourses(Courses courses) {
            this.courses.add(courses);
    }

    public void remveStudent(Student student) {
        String ans = JOptionPane.showInputDialog(null, "enter your password ");
        if (super.validatePassword(ans)) {
            this.student.remove(student);
        }


    }

    public void ShowStudent() {
        for (int i = 0; i < this.student.size(); i++) {
            System.out.print(this.student.get(i).getName());
        }
    }
}






