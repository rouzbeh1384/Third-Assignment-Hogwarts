import java.util.ArrayList;

public class Student extends Account{



    ArrayList<Courses> courses;

    ArrayList<Courses> allCourses;

    String Name ;

    String LastName;

    ArrayList<Integer> Grade=new ArrayList<>();

    int AvregeGrade=0;
    //Constructor
    public Student(String Name, String LastName,String username,String password)
    {
        super(username ,password);
        this.Name=Name;
        this.LastName=LastName;
    }

    public Student(ArrayList<Courses> courses,String Name, String LastName,String username,String password )
    {
        super(username,password);
        this.courses=new ArrayList<>();
        this.allCourses=new ArrayList<>();
        this.Name=Name;
        this.LastName=LastName;
    }

    /**
     * change name
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

    public boolean equal(String uesr,String password)
    {
        if (uesr.equals(super.getUsername())  & super.validatePassword(password))
        {
            return true;
        }

       return false;
    }

    /**
     * this is not correct of set grade for student
     * @param grade
     */
    //TODO >find better way ?
    public void setGrade(int grade){
        Grade.add(grade);
    }

    /**
     * for Average Grade
     */
    public void calculsaGrade()
    {
        AvregeGrade=0;
        for (int i=0;i<Grade.size();i++)
        {
            AvregeGrade+= Grade.get(i);
        }
        AvregeGrade/=Grade.size();

    }
    /**
     * print grade
     */
    public void  printGrade()
    {
        if (Grade.size()!=0)
         for (int x:this.Grade)
             System.out.println("\t"+x);
        else{
            System.out.println("NO have grade ");
        }
    }







}
