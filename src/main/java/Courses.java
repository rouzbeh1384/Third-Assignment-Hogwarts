import java.util.ArrayList;

public class Courses {

    //Array of student in class
    ArrayList<String> Student ;
    //Name of Teacher
    String Teacher;

    String Time ;

    //Constructor
     public Courses(Teacher teacher) {
        this.Teacher=teacher.getName();

    }
    public Courses() {

    }
    protected  void setTime (String Stime,String Etime){
        this.Time=Stime+"--->"+Etime;
    }

    public String getTime()
    {
        return this.Time;
    }
    public void AddStudent(Student student) {
         this.Student.add(student.getName());

    }

    public void SetTeacher(String Name ){
         this.Teacher=Name;
    }

}
