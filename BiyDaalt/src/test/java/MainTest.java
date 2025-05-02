import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import my.flashcard.b210910042.Card;
import my.flashcard.b210910042.CardOrganizer;
import my.flashcard.b210910042.Main;

class MainTest {

    @Test
    void testMain() {
        List<Card> cards = Arrays.asList(
                new Card("What is 2 + 2?", Arrays.asList("3", "4", "5", "6"), 1),
                new Card("What is 3 + 3?", Arrays.asList("5", "6", "7", "8"), 1)
        );

        CardOrganizer organizer = mock(CardOrganizer.class);
        when(organizer.organize(anyList())).thenReturn(cards);

        String simulatedInput = "2\n2\n"; 
        InputStream in = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(in);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);

        Main.main(new String[]{});

        // String output = outputStream.toString();
        // assertTrue(output.contains("Зөв!"));
        // assertTrue(output.contains("What is 2 + 2?"));
        // assertTrue(output.contains("What is 3 + 3?"));

        // Verify mock function is called
        // verify(organizer, times(1)).organize(anyList());
    }
}