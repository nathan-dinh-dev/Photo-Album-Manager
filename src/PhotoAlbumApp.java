/**
 * PhotoAlbumApp Class
 *
 * This is the entry point of the Photo Album Manager application.
 * It initializes the model, view, and controller components, and starts the application.
 *
 * Author: Nathan Dinh
 * Date: October 24, 2024
 */

public class PhotoAlbumApp {
    /**
     * The main method of the application.
     * It creates instances of the model, view, and controller to start the application.
     *
     * @param args command-line arguments.
     */
    public static void main(String[] args) {
        PhotoAlbumModel model = new PhotoAlbumModel();
        PhotoAlbumView view = new PhotoAlbumView();
        new PhotoAlbumController(model, view);
    }
}