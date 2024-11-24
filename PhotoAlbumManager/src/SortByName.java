/**
* Fall 2024 CS 151 Assignment #3
* @author Joyce Liu * @version 1.0 10/25/24 */
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * A SortByName Object is a SortingStrategy that uses a Comparator to sort a list of Photos by name
 */
public class SortByName implements SortingStrategy, Comparator<Photo>{
	
	/** Returns a List sorted by Name
	 * @return a List sorted by Name
	 */
	@Override
	public List sort(List photos) {
		
		List sortedList = photos;
		
		Comparator<Photo> compN = new SortByName();
		
		Collections.sort(sortedList, compN) ;
		
		return sortedList;
		
	}
	

	/** Compares two photos by their names
	 * @return a negative integer if first parameter's name is alphabetically before the second parameter's name
	 * a positive integer if first parameter's name is alphabetically after the second parameter's name
	 * 0 if both parameters' names are the same
	 */
	@Override
	public int compare(Photo o1, Photo o2) {
		return o1.getName().compareTo(o2.getName());
	}

}
