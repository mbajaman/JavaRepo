import java.util.*;

/**
 * Created by rodne on 2017-10-19.
 * Edited by Mike on 2017-11-17
 */
public class StudentPlacement {

    private ArrayList<Student> stulist;
    private ArrayList<Options> optlist;
    private HashSet<Student> nullList;
    ArrayList<Student> onePriorityList = new ArrayList<>();
    ArrayList<Student> twoPriorityList = new ArrayList<>();
    ArrayList<Student> threePriorityList = new ArrayList<>();
    ArrayList<Student> fourPriorityList = new ArrayList<>();

    //Find the average GPA of all students
    public void averageGPA(ArrayList<Student> stulist){
        Double gpa = 0.0;
        int numberOfStudents = 0;
        double totalGPA = 0.0;
        for(Student stu:stulist){
            gpa += stu.getGPA();
            numberOfStudents++;
        }
        totalGPA = Math.round((gpa/numberOfStudents)*100);
        System.out.println("Average GPA of All Students: "+ totalGPA/100+"%");
    }

    //Find the lowest GPA of all student
    public void lowestGPA(ArrayList<Student> stulist){
        double lowestGPA = 100.0;
        int counter = 0;
        for(Student stu:stulist) {
            if (stu.getGPA() < lowestGPA) {
                lowestGPA = stu.getGPA();
            }

            if (stu.getGPA() < 0) {
                counter += 1;
            }
        }

        System.out.println("Lowest GPA: " + lowestGPA + "%");

        if (counter != 0) {
            System.out.println("A GPA value is less than 0 and is invalid");
            System.out.println();
        }

    }

    //Find the highest GPA of all students
    public void highestGPA(ArrayList<Student> stulist){
        double highestGPA = 0.0;
        int counter = 0;
        for(Student stu:stulist) {
            if (stu.getGPA() > highestGPA) {
                highestGPA = stu.getGPA();
            }

            if (stu.getGPA() > 100) {
                counter += 1;
            }
        }

        System.out.println("Highest GPA: "+ highestGPA+"%");

        if (counter != 0) {
            System.out.println("A GPA value is greater than 100 and is invalid");
            System.out.println();
        }
    }

    //Find total number of students on the list
    public void totalStudents(ArrayList<Student> stulist){
        int numberOfStudents = 0;
        for(Student stu:stulist){
            numberOfStudents++;
        }
        System.out.println("Total Number of Students: "+ numberOfStudents);
    }

    //Find out how many people are in each priority and number of people who does not have either priority 1 or 2
    public void groupPriority(ArrayList<Student> stulist){
            int priorityA = 0;
            int priorityB = 0;
            int otherPriority = 0;
            for(Student stu:stulist) {
                if (stu.getPriority() == 1) {
                    priorityA++;
                } else if (stu.getPriority() == 2) {
                    priorityB++;
                } else {
                    otherPriority++;
                }
            }
            System.out.println("Students with Priority Level 1: " +priorityA);
            System.out.println("Students with Priority Level 2: " +priorityB);
            if(otherPriority != 0) {
                System.out.println("Students with Other Priority Level: " +otherPriority);
            }else{
                System.out.println("Note: No students in other priority level!");
            }
    }

    //This class calculate average GPA based on priority
    public void priorityGPA(ArrayList<Student> stulist) {
        Double GPA1 = 0.0;
        Double GPA2 = 0.0;
        Double GPAOther = 0.0;
        int numberOfStudents1 = 0;
        int numberOfStudents2 = 0;
        int numberOfStudentsOther = 0;
        double totalGPA1 = 0.0;
        double totalGPA2 = 0.0;
        double totalGPAOther = 0.0;
        for(Student stu:stulist){
            if(stu.getPriority() == 1) {
                GPA1 += stu.getGPA();
                numberOfStudents1++;
            }else if(stu.getPriority() == 2) {
                GPA2 +=stu.getGPA();
                numberOfStudents2++;
            }else{
                GPAOther +=stu.getGPA();
                numberOfStudentsOther++;
            }
        }
        totalGPA1 = Math.round((GPA1/numberOfStudents1)*100);
        totalGPA2 = Math.round((GPA2/numberOfStudents2)*100);
        totalGPAOther = Math.round((GPAOther/numberOfStudentsOther)*100);
        System.out.println("Average GPA of Priority 1 Students: "+ totalGPA1/100+"%");
        System.out.println("Average GPA of Priority 2 Students: "+ totalGPA2/100+"%");
        if(numberOfStudentsOther != 0) {
            System.out.println("Average GPA of Other Priority Students: " + totalGPAOther / 100 + "%");
        }

    }

