import java.io.BufferedWriter;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class WriteLoadContent {

  public static List<String> loadFile(String source) {
    List<String> myList = new ArrayList<>();
    try {
      Path path1 = Paths.get(source);
      List<String> etwas = Files.readAllLines(path1);
      myList = new ArrayList<>(etwas);
    } catch (Exception wrongpath) {
      System.out.println("WRONG PATH!!");
    } return myList;
  }

  public static void writeAFile(List<String> source, String listname){
    try {
      BufferedWriter writer = new BufferedWriter(new FileWriter(listname));
      for (int rows = 0; rows < source.size(); rows++) {
        writer.write(source.get(rows));
        writer.newLine();
      }
      writer.close();
    } catch (Exception x) {
      System.out.println("Filewriter FAILED");
    }
  }
}
