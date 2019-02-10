package Lesson_6;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

public class GrUI extends JFrame implements MessageSender {

    private JTextField textField;
    private JButton button;
    private JScrollPane scrollPane;
    private JList<Message> list;
    private DefaultListModel<Message> listModel;
    private JPanel panel;

    private Network network;

    public GrUI() {
        setTitle("Geek Chat");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(200, 200, 500, 500);

        setLayout(new BorderLayout());   // выбор компоновщика элементов

        listModel = new DefaultListModel<>();
        list = new JList<>(listModel);
        list.setCellRenderer(new MessageCellRenderer());

        panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(list, BorderLayout.SOUTH);
        panel.setBackground(list.getBackground());
        scrollPane = new JScrollPane(panel);
        add(scrollPane, BorderLayout.CENTER);

        textField = new JTextField();
        button = new JButton("Send");
        button.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = textField.getText();
                submitMessage("user", text);
                textField.setText(null);
                textField.requestFocus();

                network.sendMessage(text);
            }
        });

        textField.addKeyListener(new KeyListener(){
        @Override
        public void keyTyped(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_ENTER) {

                    String text = textField.getText();
                    submitMessage("user", text);
                    textField.setText(null);
                    textField.requestFocus();

                    network.sendMessage(text);
            }
        }


        @Override
        public void keyPressed(KeyEvent e){
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {

                        String text = textField.getText();
                        submitMessage("user", text);
                        textField.setText(null);
                        textField.requestFocus();

                        network.sendMessage(text);
                }
        }


        @Override
        public void keyReleased(KeyEvent e){
                    if (e.getKeyCode() == KeyEvent.VK_ENTER) {

                            String text = textField.getText();
                            submitMessage("user", text);
                            textField.setText(null);
                            textField.requestFocus();

                            network.sendMessage(text);
                    }
        }

    });

        this.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent evt) {
                list.ensureIndexIsVisible(listModel.size() - 1);
            }
        });

        panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(button, BorderLayout.EAST);
        panel.add(textField, BorderLayout.CENTER);

        add(panel, BorderLayout.SOUTH);

        try {
            network = new Network("localhost", 7776, this);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(-1);
        }

        setVisible(true);
    }

    @Override
    public void submitMessage(String user, String message) {
        if (message == null || message.isEmpty()) {
            return;
        }
        Message msg = new Message(user, message);
        listModel.add(listModel.size(), msg);
        list.ensureIndexIsVisible(listModel.size() - 1);
    }
}
