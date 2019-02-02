package Lesson_4;

import java.awt.*;
import java.awt.event.*;
import java.security.Key;
import javax.swing.*;

public class Gui extends JFrame {

    private JList<String> list;
    private DefaultListModel<String> modelList;
    private JButton button;
    private JTextField textField;

    public Gui() {
        setTitle("GeekChat");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(300, 300, 400, 400);

        JPanel grid2 = new JPanel(new GridLayout(1,0,1,1));
        modelList = new DefaultListModel<String>();
        list = new JList<>(modelList);
        grid2.add(list)  ;


        JPanel grid = new JPanel(new GridLayout(2,0,1,1));
        // Альтернативный вариант размещения поля и копки
        //JPanel grid = new JPanel(new GridLayout(1,0,1,1));
        grid.add(textField = new JTextField());
        grid.add(button = new JButton("Send"));

        button.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modelList.add(modelList.size(), textField.getText());
            }
        });

        textField.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    modelList.add(modelList.size(), textField.getText());
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    modelList.add(modelList.size(), textField.getText());
                }

               }

            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    modelList.add(modelList.size(), textField.getText());
                }
            }

        });

        setLayout(new BorderLayout());

        add(grid2, BorderLayout.CENTER);
        add(grid, BorderLayout.SOUTH);
        setVisible(true);

    }

}

