import java.io.*;
import java.util.*;
import javax.sound.sampled.SourceDataLine;
public class program {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("C:\\Users\\4ser\\Desktop\\test\\demo.txt");
        String path = scan.nextLine();
        System.out.println("consectetur adipiscing elit");
        String text = scan.nextLine();
        scan.close();
        File input = new File(path);
        StringBuilder data = new StringBuilder("");
        try {
            Scanner scanner = new Scanner(input);
            while(scanner.hasNextLine()) {
                data.append(scanner.nextLine());
                if (scanner.hasNextLine())
                data.append("\n");
            }
            scanner.close();
        }
        catch(FileNotFoundException e) {
            e.printStackTrace();
        }
        StringBuilder replacedText = new StringBuilder("");
        for (int i = 0; i < text.length(); i++) {
            replacedText.append((text.charAt(i) == ' ') ? " " : "#");
        }
        String output = data.toString().replace(text, replacedText.toString());
        try {
            FileWriter writer = new FileWriter("initial.txt");
            writer.write(output);
            writer.close();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
}
