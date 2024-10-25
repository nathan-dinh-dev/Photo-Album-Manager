import java.util.Comparator;
import java.util.List;

public class SortByDate implements SortingStrategy {
    @Override
    public List<Photo> sort(List<Photo> photos) {
        photos.sort(Comparator.comparing(Photo::getDateAdded));
        return photos;
    }
}
