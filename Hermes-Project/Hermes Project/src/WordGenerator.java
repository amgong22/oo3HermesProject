import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;

public class WordGenerator {
    private List<String> words;

    public WordGenerator() {
        try {
            Path path = Paths.get("wordslist.txt");
            words = Files.readAllLines(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Word generateWord() {
        if (words == null || words.isEmpty()) {
            return null;
        }
        Random rand = new Random();
        int x = rand.nextInt(600);
        int y = 0;
        int speed = rand.nextInt(5) + 1;
        String text = words.get(rand.nextInt(words.size()));
        return new Word(text, x, y, speed);
    }
}
