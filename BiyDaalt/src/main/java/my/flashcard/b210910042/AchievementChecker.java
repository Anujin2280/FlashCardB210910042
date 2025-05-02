package my.flashcard.b210910042;

import java.util.List;

public class AchievementChecker {

    public static boolean checkCorrect(List<Card> cards) {
        return cards.stream().allMatch(card -> card.getCorrectStreak() >= 3);
    }

    public static boolean checkRepeat(Card card) {
        return card.getMistakes() >= 5;
    }

    public static boolean checkConfident(Card card) {
        return card.getCorrectStreak() >= 3;
    }
}
