import java.util.Comparator;
import java.util.List;
/**
 * SortBySize Class
 *
 * This class implements the {@link SortingStrategy} interface to provide a
 * sorting strategy for photos based on their file size. It sorts the photos
 * in ascending order by their size in bytes.
 *
 * Author: Nathan Dinh
 * Date: October 24, 2024
 */
public class SortBySize implements SortingStrategy {
    /**
     * Sorts the given list of photos by their file size in ascending order.
     *
     * @param photos the list of Photo objects to be sorted.
     * @return the sorted list of photos.
     */
    @Override
    public List<Photo> sort(List<Photo> photos) {
        photos.sort(Comparator.comparing(Photo::getFileSize));
        return photos;
    }
}
