import java.util.Date;

public class Photo {
    private String name;
    private String filePath;
    private Date dateAdded;
    private long fileSize;

    public Photo(String name, String filePath, Date dateAdded, long fileSize) {
        this.name = name;
        this.filePath = filePath;
        this.dateAdded = dateAdded;
        this.fileSize = fileSize;
    }

    public String getName() {
        return name;
    }

    public String getFilePath() {
        return filePath;
    }

    public Date getDateAdded() {
        return dateAdded;
    }

    public long getFileSize() {
        return fileSize;
    }
}
