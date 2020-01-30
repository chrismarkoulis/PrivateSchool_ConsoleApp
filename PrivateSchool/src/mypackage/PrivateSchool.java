/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mypackage;

import dao.AssignmentDao;
import dao.AssignmentsPerCourseDao;
import dao.AssignmentsPerStudentPerCourseDao;
import dao.CourseDao;
import dao.MoreThanOneCourseDao;
import dao.StudentDao;
import dao.StudentsPerCourseDao;
import dao.TrainerDao;
import dao.TrainersPerCourseDao;
import entities.Assignment;
import entities.AssignmentsPerCourse;
import entities.AssignmentsPerStudentPerCourse;
import entities.Course;
import entities.MoreThanOneCourse;
import entities.Student;
import entities.StudentsPerCourse;
import entities.Trainer;
import entities.TrainersPerCourse;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author chris
 */
public class PrivateSchool {

    StudentDao studentDao = new StudentDao();
    TrainerDao trainerDao = new TrainerDao();
    CourseDao courseDao = new CourseDao();
    AssignmentDao assignmentDao = new AssignmentDao();

    MoreThanOneCourseDao mtc = new MoreThanOneCourseDao();

    StudentsPerCourseDao spcDao = new StudentsPerCourseDao();
    TrainersPerCourseDao tpcDao = new TrainersPerCourseDao();
    AssignmentsPerCourseDao apcDao = new AssignmentsPerCourseDao();
    AssignmentsPerStudentPerCourseDao appDao = new AssignmentsPerStudentPerCourseDao();

    List<Student> students;
    List<Course> courses;
    List<Trainer> trainers;
    List<Assignment> assignments;

    List<TrainersPerCourse> trainersPerCourse;
    List<StudentsPerCourse> studentsPerCourse;
    List<AssignmentsPerCourse> assignmentsPerCourse;
    List<AssignmentsPerStudentPerCourse> assignmentsPerStudentPerCourse;

    List<MoreThanOneCourse> lastQuery;

    public void startApp() {

        screen();
        menu();

    }

    public void screen() {

        System.out.println("========================================");
        System.out.println("|                                      |");
        System.out.println("|      Private School project          |");
        System.out.println("|                                      |");
        System.out.println("========================================");

        System.out.println("\nWelcome, Please choose from the options below.");
        System.out.println("\n");
        System.out.println("- To print a list of Students enter '1'");
        System.out.println("- To print a list of Assignments enter '2'");
        System.out.println("- To print a list of Trainers enter '3'");
        System.out.println("- To print a list of Courses enter '4'");
        System.out.println("- To print a list of Students Per Course enter '5'");
        System.out.println("- To print a list of Trainers Per Course enter '6'");
        System.out.println("- To print a list of Assignments Per Course enter '7'");
        System.out.println("- To print a list of Assignments Per Student Per Course enter '8'");
        System.out.println("- To print a list of Students that belong to more"
                + " than one courses\n enter '9'");

        System.out.println("- To insert student enter '10'");
        System.out.println("- To insert trainer enter 11'");
        System.out.println("- To insert assignment enter '12'");
        System.out.println("- To insert course enter '13'");
        System.out.println("- To insert students per course enter '15'");
        System.out.println("- To insert trainers per course enter '14'");
        System.out.println("- To insert assignments per course enter '16'");
        System.out.println("- To insert assignments per student per course enter '17'");

    }

