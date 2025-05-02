package my.flashcard.b210910042;

import java.util.List;
import java.util.stream.Collectors;

public class RecentMistakesFirstSorter implements CardOrganizer {
    @Override
    public List<Card> organize(List<Card> cards) {
        List<Card> mistakenCards = cards.stream()
                .filter(card -> card.getMistakes() > 0)
                .collect(Collectors.toList());
        return mistakenCards.isEmpty() ? cards : mistakenCards;
    }
}