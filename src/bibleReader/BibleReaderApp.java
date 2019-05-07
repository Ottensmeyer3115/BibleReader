package bibleReader;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import bibleReader.model.ArrayListBible;
import bibleReader.model.Bible;
import bibleReader.model.BibleReaderModel;
import bibleReader.model.ReferenceList;
import bibleReader.model.VerseList;

/**
 * The main class for the Bible Reader Application.
 * 
 * @author Fredrick Ottensmeyer and Grace DuMez
 */
public class BibleReaderApp extends JFrame {
	
	public static final int width = 600;
	public static final int height = 600;

	public static void main(String[] args) {
		new BibleReaderApp();
	}

	// Fields
	private BibleReaderModel model;
	private ResultView resultView;
	private JTextField searchField;



	/**
	 * Default constructor. Creates the main panel layout which implements the ResultView Layout.
	 */
	public BibleReaderApp() {
		
		model = new BibleReaderModel(); //call the default constructor.
		searchField = new JTextField(10);
										
		File kjvFile = new File("kjv.atv");
		VerseList verses = BibleIO.readBible(kjvFile);

		Bible kjv = new ArrayListBible(verses);

		model.addBible(kjv);

		resultView = new ResultView(model);

		setupGUI();
		pack();
		setSize(width, height);

		// So the application exits when you click the "x".
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	/**
	 * Set up the main GUI. This main GUI uses the ResultView GUI.
	 */
	private void setupGUI() {
		this.setLayout(new BorderLayout());
		JButton searchButton;
		searchButton = new JButton("Search");
		searchButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent s) {
				
				ReferenceList list = model.getReferencesContaining(searchField.getText());
				resultView.displaySearchResults(list, searchField.getText());
			}
				
		});	
		
		Container contents = this.getContentPane();
		JPanel panel = new JPanel();
		contents.add(panel, BorderLayout.SOUTH);
		contents.add(resultView, BorderLayout.CENTER);
		panel.add(searchButton);
		panel.add(searchField);
		this.pack();
		setVisible(true);
		
		
		// TODO textfield and button that allow a word search to be performed: Stage 5
		// TODO Display search results (in the ResulteView): Stage 5

		// The stage numbers below may change, so make sure to pay attention to
		// what the assignment says.
		// TODO Add passage lookup: Stage ?
		// TODO Add 2nd version on display: Stage ?
		// TODO Limit the displayed search results to 20 at a time: Stage ?
		// TODO Add 3rd versions on display: Stage ?
		// TODO Format results better: Stage ?
		// TODO Display cross references for third version: Stage ?
		// TODO Save/load search results: Stage ?
	}

}
