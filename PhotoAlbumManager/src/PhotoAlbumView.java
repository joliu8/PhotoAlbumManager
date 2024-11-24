/**
* Fall 2024 CS 151 Assignment #3
* @author Joyce Liu * @version 1.0 10/25/24 */
import java.awt.Image;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;

/**
 * A PhotoAlbumView provides a GUI that displays an updated list of photos and the current photo
 */
public class PhotoAlbumView extends JPanel {

	private PhotoAlbumModel model;
	private JPanel mainPanel;
	private JLabel picLabel;
	private JPanel listPanel;
	
	/**
	 * Constructs a PhotoAlbumView with a PhotoAlbumModel 
	 * @param m - a PhotoAlbumModel 
	 */
	public PhotoAlbumView(PhotoAlbumModel m) {

		model = m;

		//class
		ChangeListener listener = new ChangeListener() {
			public void stateChanged(ChangeEvent event) {
				newListItem();
				newPicItem();
				mainPanel.repaint();
				mainPanel.revalidate();
			}
		};

		model.addChangeListener(listener);

		mainPanel = new JPanel();
		listPanel = new JPanel();

		listPanel.setLayout(new BoxLayout(listPanel, 1));

		mainPanel.add(listPanel);

		picLabel = new JLabel();

		mainPanel.add(picLabel);

		add(mainPanel);


	}

	private ImageIcon makeThumbnail(String filePath) {
		return new ImageIcon(new ImageIcon(filePath).getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
	}
	
	DateFormat df = new SimpleDateFormat("MM/dd/yyyy");

	private void newListItem() {
		listPanel.removeAll();
		AlbumIterator iteratorP = model.iterator();
		while (iteratorP.hasNext()) {
			Photo pic = iteratorP.next();
			JLabel dd = new JLabel(pic.getName() + " " + df.format(pic.getDate()) + " (" + pic.getFileSize() + " bytes) ");
			dd.setIcon(makeThumbnail(pic.getFilePath()));
			listPanel.add(dd);
		}
	}

	private ImageIcon makePicView(String filePath) {
		ImageIcon newPic = new ImageIcon(filePath);

		return new ImageIcon(
				new ImageIcon(filePath).getImage().getScaledInstance(500, 400, Image.SCALE_SMOOTH));
	}

	
	private void newPicItem() {
		if (model.getIndex() >= 0) {
			picLabel.setIcon(makePicView(model.getCurrPhoto().getFilePath()));

		}
	}


}

