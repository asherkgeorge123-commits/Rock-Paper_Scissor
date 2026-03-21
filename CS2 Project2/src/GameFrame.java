import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The GameFrame class creates the GUI for the Rock-Paper-Scissors game.
 * It handles displaying the game interface, user interactions, and game animations.
 */
public class GameFrame extends JFrame implements ActionListener {
    private JLabel computerChoiceLabel, playerChoiceLabel;
    private JLabel computerScoreLabel, playerScoreLabel;
    private final GameLogic rockPaperScissor;
    private final ImageIcon rockIcon;
    private final ImageIcon paperIcon;
    private final ImageIcon scissorsIcon;
    private final ImageIcon[] icons;
    private JButton rockButton, paperButton, scissorsButton;

    /**
     * Constructs the game frame and initializes the GUI components.
     */
    public GameFrame() {
        super("Rock Paper Scissors");
        setSize(450, 600);
        setLayout(null);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.BLACK);
        rockPaperScissor = new GameLogic();

        rockIcon = scaleIcon(new ImageIcon("Stone.jpg"), 80, 80);
        paperIcon = scaleIcon(new ImageIcon("Paper.png"), 80, 80);
        scissorsIcon = scaleIcon(new ImageIcon("Scissor.png"), 80, 80);
        icons = new ImageIcon[]{rockIcon, paperIcon, scissorsIcon};

        setupComponents();
    }

    /**
     * Initializes and adds components to the frame.
     */
    private void setupComponents() {
        computerScoreLabel = new JLabel("Computer: 0");
        computerScoreLabel.setBounds(0, 20, 450, 30);
        computerScoreLabel.setFont(new Font("Dialog", Font.BOLD, 26));
        computerScoreLabel.setHorizontalAlignment(SwingConstants.CENTER);
        computerScoreLabel.setForeground(Color.WHITE);
        add(computerScoreLabel);

        computerChoiceLabel = new JLabel();
        computerChoiceLabel.setBounds(175, 70, 100, 100);
        computerChoiceLabel.setHorizontalAlignment(SwingConstants.CENTER);
        computerChoiceLabel.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        computerChoiceLabel.setForeground(Color.WHITE);
        add(computerChoiceLabel);

        playerScoreLabel = new JLabel("Player: 0");
        playerScoreLabel.setBounds(0, 200, 450, 30);
        playerScoreLabel.setFont(new Font("Dialog", Font.BOLD, 26));
        playerScoreLabel.setHorizontalAlignment(SwingConstants.CENTER);
        playerScoreLabel.setForeground(Color.WHITE);
        add(playerScoreLabel);

        playerChoiceLabel = new JLabel();
        playerChoiceLabel.setBounds(175, 250, 100, 100);
        playerChoiceLabel.setHorizontalAlignment(SwingConstants.CENTER);
        playerChoiceLabel.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        playerScoreLabel.setForeground(Color.WHITE);
        add(playerChoiceLabel);

        rockButton = createIconButton(rockIcon, "Rock", 40);
        paperButton = createIconButton(paperIcon, "Paper", 165);
        scissorsButton = createIconButton(scissorsIcon, "Scissors", 290);

        add(rockButton);
        add(paperButton);
        add(scissorsButton);
    }

    /**
     * Creates a JButton with the specified icon and position.
     * @param icon the image icon to display
     * @param name the tooltip text for the button
     * @param x    the x position of the button
     * @return the created JButton
     */
    private JButton createIconButton(ImageIcon icon, String name, int x) {// Used Internet for applying icons
        JButton button = new JButton(icon);
        button.setBounds(x, 400, 105, 105);
        button.setToolTipText(name);
        button.addActionListener(this);
        return button;
    }

    /**
     * Scales the provided icon to the given width and height.
     * @param icon the original icon
     * @param w    the desired width
     * @param h    the desired height
     * @return the scaled ImageIcon
     */
    private ImageIcon scaleIcon(ImageIcon icon, int w, int h) {
        Image img = icon.getImage().getScaledInstance(w, h, Image.SCALE_SMOOTH);
        return new ImageIcon(img);
    }

    /**
     * Handles button click events.
     * @param e the action event triggered by a button click
     */
    @Override
    public void actionPerformed(ActionEvent e) { //got help from my friend
        String playerChoice = ((JButton) e.getSource()).getToolTipText();

        // Disable buttons during animation
        setButtonsEnabled(false);

        updateChoiceLabel(playerChoiceLabel, playerChoice);

        // Start animation, then reveal computer's real choice and show result
        animateComputerChoice(() -> {
            String result = rockPaperScissor.playRockPaperScissor(playerChoice);

            updateChoiceLabel(computerChoiceLabel, rockPaperScissor.getComputerChoice());

            playerScoreLabel.setText("Player: " + rockPaperScissor.getPlayerScore());
            computerScoreLabel.setText("Computer: " + rockPaperScissor.getComputerScore());

            showDialog(result);

            // Re-enable buttons
            setButtonsEnabled(true);
        });
    }

    /**
     * Enables or disables the rock, paper, and scissors buttons.
     * @param enabled true to enable, false to disable
     */
    private void setButtonsEnabled(boolean enabled) {
        rockButton.setEnabled(enabled);
        paperButton.setEnabled(enabled);
        scissorsButton.setEnabled(enabled);
    }

    /**
     * Updates the icon of the given label based on the choice.
     * @param label  the label to update
     * @param choice the player's or computer's choice
     */
    private void updateChoiceLabel(JLabel label, String choice) {
        switch (choice) {
            case "Rock" -> label.setIcon(rockIcon);
            case "Paper" -> label.setIcon(paperIcon);
            case "Scissors" -> label.setIcon(scissorsIcon);
        }
        label.setText("");
    }

    /**
     * Animates the computer's choice by cycling through icons before showing the result.
     * @param afterAnimation the action to perform after animation ends
     */
    private void animateComputerChoice(Runnable afterAnimation) {//got help from AI
        Timer timer = new Timer(100, null);
        final int[] count = {0};

        timer.addActionListener(e -> {
            computerChoiceLabel.setIcon(icons[count[0] % icons.length]);
            computerChoiceLabel.setText("");
            count[0]++;
            if (count[0] > 20) {
                timer.stop();
                afterAnimation.run();
            }
        });

        timer.start();
    }

    /**
     * Displays a dialog box with the result after a short delay.
     * @param message the message to display
     */
    private void showDialog(String message) {
        Timer timer = new Timer(750, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(GameFrame.this, message);
            }
        });
        timer.setRepeats(false);
        timer.start();
    }
}
