import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import my.flashcard.b210910042.Card;
import my.flashcard.b210910042.RandomSorter;

class RandomSorterTest {

    @Test
    void testRandomSort() {
        List<Card> cards = Arrays.asList(
                new Card("Q1", Arrays.asList("A", "B", "C", "D"), 0),
                new Card("Q2", Arrays.asList("A", "B", "C", "D"), 1),
                new Card("Q3", Arrays.asList("A", "B", "C", "D"), 2)
        );

        List<Card> shuffled = new RandomSorter().organize(cards);
        assertEquals(3, shuffled.size());
    }
}

