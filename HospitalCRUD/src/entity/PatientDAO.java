
package entity;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import core.*;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class PatientDAO implements DAO<Patient>
{   
    public PatientDAO() {
        
    }
    List<Patient> patients;
    
    @Override
    public Optional<Patient> get(int id) {
        DB db = DB.getInstance();
        ResultSet rs = null;
        try {
            String sql = "SELECT * FROM Patient WHERE PatientID = ?";
            PreparedStatement stmt = db.getPreparedStatement(sql);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            Patient patient = null;
            while (rs.next()) {
                patient = new Patient(rs.getInt("PatientID"), rs.getString("First_Name"), rs.getString("Last_Name"), rs.getInt("Bed_ID"), rs.getString("Date_Time_Bed_Visited"), rs.getBoolean("Radiology_Visited"));
            }
            return Optional.ofNullable(patient);
        } catch (SQLException ex) {
            System.err.println(ex.toString());
            return null;
        }
    }
    
    
    @Override
    public List<Patient> getAll() {
        DB db = DB.getInstance();
        ResultSet rs = null;
        patients = new ArrayList<>();
        try {
            String sql = "SELECT * FROM Patient";
            rs = db.executeQuery(sql);
            Patient patient = null;
            while (rs.next()) {
                patient = new Patient(rs.getInt("PatientID"), rs.getString("First_Name"), rs.getString("Last_Name"), rs.getInt("Bed_ID"), rs.getString("Date_Time_Bed_Visited"), rs.getBoolean("Radiology_Visited"));
                patients.add(patient);
            }
            return patients;
        } catch (SQLException ex) {
            System.err.println(ex.toString());
            return null;
        }
    }
    
    
    @Override
    public void insert(Patient patient)
    {
        DB db = DB.getInstance();
        try {
            String sql = "INSERT INTO Patient(PatientID, First_Name, Last_Name, Bed_ID, Date_Time_Bed_Visited, Radiology_Visited) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = db.getPreparedStatement(sql);
            stmt.setInt(1, patient.getPatientID());
            stmt.setString(2, patient.getFirst_Name());
            stmt.setString(3, patient.getLast_Name());
            stmt.setInt(4, patient.getBed_ID());
            stmt.setString(5, patient.getDate_Time_Bed_Visited());
            stmt.setBoolean(6, patient.getRadiology_Visited());
            int rowInserted = stmt.executeUpdate();
            if (rowInserted > 0) {
                System.out.println("A new patient was inserted successfully!");
            }
        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }
    }
    
    
    @Override
    public void update(Patient patient) {
        DB db = DB.getInstance();
        try {
            String sql = "UPDATE Patient SET First_Name=?, Last_Name=?, Bed_ID=?, Date_Time_Bed_Visited=?, Radiology_Visited=? WHERE PatientID=?";
            PreparedStatement stmt = db.getPreparedStatement(sql);
            stmt.setString(1, patient.getFirst_Name());
            stmt.setString(2, patient.getLast_Name());
            stmt.setInt(3, patient.getBed_ID());
            stmt.setString(4, patient.getDate_Time_Bed_Visited());
            stmt.setBoolean(5, patient.getRadiology_Visited());
            stmt.setInt(6, patient.getPatientID());
            int rowsUpdated = stmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("An existing patient was updated successfully!");
            }
        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }
    }
    
    
    @Override
    public void delete(Patient patient) {
        DB db = DB.getInstance();
        try {
            String sql = "DELETE FROM Patient WHERE PatientID = ?";
            PreparedStatement stmt = db.getPreparedStatement(sql);
            stmt.setInt(1, patient.getPatientID());
            int rowsDeleted = stmt.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("A patient was deleted successfully!");
            }
        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }
    }
    
    
    @Override
    public List<String> getColumnNames() {
        DB db = DB.getInstance();
        ResultSet rs = null;
        List<String> headers = new ArrayList<>();
        try {
            String sql = "SELECT * FROM Patient WHERE PatientID = -1";//We just need this sql query to get the column headers
            rs = db.executeQuery(sql);
            ResultSetMetaData rsmd = rs.getMetaData();
            //Get number of columns in the result set
            int numberCols = rsmd.getColumnCount();
            for (int i = 1; i <= numberCols; i++) {
                headers.add(rsmd.getColumnLabel(i));//Add column headers to the list
            }
            return headers;
        } catch (SQLException ex) {
            System.err.println(ex.toString());
            return null;
        } 
    }
}
