package edu.uniandes.ecos.isw.tarea2.app;

import edu.uniandes.ecos.isw.tarea2.app.model.LoadData;
import edu.uniandes.ecos.isw.tarea2.app.controller.Controller;
import edu.uniandes.ecos.isw.tarea2.app.model.ProjectInfo;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) {
     
        Controller controller = new Controller();
        List<String> projectDirectories = controller.loadProjectsInEnclosingFolder();
        List<ProjectInfo> projects = new ArrayList<ProjectInfo>();
        projects = controller.loadFilesOfProject(projectDirectories);
        projects = controller.countLines(projects);
        for(ProjectInfo project : projects) {
            System.out.println(project.projectName + ":\nNumero de clases: " + project.projectFiles.size() + "\nNumero de items: " + project.items + "\nNumero de lineas de codigo: " + project.linesOfCode);
            System.out.println("\n=======================================");
        }
        
    }
}
