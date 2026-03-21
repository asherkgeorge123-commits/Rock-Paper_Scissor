import javax.swing.*;
/**
 * This class launches the game by creating and displaying the {@link LauncherFrame}.
 */
public class Main {
    /**
     * The main method that starts the application.
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        // Launch GUI on the Event Dispatch Thread (EDT) ------>Didn't know that, got help from internet
        SwingUtilities.invokeLater(() -> {
            new LauncherFrame().setVisible(true);
        });
    }
}
