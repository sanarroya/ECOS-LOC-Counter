/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniandes.ecos.isw.tarea2.app.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author SantiagoAvila
 */
public class CountManager {
    
    private final static String COMMENTS_0 = "/*";
    private final static String COMMENTS_1 = "*";
    private final static String COMMENTS_2 = "*/";
    private final static String COMMENTS_3 = "//";
    private final static String PUBLIC = "public";
    private final static String PRIVATE = "private";
    private final static String STATIC = "static";
    private final static String OPENING_SIGN = "{";
    private final static String OPENING_PARENTHESIS = "(";
    private final static String CLOSING_PARENTHESIS = "(";

    
    static public List<ProjectInfo> numberOfLines(List<ProjectInfo> projects) {
        for(ProjectInfo project : projects) {
            int numberOfLines = 0;
            int numberOfItems = 0;
            for(String fileName : project.projectFiles) {
                String countingResult = countLines(fileName);
                String[] linesAndItems = countingResult.split(":xxx:");
                int lines = Integer.parseInt(linesAndItems[0]);
                int items = Integer.parseInt(linesAndItems[1]);
                numberOfLines += lines;
                numberOfItems += items;
            }
            project.items = numberOfItems;
            project.linesOfCode = numberOfLines;
        }
        return projects;
    }
    
    private static String countLines(String fileName) {
        
        int numberOfLines = 0;
        int numberOfItems = 0;
        File archive = new File(fileName);
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line;
            while((line = reader.readLine()) != null) {
                if(!line.isEmpty() && !line.trim().isEmpty() && !line.contains(COMMENTS_0) && !line.contains(COMMENTS_1) && !line.contains(COMMENTS_2) && !line.contains(COMMENTS_3)) {
                    numberOfLines++;
                    if((line.contains(PUBLIC) || line.contains(PRIVATE) || line.contains(STATIC)) && line.contains(OPENING_SIGN) && line.contains(OPENING_PARENTHESIS) && line.contains(CLOSING_PARENTHESIS)) {
                        numberOfItems++;
                    }
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(LoadData.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(LoadData.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String result = String.valueOf(numberOfLines) + ":xxx:"+ String.valueOf(numberOfItems);
        return result;
    }  
}