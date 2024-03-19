import javax.swing.*;
import java.util.ArrayList;

public class Assistant extends  Account {


    ArrayList<Student> student;

    ArrayList<Teacher> teacher;

    ArrayList<Courses> courses;


    //Constructor
    public Assistant(String Name, String password,ArrayList<Student> student,ArrayList<Teacher> teacher ,ArrayList<Courses> courses) {
        super(Name, password);
        this.student = new ArrayList<>(student);
        this.teacher = new ArrayList<>(teacher);
        this.courses = new ArrayList<>(courses);
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

    public void addCourses(String Name ,String time) {
        try {
            Courses courses=new Courses(Name,time);
            System.out.println(courses.Time);
            this.courses.add(courses);
        }
        catch (Exception e)
        {
            System.out.println("Not");
        }

    }

    public void remveStudent(Student student) {
        String ans = JOptionPane.showInputDialog(null, "enter your password ");
        if (super.validatePassword(ans)) {
            this.student.remove(student);
        }


    }
    public void removeCourses(Courses courses)
    {
        String ans = JOptionPane.showInputDialog(null, "enter your password ");
        if (super.validatePassword(ans)) {
            this.courses.remove(courses);
        }

    }

    public void ShowStudent() {
        for (int i = 0; i < this.student.size(); i++) {
            System.out.print(this.student.get(i).getName());
        }
    }
    public boolean equal(String username,String password)
    {
        return validatePassword(password)& getUsername().equals(username);
    }
}






