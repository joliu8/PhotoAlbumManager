/*
* Fall 2024 CS 151 Assignment #3
* @author Joyce Liu * 
* @version 1.0 10/25/24 */


/**
 * Interface to iterate over photos in the album
 */
public interface AlbumIterator {
	/**
	 * Returns if there are more photos in the album
	 * @return if there is another photo next in the album
	 */
    boolean hasNext();
    
    /**
     * Retrieves the next photo in the album
     * @return the next Photo 
     */
    Photo next();
}
