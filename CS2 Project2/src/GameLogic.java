
import java.util.Random;

/**
 * The GameLogic class handles the backend logic of the Rock-Paper-Scissors game.
 * It manages the computer's random choices, keeps track of scores, and determines the outcome of each round.
 */
class GameLogic {
    private static final String[] computerChoices = {"Rock", "Paper", "Scissors"};
    private String computerChoice;
    private int computerScore, playerScore;
    private Random random;

    /**
     * Constructs a new GameLogic instance with an initialized random number generator.
     */
    public GameLogic() {
        random = new Random();
    }

    /**
     * Returns the computer's current choice.
     * @return the computer's choice as a String ("Rock", "Paper", or "Scissors")
     */
    public String getComputerChoice() {
        return computerChoice;
    }

    /**
     * Returns the current score of the computer.
     * @return the computer's score as an integer
     */
    public int getComputerScore() {
        return computerScore;
    }

    /**
     * Returns the current score of the player.
     * @return the player's score as an integer
     */
    public int getPlayerScore() {
        return playerScore;
    }

    /**
     * Simulates a round of Rock-Paper-Scissors with the player's choice randomly generating the computer's choice, updating scores, and returning the result message.
     * @param playerChoice the player's choice ("Rock", "Paper", or "Scissors")
     * @return a detailed String message showing both choices and the round's result
     */
    public String playRockPaperScissor(String playerChoice) {
        computerChoice = computerChoices[random.nextInt(computerChoices.length)];
        String result;

        if (computerChoice.equals("Rock")) {
            if (playerChoice.equals("Paper")) {
                result = """
                        Player chose paper!
                        Computer chose rock!
                        Player Wins!!!""";
                playerScore++;
            } else if (playerChoice.equals("Scissors")) {
                result = """
                        Player chose scissors!
                        Computer chose rock
                        Computer Wins""";
                computerScore++;
            } else {
                result = "Draw";
            }
        } else if (computerChoice.equals("Paper")) {
            if (playerChoice.equals("Scissors")) {
                result =  """
                        Player chose scissors!
                        Computer chose paper!
                        Player Wins!!!""";
                playerScore++;
            } else if (playerChoice.equals("Rock")) {
                result = """
                        Player chose rock!
                        Computer chose paper!
                        Computer Wins!!!""";
                computerScore++;
            } else {
                result = "Draw";
            }
        } else {
            if (playerChoice.equals("Rock")) {
                result =  """
                        Player chose rock!
                        Computer chose scissors!
                        Player Wins!!!""";
                playerScore++;
            } else if (playerChoice.equals("Paper")) {
                result =  """
                        Player chose paper!
                        Computer chose scissors!
                        Computer Wins!!!""";
                computerScore++;
            } else {
                result = "Draw";
            }
        }
        return result;
    }
}



