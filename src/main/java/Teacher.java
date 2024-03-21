import java.util.ArrayList;

public class Teacher extends Account {

    ArrayList<Integer>Rate;
    private int Grade=0;

    ArrayList<String> courses;
    String NameTeacher;
    //Constructor
//    public Teacher(String,String Teacher ,String usernaem ,String password)
//    {
//        super(usernaem,password);
//        this.courses=new ArrayList<>();
//        this.NameTeacher=Teacher;
//    }
    public Teacher(String Teacher,String usernaem ,String password)
    {
        super(usernaem,password);
        this.NameTeacher=Teacher;
        courses=new ArrayList<>();
        Rate=new ArrayList<>();

    }
    /**
     * return name
     *
     */
    public String getName()
    {
        return this.NameTeacher;
    }

    /**
     * set courses
     * @param courses
     */
    public void GetCourse(Courses courses)
    {
        this.courses.add(courses.getName());
    }

    /**
     * get Rate
     * @param Rate
     */
    public void Rate(int Rate  )
    {
        this.Rate.add(Rate);
        calculateGrade();
    }


    /**
     * calculateGrade
     */
    private void calculateGrade()
    {
        int a=0;
        for(int i:this.Rate)
        {
            a+=i;
        }
        this.Grade=a/this.Rate.size();
    }

    public int getGrade()
    {
        return this.Grade;
    }
    public boolean equal(String userName, String password) {
       if (this.getUsername().equals(userName))
       {
           if (this.validatePassword(password))
           {
               return true;
           }
           return false;
       }
       return false;
    }










}
