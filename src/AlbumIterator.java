/**
 * AlbumIterator Interface
 *
 * This interface provides methods to navigate through a collection of photos.
 * It allows moving forward and backward through the collection using `next()`
 * and `previous()` methods, and retrieving the current photo.
 *
 * Author: Nathan Dinh
 * Date: October 24, 2024
 */

public interface AlbumIterator {
    /**
     * Checks if there is a next photo in the album.
     *
     * @return true if there is a next photo, false otherwise.
     */
    boolean hasNext(); // to check if there is a next element

    /**
     * Checks if there is a previous photo in the album.
     *
     * @return true if there is a previous photo, false otherwise.
     */
    boolean hasPrevious(); // to check if there is a previous element

    /**
     * Retrieves the photo at the current position in the album.
     *
     * @return the current Photo object, or null if the album is empty or
     *         if the iterator is out of bounds.
     */
    Photo current(); // to get the photo at the current position

    /**
     * Advances the iterator to the next photo and returns it.
     *
     * @return the next Photo object, or null if there are no more photos.
     */
    Photo next(); // to advance the iterator to the next position

    /**
     * Moves the iterator to the previous photo and returns it.
     *
     * @return the previous Photo object, or null if there are no previous photos.
     */
    Photo previous(); // to advance the iterator to the previous position
}