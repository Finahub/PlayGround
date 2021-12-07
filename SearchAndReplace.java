import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class SearchAndReplace {
	

	  public static void main(String[] args) {
	        System.out.print("Enter Search and Replace Item: ");
	        Scanner sp = new Scanner(System.in);
	        String p;
	        String lists="";
	        p = sp.nextLine();
	        int length=p.length();
	        char array[]=new char[length];
	        
	        for(int i=0;i<length;i++){
	        	array[i]=p.charAt(i);
	        }
	       	       
	        	
	        {
	         try
	             {
	             File file = new File("C://users//adher//Desktop//newcommand.txt");
	             BufferedReader reader = new BufferedReader(new FileReader(file));
	             String line = "", oldtext = "";
	             while((line = reader.readLine()) != null)
	                 {
	            	
	                 oldtext += line + "\r\n";
	             }
	             reader.close();
	            
	             for(int i=0;i<length;i++) {
	            	 if(Character.isWhitespace(array[i])==true) {
	            		 lists=lists+"\t";
	            	 }else {
	            	 lists=lists+"#";
	            	 }
	             }
	             
	             String replacedtext  = oldtext.replaceAll(p, "" + lists);


	             FileWriter writer = new FileWriter("C://users//adher//Desktop//newcommand.txt");
	             writer.write(replacedtext);


	             writer.close();

	         }
	         catch (IOException ioe)
	             {
	             ioe.printStackTrace();
	         }
	     }

}
}
