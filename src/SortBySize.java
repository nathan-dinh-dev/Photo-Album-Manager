import java.util.Comparator;
import java.util.List;

public class SortBySize implements SortingStrategy {
    @Override
    public List<Photo> sort(List<Photo> photos) {
        photos.sort(Comparator.comparing(Photo::getFileSize));
        return photos;
    }
}
