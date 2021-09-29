import java.io.*;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Main
{
  public static void main (String[]args)
  {
    String REGEX = "fun";
    String REPLACE = "###";
    String data ="";

      try
    {
      File myObj = new File ("filename.txt");
      Scanner myReader = new Scanner (myObj);
      while (myReader.hasNextLine ())
    {
       data = myReader.nextLine ();
        System.out.println (data);
      Pattern p = Pattern.compile (REGEX);
      Matcher m = p.matcher (data);
        data = m.replaceAll (REPLACE);
        System.out.println (data);
    }

      myReader.close ();
      try
      {
    FileWriter myWriter = new FileWriter ("filename.txt");
    myWriter.write (data);
    myWriter.close ();
    System.out.println ("Successfully wrote to the file.");
      }
      catch (IOException e)
      {
    System.out.println ("An error occurred.");
    e.printStackTrace ();
      }
    }
    catch (FileNotFoundException e)
    {
      System.out.println ("An error occurred.");
      e.printStackTrace ();
    }
  }
}
