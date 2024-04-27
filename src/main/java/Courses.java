import java.util.ArrayList;

public class Courses {

    //Array of student in class
    ArrayList<Student> Student ;
    //Name of Teacher
    Teacher teacher;

    String Time ;

    private String Name;

    //Constructor
//     public Courses(Teacher teacher,String Name) {
//        this.teacher=teacher;
//        this.Name=Name;
//    }
    public Courses(String Name,String time)
    {
        this.Name=Name;
        this.Time=time;
    }
    public Courses() {

    }
    public   void setTime (String Stime,String Etime){
        this.Time=Stime+"--->"+Etime;
    }

    public String getTime()
    {
        return this.Time;
    }
    public void AddStudent(Student student) {
         this.Student.add(student);
    }

    public void SetTeacher(Teacher teacher){
         this.teacher=teacher;
    }


    /**
     * return Name of courses
     * @return
     */
    public String getName() {return this.Name;}

}
