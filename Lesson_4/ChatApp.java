package Lesson_4;

import java.awt.event.KeyEvent;

public class ChatApp {

    public static void main(String[] args) {

        new Gui();
    }

    public void keyReleased(KeyEvent event) {
        if (event.getKeyCode() == KeyEvent.VK_ENTER) {
            // тело метода
        }
    }
}
