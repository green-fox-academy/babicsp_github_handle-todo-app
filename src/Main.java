
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


public class Main {
  public static void main(String[] args) {


    String listname = "List.txt";

    if (args[0].equals("todo")) {
      printUsage();
    } else if (args[0].equals("-l")) {
      loadInFiles(listname);
    } else if (args[0].equals("-a")){
      newToDoElement(listname, args[1]);
    }
  }

  private static void newToDoElement(String b, String a) {
    List<String> myList = putItToArraylist(b);
    myList.add(a);
    try {
      BufferedWriter writer = new BufferedWriter(new FileWriter("List.txt"));
      for (int rows = 0; rows < myList.size(); rows++) {
          writer.write(myList.get(rows));
          writer.newLine();
      }
      writer.close();
    } catch (Exception x){
      System.out.println("Filewriter FAILED");
    }

  }

  private static List<String> putItToArraylist(String a) {
    List<String> myList = new ArrayList<>();
    try {
      Path path1 = Paths.get(a);
      List<String> etwas = Files.readAllLines(path1);
      myList = new ArrayList<>(etwas);
    } catch (Exception wrongpath) {
      System.out.println("WRONG PATH!!");
    } return myList;
  }


  private static List<String> loadInFiles(String a) {
    List<String> myList = putItToArraylist(a);
      if (myList.isEmpty()){
        System.out.println("No todos for today :-)");
      } else {
        for (int i = 0; i < myList.size(); i++) {
          System.out.println((i + 1) + " - " + myList.get(i));
        }
      }
/*
      Files.write(path1,myList);
*/
    return myList;
  }


  public static void printUsage(){
    System.out.println("$ todo\n" +
            "\n" +
            "Command Line Todo application\n" +
            "=============================\n" +
            "\n" +
            "Command line arguments:\n" +
            "    -l   Lists all the tasks\n" +
            "    -a   Adds a new task\n" +
            "    -r   Removes an task\n" +
            "    -c   Completes an task");
  }
}
