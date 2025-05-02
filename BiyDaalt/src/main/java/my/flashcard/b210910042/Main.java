package my.flashcard.b210910042;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        if (args.length == 0 || args[0].equals("--help")) {
            printHelp();
            return;
        }

        String fileName = args[0];
        String order = "random";
        int repetitions = 1;
        boolean invertCards = false;

        for (int i = 1; i < args.length; i++) {
            switch (args[i]) {
                case "--order":
                    order = args[++i];
                    break;
                case "--repetitions":
                    repetitions = Integer.parseInt(args[++i]);
                    break;
                case "--invertCards":
                    invertCards = true;
                    break;
                case "--help":
                    printHelp();
                    return;
                default:
                    System.out.println("Танигдаагүй сонголт: " + args[i]);
                    printHelp();
                    return;
            }
        }

        try {
            List<Card> cards = CardLoader.loadCards(fileName);
            CardOrganizer organizer;

            switch (order) {
                case "random":
                    organizer = new RandomSorter();
                    break;
                case "worst-first":
                    organizer = new WorstFirstSorter();
                    break;
                case "recent-mistakes-first":
                    organizer = new RecentMistakesFirstSorter();
                    break;
                default:
                    System.out.println("Танигдаагүй order төрөл: " + order);
                    return;
            }

            FlashCard flashCard = new FlashCard(cards, organizer, invertCards, repetitions);
            flashCard.play();
        } catch (Exception e) {
            System.out.println("Алдаа гарлаа: " + e.getMessage());
        }
    }

    private static void printHelp() {
        System.out.println("flashcard <cards-file> [options]");
        System.out.println("Options:");
        System.out.println("  --help                   Тусламжийн мэдээлэл харуулах");
        System.out.println("  --order <order>          Зохион байгуулалтын төрөл (random, worst-first, recent-mistakes-first)");
        System.out.println("  --repetitions <num>      Нэг картыг хэдэн удаа зөв хариулахыг шаардлагатай");
        System.out.println("  --invertCards            Асуулт, хариултыг сольж асуух");
    }
}