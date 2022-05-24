package program;

import entity.*;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Main {

    private static DAO bedDAO;
    private static DAO patientDAO;

    public static void main(String[] args) {
        bedDAO = new BedDAO();
        Bed bed;
        bed = new Bed(1, false);
        bedDAO.insert(bed);
        bed = new Bed(2, false);
        bedDAO.insert(bed);
        bed = new Bed(3, false);
        bedDAO.insert(bed);
        bed = new Bed(4, true);
        bedDAO.insert(bed);
        bed = new Bed(5, true);
        bedDAO.insert(bed);
        bed = new Bed(6, false);
        bedDAO.insert(bed);
        bed= new Bed(6, true);
        bedDAO.update(bed);

        patientDAO = new PatientDAO();
        Patient patient;
        patient = new Patient(139, "Jahidul", "Robin", 1, "2021-05-23 10:39:23.453", false);
        patientDAO.insert(patient);//Insert John
        patient = new Patient(120, "Steve", "Grace", 2, "2021-06-30 18:12:33.392", false);
        patientDAO.insert(patient);//Insert Steve
        printPatients();
        patient = new Patient(120, "Steve", "Grace", 2, "2021-05-30 08:15:00.392", false);
        patientDAO.update(patient);//Update Steve
        printPatients();
        patient = new Patient(111, "Dev", "Malik", 3, "2021-07-27 11:29:10.233", false);
        patientDAO.insert(patient);//Insert Dev
        patient = new Patient(93, "Mike", "Smith", 4, "2021-07-29 08:48:11.556", true);
        patientDAO.insert(patient);//Insert Mike
        patient = new Patient(102, "Love", "Robinson", 5, "2021-09-19 23:59:59.392", true);
        patientDAO.insert(patient);//Insert Love
        patient = new Patient(102, "Love", "Robinson", -1, "2021-09-19 23:59:59.392", true);
        patientDAO.update(patient);//Update Love
        patient = new Patient(84, "Dhamu", "Patel", 6, "2021-10-16 4:20:19.293", true);
        patientDAO.insert(patient);//Insert Dhamu
        printPatients();
        patientDAO.delete(patient);//Delete Dhamu
        printPatients();
        printBeds();
        patient = getPatient(0);
        System.out.println(patient.getPatientID() + "-" + patient.getFirst_Name() + "-" + patient.getLast_Name() + "-" + patient.getBed_ID() + "-" + patient.getDate_Time_Bed_Visited() + "-" + patient.getRadiology_Visited());
    
    
    Scanner sc = new Scanner(System.in);

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

        addBed(patientID,vent);
        printBeds();
    }
    
    if(x==2){

        System.out.println("Enter Bed ID");
        int patientID = sc.nextInt();

        System.out.println("Enter true or false if ventilator is present");
        boolean vent = sc.nextBoolean();

        bed = new Bed(patientID,vent);

        bedDAO.update(bed);
        printBeds();
    }
    
    if(x==3){

        System.out.println("Enter Bed ID");
        int patientID = sc.nextInt();

        System.out.println("Enter true or false if ventilator is present");
        boolean vent = sc.nextBoolean();

        bed = new Bed(patientID,vent);

        bedDAO.delete(bed);
        printBeds();
        }if(x==4){

        printBeds();

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

        addPatient(patientID,first1,last,idbed,date1,radio);

        printPatients();

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
        printPatients();

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
    printPatients();

    }if(x==8){

    printPatients();
    }
    }
    sc.close();
    }

    static void addPatient(int Patient_ID, String First_Name, String Last_Name, int Bed_ID, String Date_Time_Bed_Visited, Boolean Radiology_Visited) {
        Patient patient;
        patient = new Patient(Patient_ID, First_Name, Last_Name, Bed_ID, Date_Time_Bed_Visited, Radiology_Visited);
        patientDAO.insert(patient);
    }

    static void addBed(int Bed_ID, boolean With_Ventilator) {
        Bed bed;
        bed = new Bed(Bed_ID, With_Ventilator);
        bedDAO.insert(bed);
    }

    static Patient getPatient(int id) {
        Optional<Patient> patient = patientDAO.get(id);
        return patient.orElseGet(() -> new Patient(-1, "Non-exist", "Non-exist", -1, "Non-exist", false));
    }

    static Bed getBed(int id) {
        Optional<Bed> bed = bedDAO.get(id);
        return bed.orElseGet(() -> new Bed(-1, false));
    }

    static void printPatients() {
        List<String> headers = patientDAO.getColumnNames();
        int numberCols = headers.size();
        //Print column names as header
        for (int i = 0; i < numberCols; i++) {
            String header = headers.get(i);
            System.out.printf("%25s", header);
        }
        System.out.println();
        //Print the results
        List<Patient> patients = patientDAO.getAll();
        int numberRows = patients.size();
        for (int i = 0; i < numberRows; i++) {
            System.out.printf("%25s%25s%25s%25s%25s%25s", patients.get(i).getPatientID(), patients.get(i).getFirst_Name(), patients.get(i).getLast_Name(), patients.get(i).getBed_ID(), patients.get(i).getDate_Time_Bed_Visited(), patients.get(i).getRadiology_Visited());
            System.out.println();
        }

    }

    static void printBeds() {
        List<String> headers = bedDAO.getColumnNames();
        int numberCols = headers.size();
        //Print column names as header
        for (int i = 0; i < numberCols; i++) {
            String header = headers.get(i);
            System.out.printf("%25s", header);
        }
        System.out.println();
        //Print the results
        List<Bed> beds = bedDAO.getAll();
        int numberRows = beds.size();
        for (int i = 0; i < numberRows; i++) {
            System.out.printf("%25s%25s", beds.get(i).getBed_ID(), beds.get(i).getWith_Ventilator());
            System.out.println();
        }

    }

}
