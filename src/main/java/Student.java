import java.util.ArrayList;

public class Student extends Account{



    ArrayList<Courses> courses;

    ArrayList<Courses> allCourses;

    String Name ;



    //Constructor
    public Student(ArrayList<Courses> courses)
    {
        super();
        this.courses=new ArrayList<>();
        this.allCourses=new ArrayList<>();
//        allCourses.replaceAll();

    }

    /**
     * set name
     * @param Name
     */
    public void setName(String Name ){
        this.Name=Name;
    }

    /**
     * getName
     * @return
     */
    public  String getName() {
        return this.Name;
    }


    /**
     * set courses for student
     * @param courses
     */
    public void setCourses(Courses courses) {
        this.courses.add(courses);
    }

    /**
     * return courses
     * @return
     */
    public ArrayList<Courses> getCourses() {
        return this.courses;
    }








}
