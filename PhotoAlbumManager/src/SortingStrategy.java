/*
* Fall 2024 CS 151 Assignment #3
* @author Joyce Liu * 
* @version 1.0 10/25/24 */

import java.util.List;

/**
 * Interface to sort photos in the album by a characteristic of Photos
 */
public interface SortingStrategy {
	
    /**
     * Retrieves the next photo in the album
     * @param photos - a List of photos to be sorted
     * @return a List that is a sorted version of photos
     */
    List sort(List photos);
}