import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.web.WebView;

import javax.swing.*;
import java.awt.*;

public class ModelViewer {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("View the Model");
            frame.setLayout(new BorderLayout()); // Use BorderLayout

            final JFXPanel fxPanel = new JFXPanel();
            frame.add(fxPanel, BorderLayout.CENTER); // Add JFXPanel at the center

            // Create a panel for buttons
            JPanel buttonPanel = new JPanel();
            buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER)); // Set the layout

            // Create buttons
            JButton saveButton = new JButton("Save");
            saveButton.setBackground(new Color(150, 93, 30));
            saveButton.setForeground(new Color(162, 238, 255));
            saveButton.setFont(new Font("Advert", Font.BOLD, 14));
            JButton editButton = new JButton("Edit");
            editButton.setBackground(new Color(150, 93, 30));
            editButton.setForeground(new Color(162, 238, 255));
            editButton.setFont(new Font("Advert", Font.BOLD, 14));
            JButton deleteButton = new JButton("Delete");
            deleteButton.setBackground(new Color(150, 93, 30));
            deleteButton.setForeground(new Color(162, 238, 255));
            deleteButton.setFont(new Font("Advert", Font.BOLD, 14));
            JButton returnButton = new JButton("Return");
            returnButton.setBackground(new Color(150, 93, 30));
            returnButton.setForeground(new Color(162, 238, 255));
            returnButton.setFont(new Font("Advert", Font.BOLD, 14));

            // Add action listeners for the buttons
            saveButton.addActionListener(e -> {
                JOptionPane.showMessageDialog(frame,
                        "Successfully saved to your directory",
                        "Save Successful",
                        JOptionPane.INFORMATION_MESSAGE);
            });

            editButton.addActionListener(e -> frame.dispose());

            deleteButton.addActionListener(e -> {
                int result = JOptionPane.showConfirmDialog(frame,
                        "Are you sure?",
                        "Confirm Delete",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE);
                if (result == JOptionPane.YES_OPTION) {
                    frame.dispose();
                }
            });

            returnButton.addActionListener(e -> frame.dispose());

            // Add buttons to the panel
            buttonPanel.add(saveButton);
            buttonPanel.add(editButton);
            buttonPanel.add(deleteButton);
            buttonPanel.add(returnButton);

            buttonPanel.setBackground(new Color(100, 150, 150));

            // Add the panel of buttons to the bottom of the frame
            frame.add(buttonPanel, BorderLayout.SOUTH);

            frame.setSize(800, 600);
            frame.setVisible(true);
            frame.setLocationRelativeTo(null);
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

            Platform.runLater(() -> {
                initFX(fxPanel);
            });
        });
    }

    private static void initFX(JFXPanel fxPanel) {
        // This method is invoked on the JavaFX thread
        WebView webView = new WebView();
        webView.getEngine().load("https://sketchfab.com/3d-models/wooden-table-game-ready-asset-4618e56258e54e259a617f38be5b094a/embed");

        Scene scene = new Scene(webView);
        fxPanel.setScene(scene);
    }

}