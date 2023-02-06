/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.projectwebapplication;

import Model.VSComments;
import Model.VSProject;
import Model.VSProjectAsset;
import Model.VSShowcase;
import Model.VSShowcaseProject;
import Model.VSUser;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author k00262792
 */
public class VSArtListerController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //start coding here
        String url = "/HomePage.jsp";
        String action = request.getParameter("ACTION");
        HttpSession session = request.getSession();
        if (action == null) {
            action = "HOME";
        }
        
        System.out.println("processing request" + action);
        switch (action) {
            case "HOME":
                processRequestShowcases(session);
                processRequestProjects(session);
                url = "/HomePage.jsp";
                break;
            case "SHOWCASELISTPAGE":
                processRequestShowcases(session);
                url = "/ShowcaseListPage.jsp";
                break;
            case "GETPROJETCS":
                processRequestProjects(session);
                url = "/ShowcasePage.jsp";
                break;
            case "GETSHOWCASEPROJETCS":
                processRequestShowcaseProjects(request, response, session);
                url = "/ShowcasePage.jsp";
                break;
            case "GETPROJETCINFO":
                processRequestProjectInfo(request, response, session);
                url = "/ProjectPage.jsp";
                break;
            case "GETUSERINFO":
                processRequestUserInfo(request, response, session);
                url = "/ProjectPage.jsp";
                break;
            case "GETCOMMENTINFO":
                processRequestCommentInfo(request, response, session);
                url = "/ProjectPage.jsp";
                break;
        }
        gotoPage(url, request, response);
    }

    private void processRequestShowcases(HttpSession session) {
        //All Showcases
        System.out.println("in display all showcases");
        ArrayList<VSShowcase> allShowcaseList = new ArrayList<>();
        VSShowcase b1 = new VSShowcase();
        allShowcaseList = b1.findAllShowcase();
        System.out.println("after find all " + allShowcaseList.size());
        session.setAttribute("AllShowCases", allShowcaseList);

        //All Live Showcases
        System.out.println("in display all live showcases");
        ArrayList<VSShowcase> allLiveShowcaseList = new ArrayList<>();
        VSShowcase b2 = new VSShowcase();
        allLiveShowcaseList = b2.findAllLiveShowcase();
        System.out.println("after find all " + allLiveShowcaseList.size());
        session.setAttribute("AllLiveShowCases", allLiveShowcaseList);
    }

    private void processRequestProjects(HttpSession session) {
        //All Projects
        System.out.println("in display all projects");
        ArrayList<VSProjectAsset> allProjectAssetList = new ArrayList<>();
        VSProjectAsset d1 = new VSProjectAsset();
        allProjectAssetList = d1.findProjectAsset();
        System.out.println("after find all " + allProjectAssetList.size());
        session.setAttribute("AllProjectAsset", allProjectAssetList);
        
    }

    private void processRequestShowcaseProjects(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        //Find All Projects for Showcase
        ArrayList<VSProject> allShowcaseProject = new ArrayList<VSProject>();
        VSShowcaseProject sProjects = new VSShowcaseProject();
        String ShowcaseID = request.getParameter("ShowcaseID");
        int sID = Integer.parseInt(ShowcaseID);
        
       allShowcaseProject = sProjects.findAllShowcaseProject(sID);
       for(VSProject p:allShowcaseProject){
           System.out.println("user name on showcase " + p.getUserObject().getUserName());
       }
        System.out.println("ShowcaseProjects " + allShowcaseProject.size());
        session.setAttribute("ShowcaseProjects", allShowcaseProject);
    }
    
    private void processRequestProjectInfo(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        //Find Project Info for Project
        ArrayList<VSProjectAsset> allProjectInfo = new ArrayList<VSProjectAsset>();
        VSProjectAsset iProjects = new VSProjectAsset();
        String ProjectID = request.getParameter("ProjectID");
        int pID = Integer.parseInt(ProjectID);
        
       allProjectInfo = iProjects.findAllProjectInfo(pID);
        System.out.println("ProjectsInfo " + allProjectInfo.size());
        session.setAttribute("ProjectsInfo", allProjectInfo);
    }
    
    private void processRequestUserInfo(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        //Find User Info for Project
        ArrayList<VSUser> allUserInfo = new ArrayList<VSUser>();
        VSUser uProjects = new VSUser();
        String UserID = request.getParameter("UserID");
        int uID = Integer.parseInt(UserID);
        
       allUserInfo = uProjects.findAllUserInfo(uID);
        System.out.println("UserInfo " + allUserInfo.size());
        session.setAttribute("UserInfo", allUserInfo);
    }
    
     private void processRequestCommentInfo(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
         //Find All Comments for Project
        ArrayList<VSComments> allComments = new ArrayList<VSComments>();
        VSComments cProjects = new VSComments();
        String ProjectID = request.getParameter("ProjectID");
        int pID = Integer.parseInt(ProjectID);
        
        allComments = cProjects.findAllProjectComments(pID);
        System.out.println("ProjectsComment " + allComments.size());
        session.setAttribute("ProjectsComment", allComments);
    }
    
    
    
    

    private void gotoPage(String url, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
