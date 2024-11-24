/**
* Fall 2024 CS 151 Assignment #3
* @author Joyce Liu * @version 1.0 10/25/24 */
import java.util.Date;

/**
 * A Photo has a name, filePath, dateAdded, and fileSize that can be retrieved
 */
public class Photo {
    private String name;
    private String filePath;
    private Date dateAdded;
    private long fileSize;

    /**
     * Constructs a Photo with specified information
     * @param name - name of the Photo
     * @param filePath - a string of the file path to access the Photo
     * @param dateAdded - a Date 
     * @param fileSize - a long of the byte size of the Photo
     */
    public Photo(String name, String filePath, Date dateAdded, long fileSize) {
    	this.name = name;
    	this.filePath = filePath;
    	this.dateAdded = dateAdded;
    	this.fileSize = fileSize;  	
    	
    }
    
    /**
     * Returns the name of the Photo
     * @return the name variable of the Photo
     */
    public String getName() {
    	return name;
    }
    
    /**
     * Returns the filePath of the Photo
     * @return the filePath variable of the Photo
     */
    public String getFilePath() {
    	return filePath;
    }
    
    /**
     * Returns the Date of the Photo
     * @return the Date variable of the Photo
     */
    public Date getDate() {
    	return dateAdded;
    }
    
    /**
     * Returns the fileSize of the Photo
     * @return the fileSize variable of the Photo
     */
    public long getFileSize() {
    	return fileSize;
    }
    
}