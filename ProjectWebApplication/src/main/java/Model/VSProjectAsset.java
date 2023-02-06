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
public class VSProjectAsset implements Serializable{

    private int AssetID;
    private int ProjectID;

    private String AssetName;
    private String AssetDescription;
    private String AssetType;
    private String Asset;

    public VSProjectAsset() {

    }

    public VSProjectAsset(int AssetID, int ProjectID, String AssetName, String AssetDescription, String AssetType, String Asset) {
        this.AssetID = AssetID;
        this.ProjectID = ProjectID;
        this.AssetName = AssetName;
        this.AssetDescription = AssetDescription;
        this.AssetType = AssetType;
        this.Asset = Asset;
    }

    public int getAssetID() {
        return AssetID;
    }

    public void setAssetID(int AssetID) {
        this.AssetID = AssetID;
    }

    public int getProjectID() {
        return ProjectID;
    }

    public void setProjectID(int ProjectID) {
        this.ProjectID = ProjectID;
    }

    public String getAssetName() {
        return AssetName;
    }

    public void setAssetName(String AssetName) {
        this.AssetName = AssetName;
    }

    public String getAssetDescription() {
        return AssetDescription;
    }

    public void setAssetDescription(String AssetDescription) {
        this.AssetDescription = AssetDescription;
    }

    public String getAssetType() {
        return AssetType;
    }

    public void setAssetType(String AssetType) {
        this.AssetType = AssetType;
    }

    public String getAsset() {
        return Asset;
    }

    public void setAsset(String Asset) {
        this.Asset = Asset;
    }

    
    public ArrayList<VSProjectAsset> findProjectAsset() {
        ArrayList<VSProjectAsset> allProjectAsset = new ArrayList<VSProjectAsset>();
        Connection c = VSDataBaseHelper.getConnection();
        String template = "SELECT * FROM projectasset;";

        if (c != null) {
            try {
                PreparedStatement inserter = c.prepareStatement(template);
                ResultSet resultSet = inserter.executeQuery();
                System.out.println("All Projects");
                while (resultSet.next()) {
                    VSProjectAsset d = new VSProjectAsset();
                    d.AssetID = resultSet.getInt("AssetID");
                    d.ProjectID = resultSet.getInt("ProjectID");
                    d.AssetName = resultSet.getString("AssetName");
                    d.AssetDescription = resultSet.getString("AssetDescription");
                    d.AssetType = resultSet.getString("AssetType");
                    d.Asset = resultSet.getString("Asset");

                    allProjectAsset.add(d);

                }

                System.out.println(inserter);
                inserter.close();
                c.close();
            } catch (SQLException ex) {
                System.out.println("Error on find all " + ex);
            }

        }

        return allProjectAsset;
    }
    
    
    public ArrayList<VSProjectAsset> findAllProjectInfo(int projectID) {
        ArrayList<VSProjectAsset> allProjectInfo = new ArrayList<VSProjectAsset>();
        Connection c = VSDataBaseHelper.getConnection();
        
        String template = "SELECT * FROM  projectasset where ProjectID = ?";

        if (c != null) {
            try {
                PreparedStatement inserter = c.prepareStatement(template);
                 inserter.setInt(1, projectID);
                ResultSet resultSet = inserter.executeQuery();
                System.out.println("All ProjectInfo");
                while (resultSet.next()) {
                    VSProjectAsset d = new VSProjectAsset();
                    d.setAssetID(resultSet.getInt("AssetID")); 
                    d.setProjectID(resultSet.getInt("ProjectID"));
                    d.setAssetName(resultSet.getString("AssetName"));
                    d.setAssetDescription(resultSet.getString("AssetDescription"));
                    d.setAssetType(resultSet.getString("AssetType"));
                    d.setAsset(resultSet.getString("Asset"));

                    allProjectInfo.add(d);

                }

                System.out.println(inserter);
                inserter.close();
                c.close();
            } catch (SQLException ex) {
                System.out.println("Error on find all " + ex);
            }

        }

        return allProjectInfo;
    }
    
}
