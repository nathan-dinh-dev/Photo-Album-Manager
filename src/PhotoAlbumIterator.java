import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Consumer;

public class PhotoAlbumIterator implements Iterator<Photo> {

    private List<Photo> photos;
    private int currentIndex = 0;

    public PhotoAlbumIterator(List<Photo> photos) {
        this.photos = photos;
    }

    @Override
    public boolean hasNext() {
        return currentIndex < photos.size();
    }

    @Override
    public Photo next() {
        if(!hasNext()) throw new NoSuchElementException();
        return photos.get(currentIndex++);
    }

    @Override
    public void remove() {
        Iterator.super.remove();
    }

    @Override
    public void forEachRemaining(Consumer<? super Photo> action) {
        Iterator.super.forEachRemaining(action);
    }
}
