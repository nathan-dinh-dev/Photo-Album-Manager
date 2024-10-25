import java.util.Date;

/**
 * Photo Class
 *
 * Represents a photo with attributes such as name, file path,
 * date added, and file size. Provides getter methods to access
 * these properties.
 *
 * Author: Nathan Dinh
 * Date: October 24, 2024
 */

public class Photo {
    private String name;
    private String filePath;
    private Date dateAdded;
    private long fileSize;

    /**
     * Constructs a new Photo object with the given attributes.
     *
     * @param name       the name of the photo.
     * @param filePath   the file path of the photo.
     * @param dateAdded  the date when the photo was added.
     * @param fileSize   the size of the photo file in bytes.
     */
    public Photo(String name, String filePath, Date dateAdded, long fileSize) {
        this.name = name;
        this.filePath = filePath;
        this.dateAdded = dateAdded;
        this.fileSize = fileSize;
    }

    /**
     * Gets the name of the photo.
     *
     * @return the name of the photo.
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the file path of the photo.
     *
     * @return the file path of the photo.
     */
    public String getFilePath() {
        return filePath;
    }

    /**
     * Gets the date the photo was added.
     *
     * @return the date when the photo was added.
     */
    public Date getDateAdded() {
        return dateAdded;
    }

    /**
     * Gets the file size of the photo.
     *
     * @return the size of the photo file in bytes.
     */
    public long getFileSize() {
        return fileSize;
    }
}
