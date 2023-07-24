import javax.swing.*;

public class TypeCraft {
    public static void main(String[] args) {
        JFrame frame = new JFrame("TypeCraft");
        WordGenerator wordGenerator = new WordGenerator();
        GamePanel gamePanel = new GamePanel(wordGenerator);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.add(gamePanel);
        frame.setVisible(true);

        while (gamePanel.isGameRunning()) {
            gamePanel.update();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Show game over message
        JOptionPane.showMessageDialog(frame, "Game Over! Your score is: " + gamePanel.getScore());
        frame.dispose();  // Close the game window
    }
}
