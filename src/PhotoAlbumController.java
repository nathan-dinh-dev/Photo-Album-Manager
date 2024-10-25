import javax.swing.*;
import java.io.File;
import java.util.Date;
import java.awt.Image;
import javax.imageio.ImageIO;

/**
 * PhotoAlbumController Class
 *
 * This class serves as the controller in the MVC pattern, managing the interaction
 * between the PhotoAlbumModel and PhotoAlbumView. It handles user actions, such as
 * adding, deleting, and navigating through photos, and updates the model and view
 * accordingly.
 *
 * Author: Nathan Dinh
 * Date: October 24, 2024
 */

public class PhotoAlbumController {
    private PhotoAlbumModel model;
    private PhotoAlbumView view;
    private AlbumIterator iterator;

    /**
     * Constructs a PhotoAlbumController with the specified model and view.
     * Initializes event listeners for user interactions and updates the photo list.
     *
     * @param model the PhotoAlbumModel instance managing the photo data.
     * @param view  the PhotoAlbumView instance providing the user interface.
     */
    public PhotoAlbumController(PhotoAlbumModel model, PhotoAlbumView view) {
        this.model = model;
        this.view = view;
        this.iterator = model.iterator(); // Initialize the iterator

        // Register event listeners
        view.getAddButton().addActionListener(e -> addPhoto());
        view.getDeleteButton().addActionListener(e -> deletePhoto());
        view.getNextButton().addActionListener(e -> nextPhoto());
        view.getPreviousButton().addActionListener(e -> previousPhoto());
        view.getSortByComboBox().addActionListener(e -> changeSorting());

        updatePhotoList();
    }

    /**
     * Opens a file chooser dialog to allow the user to add a new photo to the album.
     */
    private void addPhoto() {
        // Open file chooser to select a photo
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showOpenDialog(view);

        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            String name = selectedFile.getName();
            String path = selectedFile.getAbsolutePath();
            long size = selectedFile.length();
            Date dateAdded = new Date(selectedFile.lastModified());

            // Add the selected photo to the model
            model.addPhoto(new Photo(name, path, dateAdded, size));
            updatePhotoList();
        }
    }

    /**
     * Prompts the user to enter the name of a photo to delete from the album.
     */
    private void deletePhoto() {
        String name = JOptionPane.showInputDialog("Enter photo name to delete:");
        model.deletePhoto(name);
        updatePhotoList();
    }

    /**
     * Advances to the next photo in the album, if available, and updates the view.
     */
    private void nextPhoto() {
        if (iterator.hasNext()) {
            Photo photo = iterator.next();
            displayPhoto(photo);
        } else {
            JOptionPane.showMessageDialog(view, "No more photos.");
        }
    }

    /**
     * Moves to the previous photo in the album, if available, and updates the view.
     */
    private void previousPhoto() {
        if (iterator.hasPrevious()) {
            Photo photo = iterator.previous();
            displayPhoto(photo);
        } else {
            JOptionPane.showMessageDialog(view, "No previous photos.");
        }
    }

    /**
     * Changes the sorting strategy based on user selection from the dropdown menu.
     */
    private void changeSorting() {
        String selected = (String) view.getSortByComboBox().getSelectedItem();
        if (selected.equals("Name")) model.setSortingStrategy(new SortByName());
        if (selected.equals("Date")) model.setSortingStrategy(new SortByDate());
        if (selected.equals("Size")) model.setSortingStrategy(new SortBySize());
        updatePhotoList();
    }

    /**
     * Updates the photo list displayed in the view and resets the iterator.
     */
    private void updatePhotoList() {
        DefaultListModel<Photo> photoListModel = view.getPhotoListModel();
        photoListModel.clear();
        for (Photo photo : model.getPhotos()) {
            photoListModel.addElement(photo);
        }
        if (model.getPhotos().size() > 0) {
            iterator = model.iterator(); // Re-initialize iterator
            displayPhoto(iterator.current());
        }
    }

    /**
     * Displays the specified photo in the view, including its name and thumbnail.
     *
     * @param photo the Photo object to display.
     */
    private void displayPhoto(Photo photo) {
        try {
            ImageIcon imageIcon = new ImageIcon(ImageIO.read(new File(photo.getFilePath()))
                    .getScaledInstance(400, 300, Image.SCALE_SMOOTH));
            view.getCurrentPhotoLabel().setIcon(imageIcon);
            view.getCurrentPhotoLabel().setText(photo.getName());
        } catch (Exception e) {
            view.getCurrentPhotoLabel().setText("Unable to display photo.");
            view.getCurrentPhotoLabel().setIcon(null);
        }
    }
}
