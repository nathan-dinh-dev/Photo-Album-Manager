import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class PhotoAlbumController {
    private PhotoAlbumModel model;
    private PhotoAlbumView view;

    public PhotoAlbumController(PhotoAlbumModel model, PhotoAlbumView view) {
        this.model = model;
        this.view = view;

        view.getAddButton().addActionListener(e -> addPhoto());
        view.getDeleteButton().addActionListener(e -> deletePhoto());
        view.getNextButton().addActionListener(e -> nextPhoto());
        view.getPreviousButton().addActionListener(e -> previousPhoto());
        view.getSortByComboBox().addActionListener(e -> changeSorting());
    }

    private void addPhoto() {
        String name = JOptionPane.showInputDialog("Enter photo name:");
        String path = JOptionPane.showInputDialog("Enter photo file path:");
        long size = Long.parseLong(JOptionPane.showInputDialog("Enter file size:"));
        model.addPhoto(new Photo(name, path, new Date(), size));
        updatePhotoList();
    }

    private void deletePhoto() {
        String name = JOptionPane.showInputDialog("Enter photo name to delete:");
        model.deletePhoto(name);
        updatePhotoList();
    }

    private void nextPhoto() {
        PhotoAlbumIterator iterator = model.iterator();
        if (iterator.hasNext()) {
            Photo photo = iterator.next();
            view.getPhotoLabel().setText(photo.getName());
        }
    }

    private void previousPhoto() {
        // Logic for previous photo (optional reverse iterator can be implemented)
    }

    private void changeSorting() {
        String selected = (String) view.getSortByComboBox().getSelectedItem();
        if (selected.equals("Name")) model.setSortingStrategy(new SortByName());
        if (selected.equals("Date")) model.setSortingStrategy(new SortByDate());
        if (selected.equals("Size")) model.setSortingStrategy(new SortBySize());
        updatePhotoList();
    }

    private void updatePhotoList() {
        StringBuilder sb = new StringBuilder();
        for (Photo photo : model.getPhotos()) {
            sb.append(photo.getName()).append("\n");
        }
        view.getPhotoListArea().setText(sb.toString());
    }
}
