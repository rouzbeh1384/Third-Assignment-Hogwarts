import java.util.ArrayList;

public class Hogwarts extends Account{

    // TODO: Define Attributes

    ArrayList<Student> student;

    ArrayList<Teacher> teacher;

    ArrayList<Courses> courses;

    ArrayList<Assistant> assistants;

    public Hogwarts(String username, String password) {
        super(username, password);
        assistants=new ArrayList<>();
        courses=new ArrayList<>();
        teacher=new ArrayList<>();
        student=new ArrayList<>();
    }

    public void add_Assistant(String Name ,String password)
    {
        Assistant assistant=new Assistant(Name,password,this.student,this .teacher,this.courses);
        this.assistants.add(assistant);
    }
    public boolean CheckPassword(String userName,String passWord)
    {
        return validatePassword(passWord) & getUsername().equals(userName);

    }




}
