import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class keyHandler implements KeyListener {

    GUI gui;

    public keyHandler(GUI gui) {
        this.gui = gui;
    }
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        // Save file
        if (e.isControlDown() && e.getKeyCode() == KeyEvent.VK_S) {
            gui.file.savefile();
        }

        // New File
        if (e.isControlDown() && e.getKeyCode() == KeyEvent.VK_N) {
            gui.file.newfile();
        }

        // Open File
        if (e.isControlDown() && e.getKeyCode() == KeyEvent.VK_O) {
            gui.file.openfile();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
