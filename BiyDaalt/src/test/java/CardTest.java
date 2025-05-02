import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import my.flashcard.b210910042.Card;

class CardTest {

    @Test
    void testCardFields() {
        Card card = new Card("HTML гэж юу вэ?", Arrays.asList("Програмчлал", "Стандарт", "Протокол", "Төрөл"), 1);
        assertEquals("HTML гэж юу вэ?", card.getQuestion());
        assertEquals(4, card.getChoices().size());
        assertEquals(1, card.getCorrectIndex());
    }

    @Test
    void testCorrectAndWrong() {
        Card card = new Card("Test?", Arrays.asList("A", "B", "C", "D"), 2);
        card.correct();
        card.correct();
        assertEquals(2, card.getCorrectStreak());
        card.wrong();
        assertEquals(0, card.getCorrectStreak());
        assertEquals(1, card.getMistakes());
    }
}
