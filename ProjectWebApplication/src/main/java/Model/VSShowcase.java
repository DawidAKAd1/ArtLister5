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
public class VSShowcase implements Serializable{

    private int ShowCaseID;

    private String Name;
    private String Description;
    private String Image;
    private String Status;

    public VSShowcase() {

    }

    public VSShowcase(int ShowCaseID, String Name, String Description, String Image, String Status) {
        this.ShowCaseID = ShowCaseID;
        this.Name = Name;
        this.Description = Description;
        this.Image = Image;
        this.Status = Status;
    }

    public int getShowCaseID() {
        return ShowCaseID;
    }

    public void setShowCaseID(int ShowCaseID) {
        this.ShowCaseID = ShowCaseID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String Image) {
        this.Image = Image;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

    public ArrayList<VSShowcase> findAllShowcase() {
        ArrayList<VSShowcase> allShowcase = new ArrayList<VSShowcase>();
        Connection c = VSDataBaseHelper.getConnection();
        String template = "SELECT * FROM showcase where status != 'PENDING'";

        if (c != null) {
            try {
                PreparedStatement inserter = c.prepareStatement(template);
                ResultSet resultSet = inserter.executeQuery();
                System.out.println("All Showcases");
                while (resultSet.next()) {
                    VSShowcase b = new VSShowcase();
                    b.ShowCaseID = resultSet.getInt("ShowCaseID");
                    b.Name = resultSet.getString("Name");
                    b.Description = resultSet.getString("Description");
                    b.Image = resultSet.getString("Image");
                    b.Status = resultSet.getString("Status");

                    allShowcase.add(b);

                }

                System.out.println(inserter);
                inserter.close();
                c.close();
            } catch (SQLException ex) {
                System.out.println("Error on find all " + ex);
            }

        }

        return allShowcase;
    }

    public ArrayList<VSShowcase> findAllLiveShowcase() {
        ArrayList<VSShowcase> allLiveShowcase = new ArrayList<VSShowcase>();
        Connection c = VSDataBaseHelper.getConnection();
        String template = "SELECT * FROM showcase where status = 'LIVE'";

        if (c != null) {
            try {
                PreparedStatement inserter = c.prepareStatement(template);
                ResultSet resultSet = inserter.executeQuery();
                System.out.println("All Live Showcases");
                while (resultSet.next()) {
                    VSShowcase b2 = new VSShowcase();
                    b2.ShowCaseID = resultSet.getInt("ShowCaseID");
                    b2.Name = resultSet.getString("Name");
                    b2.Description = resultSet.getString("Description");
                    b2.Image = resultSet.getString("Image");
                    b2.Status = resultSet.getString("Status");

                    allLiveShowcase.add(b2);

                }

                System.out.println(inserter);
                inserter.close();
                c.close();
            } catch (SQLException ex) {
                System.out.println("Error on find all " + ex);
            }

        }

        return allLiveShowcase;
    }

}
