/**
* Fall 2024 CS 151 Assignment #3
* @author Joyce Liu * @version 1.0 10/25/24 */
import java.awt.event.*;
import java.io.File;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.*;

/**
 * A PhotoAlbumController is a JPanel that contains buttons for 
 * adding, deleting, sorting, and navigating a photo album, responding
 * to user actions and modifies the model
 */
public class PhotoAlbumController extends JPanel {

	private PhotoAlbumModel model;

	/**
	 * Constructs a PhotoAlbumController with a model
	 * @param m - a PhotoAlbumModel
	 */
	public PhotoAlbumController(final PhotoAlbumModel m) {
		model = m;

		JButton addButton = new JButton("Add Photo");
		JButton deleteButton = new JButton("Delete Photo");
		JButton nextButton = new JButton("Next");
		JButton previousButton = new JButton("Previous");
		JButton sortByNameButton = new JButton("Sort By Name");
		JButton sortByDateButton = new JButton("Sort By Date");
		JButton sortBySizeButton = new JButton("Sort By Size");

		add(addButton);
		add(deleteButton);
		add(previousButton);
		add(nextButton);
		add(sortByNameButton);
		add(sortByDateButton);
		add(sortBySizeButton);

		addButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent event) {

				System.out.println("/Users/joyceliu/CS151HW3/cat.jpg");
				JFrame addPopUp = new JFrame("Add Pop-Up");
				String fileName = JOptionPane.showInputDialog(addPopUp,
						"Enter the FILE NAME of the photo you want to add: ", null);
				
				String fileDate = JOptionPane.showInputDialog(addPopUp,
						"Enter the FILE DATE of the photo you want to add (MM/dd/yyyy): ", null);
				DateFormat format = new SimpleDateFormat("MM/dd/yyyy");
				Date date = new Date();
				try {
					date = format.parse(fileDate);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					fileDate = JOptionPane.showInputDialog(addPopUp,
							"Please try again. Enter the FILE DATE of the photo you want to add (MM/dd/yyyy): ", null);
				}
				
				String filePath = JOptionPane.showInputDialog(addPopUp,
						"Enter the FILE PATH of the photo you want to add: ", null);
				long fileSize = 333;
				boolean flag = false;
				while (flag == false) {
					File f = new File(filePath);
					if (!f.exists()) {
						filePath = JOptionPane.showInputDialog(addPopUp,
								"The file path you entered does not exist, please try again. Enter the FILE PATH of the photo you want to add: ",
								null);
					}
					flag = f.exists();
					fileSize = f.length();
				}

				model.addPhoto(new Photo(fileName, filePath, date, fileSize));

				for (Photo p : model.getPhotoList())
					System.out.println(p.getName() + p.getFileSize() + p.getDate());

			}

		});

		deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				JFrame deletePopUp = new JFrame("Delete Pop-Up");

				String fileName = JOptionPane.showInputDialog(deletePopUp,
						"Enter the file name of the photo you want to delete: ", null);

				System.out.println("inpput: " + fileName);
				if (fileName != null) {
					model.deletePhoto(fileName);

//					for (Photo p : model.getPhotoList())
//						System.out.println("124" + p.getName());
				}
			}
		});

		nextButton.addActionListener((event) -> {
			model.incrementIndex();
		});

		previousButton.addActionListener((event) -> {
			model.decrementIndex();
		});

		sortByDateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
//				textField.setText("date button clicked");

				model.setPhotoList(model.sort(new SortByDate()));
				model.setIndex(0);

				for (Photo p : model.sort(new SortByDate())) {
					System.out.println(p.getName() + " " + p.getDate());
				}
				System.out.println();

			}

		});

		sortByNameButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				model.setPhotoList(model.sort(new SortByName()));
				model.setIndex(0);

				for (Photo p : model.sort(new SortByName())) {
					System.out.println(p.getName());
				}
				System.out.println();
			}
		});

		sortBySizeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {

				model.setPhotoList(model.sort(new SortBySize()));
				model.setIndex(0);

				for (Photo p : model.sort(new SortBySize())) {
					System.out.println(p.getName() + " " + p.getFileSize());
				}
				System.out.println();
			}
		});

	}

}
