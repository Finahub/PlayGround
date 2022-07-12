package com.nirmal;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class ReplaceStringChllenge {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File log= new File("F:\\Tony Babu\\DSA Basics\\src\\com\\nirmal\\test.txt");
		String pattern = "consectetur adipiscing elit";
		String patternArray[] = pattern.split(" ");
		String replace = "";
		for(int i = 0; i < patternArray.length; i++) {
			if(i==0) {
				replace += patternArray[i].replaceAll(".", "#");
			}else {
				replace += " " +patternArray[i].replaceAll(".", "#");
			}
		}
		
		try{
		    FileReader fr = new FileReader(log);
		    String s;
		    String totalStr = "";
		    try (BufferedReader br = new BufferedReader(fr)) {
		    	int i=1;
		        while ((s = br.readLine()) != null) {
		            totalStr += s;
		        }
		        totalStr = totalStr.replaceAll(pattern, replace);
		        FileWriter fw = new FileWriter(log);
		    fw.write(totalStr);
		    fw.close();
		    }
		}catch(Exception e){
		    e.printStackTrace();
		}

	}

}
