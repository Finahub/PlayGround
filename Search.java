package Search;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Search {
	public static void main(String arg[]) throws IOException {
		
		String path, searchWord, str = null;
		
		FileReader fr = null;
		System.out.println("Enter the Path of file to Scan");
		Scanner sc = new Scanner(System.in);
		
		path = sc.nextLine();
		
		File input = new File(path);
		System.out.println("Enter the String to search..");
		
		searchWord = sc.nextLine();
		try {
			fr = new FileReader(input);
			BufferedReader br = new BufferedReader(fr);
			
			while ((str = br.readLine()) != null) {
			
				 if (str.contains(searchWord)) {
					String hash = "#";
					//searchWord.replace(searchWord, hash);
				
					
				 BufferedWriter writer = new BufferedWriter(new FileWriter(path));
				 
				 writer.write(searchWord.replace(searchWord, hash));
				 writer.close();
					
				 }
				
			}
		} catch (Exception e) {
			System.out.println("exception found" + e.getMessage());
		} 
		
		finally {
			fr.close();
		}

	}

}
