import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] agrs){
        try{
            Scanner scannerObject1 = new Scanner(System.in);

            System.out.print("Enter the file location (ONLY  WINDOWS OS FILE ACCESS IS POSSIBLE!! ) : ");
            String file_path = scannerObject1.nextLine();

            System.out.print("Enter the phrase to change :");
            String search_phrase = scannerObject1.nextLine();

            scannerObject1.close();

            // finding the replacement phrase
            String replacement_phrase = findReplacementPhrase(search_phrase);
            System.out.println("Entered phrase will be replaced with -->" +replacement_phrase);

            //Reading file to a string
            String fileContent = "";
            File file = new File(file_path);
            Scanner scannerObject2 = new Scanner(file);
            while(scannerObject2.hasNextLine()){
                fileContent =fileContent.concat(scannerObject2.nextLine()+"\n");
            }

            //Replacing the phrase with the desired new string
            String editedFileContent = fileContent.replaceAll(search_phrase, replacement_phrase);
            System.out.println("Execution completed .\n [ "+search_phrase+" ] replaced with [ "+replacement_phrase+" ]");
            System.out.print("\n");
            System.out.println("FILE CONTENT===>");
            //System.out.println("\n");
            System.out.print(editedFileContent);
            System.out.println("\n");

            //Attaching edited file
            FileWriter writer = new FileWriter(file_path);
            writer.write(editedFileContent);
            System.out.println("****Old file replaced with new edited file.****");

            scannerObject2.close();
            writer.close();

        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Function for finding the replacement phrase
    static String findReplacementPhrase(String given_phrase)
    {
        char[] new_phrase_array = new char[given_phrase.length()];
        for (int i=0; i < given_phrase.length(); i++)
        {
            if (given_phrase.charAt(i) == ' ')
            {
                new_phrase_array[i] = ' ';
            }
            else
            {
                new_phrase_array[i] = '#';
            }
        }
        String new_string = new String(new_phrase_array);
        return new_string;

    }

}