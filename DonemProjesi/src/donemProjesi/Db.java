package donemProjesi;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author sqlitetutorial.net
 */
public class Db {

    /**
     * Connect to the test.db database
     *
     * @return the Connection object
     */
    private Connection connect() {
        // SQLite connection string
        String url = "jdbc:sqlite:/home/hhnigdeli/eclipse-workspace/donemProjesi/db/test.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
    
    /**
     * Update data of a warehouse specified by the id
     *
     * @param id
     * @param name name of the warehouse
     * @param capacity capacity of the warehouse
     */
    public void select() {
    	
    	String sql = "SELECT oyuncu, puan FROM OYUNCU ORDER BY\n" + 
		"	puan DESC";
        
        try (Connection conn = this.connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){
            
        	System.out.println("Oyuncu"+"    |   "+"Puan");
        	System.out.println("__________|__________");
            // loop through the result set
            while (rs.next()) {
                System.out.println(
                				   rs.getString("oyuncu") +  "\t" + 
                                   "  |  "+rs.getInt("puan") + "\t" );
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    /**
     * Update data of a warehouse specified by the id
     *
     * @param id
     * @param name name of the warehouse
     * @param capacity capacity of the warehouse
     */
    public boolean sorgu(String oyuncuIsim) {
    	
    	String sql ="SELECT\n" + 
    			    "	oyuncu,\n" + 
    			    "	puan \n" + 
    			    "FROM\n" + 
    			    "	OYUNCU\n" + 
    			    "WHERE\n" + 
    			    "	oyuncu = '" + oyuncuIsim + "'";
        
        try (Connection conn = this.connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){
            
        	int donus = 3;
            while (rs.next()) {               
            		donus *= rs.getInt("puan");                                   
            }
           
            if(donus!= 3) {
            	return true;
            }else if(donus == 0){
            	return true;
            }else {
            	return false;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
          }
        
        }
       
    /**
     * Update data of a warehouse specified by the id
     *
     * @param id
     * @param name name of the warehouse
     * @param capacity capacity of the warehouse
     */
    public int sorguPuan(String oyuncuIsim) {
        	
        	String sql ="SELECT\n" + 
        			    "	oyuncu,\n" + 
        			    "	puan \n" + 
        			    "FROM\n" + 
        			    "	OYUNCU\n" + 
        			    "WHERE\n" + 
        			    "	oyuncu = '" + oyuncuIsim + "'";
            
            try (Connection conn = this.connect();
                 Statement stmt  = conn.createStatement();
                 ResultSet rs    = stmt.executeQuery(sql)){
                
            	int donus = 0;
                while (rs.next()) {               
                		donus += rs.getInt("puan");                                   
                }
               
                return donus;
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
      return 0;  
    }
      
    /**
     * Update data of a warehouse specified by the id
     *
     * @param id
     * @param name name of the warehouse
     * @param capacity capacity of the warehouse
     */
    public void update(String oyuncu, int puan) {
        String sql = "UPDATE OYUNCU SET puan = ?  "
                + "WHERE oyuncu = ?";

        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // set the corresponding param
            pstmt.setString(2, oyuncu);
            pstmt.setInt(1, puan);
            
            // update 
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    /**
     * Insert a new row into the warehouses table
     *
     * @param name
     * @param capacity
     */
    public void insert(String oyuncu, int puan) {
        String sql = "INSERT INTO OYUNCU(oyuncu,puan) VALUES(?,?)";

        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, oyuncu);
            pstmt.setInt(2, puan);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
