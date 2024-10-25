import java.util.List;
/**
 * SortingStrategy Interface
 *
 * This interface defines a contract for sorting strategies that can be applied
 * to a list of photos. Implementing classes must provide their own logic for
 * sorting the photos based on specific criteria such as name, date, or file size.
 *
 * Author: Nathan Dinh
 * Date: October 24, 2024
 */
public interface SortingStrategy {
    /**
     * Sorts the given list of photos according to the specific strategy.
     *
     * @param photos the list of Photo objects to be sorted.
     * @return the sorted list of Photo objects.
     */
    List<Photo> sort(List<Photo> photos);
}