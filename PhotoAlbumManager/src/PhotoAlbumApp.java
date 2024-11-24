/**
* Fall 2024 CS 151 Assignment #3
* @author Joyce Liu * @version 1.0 10/25/24 */
import java.awt.BorderLayout;
import javax.swing.JFrame;

/**
 * A PhotoAlbumApp initializes the main application window and adds all MVC components to a JFrame
 */
public class PhotoAlbumApp {
	
	/**
	 * 
	 * @param args - command line arguments (not used)
	 */
	public static void main(String[] args) {
		PhotoAlbumModel modelPA = new PhotoAlbumModel();
		PhotoAlbumView viewPA = new PhotoAlbumView(modelPA);
		PhotoAlbumController controllerPA = new PhotoAlbumController(modelPA);
		
		JFrame mainApp = new JFrame("Photo Album Manager");
		mainApp.setSize(850,500);
		mainApp.setLayout(new BorderLayout());	
		
        mainApp.add(viewPA, BorderLayout.CENTER);    
        mainApp.add(controllerPA, BorderLayout.SOUTH); 
        
        mainApp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        mainApp.setVisible(true);
		
		
		


	}

}
