package pl.edu.agh.hangman;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

/**
 * 1. readFile(<file.txt> from resource) - return collection of strings in uppercases
 * 2. drawWord(collection) - return single word as string in uppercase
 */
public class WordLoader {

    public List<String> readFile(String fileName) throws IOException {
        FileInputStream inputStream = null;
        List<String> words = new ArrayList<>();
        try {
            ClassLoader classLoader = this.getClass().getClassLoader();
            File configFile = new File(Objects.requireNonNull(classLoader.getResource(fileName)).getFile());

            inputStream = new FileInputStream(configFile);
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            while ((line = reader.readLine()) != null) {
                words.add(line);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            assert inputStream != null;
            inputStream.close();
        }
        words = words.stream().map(String::toUpperCase).collect(Collectors.toList());
        return words;
    }

    public List<String> filterWordsByLength(List<String> words, Integer length) {
        words = words.stream().filter(word -> word.length() == length).collect(Collectors.toList());
        return words;
    }

    public String drawWord(List<String> words) {
        Random rand = new Random();
        int n = rand.nextInt(words.size() - 1);
        return words.get(n);
    }

    public String userGivenWord() {
        System.out.println("Enter your word: ");
        Scanner sc = new Scanner(System.in);
        String word = sc.nextLine();
        return word.toUpperCase();
    }
}
