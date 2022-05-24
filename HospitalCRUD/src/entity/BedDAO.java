
package entity;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import core.*;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class BedDAO implements DAO<Bed>
{   
    public BedDAO() {
        
    }
    List<Bed> beds;

    @Override
    public Optional<Bed> get(int id) {
        DB db = DB.getInstance();
        ResultSet rs = null;
        try {
            String sql = "SELECT * FROM Bed WHERE Bed_ID = ?";
            PreparedStatement stmt = db.getPreparedStatement(sql);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            Bed bed = null;
            while (rs.next()) {
                bed = new Bed(rs.getInt("Bed_ID"), rs.getBoolean("With_Ventilator"));
            }
            return Optional.ofNullable(bed);
        } catch (SQLException ex) {
            System.err.println(ex.toString());
            return null;
        }
    }
    
    /**
     * Get all bed entities as a List
     * @return 
     */
    @Override
    public List<Bed> getAll() {
        DB db = DB.getInstance();
        ResultSet rs = null;
        beds = new ArrayList<>();
        try {
            String sql = "SELECT * FROM Bed";
            rs = db.executeQuery(sql);
            Bed bed = null;
            while (rs.next()) {
                bed = new Bed(rs.getInt("Bed_ID"), rs.getBoolean("With_Ventilator"));
                beds.add(bed);
            }
            return beds;
        } catch (SQLException ex) {
            System.err.println(ex.toString());
            return null;
        }
    }
    
    /**
     * Insert a bed object into bed table
     * @param bed 
     */
    @Override
    public void insert(Bed bed)
    {
        DB db = DB.getInstance();
        try {
            String sql = "INSERT INTO Bed(Bed_ID, With_Ventilator) VALUES (?, ?)";
            PreparedStatement stmt = db.getPreparedStatement(sql);
            stmt.setInt(1, bed.getBed_ID());
            stmt.setBoolean(2, bed.getWith_Ventilator());
            int rowInserted = stmt.executeUpdate();
            if (rowInserted > 0) {
                System.out.println("A new bed was inserted successfully!");
            }
        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }
    }
    
    /**
     * Update a bed entity in database if it exists using a bed object
     * @param bed
     */
    @Override
    public void update(Bed bed) {
        DB db = DB.getInstance();
        try {
            String sql = "UPDATE Bed SET With_Ventilator=? WHERE BED_ID=?";
            PreparedStatement stmt = db.getPreparedStatement(sql);
            stmt.setBoolean(1, bed.getWith_Ventilator());
            stmt.setInt(2, bed.getBed_ID());
            int rowsUpdated = stmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("An existing bed was updated successfully!");
            }
        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }
    }
    
    /**
     * Delete a bed from bed table if the entity exists
     * @param bed 
     */
    @Override
    public void delete(Bed bed) {
        DB db = DB.getInstance();
        try {
            String sql = "DELETE FROM Bed WHERE Bed_ID = ?";
            PreparedStatement stmt = db.getPreparedStatement(sql);
            stmt.setInt(1, bed.getBed_ID());
            int rowsDeleted = stmt.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("A bed was deleted successfully!");
            }
        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }
    }
    
    /**
     * Get all column names in a list array
     * @return 
     */
    @Override
    public List<String> getColumnNames() {
        DB db = DB.getInstance();
        ResultSet rs = null;
        List<String> headers = new ArrayList<>();
        try {
            String sql = "SELECT * FROM Bed WHERE Bed_ID = -1";//We just need this sql query to get the column headers
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
