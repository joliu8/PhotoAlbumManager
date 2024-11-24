/**
* Fall 2024 CS 151 Assignment #3
* @author Joyce Liu * @version 1.0 10/25/24 */
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * A SortBySize Object is a SortingStrategy that uses a Comparator to sort a list of Photos by fileSize
 */
public class SortBySize implements SortingStrategy, Comparator<Photo>{
	

	/** Returns a List sorted by fileSize
	 * @return a List sorted by fileSize
	 */
	@Override
	public List sort(List photos) {
		
		List sortedList = photos;
		
		Comparator<Photo> compS = new SortBySize();
		
		Collections.sort(sortedList, compS) ;
		
		
		return sortedList;
		
	}

	/** Compares two photos by their fileSizes
	 * @return a negative integer if first parameter's fileSize before the second parameter's fileSize
	 * a positive integer if first parameter's fileSize after the second parameter's fileSize
	 * 0 if both parameters' fileSizes are the same
	 */
	@Override
	public int compare(Photo o1, Photo o2) {
		
		long photo1 = o1.getFileSize();
		long photo2 = o2.getFileSize();
		
		return Long.compare(photo1, photo2);
	}
}
