import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class PlayFairCipherGUI extends JFrame {
    private JTextField keyField;
    private JTextArea inputArea;
    private JTextArea outputArea;
    private JButton encryptButton;
    private JButton decryptButton;
    private JTextArea matrixArea;

    private char[][] keyMatrix;

    public PlayFairCipherGUI() {
        setTitle("Play-Fair Cipher Encrypt/Decrypt");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Key input
        JPanel keyPanel = new JPanel(new FlowLayout());
        keyPanel.add(new JLabel("Key:"));
        keyField = new JTextField(20);
        keyField.setText("MONARCHY");
        keyField.addActionListener(e -> generateKeyMatrix());
        keyPanel.add(keyField);
        add(keyPanel, BorderLayout.NORTH);

        // Input and output
        JPanel centerPanel = new JPanel(new GridLayout(2, 1));
        JPanel inputPanel = new JPanel(new BorderLayout());
        inputPanel.add(new JLabel("Input Text:"), BorderLayout.NORTH);
        inputArea = new JTextArea(5, 50);
        inputPanel.add(new JScrollPane(inputArea), BorderLayout.CENTER);
        centerPanel.add(inputPanel);

        JPanel outputPanel = new JPanel(new BorderLayout());
        outputPanel.add(new JLabel("Output:"), BorderLayout.NORTH);
        outputArea = new JTextArea(5, 50);
        outputArea.setEditable(false);
        outputPanel.add(new JScrollPane(outputArea), BorderLayout.CENTER);
        centerPanel.add(outputPanel);

        add(centerPanel, BorderLayout.CENTER);

        // Buttons
        JPanel buttonPanel = new JPanel(new FlowLayout());
        encryptButton = new JButton("Encrypt");
        decryptButton = new JButton("Decrypt");
        buttonPanel.add(encryptButton);
        buttonPanel.add(decryptButton);
        add(buttonPanel, BorderLayout.SOUTH);

        // Matrix display
        JPanel matrixPanel = new JPanel(new BorderLayout());
        matrixPanel.add(new JLabel("Key Matrix:"), BorderLayout.NORTH);
        matrixArea = new JTextArea(5, 50);
        matrixArea.setEditable(false);
        matrixPanel.add(new JScrollPane(matrixArea), BorderLayout.CENTER);
        add(matrixPanel, BorderLayout.EAST);

        // Event listeners
        encryptButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = inputArea.getText();
                String result = encrypt(text);
                outputArea.setText(result);
            }
        });

        decryptButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = inputArea.getText();
                String result = decrypt(text);
                outputArea.setText(result);
            }
        });

        generateKeyMatrix();
    }

    private void generateKeyMatrix() {
        String key = keyField.getText().toUpperCase().replaceAll("[^A-Z]", "").replace("J", "I");
        Set<Character> used = new HashSet<>();
        keyMatrix = new char[5][5];
        StringBuilder matrixText = new StringBuilder();

        int index = 0;
        // Add key letters
        for (char c : key.toCharArray()) {
            if (!used.contains(c)) {
                used.add(c);
                keyMatrix[index / 5][index % 5] = c;
                matrixText.append(c).append(" ");
                if ((index + 1) % 5 == 0) matrixText.append("\n");
                index++;
            }
        }

        // Add remaining letters
        String alphabet = "ABCDEFGHIKLMNOPQRSTUVWXYZ";
        for (char c : alphabet.toCharArray()) {
            if (!used.contains(c)) {
                used.add(c);
                keyMatrix[index / 5][index % 5] = c;
                matrixText.append(c).append(" ");
                if ((index + 1) % 5 == 0) matrixText.append("\n");
                index++;
            }
        }

        matrixArea.setText(matrixText.toString());
    }

    private String prepareText(String text, boolean isEncrypt) {
        text = text.toUpperCase().replaceAll("[^A-Z]", "").replace("J", "I");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < text.length(); i += 2) {
            char a = text.charAt(i);
            char b = (i + 1 < text.length()) ? text.charAt(i + 1) : 'X';
            if (a == b) {
                b = 'X';
                i--; // repeat
            }
            sb.append(a).append(b);
        }
        return sb.toString();
    }

    private int[] findPosition(char c) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (keyMatrix[i][j] == c) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    private String encrypt(String text) {
        String prepared = prepareText(text, true);
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < prepared.length(); i += 2) {
            char a = prepared.charAt(i);
            char b = prepared.charAt(i + 1);
            int[] pos1 = findPosition(a);
            int[] pos2 = findPosition(b);

            if (pos1[0] == pos2[0]) {
                // Same row
                result.append(keyMatrix[pos1[0]][(pos1[1] + 1) % 5]);
                result.append(keyMatrix[pos2[0]][(pos2[1] + 1) % 5]);
            } else if (pos1[1] == pos2[1]) {
                // Same column
                result.append(keyMatrix[(pos1[0] + 1) % 5][pos1[1]]);
                result.append(keyMatrix[(pos2[0] + 1) % 5][pos2[1]]);
            } else {
                // Rectangle
                result.append(keyMatrix[pos1[0]][pos2[1]]);
                result.append(keyMatrix[pos2[0]][pos1[1]]);
            }
        }

        return result.toString();
    }

    private String decrypt(String text) {
        String prepared = prepareText(text, false);
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < prepared.length(); i += 2) {
            char a = prepared.charAt(i);
            char b = prepared.charAt(i + 1);
            int[] pos1 = findPosition(a);
            int[] pos2 = findPosition(b);

            if (pos1[0] == pos2[0]) {
                // Same row
                result.append(keyMatrix[pos1[0]][(pos1[1] + 4) % 5]);
                result.append(keyMatrix[pos2[0]][(pos2[1] + 4) % 5]);
            } else if (pos1[1] == pos2[1]) {
                // Same column
                result.append(keyMatrix[(pos1[0] + 4) % 5][pos1[1]]);
                result.append(keyMatrix[(pos2[0] + 4) % 5][pos2[1]]);
            } else {
                // Rectangle
                result.append(keyMatrix[pos1[0]][pos2[1]]);
                result.append(keyMatrix[pos2[0]][pos1[1]]);
            }
        }

        // Remove trailing X
        String res = result.toString();
        if (res.endsWith("X")) {
            res = res.substring(0, res.length() - 1);
        }
        return res;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new PlayFairCipherGUI().setVisible(true);
        });
    }
}