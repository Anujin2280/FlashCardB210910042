package my.flashcard.b210910042;

import java.util.List;

public class Card {
    private String question;
    private List<String> choices;
    private int correctIndex;
    private int mistakes;
    private int correctStreak;

    public Card(String question, List<String> choices, int correctIndex) {
        this.question = question;
        this.choices = choices;
        this.correctIndex = correctIndex;
        this.mistakes = 0;
        this.correctStreak = 0;
    }

    public String getQuestion() { return question; }
    public List<String> getChoices() { return choices; }
    public int getCorrectIndex() { return correctIndex; }
    public int getMistakes() { return mistakes; }
    public int getCorrectStreak() { return correctStreak; }

    public void correct() { correctStreak++; }
    public void wrong() {
        mistakes++;
        correctStreak = 0;
    }
}