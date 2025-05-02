package my.flashcard.b210910042;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CardLoader {
    public static List<Card> loadCards(String filename) throws IOException {
        List<Card> cards = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length == 6) {
                    String question = parts[0];
                    List<String> choices = Arrays.asList(parts[1], parts[2], parts[3], parts[4]);
                    int correctIndex = Integer.parseInt(parts[5]) - 1; 
                    cards.add(new Card(question, choices, correctIndex));
                }
            }
        }
        return cards;
    }
}