package my.flashcard.b210910042;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class FlashCard {
    private List<Card> cards;
    private CardOrganizer organizer;
    private boolean invertCards;
    private int repetitions;

    public FlashCard(List<Card> cards, CardOrganizer organizer, boolean invertCards, int repetitions) {
        this.cards = cards;
        this.organizer = organizer;
        this.invertCards = invertCards;
        this.repetitions = repetitions;
    }

    public void play() {
        Scanner scanner = new Scanner(System.in);

        for (int round = 1; round <= repetitions; round++) {
            System.out.println("\n=== Давталт " + round + " ===");

            List<Card> organizedCards;
            if (round == 1 || !(organizer instanceof RecentMistakesFirstSorter)) {
                organizedCards = organizer.organize(cards);
            } else {
                List<Card> mistakeCards = cards.stream()
                        .filter(card -> card.getMistakes() > 0)
                        .collect(Collectors.toList());
                List<Card> correctCards = cards.stream()
                        .filter(card -> card.getMistakes() == 0)
                        .collect(Collectors.toList());
                mistakeCards.addAll(correctCards);
                organizedCards = mistakeCards;
            }

            if (organizedCards.isEmpty()) {
                System.out.println("Карт олдсонгүй.");
                continue;
            }

            for (Card card : organizedCards) {
                List<String> choices;
                String question;
                int correctIndex;

                if (invertCards) {
                    // Асуултыг хариулт болгоно, зөв хариултаар уг асуултыг таалгана
                    question = card.getChoices().get(card.getCorrectIndex()) + " гэж ямар асуултад хамаарах вэ?";
                    choices = new ArrayList<>(card.getChoices()); // card.getQuestion() оруулаагүй!
                    choices.set(card.getCorrectIndex(), card.getQuestion()); // зөв хариулт - асуулт
                    correctIndex = card.getCorrectIndex(); // зөвийн индекс хэвээр
                } else {
                    question = card.getQuestion();
                    choices = card.getChoices();
                    correctIndex = card.getCorrectIndex();
                }

                System.out.println(question);
                for (int i = 0; i < choices.size(); i++) {
                    System.out.println((i + 1) + ": " + choices.get(i));
                }

                int userChoice = -1;
                while (true) {
                    try {
                        System.out.print("Сонголтоо оруулна уу (1-4): ");
                        userChoice = Integer.parseInt(scanner.nextLine()) - 1;
                        if (userChoice >= 0 && userChoice < 4) {
                            break;
                        } else {
                            System.out.println("1-4 хооронд сонгоно уу!");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Зөвхөн тоо оруулна уу!");
                    }
                }

                if (userChoice == correctIndex) {
                    System.out.println("Зөв!");
                    card.correct();
                } else {
                    System.out.println("Буруу! Зөв хариулт: " + choices.get(correctIndex));
                    card.wrong();
                }
            }
        }

        System.out.println("\n=== Амжилтууд ===");
        for (Card card : cards) {
            if (AchievementChecker.checkRepeat(card)) {
                System.out.println("REPEAT: " + card.getQuestion());
            }
            if (AchievementChecker.checkConfident(card)) {
                System.out.println("CONFIDENT: " + card.getQuestion());
            }
        }
        if (AchievementChecker.checkCorrect(cards)) {
            System.out.println("CORRECT: Бүх картыг зөв хариулсан!");
        }
    }
}