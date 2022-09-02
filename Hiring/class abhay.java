import java.util.Scanner;  // Import the Scanner class
import java.io.File;  // Import the File class
import java.io.FileWriter;   // Import the FileWriter class
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

 class TextFileModificationProgram
{   
     void modifyFile(String filePath, String oldString, String newString)
    {
        File fileToBeModified = new File(filePath);
         
        String oldContent = "";
         
        BufferedReader reader = null;
         
        FileWriter writer = null;
         
        try
        {
            reader = new BufferedReader(new FileReader(fileToBeModified));
             
            //Reading all the lines of input text file into oldContent
             
            String line = reader.readLine();
             
            while (line != null) 
            {
                oldContent = oldContent + line + System.lineSeparator();
                 
                line = reader.readLine();
            }
             
            //Replacing oldString with newString in the oldContent
             
            String newContent = oldContent.replaceAll(oldString, newString);
             
            //Rewriting the input text file with newContent
             
            writer = new FileWriter(fileToBeModified);
             
            writer.write(newContent);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                //Closing the resources
                 
                reader.close();
                 
                writer.close();
            } 
            catch (IOException e) 
            {
                e.printStackTrace();
            }
        }
    }
}

class abhay {
  public static void main(String[] args) {
    Scanner myObj = new Scanner(System.in);  // Create a Scanner object
    System.out.println("Enter file path");

    String userName = myObj.nextLine();  // Read user input
    System.out.println("file path is: " + userName);  // Output user input

    System.out.println("Enter word");
    String userName1 = myObj.nextLine();  // Read user input
    System.out.println("word to be replaced is: " + userName1);  // Output user input
    myObj.close();

    TextFileModificationProgram obj=new TextFileModificationProgram();
    obj.modifyFile(userName,userName1,"#");

    

  }
}

