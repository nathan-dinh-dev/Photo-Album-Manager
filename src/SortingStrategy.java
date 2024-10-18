import java.util.Comparator;
import java.util.List;

public interface SortingStrategy {
    List<Photo> sort(List<Photo> photos);
}

// Concrete class for sorting by Name
class SortByName implements SortingStrategy {
    @Override
    public List<Photo> sort(List<Photo> photos) {
        photos.sort(Comparator.comparing(Photo::getName));
        return photos;
    }
}

// Concrete class for sorting by Date
class SortByDate implements SortingStrategy {
    @Override
    public List<Photo> sort(List<Photo> photos) {
        photos.sort(Comparator.comparing(Photo::getDateAdded));
        return photos;
    }
}

// Concrete class for sorting by Size
class SortBySize implements SortingStrategy {
    @Override
    public List<Photo> sort(List<Photo> photos) {
        photos.sort(Comparator.comparing(Photo::getFileSize));
        return photos;
    }
}
