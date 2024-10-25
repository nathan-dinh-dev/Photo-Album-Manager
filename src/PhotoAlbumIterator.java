import java.util.List;

public class PhotoAlbumIterator implements AlbumIterator {
    private List<Photo> photos;
    private int currentIndex = 0;

    public PhotoAlbumIterator(List<Photo> photos) {
        this.photos = photos;
    }

    @Override
    public boolean hasNext() {
        return currentIndex < photos.size() - 1;
    }

    @Override
    public boolean hasPrevious() {
        return currentIndex > 0;
    }

    @Override
    public Photo current() {
        if (photos.isEmpty()) {
            return null;  // Handle edge case: empty album
        }
        return photos.get(currentIndex);
    }

    @Override
    public Photo next() {
        if (hasNext()) {
            currentIndex++;
        }
        return current();
    }

    @Override
    public Photo previous() {
        if (hasPrevious()) {
            currentIndex--;
        }
        return current();
    }
}
