import java.util.Scanner;
import java.text.DecimalFormat;

public class GradeStudent {
    private static final Scanner sc = new Scanner(System.in);
    public static double weightmidTerm;
    public static double weightFinalTerm;
    public static double weightscorehomework;
    public static double a;
    public static double fnpointmidTerm;
    public static double fnpointfinal;
    public static double fnpointhomework;


    public static void begin(){
        System.out.println("This program reads exam/homework scores and reports your overall course grade.");
        System.out.println("");
    }

    public static void midTerm(){
        Scanner sc = new Scanner(System.in);

        int scoremidTerm;
        int rep1;
        int shiftmidTerm;
        int totalpointmidTerm;

        System.out.println("Midterm: ");


    System.out.print("Weight (0-100)? ");// trọng số điểm giữa kì
    weightmidTerm = sc.nextInt();

    System.out.print("Score earned? ");// số điểm đạt được
    scoremidTerm = sc.nextInt();

    System.out.print("Were score shifted (1=yes, 2=no) ? "); // tăng điểm giữa kì
    rep1 = sc.nextInt();
    totalpointmidTerm = scoremidTerm;
    do {
        if (rep1 != 1 && rep1 != 2) {
            System.out.print("Try again (1=yes, 2=no) ");
            rep1 = sc.nextInt();
        }
        if (rep1 == 1) {
            System.out.print("Shift amount ? ");
            shiftmidTerm = sc.nextInt();
            totalpointmidTerm = scoremidTerm + shiftmidTerm;
            break;
        } else if (rep1 == 2) {
            shiftmidTerm = 0;
            totalpointmidTerm = scoremidTerm + shiftmidTerm;
            break;
        }
    } while (rep1 != 1 || rep1 != 2);

    if (totalpointmidTerm >= 100) {
        totalpointmidTerm = 100;
    }

    System.out.println("Total points =  " + totalpointmidTerm);

    fnpointmidTerm = totalpointmidTerm * weightmidTerm /100;
    System.out.println("Weight score = " + fnpointmidTerm + "/" + weightmidTerm);
    System.out.println("");
    }

    public static void finalTerm(){
        Scanner sc = new Scanner(System.in);

        int scorefinalTerm;
        int rep2;
        int shiftfinalTerm;
        int totalpointfinalTerm;


        System.out.println("Final: ");

        System.out.print("Weight (0-100)? ");
        weightfinalTerm = sc.nextInt();

        System.out.print("Score earned? ");
        scorefinalTerm = sc.nextInt();

        System.out.print("Were score shifted (1=yes, 2=no) ? ");
        rep2 = sc.nextInt();
        totalpointfinalTerm = scorefinalTerm;
        do {
            if (rep2 != 1 && rep2 != 2){
                System.out.print("Try again (1=yes, 2=no) ");
                rep2 = sc.nextInt();
            }
            if (rep2 == 1){
                System.out.print("Shift amount ? ");
                shiftfinalTerm = sc.nextInt();
                totalpointfinalTerm = scorefinalTerm + shiftfinalTerm;
                break;

            } else if (rep2 == 2){
                totalpointfinalTerm = scorefinalTerm;
                break;

            }

        } while (rep2 != 1|| rep2 != 2 );

         if (totalpointfinalTerm >= 100){
             totalpointfinalTerm = 100;
         }

        System.out.println("Total points =  " + totalpointfinalTerm + "/100");

        fnpointfinal = (totalpointfinalTerm / 100) * weightfinalTerm;
        System.out.println("Weight score = " + fnpointfinal +"/35");
        System.out.println("");


    }
    public static double homework(){
        Scanner sc = new Scanner(System.in);

        int totalasm;
        int asmnumber;
        int section;
        int sectionpoint;


        int score = 0;
        int max = 0;

        System.out.println("Homework: ");

        System.out.print("Weight (0-100)? ");
        weightscorehomework = sc.nextInt();
         a= weightscorehomework+ weightFinalTerm + weightmidTerm;
        while (a !=100) {
            System.out.println ("try again");
            weightmidTerm = 0;
            weightfinalTerm = 0;

            midTerm();
            finalTerm();
            System.out.println("Homework: ");

            System.out.print("Weight (0-100)? ");
            weightscorehomework = sc.nextInt();
            a= weightscorehomework+ weightFinalTerm + weightmidTerm;
        }

        System.out.print("Number of assignments? ");
        totalasm = sc.nextInt();


        for ( asmnumber = 0; asmnumber < totalasm; asmnumber++) {
            System.out.print("Assignment " + (asmnumber + 1) + " score and max? ");

            score += sc.nextInt();
            max += sc.nextInt();
        }
        if (score >150){
            score = 150;
        }
        System.out.print("How many sections did you atend?  ");
        section = sc.nextInt();

        sectionpoint = section * 5;
        if (section * 5 > 30){
            sectionpoint = 30;
        }
        System.out.println("Section points = " + sectionpoint +"/30");


        System.out.println("Total points =  "+ (score + sectionpoint) +"/" + (max + 30));

        double dhm = (double)(score + sectionpoint)/ (max + 30) * weightscorehomework; // ép kiểu phép tính sang kiểu double

       fnpointhomework = (double)Math.round(dhm * 10)/ 10;
        DecimalFormat df = new DecimalFormat("#.#");
        System.out.println("Weight score = " + df.format(fnpointhomework )+"/" + weightscorehomework);
        System.out.println("");
        return weightscorehomework;
    }


    public static void report(){
        DecimalFormat df = new DecimalFormat("#.#");
       double pointfinal = fnpointfinal + fnpointhomework + fnpointmidTerm;// tổng điểm trung bình
        System.out.println("Overall percentage:  " + df.format(pointfinal) );

        if (pointfinal >= 85.0){
            System.out.println("Your grade will be at least: 3.0\nGood Job!");
        } else if (pointfinal >= 75.0){
            System.out.println("Your grade will be at least: 2.0\nNot too bad...");
        } else if (pointfinal >= 60.0){
            System.out.println("Your grade will be at least: 0.7\nYou should probably study more next time.");
        } else {
            System.out.println("Your grade will be at least: 0.0\nReally?");
        }

    }
    public static void main(String [] agrs){
        begin();
        midTerm();
        finalTerm();
        homework();
        report();
        }

    }

