import javax.swing.*;
import java.awt.*;
import javax.swing.DefaultListCellRenderer;
import java.io.File;
import javax.imageio.ImageIO;

/**
 * PhotoAlbumView Class
 *
 * This class provides the graphical user interface (GUI) for the Photo Album Manager.
 * It displays the list of photos with thumbnails, a control panel with action buttons,
 * and a preview of the current photo. The view uses a split pane to organize the layout
 * with the photo list on the left and the current photo preview on the right.
 *
 * Author: Nathan Dinh
 * Date: October 24, 2024
 */

public class PhotoAlbumView extends JFrame {
    private JButton addButton = new JButton("Add Photo");
    private JButton deleteButton = new JButton("Delete Photo");
    private JButton nextButton = new JButton("Next");
    private JButton previousButton = new JButton("Previous");
    private JComboBox<String> sortByComboBox = new JComboBox<>(new String[]{"Name", "Date", "Size"});
    private JLabel currentPhotoLabel = new JLabel();
    private DefaultListModel<Photo> photoListModel = new DefaultListModel<>();
    private JList<Photo> photoList = new JList<>(photoListModel);

    /**
     * Constructs the PhotoAlbumView and initializes the GUI components.
     * It sets up the layout with a control panel at the bottom,
     * a photo list on the left, and the current photo preview on the right.
     */
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

    /**
     * @return the Add Photo button.
     */
    public JButton getAddButton() { return addButton; }

    /**
     * @return the Delete Photo button.
     */
    public JButton getDeleteButton() { return deleteButton; }

    /**
     * @return the Next Photo button.
     */
    public JButton getNextButton() { return nextButton; }

    /**
     * @return the Previous Photo button.
     */
    public JButton getPreviousButton() { return previousButton; }

    /**
     * @return the sorting strategy dropdown menu.
     */
    public JComboBox<String> getSortByComboBox() { return sortByComboBox; }

    /**
     * @return the label displaying the current photo label.
     */
    public JLabel getCurrentPhotoLabel() { return currentPhotoLabel; }

    /**
     * @return the list of photos in the album.
     */
    public JList<Photo> getPhotoList() { return photoList; }

    /**
     * @return the model representing the list of photos.
     */
    public DefaultListModel<Photo> getPhotoListModel() { return photoListModel; }

    /**
     * Custom renderer for the photo list to display each photo's name with a thumbnail.
     */
    private class PhotoListRenderer extends DefaultListCellRenderer {
        @Override
        public Component getListCellRendererComponent(
                JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {

            Photo photo = (Photo) value;
            JLabel label = (JLabel) super.getListCellRendererComponent(
                    list, photo.getName(), index, isSelected, cellHasFocus);

            try {
                // Load and scale the photo thumbnail
                ImageIcon thumbnail = new ImageIcon(ImageIO.read(new File(photo.getFilePath()))
                        .getScaledInstance(50, 50, Image.SCALE_SMOOTH));
                label.setIcon(thumbnail);
                label.setHorizontalTextPosition(JLabel.NORTH); // Align text to the top of the thumbnail
            } catch (Exception e) {
                label.setText(photo.getName() + " (Thumbnail not available)");
            }

            return label;
        }
    }
}
