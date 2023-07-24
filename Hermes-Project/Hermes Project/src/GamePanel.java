import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GamePanel extends JPanel implements KeyListener {
    private WordGenerator wordGenerator;
    private Word currentWord;
    private StringBuilder typedWord = new StringBuilder();
    private JLabel scoreLabel;
    private JLabel typedWordLabel;
    private int score = 0;
    private boolean gameRunning = true;

    public GamePanel(WordGenerator wordGenerator) {
        this.wordGenerator = wordGenerator;
        this.currentWord = this.wordGenerator.generateWord();

        this.scoreLabel = new JLabel("Score: 0");
        this.typedWordLabel = new JLabel("Typed: ");
        add(scoreLabel);
        add(typedWordLabel);

        setFocusable(true);
        addKeyListener(this);
    }

    public int getScore() {
        return score;
    }

    public boolean isGameRunning() {
        return gameRunning;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawString(currentWord.getText(), currentWord.getX(), currentWord.getY());
    }

    public void update() {
        currentWord.move();
        if (currentWord.getY() > getHeight()) {
            gameRunning = false;
        }
        scoreLabel.setText("Score: " + score);
        typedWordLabel.setText("Typed: " + typedWord.toString());
        repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {
        if(e.getKeyChar() == '\b' && typedWord.length() > 0) {
            typedWord.deleteCharAt(typedWord.length() - 1);
        } else {
            typedWord.append(e.getKeyChar());
            if (typedWord.toString().equals(currentWord.getText())) {
                currentWord = wordGenerator.generateWord();
                typedWord = new StringBuilder();
                score++;
            }
        }
    }

    @Override
    public void keyPressed(KeyEvent e) { }

    @Override
    public void keyReleased(KeyEvent e) { }
}
