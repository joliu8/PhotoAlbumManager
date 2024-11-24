/**
* Fall 2024 CS 151 Assignment #3
* @author Joyce Liu * @version 1.0 10/25/24 */
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * A SortByDate Object is a SortingStrategy that uses a Comparator to sort a list of Photos by Date
 */
public class SortByDate implements SortingStrategy, Comparator<Photo>{
	
	/** Returns a List sorted by Date
	 * @return a List sorted by Date
	 */
	@Override
	public List sort(List photos) {
		
		List sortedList = photos;
		
		Comparator<Photo> compD = new SortByDate();
		
		Collections.sort(sortedList, compD) ;
		
		
		return sortedList;
	}
	
	/** Compares two photos by their Dates
	 * @return a negative integer if first parameter's Date is before the second parameter's Date
	 * a positive integer if first parameter's Date is after the second parameter's Date
	 * 0 if both parameters' Dates are the same
	 */
	@Override
	public int compare(Photo o1, Photo o2) {
		return o1.getDate().compareTo(o2.getDate());
	}

}
