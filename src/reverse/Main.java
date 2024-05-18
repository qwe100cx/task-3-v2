package reverse;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Main {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        JFrame frame = new JFrame("Linked List Reversal");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 250);
        frame.setLayout(new FlowLayout());

        JLabel label = new JLabel("Введите список:");
        JTextField textField = new JTextField(20);
        JButton reverseButton = new JButton("перевернуть ");
        JButton clearButton = new JButton("очистить");
        JButton randomButton = new JButton("случайный список");


        JTextArea textArea = new JTextArea(10, 70);
        textArea.setEditable(false);

        reverseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = textField.getText();
                String[] elements = input.split(" ");

                for (String element : elements) {
                    list.addNode(element);
                }

                list.reverseList();

                textArea.setText( list.getListAsString());
            }
        });


        randomButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                list.generateRandomList(7);
                textArea.setText(list.getListAsString());
            }
        });

        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                list.clearList();
                textArea.setText("пусто");
                textField.setText("пусто");
            }
        });


        frame.add(label);
        frame.add(textField);
        frame.add(reverseButton);
        frame.add(clearButton);
        frame.add(randomButton);
        frame.add(textArea);

        frame.setVisible(true);
    }
}
