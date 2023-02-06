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
public class VSComments implements Serializable{
    
    private int CommentID;
    
    private String CommentDetails;
    
    private int Approved;
    private int UserID;
    private int ProjectID;

    public VSComments() {
    }

    public VSComments(int CommentID, String CommentDetails, int Approved, int UserID, int ProjectID) {
        this.CommentID = CommentID;
        this.CommentDetails = CommentDetails;
        this.Approved = Approved;
        this.UserID = UserID;
        this.ProjectID = ProjectID;
    }

    public int getCommentID() {
        return CommentID;
    }

    public void setCommentID(int CommentID) {
        this.CommentID = CommentID;
    }

    public String getCommentDetails() {
        return CommentDetails;
    }

    public void setCommentDetails(String CommentDetails) {
        this.CommentDetails = CommentDetails;
    }

    public int getApproved() {
        return Approved;
    }

    public void setApproved(int Approved) {
        this.Approved = Approved;
    }

    public int getUserID() {
        return UserID;
    }

    public void setUserID(int UserID) {
        this.UserID = UserID;
    }

    public int getProjectID() {
        return ProjectID;
    }

    public void setProjectID(int ProjectID) {
        this.ProjectID = ProjectID;
    }
    
    public ArrayList<VSComments> findAllProjectComments(int projectID) {
        ArrayList<VSComments> allComments = new ArrayList<VSComments>();
        Connection c = VSDataBaseHelper.getConnection();
        
        String template = "SELECT * FROM comment WHERE ProjectID = ?";

        if (c != null) {
            try {
                PreparedStatement inserter = c.prepareStatement(template);
                 inserter.setInt(1, projectID);
                ResultSet resultSet = inserter.executeQuery();
                System.out.println("All Comments");
                while (resultSet.next()) {
                    VSComments h = new VSComments();
                    h.setCommentID(resultSet.getInt("CommentID")); 
                    h.setCommentDetails(resultSet.getString("CommentDetails"));
                    h.setApproved(resultSet.getInt("Approved"));
                    h.setUserID(resultSet.getInt("UserID"));
                    h.setProjectID(resultSet.getInt("ProjectID"));

                    allComments.add(h);

                }

                System.out.println(inserter);
                inserter.close();
                c.close();
            } catch (SQLException ex) {
                System.out.println("Error on find all " + ex);
            }

        }

        return allComments;
    }
    
    
}
