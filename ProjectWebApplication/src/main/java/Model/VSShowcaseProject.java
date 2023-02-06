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
 * @author k00262792
 */
public class VSShowcaseProject implements Serializable{

    private int ShowcaseProjectID;
    private int ProjectID;
    private int DisplayOrder;
    private int ShowcaseID;
   
    public VSShowcaseProject() {

    }

    public VSShowcaseProject(int ShowcaseProjectID, int ProjectID, int DisplayOrder, int ShowcaseID, String AssetName, String AssetDescription, String AssetType, String Asset) {
        this.ShowcaseProjectID = ShowcaseProjectID;
        this.ProjectID = ProjectID;
        this.DisplayOrder = DisplayOrder;
        this.ShowcaseID = ShowcaseID;
    }

    public int getShowcaseProjectID() {
        return ShowcaseProjectID;
    }

    public void setShowcaseProjectID(int ShowcaseProjectID) {
        this.ShowcaseProjectID = ShowcaseProjectID;
    }

    public int getProjectID() {
        return ProjectID;
    }

    public void setProjectID(int ProjectID) {
        this.ProjectID = ProjectID;
    }

    public int getDisplayOrder() {
        return DisplayOrder;
    }

    public void setDisplayOrder(int DisplayOrder) {
        this.DisplayOrder = DisplayOrder;
    }

    public int getShowcaseID() {
        return ShowcaseID;
    }

    public void setShowcaseID(int ShowcaseID) {
        this.ShowcaseID = ShowcaseID;
    }
        
    public ArrayList<VSProject> findAllShowcaseProject(int showcaseID) {
        ArrayList<VSProject> allShowcaseProject = new ArrayList<VSProject>();
        Connection c = VSDataBaseHelper.getConnection();
        
        String template = "SELECT * FROM `showcaseproject` Join Project on Project.ProjectID = ShowcaseProject.ProjectID where showcaseproject.ShowcaseID = ? ";

        if (c != null) {
            try {
                PreparedStatement inserter = c.prepareStatement(template);
                 inserter.setInt(1, showcaseID);
                ResultSet resultSet = inserter.executeQuery();
                System.out.println("All ShowcaseProject");
                while (resultSet.next()) {
                    VSProject f = new VSProject();
                    f.setProjectID(resultSet.getInt("ProjectID")); 
                    f.setProjectName(resultSet.getString("ProjectName"));
                    f.setProjectDescription(resultSet.getString("ProjectDescription"));
                    f.setUserID(resultSet.getInt("UserID"));
                    f.setYear(resultSet.getInt("Year"));
                    VSUser u = new VSUser();
                    u = u.findUserInfo(resultSet.getInt("UserID"));
                    f.setUserObject(u);
                    System.out.println("User " + u.getUserName());
                    allShowcaseProject.add(f);

                }

                System.out.println(inserter);
                inserter.close();
                c.close();
            } catch (SQLException ex) {
                System.out.println("Error on find all " + ex);
            }

        }

        return allShowcaseProject;
    }

}
