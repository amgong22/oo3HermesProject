public class Word {
    private String text;
    private int x, y, speed;

    public Word(String text, int x, int y, int speed) {
        this.text = text;
        this.x = x;
        this.y = y;
        this.speed = speed;
    }

    // Getters
    public String getText() {
        return this.text;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public int getSpeed() {
        return this.speed;
    }

    // Setters
    public void setY(int y) {
        this.y = y;
    }

    public void move() {
        this.y += this.speed;
    }
}
