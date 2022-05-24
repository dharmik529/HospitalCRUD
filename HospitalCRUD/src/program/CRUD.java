/*package program;

import java.util.Scanner;
import entity.*;
import java.util.List;
import java.util.Optional;


public class CRUD {
    private static DAO bedDAO;
    private static DAO patientDAO;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        bedDAO = new BedDAO();
        Bed bed;
        patientDAO = new PatientDAO();
        Patient patient;



    int x = 0;
    while (x!=9){
    System.out.println("");
    System.out.println("Option 1: Create a Bed");
    System.out.println("Option 2: Update a Bed");
    System.out.println("Option 3: Delete a Bed");
    System.out.println("Option 4: Print Beds");
    System.out.println("Option 5: Create a Patient");
    System.out.println("Option 6: Update a Patient");
    System.out.println("Option 7: Delete a Patient");
    System.out.println("Option 8: Print Patients");
    System.out.println("Option 9: Exit Application");

    System.out.println("Enter your option from 1 to 9");
    x = sc.nextInt();
    if(x==1){

        System.out.println("Enter Bed ID");
        int patientID = sc.nextInt();

        System.out.println("Enter true or false if ventilator is present");
        boolean vent = sc.nextBoolean();

        Main.addBed(patientID,vent);
        Main.printBeds();
    }
    
    if(x==2){

        System.out.println("Enter Bed ID");
        int patientID = sc.nextInt();

        System.out.println("Enter true or false if ventilator is present");
        boolean vent = sc.nextBoolean();

        bed = new Bed(patientID,vent);

        bedDAO.update(bed);
        Main.printBeds();
    }
    
    if(x==3){

        System.out.println("Enter Bed ID");
        int patientID = sc.nextInt();

        System.out.println("Enter true or false if ventilator is present");
        boolean vent = sc.nextBoolean();

        bed = new Bed(patientID,vent);

        bedDAO.delete(bed);
        Main.printBeds();
        }if(x==4){

        Main.printBeds();

    }
    
    if(x==5){

        System.out.println("Enter Patient ID");
        int patientID = sc.nextInt();

        System.out.println("Enter firstname");
        String st = sc.nextLine();
        String first1 = sc.nextLine();

        System.out.println("Enter lastname");
        String last = sc.nextLine();

        System.out.println("Enter BedID");
        int idbed = sc.nextInt();

        System.out.println("Enter DateTimeBedVisited");
        String ss = sc.nextLine();
        String date1 = sc.nextLine();

        System.out.println("Enter true or false if radiology was visited");
        boolean radio = sc.nextBoolean();

        Main.addPatient(patientID,first1,last,idbed,date1,radio);

        Main.printPatients();

    }
    
    if(x==6){

        System.out.println("Enter Patient ID");
        int patientID = sc.nextInt();

        System.out.println("Enter firstname");
        String st = sc.nextLine();
        String first = sc.nextLine();

        System.out.println("Enter lastname");
        String last = sc.nextLine();

        System.out.println("Enter BedID");
        int idbed = sc.nextInt();

        System.out.println("Enter DateTimeBedVisited");
        String ss = sc.nextLine();
        String date1 = sc.nextLine();

        System.out.println("Enter true or false if radiology was visited");
        boolean radio = sc.nextBoolean();
        patient = new Patient(patientID, first, last, idbed, date1, radio );

        patientDAO.update(patient);
        Main.printPatients();

    }
    
    if(x==7){

    System.out.println("Enter Patient ID");
    int patientID = sc.nextInt();
    
    System.out.println("Enter firstname");
    String st = sc.nextLine();
    String first1 = sc.nextLine();
    
    System.out.println("Enter lastname");
    String last = sc.nextLine();

    System.out.println("Enter BedID");
    int idbed = sc.nextInt();
    
    System.out.println("Enter DateTimeBedVisited");
    String ss = sc.nextLine();
    String date1 = sc.nextLine();
    
    System.out.println("Enter true or false if radiology was visited");
    boolean rad = sc.nextBoolean();
    patient = new Patient(patientID,first1,last,idbed,date1,rad);
    patientDAO.delete(patient);
    Main.printPatients();

    }if(x==8){

    Main.printPatients();
    }
    }
    sc.close();

        }
    }
*/