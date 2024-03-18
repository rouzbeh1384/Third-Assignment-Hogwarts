import java.util.ArrayList;

public class Hogwarts {

    // TODO: Define Attributes

    ArrayList<Student> student=new ArrayList<>();

    ArrayList<Teacher> teacher=new ArrayList<>();

    ArrayList<Courses> courses=new ArrayList<>();


    // TODO: Define Functionalities
    public void viewAllTeachers() {
        //TODO
    }

    public void viewAllStudents() {
        //TODO
    }

    public void viewAllCourses() {
        //TODO
    }

    public void add_Assistant(String Name ,String password)
    {
        Assistant assistant=new Assistant(Name,password,student,teacher,courses);
    }




}
