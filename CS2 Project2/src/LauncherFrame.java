import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The LauncherFrame class creates the main launcher window for the Rock-Paper-Scissors game.
 * It displays the title and provides buttons to start the game or view instructions.
 */
public class LauncherFrame extends JFrame {

    /**
     * Constructs the launcher frame, setting up its size, layout, and components.
     * The frame includes a title label, an instruction button, and a start game button.
     */
    public LauncherFrame() {
        super();

        setSize(1000, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JLabel title = new JLabel("Welcome to Rock-Paper-Scissors!", SwingConstants.CENTER);
        title.setFont(new Font("Ghibli", Font.BOLD, 30));
        title.setForeground(Color.WHITE);
        add(title, BorderLayout.CENTER);

        JButton instruction = new JButton("INSTRUCTION");
        instruction.setFont(new Font("Dialog", Font.BOLD, 14));
        instruction.addActionListener(e -> {
            Instruction inst = new Instruction();
            inst.setVisible(true);
        });

        JButton startButton = new JButton("START GAME");
        startButton.setFont(new Font("Dialog", Font.BOLD, 14));
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GameFrame game = new GameFrame();
                game.setVisible(true);
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(startButton);
        add(buttonPanel, BorderLayout.SOUTH);
        buttonPanel.add(instruction);
        getContentPane().setBackground(Color.BLACK);

        setVisible(true);
    }

}
