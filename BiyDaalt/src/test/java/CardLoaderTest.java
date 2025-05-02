import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import my.flashcard.b210910042.Card;
import my.flashcard.b210910042.CardLoader;

class CardLoaderTest {

    @Test
    void testLoadCardsValidFile() throws IOException {
        String testFile = "test_cards.txt";
        try (java.io.FileWriter writer = new java.io.FileWriter(testFile)) {
            writer.write("What is 2 + 2?;3;4;5;6;2\n");
            writer.write("What is 3 + 3?;5;6;7;8;2\n");
        }

        List<Card> cards = CardLoader.loadCards(testFile);

        assertEquals(2, cards.size());
        assertEquals("What is 2 + 2?", cards.get(0).getQuestion());
        assertEquals("What is 3 + 3?", cards.get(1).getQuestion());
    }
}