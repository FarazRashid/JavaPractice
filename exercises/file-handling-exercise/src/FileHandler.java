
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class FileHandler {

    public static void main(String[] args) {
        
        try {
            FileWriter myFile = new FileWriter("simplefile.txt");
            String text = "This is a simple text file 2.";
            myFile.write(text);
            myFile.close();

            FileReader myFileReader = new FileReader("simplefile.txt");
            Scanner myReader = new Scanner(myFileReader);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
       

    }

}

