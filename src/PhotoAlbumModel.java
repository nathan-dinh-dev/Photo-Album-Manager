import java.util.ArrayList;
import java.util.List;

/**
 * PhotoAlbumModel Class
 *
 * This class represents the model in the MVC pattern. It manages the collection
 * of photos and provides methods to add, delete, and retrieve photos. It also
 * supports sorting through different strategies using the Strategy pattern.
 *
 * Author: Nathan Dinh
 * Date: October 24, 2024
 */

public class PhotoAlbumModel {
    private List<Photo> photos = new ArrayList<Photo>();
    private SortingStrategy sortingStrategy = new SortByDate();

    /**
     * Adds a new photo to the album.
     *
     * @param photo the Photo object to add.
     */
    public void addPhoto(Photo photo) {
        photos.add(photo);
    }

    /**
     * Deletes a photo from the album by name.
     *
     * @param name the name of the photo to delete.
     */
    public void deletePhoto(String name) {
        photos.removeIf(photo -> photo.getName().equalsIgnoreCase(name));
    }

    /**
     * Retrieves the list of photos sorted according to the current sorting strategy.
     *
     * @return a sorted list of Photo objects.
     */
    public List<Photo> getPhotos() {
        return sortingStrategy.sort(photos);
    }

    /**
     * Sets the sorting strategy to be used for retrieving photos.
     *
     * @param sortingStrategy the new sorting strategy.
     */
    public void setSortingStrategy(SortingStrategy sortingStrategy) {
        this.sortingStrategy = sortingStrategy;
    }

    /**
     * Creates and returns an iterator for navigating through the photo album.
     *
     * @return a PhotoAlbumIterator for the photos.
     */
    public PhotoAlbumIterator iterator() {
        return new PhotoAlbumIterator(photos);
    }
}
