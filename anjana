
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
public class replace {
   public static void main(String args[]) throws IOException {
      String filePath = "InputFile.txt";
      Scanner sc = new Scanner(new File(filePath));
      StringBuffer buffer = new StringBuffer();

      while (sc.hasNextLine()) {
         buffer.append(sc.nextLine()+System.lineSeparator());
      }
      String fileContents = buffer.toString();
      System.out.println("Contents of the file: "+fileContents);
      sc.close();
      String oldString = "consectetur adipiscing elit";
      String newString = "########### ########## ####";
      fileContents = fileContents.replaceAll(oldString, newString);
      String filePathNew = "OutputFile.txt";
      FileWriter writer = new FileWriter(filePathNew);
      System.out.println("");
      System.out.println("new : "+fileContents);
      writer.append(fileContents);
      
   }
}
