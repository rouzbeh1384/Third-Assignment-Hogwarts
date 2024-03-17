import java.util.ArrayList;

public class Teacher {

    ArrayList<Integer>Rate=new ArrayList<>();
    int Grade=0;

    ArrayList<Courses> courses;
    String NameTeacher;
    //Constructor
    public Teacher(ArrayList<Courses>courses,String Teacher)
    {
        this.courses=new ArrayList<>(courses);
        this.NameTeacher=Teacher;
    }

    //.....

    public String getName()
    {
        return this.NameTeacher;
    }
    public void GetCourse(Courses courses)
    {
        courses.SetTeacher(this.NameTeacher);
    }
    public void Rate(int Rate  )
    {
        this.Rate.add(Rate);
        calculateGrade();
    }
    private void calculateGrade()
    {
        int a=0;
        for(int i:this.Rate)
        {
            a+=i;
        }
        this.Grade=a/this.Rate.size();
    }


}
