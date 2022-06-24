import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Producer.run();
    }
}

class Producer {
    public static void run() {
        readScoreOnConsole("score.txt");
    }

    private static void readScoreOnConsole(String filename) {
        Scanner scanner = new Scanner(System.in);

        for (; ; ) {
            String str = scanner.nextLine();
            //TODO: validation should be improved
            isValidScoreRecord(str);
            writeScoreInFile(filename, str.trim());

            if (str.equals("quit")) {
                break;
            }
        }

    }

    private static boolean isValidScoreRecord(String s){
        if (s.isEmpty() || s.isBlank())
            return false;
        else if(!s.contains("-"))
            return false;
        else
            return true;
    }

    private static void writeScoreInFile(String filename, String score) {
        try (BufferedWriter br = new BufferedWriter(new FileWriter(filename, true))) {
            br.write(score);
            br.newLine();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
