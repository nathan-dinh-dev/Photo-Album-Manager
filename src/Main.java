public class Main {
    public static void main(String[] args) {
        PhotoAlbumModel model = new PhotoAlbumModel();
        PhotoAlbumView view = new PhotoAlbumView();
        new PhotoAlbumController(model, view);    }
}