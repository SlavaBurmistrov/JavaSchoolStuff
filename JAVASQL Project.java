

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLWarning;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import java.util.Scanner;

import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;

public class asg5 {
    static private boolean debug = true;

    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String URL = "jdbc:mysql://localhost:3306/";
    //static final String URL = "jdbc:mysql://127.0.0.1:3306/";

    //  Database credentials
    static final String DBASE = "company";
    static final String USER = "root";
    static final String PASS = "";

    public static void main(String[] args) {
    	int count, wacount;
        String inpname;
        Scanner console = new Scanner(System.in);  
        FileReader file; 
        Scanner inFile;
        String fileName;
        System.out.print("Please input file name: ");
        fileName = console.nextLine();
        try {
            file = new FileReader(fileName);
            inFile = new Scanner(file);
        } catch (FileNotFoundException fe){
            fe.printStackTrace();
            inFile = new Scanner(System.in);
            System.exit(0);
        }
        
        
        Connection conn = null;
        PreparedStatement stmt1 = null, stmt2 = null, stmt3 = null;

        try {
            // Register JDBC driver
            Class.forName(JDBC_DRIVER);

            // Open a connection
            conn = DriverManager.getConnection(URL + DBASE, USER, PASS);

            if (conn != null) {
                System.out.println();
                System.out.println("Successfully connected to the " + DBASE + " database");
                System.out.println();
                //make the queries
                stmt1 = conn.prepareStatement("SELECT dname,lname, fname FROM project, department, employee WHERE ssn = mgrssn AND dnumber = dnum AND pnumber = ?");
                stmt2 = conn.prepareStatement("SELECT pname FROM project WHERE pnumber = ?");
                stmt3 = conn.prepareStatement("SELECT COUNT(PNO) FROM works_on, project WHERE pno = pnumber AND pnumber = ?");
                
                System.out.println("Enter input file name: " + fileName);
                System.out.println("Proj#   ProjName        Department      Manager         # of assignments   ");
                System.out.println("------- -------------   --------------- --------------  ----------------   ");
				count = 0;
				wacount = 0;
                //Reading the Text file, Should loop
                while(inFile.hasNext()) {
                    inpname = inFile.nextLine();
                    stmt1.clearParameters();
                    stmt1.setString(1, inpname); // replaces the first argument (?) with inpname value
                    ResultSet rs1 = stmt1.executeQuery();

                    //test
                    stmt2.clearParameters();
                    stmt2.setString(1, inpname); // replaces the first argument (?) with inpname value
                    ResultSet rs2 = stmt2.executeQuery();
                    
                    stmt3.clearParameters();
                    stmt3.setString(1, inpname); // replaces the first argument (?) with inpname value
                    ResultSet rs3 = stmt3.executeQuery();
                    if (!rs2.next()){
                        System.out.println("Invalid Input for: " + inpname);
                        continue;
                    } else {
                        count++;
                        String ProjectNum = inpname;
                        do { //Project Name query output
                            String ProjectName = rs2.getString(1);
                
                            SQLWarning warning = stmt2.getWarnings();
                            if (warning != null) {
                                System.out.println("\n---Warning---\n");
                                while (warning != null) {
                                    System.out.println("Message: " + warning.getMessage());
                                    System.out.println("SQLState: " + warning.getSQLState());
                                    System.out.print("Vendor error code: ");
                                    System.out.println(warning.getErrorCode());
                                    System.out.println("");
                                    warning = warning.getNextWarning();
                                }
                            }
                        
                            System.out.printf("%-7s %-17s ", ProjectNum, ProjectName);
                        } while (rs2.next());
                        rs2.close();
                        while (rs1.next()) { //Department and Manger Name query output
                            String Department = rs1.getString(1);
                            String Name = rs1.getString(2);
                            Name = Name.concat(" ");
                            Name = Name.concat(rs1.getString(3));

                            SQLWarning warning = stmt1.getWarnings();
                            if (warning != null) {
                                System.out.println("\n---Warning---\n");
                                while (warning != null) {
                                    System.out.println("Message: " + warning.getMessage());
                                    System.out.println("SQLState: " + warning.getSQLState());
                                    System.out.print("Vendor error code: ");
                                    System.out.println(warning.getErrorCode());
                                    System.out.println("");
                                    warning = warning.getNextWarning();
                                }
                            }
                        
                            System.out.printf("%-15s %-17s ", Department, Name);
                        }
                        rs1.close();
                        while (rs3.next()) { //PNO count output
                            String PNOCount = rs3.getString(1);
                            wacount = wacount + Integer.parseInt(PNOCount);

                            SQLWarning warning = stmt3.getWarnings();
                            if (warning != null) {
                                System.out.println("\n---Warning---\n");
                                while (warning != null) {
                                    System.out.println("Message: " + warning.getMessage());
                                    System.out.println("SQLState: " + warning.getSQLState());
                                    System.out.print("Vendor error code: ");
                                    System.out.println(warning.getErrorCode());
                                    System.out.println("");
                                    warning = warning.getNextWarning();
                                }
                            }
                        
                            System.out.printf(" %-16s\n", PNOCount);
                        }
                        rs3.close();
                    }
                }
			float avrgwrk = (float) wacount/count; //Avarage number of work assignments
			System.out.printf("The average number of work assignments per valid project is: %.2f\n", avrgwrk );
            }
        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            try {
                if (stmt1 != null)
                    stmt1.close();
            } catch (SQLException se2) {} // nothing we can do
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            } //end finally try
        } //end try
        System.out.println("\nBye!");
    } //end main
} //end TestDB4