/**
* Fall 2024 CS 151 Assignment #3
* @author Joyce Liu * @version 1.0 10/25/24 */
import java.util.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * A PhotoAlbumModel represents the photo collection and the current state of the album
 * and notifies the view when there are changes.
 */
public class PhotoAlbumModel {

	private ArrayList<Photo> photoList;

	private ArrayList<ChangeListener> photoAlbumViewListeners;

	private int currentIndex;

	/**
	 * Constructs a PhotoAlbumModel with an ArrayList of Photos, ArrayList of ChangeListeners, and an index
	 */
	public PhotoAlbumModel() {
		photoList = new ArrayList<>();
		photoAlbumViewListeners = new ArrayList<>();
		currentIndex = 0;
	}
	
	/**
	 * Returns the newest Photo in the photoList
	 * @return the last Photo in photoList
	 */
	public Photo getLastPhoto() {
		return photoList.get(photoList.size()-1);
	}

	/**
	 * Returns the current Photo in the photoList
	 * @return the current Photo in photoList
	 */
	public Photo getCurrPhoto() {
		if (currentIndex >= 0)
			return photoList.get(currentIndex);
		else
			return null;
	}

	/**
	 * Returns the current index
	 * @return the current index
	 */
	public int getIndex() {
		return currentIndex;
	}

	/**
	 * Increases the current index by 1
	 */
	public void incrementIndex() {
		if (currentIndex + 1 < photoList.size()) {
			currentIndex += 1;
			currentIndex = currentIndex % photoList.size();
		} else {
			System.out.println("invalid incrementing index");
		}
		ChangeEvent added = new ChangeEvent(this);
		for (ChangeListener listener : photoAlbumViewListeners) {
			listener.stateChanged(added);
		}
	}

	/**
	 * Decreases the current index by 1
	 */
	public void decrementIndex() {
		if (photoList.size() > 1) {
			currentIndex -= 1;
			currentIndex = currentIndex % photoList.size();
		} else {
			System.out.println("invalid decrementing index");
		}
		
		ChangeEvent added = new ChangeEvent(this);
		for (ChangeListener listener : photoAlbumViewListeners) {
			listener.stateChanged(added);
		}
	}

	/**
	 * Returns the list of photos in the photo album
	 * @return the ArrayList, photoList, containing all the photos 
	 */
	public ArrayList<Photo> getPhotoList() {
		return photoList;
	}

	/**
	 * Returns a sorted ArrayList of Photos
	 * @param ss - a SortingStrategy that will be used to sort the ArrayList of Photos
	 * @return a sorted ArrayList of Photos
	 */
	public ArrayList<Photo> sort(SortingStrategy ss) {

		return (ArrayList) ss.sort(photoList);
	}

	/**
	 * Sets the list of photos to another list
	 * @param photos - A List of Photos 
	 * precondition: photos should be a list of Photos
	 */ 
	
	public void setPhotoList(List photos) {
		photoList = (ArrayList<Photo>) photos;
		
		ChangeEvent added = new ChangeEvent(this);
		for (ChangeListener listener : photoAlbumViewListeners) {
			listener.stateChanged(added);
		}

	}
	
	/**
	 * Sets the currentIndex to index
	 * @param index - an integer index
	 */
	public void setIndex(int index) {
		currentIndex = index;
	}


	/**
	 * Adds a Photo to the photo album
	 * @param p - a new Photo
	 */
	public void addPhoto(Photo p) {

		photoList.add(p);
		photoList.sort(new SortByDate());

		System.out.println("model addphoto");

		ChangeEvent added = new ChangeEvent(this);
		for (ChangeListener listener : photoAlbumViewListeners) {
			listener.stateChanged(added);
		}
		

	}
	
	/**
	 * Deletes a Photo in the photo album
	 * @param name - the name of the Photo to be deleted
	 */
	public void deletePhoto(String name) {
		for(int i =0; i<photoList.size(); i++) {
			if(photoList.get(i).getName().equals(name)) {
				photoList.remove(i);
				if(currentIndex < i) {
					currentIndex--;
				}
			}
			if(i == currentIndex && photoList.size() > 0) {
				currentIndex = 0;
			}
		}

		// notify all view's listener w/ loop
		ChangeEvent deleted = new ChangeEvent(this);
		for (ChangeListener listener : photoAlbumViewListeners) {
			listener.stateChanged(deleted);

		}

	}

	/**
	 * Adds a ChangeListener to an ArrayList of ChangeListeners
	 * @param cl - a ChangeListener to be added to photoAlbumViewListeners
	 */
	public void addChangeListener(ChangeListener cl) { // attach view's listener
		photoAlbumViewListeners.add(cl);

	}

	/**
	 * Returns a MyIterator object
	 * @return a MyIterator object
	 */
	public MyIterator iterator() {
		return new MyIterator();

	}
	
	/**
	 * A MyIterator is an AlbumIterator that allows for photos in the album to be iterated over
	 */
	public class MyIterator implements AlbumIterator{
		
		private int current = 0;
		
			public boolean hasNext() {
				return current < photoList.size();
			}

			public Photo next() {
				return photoList.get(current++);
			}

			public void remove(String name) {
				if (next().getName().equals(name)) {
					photoList.remove(current);
				}
			}

	}
	

}
