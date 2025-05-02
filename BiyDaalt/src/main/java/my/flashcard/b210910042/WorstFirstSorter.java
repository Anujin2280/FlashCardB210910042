package my.flashcard.b210910042;

import java.util.Comparator;
import java.util.List;

public class WorstFirstSorter implements CardOrganizer {
    @Override
    public List<Card> organize(List<Card> cards) {
        cards.sort(Comparator.comparingInt(Card::getMistakes).reversed());
        return cards;
    }
}
