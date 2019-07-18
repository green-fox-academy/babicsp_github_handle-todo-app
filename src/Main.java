
import java.nio.file.Files;
import java.util.List;

import static java.lang.Integer.parseInt;


public class Main extends WriteLoadContent {
  public static void main(String[] args) {


    String PathOfTheToDoList = "List.txt";

    try {

      if (args.length == 0) {
        printUsage();
      } else if (args[0].equals("todo")) {
        printUsage();
      } else if (args[0].equals("-l")) {
        writeOutListElements(PathOfTheToDoList);
      } else if (args[0].equals("-a")) {
        if (args.length != 2) {
          System.out.println("Unable to add: no task provided");
        } else {
          newToDoElement(PathOfTheToDoList, args[1]);
        }
      } else if (args[0].equals("-r")) {
        deleteElement(PathOfTheToDoList, args[1]);
      } else if (args[0].equals("-c")) {
        if (args.length != 2) {
          System.out.println("Unable to add: no task provided");
        } else if (args.length < parseInt(args[1])) {
          System.out.println("Unable to check: index is out of bound");
        } else
          checkIT(PathOfTheToDoList, args[1]);
      } else {
        System.out.println("Unsupported argument");
      }
    } catch (Exception x) {
      System.out.println("Unable to check: index is not a number");
    }
  }

  private static void checkIT(String listname, String arg) {
    List<String> myList = WriteLoadContent.loadFile(listname);
    myList.set(parseInt(arg) - 1,"[x] " + myList.get(parseInt(arg) - 1).substring(4));
    WriteLoadContent.writeAFile(myList,listname);
  }

  private static void deleteElement(String listname, String a) {
    List<String> myList = WriteLoadContent.loadFile(listname);
    myList.remove(parseInt(a) - 1);
    WriteLoadContent.writeAFile(myList,listname);
  }

  private static void newToDoElement(String listname, String a) {
    List<String> myList = WriteLoadContent.loadFile(listname);
    myList.add("[ ] " + a);
    WriteLoadContent.writeAFile(myList,listname);
  }



  private static List<String> writeOutListElements(String a) {
    List<String> myList = WriteLoadContent.loadFile(a);
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
