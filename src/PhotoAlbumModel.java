import java.util.ArrayList;
import java.util.List;

public class PhotoAlbumModel {
    private List<Photo> photos = new ArrayList<Photo>();
    private SortingStrategy sortingStrategy = new SortByDate();

    public void addPhoto(Photo photo) {
        photos.add(photo);
    }

    public void deletePhoto(String name) {
        photos.removeIf(photo -> photo.getName().equalsIgnoreCase(name));
    }

    public List<Photo> getPhotos() {
        return sortingStrategy.sort(photos);
    }

    public void setSortingStrategy(SortingStrategy sortingStrategy) {
        this.sortingStrategy = sortingStrategy;
    }

    public PhotoAlbumIterator iterator() {
        return new PhotoAlbumIterator(photos);
    }
}
