import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import my.flashcard.b210910042.Card;
import my.flashcard.b210910042.WorstFirstSorter;

class WorstFirstSorterTest {

    @Test
    void testWorstFirstSort() {
        Card c1 = new Card("Q1", Arrays.asList("A", "B", "C", "D"), 0);
        Card c2 = new Card("Q2", Arrays.asList("A", "B", "C", "D"), 1);
        c1.wrong();
        c1.wrong(); 
        c2.wrong(); 

        List<Card> cards = Arrays.asList(c1, c2);
        List<Card> sorted = new WorstFirstSorter().organize(cards);

        assertEquals("Q1", sorted.get(0).getQuestion());
    }
}