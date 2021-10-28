/** 
 *  In this program 3 methods are used :
 *  1.  In the method  findReplaceString(String searchPhrase),
 *  	the Java Regex API and inbuilt String method replaceAll( ) are used 
 *  	Logic : simply all characters in the string(searchPhrase) 
 *  			except white spaces are replaced by '#'
 *  
 * 2. In the method fileReadingUsingPath(String filePath) ,
 * 	   Used BufferedReader to read file and StringBuilder to store the file into a String 
 * 
 * 3. In the main method inputs are taken with help of Scanner class.
 */
import java.io.*;
import java.util.Scanner;
public class Challenge {
	
	public static String findReplaceString(String searchPhrase) {
		String replacePhrase = "";
		replacePhrase = searchPhrase.replaceAll("[^\\s]", "#");
		return replacePhrase;
		
	}

	public String fileReadingUsingPath(String filePath) {
		String str = "";
		StringBuilder strBuilder = new StringBuilder();
		try {
			BufferedReader br = new BufferedReader(new FileReader(filePath));
			String strCurrentLine;
			while((strCurrentLine = br.readLine()) != null){
				
				strBuilder.append(strCurrentLine).append("\n");
			}
			br.close();
			
		}
		catch (Exception e) {
			System.err.println(e.getMessage());
		}
		str = strBuilder.toString();
		return str;
	}
	
	public static void main(String[] args) {
		
		Scanner scn = new Scanner(System.in);
		System.out.println("Please enter the path of the file");
		String filePath = scn.nextLine();
		System.out.println("Please enter the search Phrase");
		String searchPhrase = scn.nextLine();
		
		Challenge obj1 = new Challenge();
		String str = obj1.fileReadingUsingPath(filePath);
		
		
		String replacePhrase = findReplaceString(searchPhrase);
        System.out.println(str.replace(searchPhrase, replacePhrase));
		
		scn.close();
		}
}
