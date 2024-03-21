import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Student extends Account{



    ArrayList<String> courses;
    ArrayList<String> plan;
    ArrayList<String> Grade;

    String Name ;

    String LastName;



    int AvregeGrade=0;
    //Constructor
    public Student(String Name, String LastName,String username,String password)
    {
        super(username ,password);
        this.Name=Name;
        this.LastName=LastName;
        this.courses=new ArrayList<>();
        this.plan=new ArrayList<>();
        this.Grade=new ArrayList<>();
    }

//    public Student(String Name, String LastName,String username,String password ,String mae )
//    {
//        super(username,password);
//        this.courses=new ArrayList<>();
//        this.plan=new ArrayList<>();
//        this.Grade=new ArrayList<>();
//        this.Name=Name;
//        this.LastName=LastName;
//    }

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
     * @param
     */
    public void setCourses(String coursesName,String time ) {
        this.courses.add(coursesName);
        this.plan.add(coursesName+" in this time "+time);
    }

    /**
     * return courses
     * @return
     */
    public ArrayList<String> getCourses() {
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
    public void setGrade(String grade,String courses){
       this.Grade.add(grade+" "+courses);

    }

    /**
     * for Average Grade
     */
    private int  calculsaGrade()
    {
        AvregeGrade=0;
        for (int i=0;i<Grade.size();i++)
        {
            String  regex ="\\d+(?=\\s\\w)";
            Pattern pattern=  Pattern.compile(regex);
            Matcher matcher=pattern.matcher(this.Grade.get(i));
            AvregeGrade+=  Integer.parseInt(matcher.group());
        }
        AvregeGrade/=Grade.size();
        return this.AvregeGrade;
    }


    /**
     * print grade
     */
    public void  printGrade()
    {

        System.out.println("your GPA : "+this.calculsaGrade());
        System.out.println("Lesson by lesson score \n___________________________________");
        if (!this.Grade.isEmpty())
         for (String x: this.Grade)
             System.out.println("\t"+x);
        else{
            System.out.println("NO have grade ");
        }
    }

    /**
     * Show plan of student
     */
    public void ShowPlan() {
        if (!this.plan.isEmpty())
        for(String x: this.plan)
        {
            System.out.println(x);
        }
        else {
            System.out.println("No courses exist");
        }
    }


}
