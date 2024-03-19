/*
    TODO: Import all the classes that you have defined and make use of them to build the program.
 */

import java.util.ArrayList;
import java.util.Scanner;

public class Main {



    public static void main(String[] args) {

        Hogwarts rouzbeh=new Hogwarts("rouzbeh","1234");
        // TODO: Program starts from here
        runMenu(rouzbeh);
    }

    public static void runMenu(Hogwarts rouzbeh) {
        // TODO: Menu will be shown here...


     Scanner scanner=new Scanner(System.in);

        while (true) {
            System.out.print("\n\n\nhi who are you ? \n 1-Student 2-Teacher 3-Assistant\n");
            int a=scanner.nextInt();

            switch (a) {
                case 1:{
                    if (rouzbeh.student.isEmpty()) {
                        System.out.println("NO student exisit");
                        break;

                    }
                    else {
                        System.out.println("enter username : ");
                        String userName=scanner.next();
                        System.out.println(userName);
                        System.out.println("enter password : ");
                        String password=scanner.next();
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
                                        " 4-see my courses  5-removeCourses \n6- paly game  7-grade     8-back menu\n\n");
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
                                System.out.println("1-set courses 2- list of Courses with Student 3- Set Rate For student  4-own Rate  5-back menu");
                                int b = scanner.nextInt();
                                if (b != 5)
                                    runTeacher(b,rouzbeh,i);

                            }

                        }


                    }
                }
                case 3:
                    if (rouzbeh.assistants.isEmpty()) {
                        System.out.format(String.valueOf(rouzbeh.assistants.size()));
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
                            System.out.format(String.valueOf(rouzbeh.assistants.size()));

                        }
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
                                        "create a new Student 5- add teacher 6-add courses\n 7-delete a courses 8-delete student   21-back menu\n\n");
                                int b = scanner.nextInt();
                                if (b != 0)
                                   runAssistant(b,i,rouzbeh);

                            }

                        }


                    }
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
//                        rouzbeh.student.get(i).setCourses(courses.get(NumberCourses-1));
                        Courses courses1=new Courses();
                        courses1=courses.get(NumberCourses-1);
                        rouzbeh.student.get(i).setCourses(courses1);
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
            case 4:
            {
                try {
                    System.out.println("\n\n\tyour courses\n\n");
                    conter=0;
                    for (Courses x : rouzbeh.student.get(i).courses) {

                        System.out.format("\t%d --> %s\n",conter,x.getName());
                    }

                    System.out.println("\n\n");
                }catch (Exception e)
                {
                    System.out.println("Not Successful");
                }
            }
            break;
            case 5:
            {
                try {
                    System.out.println("if  you want to remove one of these courses enter ID's \n\n");
                    conter=0;
                    for (Courses x : rouzbeh.student.get(i).courses) {
                        conter++;
                        System.out.format("\t%d --> %s\n",conter,x.getName());
                    }
                    Scanner scanner=new Scanner(System.in);
                   int remove= scanner.nextInt();
                    rouzbeh.student.get(i).courses.remove(remove-1);
                }catch (Exception e)
                {
                    System.out.println("Not Successful");
                }
            }
            break;
            //paly game and increase grade
            case 6:
            {

            }
            case 7:
            {
                try {
                    rouzbeh.student.get(i).printGrade();
                }catch (Exception e)
                {
                    System.out.println("Not successful ");
                }
            }
            break;

            case 8:
                runMenu(rouzbeh);
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
                for (Student x : rouzbeh.student) {
                    int conter = 0;
                    conter++;
                    System.out.format("%d - %s", conter, x.getName());
                }
                System.out.format("enter ID of student (number )\n");
                int NumberCourses = get.nextInt();
                System.out.println("enter grade : ");
                int Grade = get.nextInt();
                rouzbeh.student.get(NumberCourses).setGrade(Grade);
                System.out.println("successful ");

            }
            break;
            case 4:
                System.out .format("your Grade is %s",rouzbeh.teacher.get(i).getGrade());
            break;


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
//                    hogwarts.assistants.get(i).addStudent(name, LastName, username, "1234");
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

            case 9:
            {

            }
            break;
            case 10:
            {
                System.out.println("enter last password ");

                String pass = scanner.next();
                try {
                    if (hogwarts.student.get(i).validatePassword(pass)) {
                        String newpass = scanner.next();
                        hogwarts.student.get(i).changePassword(newpass);
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
                String pass = scanner.next();
                try {
                    if (hogwarts.student.get(i).validatePassword(pass)) {
                        System.out.println("enter new user name ");
                        //TODO chcek ues name is unique
                        String newusername = scanner.next();
                        hogwarts.student.get(i).changeUsername(newusername);
                        System.out.println("\nSuccessful");
                    }
                }catch (Exception e)
                {
                    System.out.println("\nNot Successful");
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




