import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import my.flashcard.b210910042.AchievementChecker;
import my.flashcard.b210910042.Card;

class AchievementCheckerTest {

    @Test
    void testCheckRepeat() {
        Card card = new Card("What is 2 + 2?", Arrays.asList("3", "4", "5", "6"), 1);
        for (int i = 0; i < 5; i++) {
            card.wrong();
        }

        assertTrue(AchievementChecker.checkRepeat(card));

        card.wrong();
        assertTrue(AchievementChecker.checkRepeat(card));
    }

    @Test
    void testCheckConfident() {
        Card card = new Card("What is 3 + 3?", Arrays.asList("5", "6", "7", "8"), 1);
        for (int i = 0; i < 3; i++) {
            card.correct();
        }

        assertTrue(AchievementChecker.checkConfident(card));

        card.correct();
        assertTrue(AchievementChecker.checkConfident(card));
    }

    // @Test
    // void testCheckCorrect() {
    //     Card card1 = new Card("What is 5 + 5?", Arrays.asList("10", "11", "12", "13"), 0);
    //     card1.correct();
    //     card1.correct(); 
    //     Card card2 = new Card("What is 6 + 6?", Arrays.asList("11", "12", "13", "14"), 1);
    //     card2.correct();
    //     card2.correct(); 

    //     List<Card> cards = Arrays.asList(card1, card2);

    //     //assertFalse(AchievementChecker.checkCorrect(cards)); // correct streak < 3

    //     card1.correct();
    //     card2.correct();

    //     assertTrue(AchievementChecker.checkCorrect(cards)); // correct streak >= 3
    // }
}

