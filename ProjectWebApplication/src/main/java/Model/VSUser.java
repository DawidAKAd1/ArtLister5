/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author SethJ
 */
public class VSUser implements Serializable{
    
    private int UserID;
    
    private String FirstName;
    private String Surname;
    private String EmailAddress;
    private String UserType;
    private String UserName;
    private String Password;
    private String Organization;
    
    public VSUser() {
        
    }

    public VSUser(int UserID, String FirstName, String Surname, String EmailAddress, String UserType, String UserName, String Password, String Organization) {
        this.UserID = UserID;
        this.FirstName = FirstName;
        this.Surname = Surname;
        this.EmailAddress = EmailAddress;
        this.UserType = UserType;
        this.UserName = UserName;
        this.Password = Password;
        this.Organization = Organization;
    }

    public int getUserID() {
        return UserID;
    }

    public void setUserID(int UserID) {
        this.UserID = UserID;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    public String getSurname() {
        return Surname;
    }

    public void setSurname(String Surname) {
        this.Surname = Surname;
    }

    public String getEmailAddress() {
        return EmailAddress;
    }

    public void setEmailAddress(String EmailAddress) {
        this.EmailAddress = EmailAddress;
    }

    public String getUserType() {
        return UserType;
    }

    public void setUserType(String UserType) {
        this.UserType = UserType;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String UserName) {
        this.UserName = UserName;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getOrganization() {
        return Organization;
    }

    public void setOrganization(String Organization) {
        this.Organization = Organization;
    }
    
    
    public ArrayList<VSUser> findAllUserInfo(int userID) {
        ArrayList<VSUser> allUserInfo = new ArrayList<VSUser>();
        Connection c = VSDataBaseHelper.getConnection();
        
        String template = "SELECT * FROM  user where UserID = ?";

        if (c != null) {
            try {
                PreparedStatement inserter = c.prepareStatement(template);
                 inserter.setInt(1, userID);
                ResultSet resultSet = inserter.executeQuery();
                System.out.println("All ProjectInfo");
                while (resultSet.next()) {
                    VSUser g = new VSUser();
                    g.setUserID(resultSet.getInt("UserID")); 
                    g.setFirstName(resultSet.getString("FirstName"));
                    g.setSurname(resultSet.getString("Surname"));
                    g.setEmailAddress(resultSet.getString("EmailAddress"));
                    g.setUserType(resultSet.getString("UserType"));
                    g.setUserName(resultSet.getString("UserName"));
                    g.setPassword(resultSet.getString("Password"));
                    g.setOrganization(resultSet.getString("Organization"));

                    allUserInfo.add(g);

                }

                System.out.println(inserter);
                inserter.close();
                c.close();
            } catch (SQLException ex) {
                System.out.println("Error on find all " + ex);
            }

        }

        return allUserInfo;
    }
    
     public VSUser findUserInfo(int userID) {
        
        Connection c = VSDataBaseHelper.getConnection();
        
        String template = "SELECT * FROM  user where UserID = ?";

        if (c != null) {
            try {
                PreparedStatement inserter = c.prepareStatement(template);
                 inserter.setInt(1, userID);
                ResultSet resultSet = inserter.executeQuery();
                System.out.println("All ProjectInfo");
                while (resultSet.next()) {
                    VSUser g = new VSUser();
                    g.setUserID(resultSet.getInt("UserID")); 
                    g.setFirstName(resultSet.getString("FirstName"));
                    g.setSurname(resultSet.getString("Surname"));
                    g.setEmailAddress(resultSet.getString("EmailAddress"));
                    g.setUserType(resultSet.getString("UserType"));
                    g.setUserName(resultSet.getString("UserName"));
                    g.setPassword(resultSet.getString("Password"));
                    g.setOrganization(resultSet.getString("Organization"));
                    System.out.println("Username " + resultSet.getString("UserName"));
System.out.println(inserter);
                    return g;

                }

                System.out.println(inserter);
                inserter.close();
                c.close();
            } catch (SQLException ex) {
                System.out.println("Error on find all " + ex);
            }

        }

      return null;
    }
    
}