    public void menu() {

        Scanner input = new Scanner(System.in);
        
        boolean valid = true;
        int answer;
        
     
        while (valid) {
            
            try {
                
                answer = integerCheck(input);

                switch (answer) {

                    case 1:
                        //A list of all the Students 
                        System.out.println("Printing list of Students...\n");
                        getStudents();

                        break;

                    case 2:
                        //A list of all the Assignments 
                        System.out.println("Printing list of Assignments...\n");
                        getAssignments();

                        break;

                    case 3:
                        //A list of all the Trainers 
                        System.out.println("Printing list of Trainers...");
                        getTrainers();
                        break;

                    case 4:
                        //A list of all the Courses 
                        System.out.println("Printing list of Courses...");
                        getCourses();
                        break;

                    case 5:
                        //All the Students per course 
                        System.out.println("Printing StudentsPerCourse...");
                        getStudentsPerCourse();
                        break;

                    case 6:
                        //All the Trainers per course 
                        System.out.println("Printing TrainersPerCourse...");
                        getTrainersPerCourse();
                        break;

                    case 7:
                        //All the Assignments per course 
                        System.out.println("Printing AssignmentsPerCourse...");
                        getAssignmentsPerCourse();
                        break;

                    case 8:
                        //All the Assignments per Student per Course 
                        System.out.println("Printing AssignmentsPerStudentPerCourse...");
                        getAssignmentsPerStudentPerCourse();
                        break;

                    case 9:
                        //A list of students that belong to more than one courses
                        System.out.println("Printing Students to more than one Courses...");
                        getStudentsTomoreThanOneCourse();
                        break;

                    case 10:
                        //input student :
                        System.out.println("Enter new Student:");
                        insertStudent();
                        break;

                    case 11:
                        //input trainer :
                        System.out.println("Enter new Trainer:");
                        insertTrainer();
                        break;

                    case 12:
                        //input assignment :
                        System.out.println("Enter new Assignment:");
                        insertAssignment();
                        break;

                    case 13:
                        //input course :
                        System.out.println("Enter new Course:");
                        insertCourse();
                        break;

                    case 14:
                        //input students per course :
                        System.out.println("Enter Students per Course:\n"
                                + "*HINT:\t You can print a list of all the students\n"
                                + "and courses first, to check for their id's to enter below");
                        insertStudentsPerCourse();
                        break;

                    case 15:
                        //input trainers per course :
                        System.out.println("Enter Trainers per Course:\n"
                                + "*HINT:\t You can print a list of all the trainers\n"
                                + "and courses first, to check for their id's to enter below");
                        insertTrainersPerCourse();
                        break;

                    case 16:
                        //input assignments per course :
                        System.out.println("Enter Assignments per Course:\n"
                                + "*HINT:\t You can print a list of all the assignments\n"
                                + "and courses first, to check for their id's to enter below");
                        insertAssignmentsPerCourse();
                        break;

                    case 17:
                        //input assignments per student per course :
                        System.out.println("Enter Assignments per Student Per Course:\n"
                                + "*HINT:\t You can print a list of all the assignments,\n"
                                + " students, and courses first, to check for their id's to enter below");
                        insertAssignmentsPerStudentPerCourse();
                        break;

                    default:
                        System.out.println("Please try again.");
                }

            
        } catch (InputMismatchException i) {
            System.out.println("Error: Selection must be an integer! Please choose again from\n"
                    + "menu options above:");
        
        }
            }
    }

    /**
     *
     * @param input
     * @return
     */
    public int integerCheck(Scanner input) {
        while (!input.hasNextInt()) {
            System.out.println(" Selection must be an integer!");
            input.next();
        }
        int number = input.nextInt();
        return number;
    }

    //========== Main entities insertion methods ============//
    public void insertStudent() {

        studentDao.insert();

    }

    public void insertTrainer() {
        trainerDao.insert();

    }

    public void insertCourse() {

        courseDao.insert();

    }

    public void insertAssignment() {

        assignmentDao.insert();

    }

    //========= Extra entities insertion methods ===========//
    public void insertStudentsPerCourse() {
        spcDao.insert();
    }

    public void insertTrainersPerCourse() {
        tpcDao.insert();
    }

    public void insertAssignmentsPerCourse() {
        apcDao.insert();
    }

    public void insertAssignmentsPerStudentPerCourse() {
        appDao.insert();
    }

    //========== getData for the main entities =============//   
    public void getStudents() {

        students = studentDao.findAll();
        for (Student s : students) {
            System.out.println(s);

        }
    }

    public void getCourses() {

        courses = courseDao.findAll();
        for (Course c : courses) {
            System.out.println(c);
        }

    }

    public void getTrainers() {

        trainers = trainerDao.findAll();
        for (Trainer t : trainers) {
            System.out.println(t);
        }

    }

    public void getAssignments() {

        assignments = assignmentDao.findAll();
        for (Assignment a : assignments) {
            System.out.println(a);
        }
    }

    //========== getData for the extra entities ============//
    public void getStudentsPerCourse() {
        studentsPerCourse = spcDao.findAll();
        for (StudentsPerCourse spc : studentsPerCourse) {
            System.out.println(spc);
        }
    }

    public void getTrainersPerCourse() {
        trainersPerCourse = tpcDao.findAll();
        for (TrainersPerCourse tpc : trainersPerCourse) {
            System.out.println(tpc);
        }
    }

    public void getAssignmentsPerCourse() {

        assignmentsPerCourse = apcDao.findAll();
        for (AssignmentsPerCourse apc : assignmentsPerCourse) {
            System.out.println(apc);
        }

    }

    public void getAssignmentsPerStudentPerCourse() {

        assignmentsPerStudentPerCourse = appDao.findAll();
        for (AssignmentsPerStudentPerCourse app : assignmentsPerStudentPerCourse) {
            System.out.println(app);
        }

    }

    public void getStudentsTomoreThanOneCourse() {

        lastQuery = mtc.lastQuery();
        for (MoreThanOneCourse m : lastQuery) {
            System.out.println(m);
        }
    }
}
