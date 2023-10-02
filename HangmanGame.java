import java.util.Scanner;

public class HangmanGame {
    private String wordToGuess;
    private StringBuilder currentGuess;
    private int attemptsLeft;
    private static final int MAX_ATTEMPTS = 6;

    public HangmanGame(String wordToGuess) {
        this.wordToGuess = wordToGuess.toUpperCase();
        this.currentGuess = new StringBuilder("_".repeat(wordToGuess.length()));
        this.attemptsLeft = MAX_ATTEMPTS;
    }

    public void play() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Hangman!");
        while (attemptsLeft > 0) {
            displayHangman();
            System.out.println("Current guess: " + currentGuess.toString());
            System.out.println("Attempts left: " + attemptsLeft);
            System.out.print("Guess a letter: ");
            String input = scanner.next().toUpperCase();
            char guessedLetter = input.charAt(0);

            if (input.length() != 1 || !Character.isLetter(guessedLetter)) {
                System.out.println("Please enter a valid letter.");
                continue;
            }

            if (wordToGuess.contains(String.valueOf(guessedLetter))) {
                updateCurrentGuess(guessedLetter);
                if (currentGuess.toString().equals(wordToGuess)) {
                    System.out.println("Congratulations! You've guessed the word: " + wordToGuess);
                    break;
                }
            } else {
                System.out.println("Incorrect guess. Try again.");
                attemptsLeft--;
            }
        }

        if (attemptsLeft == 0) {
            System.out.println("Sorry, you've run out of attempts. The word was: " + wordToGuess);
        }

        scanner.close();
    }

    private void displayHangman() {
        // Implement a graphical representation of the hangman here.
        // You can print ASCII art or use any other representation.
    }

    private void updateCurrentGuess(char guessedLetter) {
        for (int i = 0; i < wordToGuess.length(); i++) {
            if (wordToGuess.charAt(i) == guessedLetter) {
                currentGuess.setCharAt(i, guessedLetter);
            }
        }
    }

    public static void main(String[] args) {
        String[] words = { "JAVA", "PYTHON", "HTML", "CSS", "JAVASCRIPT" };
        String wordToGuess = words[(int) (Math.random() * words.length)];

        HangmanGame game = new HangmanGame(wordToGuess);
        game.play();
    }
}