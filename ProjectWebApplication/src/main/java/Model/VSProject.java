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
public class VSProject implements Serializable{

    private int ProjectID;

    private String ProjectName;
    private String ProjectDescription;

    private int UserID;
    private int CourseCardID;
    private int Year;

    public VSUser getUserObject() {
        return userObject;
    }

    public void setUserObject(VSUser userObject) {
        this.userObject = userObject;
    }
    private VSUser userObject = null;


    public VSProject() {

    }

    public VSProject(int ProjectID, String ProjectName, String ProjectDescription, int UserID, int CourseCardID, int Year) {
        this.ProjectID = ProjectID;
        this.ProjectName = ProjectName;
        this.ProjectDescription = ProjectDescription;
        this.UserID = UserID;
        this.CourseCardID = CourseCardID;
        this.Year = Year;
    }

    public int getProjectID() {
        return ProjectID;
    }

    public void setProjectID(int ProjectID) {
        this.ProjectID = ProjectID;
    }

    public String getProjectName() {
        return ProjectName;
    }

    public void setProjectName(String ProjectName) {
        this.ProjectName = ProjectName;
    }

    public String getProjectDescription() {
        return ProjectDescription;
    }

    public void setProjectDescription(String ProjectDescription) {
        this.ProjectDescription = ProjectDescription;
    }

    public int getUserID() {
        return UserID;
    }

    public void setUserID(int UserID) {
        this.UserID = UserID;
    }

    public int getCourseCardID() {
        return CourseCardID;
    }

    public void setCourseCardID(int CourseCardID) {
        this.CourseCardID = CourseCardID;
    }

    public int getYear() {
        return Year;
    }

    public void setYear(int Year) {
        this.Year = Year;
    }

    public ArrayList<VSProject> findAllProjects() {
        ArrayList<VSProject> allProjects = new ArrayList<VSProject>();
        Connection c = VSDataBaseHelper.getConnection();
        String template = "SELECT * FROM project";

        if (c != null) {
            try {
                PreparedStatement inserter = c.prepareStatement(template);
                ResultSet resultSet = inserter.executeQuery();
                System.out.println("All Projects");
                while (resultSet.next()) {
                    VSProject e = new VSProject();
                    e.ProjectID = resultSet.getInt("ProjectID");
                    e.ProjectName = resultSet.getString("ProjectName");
                    e.ProjectDescription = resultSet.getString("ProjectDescription");
                    e.UserID = resultSet.getInt("UserID");
                    e.CourseCardID = resultSet.getInt("CourseCardID");
                    e.Year = resultSet.getInt("Year");

                    allProjects.add(e);

                }

                System.out.println(inserter);
                inserter.close();
                c.close();
            } catch (SQLException ex) {
                System.out.println("Error on find all " + ex);
            }

        }

        return allProjects;
    }

}
