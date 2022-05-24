
package entity;

public class Patient 
{
    private int PatientID;
    private String First_Name;
    private String Last_Name;
    private int Bed_ID;
    private String Date_Time_Bed_Visited;
    private boolean Radiology_Visited;
    
    public Patient(int PatientID, String First_Name, String Last_Name, int Bed_ID, String Date_Time_Bed_Visited, Boolean Radiology_Visited){
        
        this.PatientID = PatientID;
        this.First_Name = First_Name;
        this.Last_Name = Last_Name;
        this.Bed_ID = Bed_ID;
        this.Date_Time_Bed_Visited = Date_Time_Bed_Visited;
        this.Radiology_Visited = Radiology_Visited;
    }

    public int getPatientID() {
        return PatientID;
    }

    public String getFirst_Name() {
        return First_Name;
    }

    public String getLast_Name() {
        return Last_Name;
    }

    public int getBed_ID() {
        return Bed_ID;
    }
    
    public boolean getRadiology_Visited() {
        return Radiology_Visited;
    }
    
    public String getDate_Time_Bed_Visited() {
        return Date_Time_Bed_Visited;
    }

    @Override
    public String toString() {
return "PATIENT_TABLE {" + "PATIENT_ID=" + PatientID + ", FIRST_NAME=" + First_Name + ", LAST_NAME=" + Last_Name + ", BED_ID=" + Bed_ID + ", DATE_TIME_BED_VISITED= " + Date_Time_Bed_Visited + ", Radiology Visited= " + Radiology_Visited + '}';
    }
}
