import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.*;

public class Main {
    public static void main(String[] args) {
        Consumer.run();
    }
}

class Consumer {
    public static void run() {
        writeScoreTableOnConsole("score.txt");
        consumeScoresAndWriteAllOnConsole("score.txt");
    }

    private static void consumeScoresAndWriteAllOnConsole(String filename) {
        final Path path = FileSystems.getDefault().getPath(System.getProperty("user.dir"));

        try (final WatchService watchService = FileSystems.getDefault().newWatchService()) {
            final WatchKey watchKey = path.register(watchService, StandardWatchEventKinds.ENTRY_MODIFY);
            while (true) {
                final WatchKey wk = watchService.take();
                for (WatchEvent<?> event : wk.pollEvents()) {
                    //we only register "ENTRY_MODIFY" so the context is always a Path.
                    final Path changed = (Path) event.context();
                    System.out.println("*************** Scores ***************");
                    if (changed.endsWith(filename)) {
                        writeScoreTableOnConsole(filename);
                    }
                }
                // reset the key
                boolean valid = wk.reset();
                if (!valid) {
                    System.out.println("Key has been unregisterede");
                }
            }
        } catch (Throwable e) {
            // Log or rethrow the error
        }
    }

    private static void writeScoreTableOnConsole(String fileName) {

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {

            String s;
            while ((s = br.readLine()) != null) {
                System.out.println(s);
            }

        } catch (Exception e) {
            System.out.println(e);
        }

    }
}
