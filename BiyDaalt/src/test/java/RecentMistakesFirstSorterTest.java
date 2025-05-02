import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import my.flashcard.b210910042.Card;
import my.flashcard.b210910042.RecentMistakesFirstSorter;

class RecentMistakesFirstSorterTest {

    @Test
    void testOrganizeWithMistakes() {
        Card card1 = new Card("What is 2 + 2?", Arrays.asList("3", "4", "5", "6"), 1);
        Card card2 = new Card("What is 3 + 3?", Arrays.asList("5", "6", "7", "8"), 1);
        card1.wrong(); 
        card2.correct();

        List<Card> cards = Arrays.asList(card1, card2);
        List<Card> sortedCards = new RecentMistakesFirstSorter().organize(cards);

        assertTrue(sortedCards.size() > 0, "Тестэд карт байна");

        if (sortedCards.size() > 0) {
            assertEquals(card1, sortedCards.get(0)); 
        }
    }

    @Test
    void testOrganizeWithoutMistakes() {
        Card card1 = new Card("What is 2 + 2?", Arrays.asList("3", "4", "5", "6"), 1);
        Card card2 = new Card("What is 3 + 3?", Arrays.asList("5", "6", "7", "8"), 1);
        card1.correct();
        card2.correct(); 

        List<Card> cards = Arrays.asList(card1, card2);
        List<Card> sortedCards = new RecentMistakesFirstSorter().organize(cards);

        assertTrue(sortedCards.size() > 0, "Тестэд карт байна");

        if (sortedCards.size() > 0) {
            assertEquals(card1, sortedCards.get(0));
            assertEquals(card2, sortedCards.get(1));
        }
    }

    @Test
    void testOrganizeWithEmptyMistakes() {
        Card card1 = new Card("What is 5 + 5?", Arrays.asList("10", "11", "12", "13"), 0);
        Card card2 = new Card("What is 6 + 6?", Arrays.asList("11", "12", "13", "14"), 1);
        card1.correct();
        card2.correct();

        List<Card> cards = Arrays.asList(card1, card2);
        List<Card> sortedCards = new RecentMistakesFirstSorter().organize(cards);

        assertTrue(sortedCards.size() > 0, "Тестэд карт байна");

        if (sortedCards.size() > 0) {
            assertEquals(card1, sortedCards.get(0)); 
            assertEquals(card2, sortedCards.get(1)); 
        }
    }

    @Test
    void testOrganizeWithAllMistakes() {
        Card card1 = new Card("What is 2 + 2?", Arrays.asList("3", "4", "5", "6"), 1);
        Card card2 = new Card("What is 3 + 3?", Arrays.asList("5", "6", "7", "8"), 1);
        card1.wrong();
        card2.wrong();

        List<Card> cards = Arrays.asList(card1, card2);
        List<Card> sortedCards = new RecentMistakesFirstSorter().organize(cards);

        assertTrue(sortedCards.size() > 0, "Тестэд карт байна");

        if (sortedCards.size() > 0) {
            assertEquals(card1, sortedCards.get(0));
            assertEquals(card2, sortedCards.get(1));
        }
    }
}