    //This class finds the most "in-demand" choice of students
    public void demandChoices(ArrayList<Student> stulist){

    }

    public StudentPlacement(ArrayList<Student> stulist, ArrayList<Options> optlist, HashSet<Student> nullList){
        this.stulist = stulist;
        this.optlist = optlist;
        this.nullList = nullList;
    }

    private void sortStudentsOnGPA(ArrayList<Student> stulist){
        Collections.sort(stulist, Comparator.comparing(Student::getGPA).reversed());
    }

    private void sortStudentsOnPriority(ArrayList<Student> stulist){
        for (Student s:stulist) {
            switch(s.getPriority()){
                case 1:
                    onePriorityList.add(s);
                    break;

                case 2:
                    twoPriorityList.add(s);
                    break;

                case 3:
                    threePriorityList.add(s);
                    break;

                case 4:
                    fourPriorityList.add(s);
                    break;
            }
        }
    }

    private void createNullList(ArrayList<Student> onePriorityList, ArrayList<Student> twoPriorityList, ArrayList<Student> threePriorityList, ArrayList<Student> fourPriorityList){
        ArrayList<Student> one = onePriorityList;
        ArrayList<Student> two = twoPriorityList;
        ArrayList<Student> three = threePriorityList;
        ArrayList<Student> four = fourPriorityList;

        for(Student stu:one){
            if(stu.getAssignedOption().equals("NOTHING")){
                nullList.add(stu);
            }
        }
        for(Student stu:two){
            if(stu.getAssignedOption().equals("NOTHING")){
                nullList.add(stu);
            }
        }
        for(Student stu:three){
            if(stu.getAssignedOption().equals("NOTHING")){
                nullList.add(stu);
            }
        }
        for(Student stu:four){
            if(stu.getAssignedOption().equals("NOTHING")){
                nullList.add(stu);
            }
        }
    }

    private void placePriorityLists(ArrayList<Student> priorityList, ArrayList<Options> optlist) {
        for(Student stu:priorityList){
            if(stu.getStudentChoices().size()>0){
                if("".equals(stu.getStatus())){
                    int check = 0;
                    for(int i=0;i<stu.getStudentChoices().size();i++){
                        if(check ==0){
                            for(Options opt:optlist){
                                if (opt.getCourseName().equals(stu.getStudentChoices().get(i)) && opt.getEmptySeats()!= 0) {
                                    opt.addStudentToList(stu);
                                    stu.setAssignedOption(opt.getCourseName());
                                    check++;
                                    break;
                                }
                            }
                        }
                    }
                    if(check == 0 && stu.getAssignedOption() != null){
                        stu.setReason("All choice classes are full");
                        stu.setAssignedOption("NOTHING");
                    }
                }else{
                    stu.setReason("Has a status");
                    stu.setAssignedOption("NOTHING");
                }
            }else{
                stu.setReason("No selection was made");
                stu.setAssignedOption("NOTHING");
            }
        }
    }

    public void displayGPA(){
        sortStudentsOnGPA(stulist);
        sortStudentsOnPriority(stulist);
        placePriorityLists(onePriorityList, optlist);
        placePriorityLists(twoPriorityList, optlist);
        placePriorityLists(threePriorityList, optlist);
        placePriorityLists(fourPriorityList, optlist);
        createNullList(onePriorityList, twoPriorityList, threePriorityList, fourPriorityList);
    }


}
