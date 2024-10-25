import javax.swing.*;
import java.awt.*;
import java.util.List;
import javax.swing.DefaultListCellRenderer;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class PhotoAlbumView extends JFrame {
    private JButton addButton = new JButton("Add Photo");
    private JButton deleteButton = new JButton("Delete Photo");
    private JButton nextButton = new JButton("Next");
    private JButton previousButton = new JButton("Previous");
    private JComboBox<String> sortByComboBox = new JComboBox<>(new String[]{"Name", "Date", "Size"});
    private JLabel currentPhotoLabel = new JLabel(); // To display current photo
    private DefaultListModel<Photo> photoListModel = new DefaultListModel<>();
    private JList<Photo> photoList = new JList<>(photoListModel); // List of photos

    public PhotoAlbumView() {
        // Set the title of the window
        setTitle("Photo Album Manager");

        setLayout(new BorderLayout());

        // Control Panel
        JPanel controlPanel = new JPanel();
        controlPanel.add(addButton);
        controlPanel.add(deleteButton);
        controlPanel.add(previousButton);
        controlPanel.add(nextButton);
        controlPanel.add(sortByComboBox);

        // Photo List with Thumbnails
        photoList.setCellRenderer(new PhotoListRenderer());
        JScrollPane scrollPane = new JScrollPane(photoList);

        // Layout: Controls on top, Current Photo in the center, List at the bottom
        // Set up split pane: photo list on the left, current photo on the right
        JSplitPane splitPane = new JSplitPane(
                JSplitPane.HORIZONTAL_SPLIT, scrollPane, currentPhotoLabel);
        splitPane.setDividerLocation(250); // Set the initial divider position
        add(splitPane, BorderLayout.CENTER);  // Split pane in the center
        add(controlPanel, BorderLayout.SOUTH); // Controls at the bottom

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 800);
        setVisible(true);
    }

    public JButton getAddButton() { return addButton; }
    public JButton getDeleteButton() { return deleteButton; }
    public JButton getNextButton() { return nextButton; }
    public JButton getPreviousButton() { return previousButton; }
    public JComboBox<String> getSortByComboBox() { return sortByComboBox; }
    public JLabel getCurrentPhotoLabel() { return currentPhotoLabel; }
    public JList<Photo> getPhotoList() { return photoList; }
    public DefaultListModel<Photo> getPhotoListModel() { return photoListModel; }

    // Custom renderer to display photo names with thumbnails in the JList
    private class PhotoListRenderer extends DefaultListCellRenderer {
        @Override
        public Component getListCellRendererComponent(
                JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {

            Photo photo = (Photo) value;
            JLabel label = (JLabel) super.getListCellRendererComponent(
                    list, photo.getName(), index, isSelected, cellHasFocus);

            try {
                ImageIcon thumbnail = new ImageIcon(ImageIO.read(new File(photo.getFilePath()))
                        .getScaledInstance(50, 50, Image.SCALE_SMOOTH));
                label.setIcon(thumbnail);
                label.setHorizontalTextPosition(JLabel.RIGHT); // Align text to the right of the thumbnail
            } catch (Exception e) {
                label.setText(photo.getName() + " (Thumbnail not available)");
            }

            return label;
        }
    }
}
