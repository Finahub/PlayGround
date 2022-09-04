/*Done By Shafiullah.M
 Mail:shafi112k@gmail.com
 program : Change and replace with Hash #
*/

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
public class Req {

static String censor(String text, String word)
{

    String[] word_list = text.split("\\s+");
    String result = "";
    String stars = "";
    for (int i = 0; i < word.length(); i++)
        stars += '*';
    int index = 0;
    for (String i : word_list)
    {
        if (i.compareTo(word) == 0)
            word_list[index] = stars;
        index++;
    }
   
    // join the words
    for (String i : word_list)
        result += i + ' ';

    return result;
}
   
public static void main(String[] args) {
Scanner scanner = new Scanner(System.in);
System.out.println("Enter File path");
String filePath = scanner.next();
System.out.println("Search word:");
String printstar= scanner.next();
StringBuffer buffer = new StringBuffer();

File file = new File(filePath);

Scanner scannerFile = null;

try {

scannerFile = new Scanner(file);


while (scannerFile.hasNext())
{
buffer.append(scannerFile.nextLine()+System.lineSeparator());

}
String fileContents = buffer.toString();
scannerFile.close();

fileContents = censor(fileContents, printstar);
   
   Path output=Paths.get("output.txt");
   Files.writeString(output, fileContents, StandardCharsets.UTF_8);
   System.out.println("Successfully changed, Check output file....!");
} catch (Exception e) {
e.printStackTrace();
} finally {
scanner.close();
}
}

}
