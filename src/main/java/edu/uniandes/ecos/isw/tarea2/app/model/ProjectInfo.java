/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniandes.ecos.isw.tarea2.app.model;

import java.util.List;

/**
 *
 * @author SantiagoAvila
 */
public class ProjectInfo {
    
    public String projectName;
    public List<String> projectFiles;
    public int items;
    public int linesOfCode;
    
    public ProjectInfo() {
        
    }
    
    public ProjectInfo(String projectFolder, List<String> projectFiles) {
        this.projectName = projectFolder;
        this.projectFiles = projectFiles;
    }
}