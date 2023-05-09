import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;

public class Game extends Canvas implements Runnable {
    private boolean running;
    public static int WIDTH = 700;
    public static int HEIGHT = 500;
    public static String NAME = "GAME";

    public static void main(String[] args) {
        Game game = new Game();
        game.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        JFrame frame = new JFrame(Game.NAME);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(game);
        frame.pack();
        frame.setVisible(true);
        game.start();
    }

    @Override
    public void run() {
        while (running) {
            render();
        }
    }

    public void start() {
        running = true;
        new Thread(this).start();
    }

    public void render() {
        BufferStrategy bs = getBufferStrategy();
        if (bs == null) {
            createBufferStrategy(2);
            requestFocus();
            return;
        }
        Graphics g = bs.getDrawGraphics();
        g.setColor(Color.black);
        g.fillRect(0, 0, getWidth(), getHeight());
        g.dispose();
        bs.show();
    }
}
