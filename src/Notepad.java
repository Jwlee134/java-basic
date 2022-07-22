import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Notepad {
    public static Scanner scanner = new Scanner(System.in);
    public static Scanner fileScanner = null;
    public static FileWriter writer = null;
    public static FileInputStream stream = null;
    public static String input;
    public static int parsedInput;
    public static String newMemoName;
    public static List<String> list = new ArrayList<>();

    public static void main(String[] args) {
        while (true) {
            System.out.println("Choose a number to do.");
            System.out.println("1: New memo");
            System.out.println("2: Get a memo");
            System.out.println("3: Exit");

            input = scanner.nextLine();

            if (!isInputValid()) {
                continue;
            }
            if (parsedInput == 1) {
                System.out.println("Name of new memo?");
                newMemoName = scanner.nextLine();
                if (!createMemo(newMemoName)) {
                    continue;
                }
                System.out.println("Press q to finish writing.");
                writeMemo();
                list.clear();
                if (!closeMemo()) {
                    continue;
                }
            } else if (parsedInput == 2) {
                if (!retrieveMemo("memos")) {
                    continue;
                }
                fileScanner = new Scanner(stream);

                if (fileScanner.hasNextLine()) {
                    System.out.println("Write the name of memo.");
                    System.out.println("Available memos are as follows.");
                    makeList();
                    System.out.println(list);
                } else {
                    System.out.println("There are no available memos.");
                    continue;
                }

                String name = scanner.nextLine();
                if (!retrieveMemo(name)) {
                    continue;
                }
                fileScanner = new Scanner(stream);
                printMemo();
                list.clear();
                fileScanner.close();
            } else if (parsedInput == 3) {
                System.out.println("Successfully exited.");
                break;
            } else {
                System.out.println("Wrong input.");
                continue;
            }
        }
        scanner.close();
    }

    public static boolean isInputValid() {
        try {
            parsedInput = Integer.parseInt(input);
            return true;
        } catch (Exception e) {
            System.out.println("Wrong input.");
            return false;
        }
    }

    public static boolean createMemo(String name) {
        try {
            writer = new FileWriter("src/" + name + ".txt");
            return true;
        } catch (IOException e) {
            System.out.println("Failed to create a memo.");
            return false;
        }
    }

    public static void writeMemo() {
        while (true) {
            String newInput = scanner.nextLine();
            if (newInput.equals("q")) {
                closeMemo();
                if (retrieveMemo("memos")) {
                    saveMemoTitle();
                }
                break;
            }
            if (!writeTextDown(newInput)) {
                break;
            }
        }

    }

    public static void saveMemoTitle() {
        fileScanner = new Scanner(stream);
        makeList();
        if (!list.contains(newMemoName)) {
            list.add(newMemoName);
            Collections.sort(list);
            createMemo("memos");
            for (String name : list) {
                if (!writeTextDown(name)) {
                    break;
                }
            }
            closeMemo();
        }

    }

    public static boolean writeTextDown(String text) {
        try {
            writer.write(text + "\n");
            return true;
        } catch (IOException e) {
            System.out.println("Failed to write a memo.");
            return false;
        }
    }

    public static boolean closeMemo() {
        try {
            writer.close();
            return true;
        } catch (IOException e) {
            System.out.println("Failed to close the memo.");
            return false;
        }
    }

    public static boolean retrieveMemo(String name) {
        try {
            stream = new FileInputStream("src/" + name + ".txt");
            return true;
        } catch (FileNotFoundException e) {
            System.out.println("File doesn't exist.");
            return false;
        }
    }

    public static void printMemo() {
        System.out.println("\n");
        while (fileScanner.hasNextLine()) {
            String line = fileScanner.nextLine();
            System.out.println(line);
        }
        System.out.println("\n");
    }

    public static void makeList() {
        while (fileScanner.hasNextLine()) {
            list.add(fileScanner.nextLine());
        }
    }
}
