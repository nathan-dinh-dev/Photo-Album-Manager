import javax.swing.*;
import java.awt.*;
import java.util.List;

public class PhotoAlbumView extends JFrame {
    private JButton addButton = new JButton("Add Photo");
    private JButton deleteButton = new JButton("Delete Photo");
    private JButton nextButton = new JButton("Next");
    private JButton previousButton = new JButton("Previous");
    private JComboBox<String> sortByComboBox = new JComboBox<>(new String[]{"Name", "Date", "Size"});
    private JLabel photoLabel = new JLabel("Current Photo");
    private JTextArea photoListArea = new JTextArea(10, 30);

    public PhotoAlbumView() {
        setLayout(new BorderLayout());
        JPanel controlPanel = new JPanel();
        controlPanel.add(addButton);
        controlPanel.add(deleteButton);
        controlPanel.add(previousButton);
        controlPanel.add(nextButton);
        controlPanel.add(sortByComboBox);

        add(controlPanel, BorderLayout.NORTH);
        add(photoLabel, BorderLayout.CENTER);
        add(new JScrollPane(photoListArea), BorderLayout.SOUTH);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }

    public JButton getAddButton() { return addButton; }
    public JButton getDeleteButton() { return deleteButton; }
    public JButton getNextButton() { return nextButton; }
    public JButton getPreviousButton() { return previousButton; }
    public JComboBox<String> getSortByComboBox() { return sortByComboBox; }
    public JLabel getPhotoLabel() { return photoLabel; }
    public JTextArea getPhotoListArea() { return photoListArea; }
}
