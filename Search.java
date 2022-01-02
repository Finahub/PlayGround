package Search;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Search {
	public static void main(String arg[]) throws IOException {
		// initialize path of the file,searching word,and a string.
		String path, searchWord, str = null;
		// initialize fileReader and set to null.
		FileReader fr = null;
		System.out.println("Enter the Path of file to Scan");
		Scanner sc = new Scanner(System.in);
		// Scan the path.
		path = sc.nextLine();
		// set file to be read.
		File input = new File(path);
		System.out.println("Enter the String to search..");
		// reading word that to be searched.
		searchWord = sc.nextLine();
		try {
			fr = new FileReader(input);
			BufferedReader br = new BufferedReader(fr);
			// set str each line of the file and check the serching word is found or not
			while ((str = br.readLine()) != null) {
				// replace the word using #.
				if (str.contains(searchWord)) {
					String hash = "#";
					searchWord.replaceAll(searchWord, hash);
					Scanner scan = new Scanner(input);
					// print the txtfile after replace..
					System.out.println(scan.nextLine());

				}
			}
		} catch (Exception e) {
			System.out.println("exception found" + e.getMessage());
		} 
		//close the file.
		finally {
			fr.close();
		}

	}

}
