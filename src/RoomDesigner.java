import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RoomDesigner {
    private JComboBox<String> shapeComboBox;
    private JComboBox<String> sizeComboBox;
    private JButton colorButton;
    private JButton loadButton;

    public RoomDesigner() {
        JFrame frame = new JFrame("Room Designer");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        // Define color palette
        Color backgroundColor = new Color(150, 93, 30);
        Color foregroundColor = new Color(163, 238, 255);

        // Shape selection
        shapeComboBox = new JComboBox<>(new String[]{"Square", "Rectangle", "Circle"});
        shapeComboBox.setBackground(backgroundColor);
        shapeComboBox.setForeground(foregroundColor);
        shapeComboBox.setSelectedItem("Square");
        frame.add(new JLabel("Select Shape: "));
        frame.add(shapeComboBox);

        // Size selection
        sizeComboBox = new JComboBox<>(new String[]{"Small", "Medium", "Large"});
        sizeComboBox.setBackground(backgroundColor);
        sizeComboBox.setForeground(foregroundColor);
        sizeComboBox.setSelectedItem("Small");
        frame.add(new JLabel("Select Size: "));
        frame.add(sizeComboBox);

        // Color selection
        colorButton = new JButton("Select Color");
        colorButton.setBackground(backgroundColor);
        colorButton.setForeground(foregroundColor);
        colorButton.addActionListener(e -> {
            Color selectedColor = JColorChooser.showDialog(frame, "Choose Color", Color.WHITE);
            if (selectedColor != null) {
                colorButton.setBackground(selectedColor);
            }
        });
        frame.add(colorButton);

        // Load button
        loadButton = new JButton("Load Design");
        loadButton.setBackground(backgroundColor);
        loadButton.setForeground(foregroundColor);
        loadButton.addActionListener(e -> {
            loadDesign();
            frame.dispose();
        });
        frame.add(loadButton);

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void loadDesign() {
        String selectedShape = (String) shapeComboBox.getSelectedItem();
        String selectedSize = (String) sizeComboBox.getSelectedItem();
        Color selectedColor = colorButton.getBackground();

        // Initialize TwoDViwer form with selected values
        SwingUtilities.invokeLater(() -> {
            TwoDViwer viewer = new TwoDViwer(selectedShape, selectedSize, selectedColor);
            viewer.setVisible(true);
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(RoomDesigner::new);
    }
}
