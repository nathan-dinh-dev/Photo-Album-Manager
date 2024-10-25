import java.util.Comparator;
import java.util.List;

public interface SortingStrategy {
    List<Photo> sort(List<Photo> photos);
}