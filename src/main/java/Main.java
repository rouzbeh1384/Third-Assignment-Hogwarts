/*
    TODO: Import all the classes that you have defined and make use of them to build the program.
 */

import javax.swing.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {



    public static void main(String[] args) {

        Hogwarts rouzbeh=new Hogwarts("rouzbeh","1234");

        runMenu(rouzbeh);
    }

    public static void runMenu(Hogwarts rouzbeh) {



     Scanner scanner=new Scanner(System.in);

        while (true) {
            System.out.print("\n\n\nhi who are you ? \n\n 1-Student 2-Teacher 3-Assistant 21-exit  \n");
            int a=scanner.nextInt();


            switch (a) {
                case 1:{
                    if (rouzbeh.student.isEmpty()) {
                        System.out.println("NO student exisit");
                        break;

                    }
                    else {
                        System.out.println("\n\n\n\nenter username : ");
                        String userName=scanner.next();

                        System.out.println("enter password : ");
                        String password=scanner.next();
                        System.out.print("\033[H\033[2J");
                        boolean find=false;
                        int i=0;
                        for (i=0;i<rouzbeh.student.size();i++) {
                            find=  rouzbeh.student.get(i).equal(userName,password);
                            if (find ==true)
                                break;
                        }
                        if (find==true)
                        {

                            System.out.format("hi %s ",rouzbeh.student.get(i).Name);

                            while (true) {
                                System.out.println("1-get courses -2 see all teacher -3 see all courses\n" +
                                        " 4-see my courses  16-removeCourses \n6- paly game  7-grade And GPA 8-plan for this term  \n\n10-change passWord 11- change username    21-back menu\n\n");
                                int b = scanner.nextInt();
                                if (b != 5)
                                    runStudent(b,rouzbeh.courses,rouzbeh,i);

                            }

                        }

                    }
                }
                break;
                case 2:{
                    if (rouzbeh.teacher.isEmpty()) {
                        System.out.println("NO teacher exisit");
                        break;
                    }
                    else
                    {
                        System.out.println("enter username : ");
                        String userName=scanner.next();
                        System.out.println(userName);
                        System.out.println("enter password : ");
                        String password=scanner.next();
                        boolean find=false;
                        int i=0;
                        for (i=0;i<rouzbeh.teacher.size();i++) {
                            find=  rouzbeh.teacher.get(i).equal(userName,password);
                            if (find ==true)
                                break;
                        }
                        if (find==true)
                        {
                            //TODO-->check i -- or not
                            System.out.format("hi %s ",rouzbeh.teacher.get(i).NameTeacher);

                            while (true) {
                                System.out.println("1-get courses 2- list of Courses 3- Set Rate For student  4-own Rate  \n5-change username 6-change password  21-back menu");
                                int b = scanner.nextInt();
                                if (b != 5)
                                    runTeacher(b,rouzbeh,i);

                            }

                        }


                    }
                }
                case 3:
                    if (rouzbeh.assistants.isEmpty()) {

                        System.out.println("NO assistant exist");
                        System.out.println("are you a new  Assistant ? enter username  password of HOGWARTS ");

                        String username= scanner.next();
                        String password= scanner.next();

                        if (rouzbeh.CheckPassword(username,password))
                        {
                            System.out.println("you can add your self to Hogwarts .");
                            System.out.println("enter you username :");
                            String user = scanner.next();
                            System.out.print("enter you password : ");
                            String pass =scanner.next();

                            rouzbeh.add_Assistant(user,pass);

                        }
                        break;
                    }
                    else
                    {
                        System.out.print("\033[H\033[2J");
                        System.out.println("\n\n\n\nenter username : ");
                        String userName=scanner.next();

                        System.out.println("enter password : ");
                        String password=scanner.next();
                        boolean find=false;
                        int i=0;
                        for (i=0;i<rouzbeh.assistants.size();i++) {
                            find=  rouzbeh.assistants.get(i).equal(userName,password);
                            if (find ==true)
                                break;
                        }
                        if (find==true)
                        {
                            //TODO-->check i -- or not
                            System.out.format("hi %s ",rouzbeh.assistants.get(i).getUsername());
                            while (true) {
                                System.out.println("1-list of student 2-list od teacher 3-list of courses\n 4-" +
                                        "create a new Student 5- add teacher 6-add courses\n 7-delete a courses 8-delete student " +
                                        "\n 10-change password 11-change username \n12-set Question \n\n   21-back menu\n\n");
                                int b = scanner.nextInt();
                                if (b != 0)
                                   runAssistant(b,i,rouzbeh);

                            }

                        }


                    }

                    break;
                case 21:
                    System.exit(0);
                    break;
            }
        }


       }

    /**
     * this function is for student and make all think for student
     * @param result
     * @param courses
     * @param rouzbeh
     * @param i
     */
    public static void runStudent(int result,ArrayList<Courses> courses,Hogwarts rouzbeh,int i) {

        Scanner get = new Scanner(System.in);
        int conter = 0;
        switch (result) {
            case 1:{
                    System.out.println("this is a all courses that exist");
                    for (Courses x : courses) {

                        conter++;
                        System.out.format("%d - %s\n\n", conter, x.getName());
                    }
                    int NumberCourses = get.nextInt();
                    try {

                        String coursesName=courses.get(NumberCourses-1).getName();
                        String time =courses.get(NumberCourses-1).Time;

                        rouzbeh.student.get(i).setCourses(coursesName,time);
                        System.out.println(" successful ");
                    }
                    catch (Exception e) {System.out.println("Not successful ");}

                }
                break;
            case 2: {
                for (Teacher x : rouzbeh.teacher) {
                    conter = 0;
                    conter++;
                    System.out.format("%d - %s", conter, x.NameTeacher);
                }
            }
                 break;
            case 3: {
                for (Courses x : rouzbeh.courses) {
                    conter = 0;
                    conter++;
                    System.out.format("\n%d - %s\n", conter, x.getName());
                }
            }
                 break;
            case 4: {
                try {
                    System.out.println("\n\n\tyour courses\n\n");
                    conter=0;
                    for (String  x : rouzbeh.student.get(i).courses) {
                        conter++;
                        System.out.format("\t%d --> %s\n",conter,x);
                    }

                    System.out.println("\n\n");
                }catch (Exception e)
                {
                    System.out.println("Not Successful");
                }
            break;
            }

            case 16:
            {
                String remove="";

                System.out.println("if  you want to remove one of these courses enter Name  \n\n");
                try {
                    System.out.println("if  you want to remove one of these courses enter Name  \n\n");
                    conter = 0;
                    for (String x : rouzbeh.student.get(i).courses) {
                        conter++;
                        System.out.format("\t%d --> %s\n", conter, x);
                    }
                }catch (Exception e) {
                    System.out.println("error in print courses");
                }
                try {
                    Scanner scanner=new Scanner(System.in);
                   remove= scanner.next();
                    rouzbeh.student.get(i).courses.remove(remove);
                    System.out.println("Successful");
                }catch (Exception e)
                {
                    System.out.println("erroe in get removing ");
                }
                try {

                    int con=0;
                   for(String x:rouzbeh.student.get(i).plan) {
                    if (x.contains(remove))
                    {
                        rouzbeh.student.get(i).plan.remove(con);
                        break;
                    }
                    con++;
                   }
                }catch (Exception e){
                System.out.println("Not remove for plan ");
                }
            }
            break;
            //paly game and increase grade
            case 6:
            {
                 System.out.println("you are in a game for fun please try and answer correct \nif answer correct all of question your GPA increase 0.5 point  ");
                 System.out.println("Start");
                 int nmber =0;
                 int a=0;


                 try {
                     for ( a = 0; a < rouzbeh.assistants.get(0).QuestionANDans.size(); a++) {

                        System.out.print("Q "+(a+1)+" ");
                        int Q=  rouzbeh.assistants.get(0).QuestionANDans.get(a).indexOf("-");
                        System.out.println( rouzbeh.assistants.get(0).QuestionANDans.get(a).substring(0,Q)+": ");

                        System.out.print("enter ans: ");
                         Scanner scanner = new Scanner(System.in);
                         String  ans = scanner.next();
                         if (rouzbeh.assistants.get(0).QuestionANDans.get(a).contains(ans)) {
                             System.out.println("correct ANSEWR");
                             nmber++;
                         }

                     }
                     if (nmber==rouzbeh.assistants.get(0).QuestionANDans.size())
                     {
                        rouzbeh.student.get(i).AvregeGrade++;
                         System.out.println("Successful");
                     }
                 }catch(Exception w){
                        System.out.println("No ");
                     }

            }
            break;
            case 7:
            {
                try {
                    int number=0;
                    for (String x:rouzbeh.student.get(i).Grade) {
                       System.out.println(rouzbeh.student.get(i).Grade.get(number));
                        number++;
                    }
                }catch (Exception e)
                {
                    System.out.println("Not successful ");
                }
            }
            break;
            case 8:
            {
                System.out.println("\n\tthis you plan for this term \n\n");
                System.out.println("\n________________________________________________________\n\n");
                //TODO sort plan

                rouzbeh.student.get(i).ShowPlan();
            }
            break;
            case 9: {
                try {
                    String ans = JOptionPane.showInputDialog(null, "enter last Passwo word ", "", JOptionPane.QUESTION_MESSAGE);
                    if (rouzbeh.student.get(i).validatePassword(ans)) {
                        String ans1 = JOptionPane.showInputDialog(null, "enter new Passwo word ", "", JOptionPane.INFORMATION_MESSAGE);
                        rouzbeh.student.get(i).changePassword(ans1);
                    }
                }catch (Exception e)
                {
                    System.out.println("Not successful");
                }
            }
            break;
            case 10: {
                try {
                    String ans = JOptionPane.showInputDialog(null, "Enter  Passwo word ", "", JOptionPane.QUESTION_MESSAGE);
                    if (rouzbeh.student.get(i).validatePassword(ans)) {
                        String ans1 = JOptionPane.showInputDialog(null, "enter new username ", "", JOptionPane.INFORMATION_MESSAGE);
                        rouzbeh.student.get(i).changePassword(ans1);
                    }
                }catch (Exception e)
                {
                    System.out.println("NOT Successful");
                }
            }
            break;
            case 21:
                runMenu(rouzbeh);
            break;
        }
    }

    /**
     * this function is for teacher  and make all think for teacher
     * @param result
     * @param rouzbeh
     * @param i
     */
    public  static void runTeacher(int result,Hogwarts rouzbeh,int i){
        System.out.format(" Hi %s \n",rouzbeh.teacher.get(i).NameTeacher);
        Scanner get=new Scanner(System.in);
        switch (result) {
            /**
             * set courses
             */
            case 1: {
                System.out.println("this is a all courses that exist");
                for (Courses x : rouzbeh.courses) {
                    int conter = 0;
                    conter++;
                    System.out.format("%d - %s", conter, x.getName());
                }
                int NumberCourses = get.nextInt();
                rouzbeh.teacher.get(i).GetCourse(rouzbeh.courses.get(NumberCourses));
                System.out.println("successful ");
            }
            break;
            /**
             * see all courses
             */
            case 2: {
                for (Courses x : rouzbeh.courses) {
                    int conter = 0;
                    conter++;
                    System.out.format("%d - %s", conter, x.getName());
                    //TODO->>choose courses and show student
                }
            }
            break;
            /**
             * set grade for Student
             */
            case 3:{
                int conter ;
                for (Student x : rouzbeh.student) {
                    conter=0;
                    conter++;
                    System.out.format("%d - %s", conter, x.getName());
                }
                System.out.format("enter ID of student (number )\n");
                int NumberCourses = get.nextInt();


                for (String x : rouzbeh.student.get(NumberCourses).courses) {
                    conter = 0;
                    conter++;
                    System.out.format("%d - %s", conter, x);
                }
                System.out.println("enter number of curses");
                String Cor= get.next();

                System.out.println("enter grade : ");
                int Grade = get.nextInt();


                rouzbeh.student.get(NumberCourses-1).setGrade(String.valueOf(Grade),Cor);
                System.out.println("successful ");

            }
            break;
            case 4:
                System.out .format("your Grade is %s",rouzbeh.teacher.get(i).getGrade());
            break;
            case 10:
            {
                System.out.println("enter  password ");
                Scanner scanner3=new Scanner(System.in);
                String pass = scanner3.next();
                try {
                    if (rouzbeh.teacher.get(i).validatePassword(pass)) {
                        System.out.println("enter new user name ");
                        String newusername = scanner3.next();
                        rouzbeh.teacher.get(i).changeUsername(newusername);
                        System.out.println("\nSuccessful");
                    }
                }catch (Exception e)
                {
                    System.out.println("\nNot Successful");
                }
            }
            break;
            case 11:
            {
                System.out.println("enter  password ");
                Scanner scanner3=new Scanner(System.in);
                String pass = scanner3.next();
                try {
                    if (rouzbeh.teacher.get(i).validatePassword(pass)) {
                        System.out.println("enter new password ");
                        String newusername = scanner3.next();
                        rouzbeh.teacher.get(i).changePassword(newusername);
                        System.out.println("\nSuccessful");
                    }
                }catch (Exception e)
                {
                    System.out.println("\nNot Successful");
                }
            }





        }


        }

    /**
     * this for assistant and check
     * @param result
     * @param i
     * @param hogwarts
     */
    public static void runAssistant(int result ,int i  ,Hogwarts hogwarts)
     {
        switch (result) {
            case 1:
                System.out.println("list of Student in School: \n\n\n");
                int conter = 0;
                for (Student x : hogwarts.student) {
                    conter++;
                    System.out.format("%d -> %s\n", conter, x.getName());
                }
                System.out.println("\n");
                break;
                case 2:
                    System.out.println("list of Teacher in School with grade: \n");
                    conter = 0;
                    for (Teacher x : hogwarts.teacher) {
                        conter++;
                        System.out.format("%d -> %s   -- %s \n", conter, x.getName(), x.getGrade());
                    }
                    break;
                case 3:
                    System.out.println("list of courses in school with time  :");
                    conter = 0;
                    for (Courses x : hogwarts.courses) {
                        conter++;
                        System.out.format("%d -> %s   -- %s\n ", conter, x.getName(), x.getTime());
                    }

                break;
            case 4: {
                System.out.println("fill information for create a new student by default password is---> 1234 ");
                System.out.println("enter Name of Student: ");
                Scanner scanner = new Scanner(System.in);
                String name = scanner.next();

                System.out.println("enter Last Name");
                String LastName = scanner.next();

                System.out.println("enter Usename ");
                String username = scanner.next();
                try {

                    Student newStudent = new Student(name, LastName, username, "1234");
                    hogwarts.student.add(newStudent);
                    System.out.println("successful");
                }
               catch (Exception e)
               {
                   System.out.println("not successful");
               }


            }
            break;

            /**
             * Add teacher
             */
            case 5: {
                    System.out.println("fill information for create a new Teacher by default password is 1234 ");

                    System.out.println("enter Name of Teacher: ");
                    Scanner scanner = new Scanner(System.in);
                    String name = scanner.next();


                    System.out.println("enter Usename ");
                    String username = scanner.next();
                     try {
                         Teacher teacher=new Teacher(name,username,"1234");
                         hogwarts.teacher.add(teacher);
                         System.out.println("successful");
                     }
                    catch (Exception e)
                    {
                        System.out.println("not successful");
                    }

                }
            break;

            case 6:
            {
                System.out.println("fill information for create a new courses ");

                System.out.println("enter Name of course: ");
                Scanner scanner = new Scanner(System.in);
                String name = scanner.next();

                System.out.println("enter time start of class");
                String timeS=scanner.next();

                System.out.println("enter time end of class");
                String timeE=scanner.next();
                try {
                    Courses courses=new Courses(name ,(timeS+"--->"+timeE));
                    hogwarts.courses.add(courses);
                    System.out.println("successful");
                }
                catch (Exception e)
                {
                    System.out.println("not successful");
                }
            }
            break;
            case 7:{
                System.out.println("choose the courses for delete");
                conter=0;
                for (Courses x:hogwarts.courses)
                {
                    conter++;
                    System.out.format("%d ---> %s\n ",conter,hogwarts.courses.get(conter-1).getName() );
                }
                Scanner scanner=new Scanner(System.in);
                    try {
                        int Id= scanner.nextInt();
                        hogwarts.courses.remove(Id-1);

                        System.out.println("Successful");

                    }
                    catch (Exception e )
                    {
                        System.out.println("Not successful  ");
                    }


            }
            break;
            case 8:
                System.out.println("choose the Student for delete");
                conter=0;
                for (Student x:hogwarts.student)
                {
                    conter++;
                    System.out.format("%d ---> %s\n ",conter,hogwarts.student.get(conter-1).getName() );
                }
                Scanner scanner=new Scanner(System.in);
                try {
                    int Id= scanner.nextInt();
                    hogwarts.student.remove(Id-1);

                    System.out.println("Successful");

                }
                catch (Exception e )
                {
                    System.out.println("Not successful  ");
                }
                break;

            case 10:
            {
                System.out.println("enter last password ");

                Scanner scanner2=new Scanner(System.in);
                String pass = scanner2.next();
                try {
                    if (hogwarts.assistants.get(i).validatePassword(pass)) {
                        String newpass = scanner2.next();
                        hogwarts.assistants.get(i).changePassword(newpass);
                        System.out.println("\nSuccessful");
                    }
                }catch (Exception e)
                {
                    System.out.println("\nNot Successful");
                }
            }
            break;
            case 11:
            {
                System.out.println("enter  password ");
                Scanner scanner3=new Scanner(System.in);
                String pass = scanner3.next();
                try {
                    if (hogwarts.assistants.get(i).validatePassword(pass)) {
                        System.out.println("enter new user name ");
                        String newusername = scanner3.next();
                        hogwarts.assistants.get(i).changeUsername(newusername);
                        System.out.println("\nSuccessful");
                    }
                }catch (Exception e)
                {
                    System.out.println("\nNot Successful");
                }
            }
            break;
            case 12:{
                //TODO->game 7
                System.out.println("eneter question ");
                Scanner scanner1=new Scanner(System.in);
                String Q=scanner1.nextLine();
                String ans=scanner1.next();
                try {
                    hogwarts.assistants.get(i).setQuestion(Q, ans);
                }catch (Exception E) {
                    System.out.println("Not Successful to set Question ");
                }
            }
            break;
            case 21:
                System.out.println("successful");
                runMenu(hogwarts);
                break;

        }


    }



    }




