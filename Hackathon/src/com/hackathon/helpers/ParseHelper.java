package com.hackathon.helpers;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.opencsv.CSVReader;

public class ParseHelper {

	
	
	
	public static List<String[]> parseFile(File file) {
		
		List<String[]> rawRows = new ArrayList<String[]>();
		
        String[] nextLine;
        
        String ch = "'";
        try {
            //read file
            //CSVReader(fileReader, ';', ''', 1) means
            //using separator ; and using single quote ' . Skip first line when read

            try (FileReader fileReader = new FileReader(file);
                CSVReader reader = new CSVReader(fileReader, ';', ch.charAt(0), 0);) {
            	
                while ((nextLine = reader.readNext()) != null) {
                    for(int i=0;i<nextLine.length;i++){
                    	
                    	nextLine[i] = nextLine[i].replaceAll("[^\\x00-\\x7F]", "");
                    	
                    	String[] values = nextLine[i].split(",");
                    	rawRows.add(values);
                    }
                }
            }
            
            
            
            
        } catch (IOException e) {
            System.out.println("error while reading csv and put to db : " + e.getMessage());
        } 

		
		
		return rawRows;
		
		
		
	}

	

	
	
}
