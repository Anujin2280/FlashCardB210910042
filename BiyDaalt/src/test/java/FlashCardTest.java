import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import my.flashcard.b210910042.Card;
import my.flashcard.b210910042.CardOrganizer;
import my.flashcard.b210910042.FlashCard;

class FlashCardTest {

    @Test
    void testPlay() {
        List<Card> cards = Arrays.asList(
                new Card("What is 2 + 2?", Arrays.asList("3", "4", "5", "6"), 1),
                new Card("What is 3 + 3?", Arrays.asList("5", "6", "7", "8"), 1)
        );

        CardOrganizer organizer = mock(CardOrganizer.class);
        when(organizer.organize(anyList())).thenReturn(cards);

        String simulatedInput = "2\n2\n";
        InputStream in = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(in);

        FlashCard flashCard = new FlashCard(cards, organizer, false, 1);

        flashCard.play();

    }

    @Test
    void testPlayIncorrectAnswer() {
        List<Card> cards = Arrays.asList(
                new Card("What is 2 + 2?", Arrays.asList("3", "4", "5", "6"), 1),
                new Card("What is 3 + 3?", Arrays.asList("5", "6", "7", "8"), 1)
        );

        CardOrganizer organizer = mock(CardOrganizer.class);
        when(organizer.organize(anyList())).thenReturn(cards);

        String simulatedInput = "3\n3\n"; 
        InputStream in = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(in);

        FlashCard flashCard = new FlashCard(cards, organizer, false, 1);

        flashCard.play();

    }
    
    @Test
    void testPlayEmptyCards() {
        List<Card> cards = Arrays.asList(); 

        CardOrganizer organizer = mock(CardOrganizer.class);
        when(organizer.organize(anyList())).thenReturn(cards);

        String simulatedInput = "2\n2\n";  
        InputStream in = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(in);

        FlashCard flashCard = new FlashCard(cards, organizer, false, 1);

        flashCard.play();

    }

}