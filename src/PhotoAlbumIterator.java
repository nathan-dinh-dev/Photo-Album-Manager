import java.util.List;

/**
 * PhotoAlbumIterator Class
 *
 * This class implements the {@link AlbumIterator} interface to provide
 * navigation through a list of photos. It supports moving forward and
 * backward within the collection, as well as accessing the current photo.
 *
 * Author: Nathan Dinh
 * Date: October 24, 2024
 */

public class PhotoAlbumIterator implements AlbumIterator {
    private List<Photo> photos;
    private int currentIndex = 0;

    /**
     * Constructs a PhotoAlbumIterator for the given list of photos.
     *
     * @param photos the list of photos to iterate through.
     */
    public PhotoAlbumIterator(List<Photo> photos) {
        this.photos = photos;
    }

    /**
     * Checks if there is a next photo in the album.
     *
     * @return true if there is a next photo, false otherwise.
     */
    @Override
    public boolean hasNext() {
        return currentIndex < photos.size() - 1;
    }

    /**
     * Checks if there is a previous photo in the album.
     *
     * @return true if there is a previous photo, false otherwise.
     */
    @Override
    public boolean hasPrevious() {
        return currentIndex > 0;
    }

    /**
     * Retrieves the current photo in the album.
     *
     * @return the current Photo object, or null if the album is empty.
     */
    @Override
    public Photo current() {
        if (photos.isEmpty()) {
            return null;  // Handle edge case: empty album
        }
        return photos.get(currentIndex);
    }

    /**
     * Advances the iterator to the next photo and returns it.
     *
     * @return the next Photo object, or the current photo if no next exists.
     */
    @Override
    public Photo next() {
        if (hasNext()) {
            currentIndex++;
        }
        return current();
    }

    /**
     * Moves the iterator to the previous photo and returns it.
     *
     * @return the previous Photo object, or the current photo if no previous exists.
     */
    @Override
    public Photo previous() {
        if (hasPrevious()) {
            currentIndex--;
        }
        return current();
    }
}
