import javax.swing.*;
import java.io.File;
import java.util.Date;
import java.awt.Image;
import javax.imageio.ImageIO;


public class PhotoAlbumController {
    private PhotoAlbumModel model;
    private PhotoAlbumView view;
    private AlbumIterator iterator;

    public PhotoAlbumController(PhotoAlbumModel model, PhotoAlbumView view) {
        this.model = model;
        this.view = view;
        this.iterator = model.iterator(); // Initialize the iterator

        view.getAddButton().addActionListener(e -> addPhoto());
        view.getDeleteButton().addActionListener(e -> deletePhoto());
        view.getNextButton().addActionListener(e -> nextPhoto());
        view.getPreviousButton().addActionListener(e -> previousPhoto());
        view.getSortByComboBox().addActionListener(e -> changeSorting());

        updatePhotoList();
    }

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

    private void deletePhoto() {
        String name = JOptionPane.showInputDialog("Enter photo name to delete:");
        model.deletePhoto(name);
        updatePhotoList();
    }

    private void nextPhoto() {
        if (iterator.hasNext()) {
            Photo photo = iterator.next();
            displayPhoto(photo);
        } else {
            JOptionPane.showMessageDialog(view, "No more photos.");
        }
    }

    private void previousPhoto() {
        if (iterator.hasPrevious()) {
            Photo photo = iterator.previous();
            displayPhoto(photo);
        } else {
            JOptionPane.showMessageDialog(view, "No previous photos.");
        }
    }

    private void changeSorting() {
        String selected = (String) view.getSortByComboBox().getSelectedItem();
        if (selected.equals("Name")) model.setSortingStrategy(new SortByName());
        if (selected.equals("Date")) model.setSortingStrategy(new SortByDate());
        if (selected.equals("Size")) model.setSortingStrategy(new SortBySize());
        updatePhotoList();
    }

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
