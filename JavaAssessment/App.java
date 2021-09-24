import java.util.*;
import java.io.*;


class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String filePath = sc.nextLine();
        String str = sc.nextLine();

        try {
            File file = new File(filePath);
            String repl = str.replaceAll("\\w", "#");
            processFile(file, str, repl);
        } catch (FileNotFoundException ex) {
            System.out.println("File does not exist");
        } catch (IOException ex) {
            System.out.println("IOException occurred");
        }
    }

    private static void processFile(File file, String str, String repl) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(file));

        int c = 0, index = 0;
        String finalString = "";
        String tempString = "";

        while ((c = reader.read()) != -1) {
            char character = (char) c;

            if (index >= str.length()) {
                finalString += repl;
                tempString = "";
                index = 0;
            }

            if (character == str.charAt(index)) {
                tempString += character;
                index++;
            }
            else {
                if (tempString.length() > 0) {
                    finalString += tempString;
                    index = 0;
                }
                finalString += character;
            }
        }

        if (tempString.length() > 0) {
            if (tempString.length() == str.length()) finalString += repl;
            else finalString += tempString;
        }

        reader.close();

        FileWriter writer = new FileWriter(file, false);
        writer.write(finalString);
        writer.close();
    }
}