/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniandes.ecos.isw.tarea2.app.controller;

import edu.uniandes.ecos.isw.tarea2.app.model.CountManager;
import edu.uniandes.ecos.isw.tarea2.app.model.LoadData;
import edu.uniandes.ecos.isw.tarea2.app.model.ProjectInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author SantiagoAvila
 */
public class Controller {
    
    public List<String> loadProjectsInEnclosingFolder() {
        String enclosingFolder = LoadData.getProjectEnclosingFolder();
        return LoadData.loadFoldersInFolder(enclosingFolder);
    }
    
    public List<ProjectInfo> loadFilesOfProject(List<String> projectDirectories) {
        return LoadData.loadFilesOfProject(projectDirectories);
    }
    
    public List<ProjectInfo> countLines(List<ProjectInfo> projects) {
        return CountManager.numberOfLines(projects);
    }
}
