/*
    TODO: Import all the classes that you have defined and make use of them to build the program.
 */

import java.util.ArrayList;
import java.util.Scanner;

public class Main {



    public static void main(String[] args) {
        // TODO: Program starts from here
        runMenu();
    }

    public static void runMenu() {
        // TODO: Menu will be shown here...
        System.out.print("hi who are you ? \n 1-Student 2-Teacher 3-Assistant\n");
      //  Scanner scanner=new Scanner("?");
        Hogwarts rouzbeh=new Hogwarts();


     Scanner scanner=new Scanner(System.in);

        while (true) {
            int a=scanner.nextInt();
            switch (a) {
                case 1:
                    if (!rouzbeh.student.isEmpty()) {
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
                            //TODO-->check i -- or not
                            System.out.format("hi %s ",rouzbeh.student.get(i).Name);

                            while (true) {
                                System.out.println("1- get courses -2 teacher -3 courses 4-removeCourses 5-back menu");
                                int b = scanner.nextInt();
                                if (b != 5)
                                    runStudent(b,rouzbeh.courses,rouzbeh,i);

                            }

                        }

                    }
                case 2:{
                    if (!rouzbeh.teacher.isEmpty()) {
                        System.out.println("NO student exisit");
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
        System.out.format("HI %s \n",rouzbeh.student.get(i).Name);
        Scanner get = new Scanner(System.in);
        switch (result) {
            case 1: {
                System.out.println("this is a all courses that exist");
                for (Courses x : courses) {
                    int conter = 0;
                    conter++;
                    System.out.format("%d - %s", conter, x.getName());
                }
                int NumberCourses = get.nextInt();
                rouzbeh.student.get(i).setCourses(courses.get(NumberCourses));
                System.out.println("successful ");
            }
            break;
            case 2: {
                for (Teacher x : rouzbeh.teacher) {
                    int conter = 0;
                    conter++;
                    System.out.format("%d - %s", conter, x.NameTeacher);
                }
            }
            break;
            case 3: {
                for (Courses x : rouzbeh.courses) {
                    int conter = 0;
                    conter++;
                    System.out.format("%d - %s", conter, x.getName());
                }
            }


        }
    }

    public  static void runTeacher(int result,Hogwarts rouzbeh,int i){
        System.out.format(" Hi %s \n",rouzbeh.teacher.get(i).NameTeacher);
        Scanner get=new Scanner(System.in);
        switch (result)
        {
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
            case 3:
                for (Student x : rouzbeh.student) {
                    int conter = 0;
                    conter++;
                    System.out.format("%d - %s", conter, x.getName());
                }
                int NumberCourses = get.nextInt();
                rouzbeh.teacher.get(i).GetCourse(rouzbeh.courses.get(NumberCourses));
                System.out.println("successful ");


                System.out.format("please enter id of Student ");


            }

        }



    }









    }


