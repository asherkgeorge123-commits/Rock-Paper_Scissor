import javax.swing.*;
import java.awt.*;

/**
 * Instruction frame that displays the game instructions in a scrollable text area.
 * The instructions explain how to play the Rock-Paper-Scissors game.
 */
public class Instruction extends JFrame {

    /**
     * Constructs the Instruction frame, setting size, layout, and adding the instruction text area.
     */
    public Instruction() {
        super();
        setSize(500, 400);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        getContentPane().setBackground(Color.BLACK);

        JTextArea instArea = new JTextArea(inst());
        instArea.setEditable(false);
        instArea.setLineWrap(true);
        instArea.setWrapStyleWord(true);
        instArea.setMargin(new Insets(10, 10, 10, 10));
        add(instArea, BorderLayout.CENTER);

        setVisible(true);
    }

    /**
     * Returns the instructions string describing how to play the game.
     * @return the multiline instructions text
     */
    private String inst() {
        return "1. This game is played between you and the computer.\n\n" +
                "2. Choose one of the three options by clicking a button or icon: Rock, Paper, or Scissors.\n\n" +
                "3. The computer will also select Rock, Paper, or Scissors randomly.\n\n" +
                "4. The winner is decided by these rules:\n\n" +
                "* Rock beats Scissors\n" +
                "* Scissors beats Paper\n" +
                "* Paper beats Rock\n" +
                "* If both choose the same, it is a draw.\n\n" +
                "5. Each time you win, you get one point. The computer gets a point when it wins.\n\n" +
                "6. Try to score more points than the computer!\n\n" +
                "Good luck!";
    }
}
