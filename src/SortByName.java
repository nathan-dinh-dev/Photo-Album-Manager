import java.util.Comparator;
import java.util.List;
/**
 * SortByName Class
 *
 * This class implements the {@link SortingStrategy} interface to provide a
 * sorting strategy for photos based on their names. It sorts the photos in
 * ascending order by their name.
 *
 * Author: Nathan Dinh
 * Date: October 24, 2024
 */
public class SortByName implements SortingStrategy {
    /**
     * Sorts the given list of photos by their name in ascending order.
     *
     * @param photos the list of Photo objects to be sorted.
     * @return the sorted list of photos.
     */
    @Override
    public List<Photo> sort(List<Photo> photos) {
        photos.sort(Comparator.comparing(Photo::getName));
        return photos;
    }
}
