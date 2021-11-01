package Javaprogram;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class SearchandReplace {
	public String readTextFromFile(String filePath) {
		String result = "";
		StringBuilder strBuilder = new StringBuilder();
		try {
			BufferedReader br = new BufferedReader(new FileReader(filePath));
			String strSentence;
			while ((strSentence = br.readLine()) != null) {
				strBuilder.append(strSentence).append(System.lineSeparator());
			}
			br.close();
		} catch (Exception e) {

		}
		result = strBuilder.toString();
		return result;
	}

	public void writeFile(String folderPath, String str) throws IOException {
		try {
			FileWriter fw = new FileWriter(folderPath + "\\NewFile.txt");
			fw.write(str);
			fw.close();
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter full path to the file");
		String filepath = scanner.nextLine();
		System.out.println("Enter word");
		String searchword = scanner.nextLine();
		SearchandReplace searchandReplace = new SearchandReplace();
		String str = searchandReplace.readTextFromFile(filepath);
		String stringToReplace = searchword.replaceAll("[^\\s]", "#");
		str = str.replace(searchword, stringToReplace);
		System.out.println(str);
		scanner.close();
		String folderPath = filepath.substring(0, filepath.lastIndexOf("\\"));
		searchandReplace.writeFile(folderPath, str);
	}

}
