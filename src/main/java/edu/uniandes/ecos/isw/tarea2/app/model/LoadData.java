package edu.uniandes.ecos.isw.tarea2.app.model;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


/**
 *
 * @author SantiagoAvila
 */
public class LoadData {
    
    static final String STANDARD_ROUTE = "/src/main/java/edu/uniandes/ecos/isw/tarea2/app";
    static final String CUSTOME_ROUTE = "/src/tarea1";
    /**
     *
     * @return
     */
    static public List<String> loadFoldersInFolder(String folderName) {
        File folder = new File(folderName);
        File[] listOfFolders = folder.listFiles();
        List<String> foldersName = new ArrayList<String>();
        for (int i = 0; i < listOfFolders.length; i++) {
            if (listOfFolders[i].isDirectory()) {
                foldersName.add(listOfFolders[i].getName());
            } 
        }
        return foldersName;
    }
    
    static public List<String> loadFiles(List<String> folderNames) {
        List<String> filesName = new ArrayList<String>();
        for(String folderName : folderNames) {
            File folder = new File(folderName);
            File[] listOfFiles = folder.listFiles();
            for (int i = 0; i < listOfFiles.length; i++) {
                if (listOfFiles[i].isFile() && listOfFiles[i].getName().endsWith(".java")) {
                    filesName.add(folderName + "/" + listOfFiles[i].getName());
                } 
            }
        }
        
        return filesName;
    }
    
    static public String getProjectEnclosingFolder() {
        String projectFolder = System.getProperty("user.dir");
        return projectFolder.substring(0, projectFolder.lastIndexOf("/"));
    }
    
    static public List<ProjectInfo> loadFilesOfProject(List<String> projects) {
        List<ProjectInfo> projectsInfo = new ArrayList<ProjectInfo>();
        for(String projectFolder : projects) {
            if("Tarea1".equals(projectFolder)) {
                String source = LoadData.getProjectEnclosingFolder() + "/" + projectFolder + CUSTOME_ROUTE;
                List<String> tarea1Folders = LoadData.loadFoldersInFolder(source);
                List<String> subFolders = new ArrayList<String>();
                for(String subFolder : tarea1Folders) {
                    subFolders.add(source + "/" + subFolder);
                }
                List<String> files = LoadData.loadFiles(subFolders);
                System.out.println(files);
                ProjectInfo project = new ProjectInfo(projectFolder, files);
                projectsInfo.add(project);

            }else {
                String source = LoadData.getProjectEnclosingFolder() + "/" + projectFolder + STANDARD_ROUTE;
                List<String> folders = LoadData.loadFoldersInFolder(source);
                List<String> subFolders = new ArrayList<String>();
                for(String subFolder : folders) {
                    subFolders.add(source + "/" + subFolder);
                }
                subFolders.add(source);
                List<String> files = LoadData.loadFiles(subFolders);
                ProjectInfo project = new ProjectInfo(projectFolder, files);
                projectsInfo.add(project);

            }
        }
        return projectsInfo;
    }
}