package bibleReader;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JEditorPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import bibleReader.model.BibleReaderModel;
import bibleReader.model.ReferenceList;
import bibleReader.model.Reference;
import bibleReader.model.Verse;
import bibleReader.model.VerseList;

/**
 * The display panel for the Bible Reader.
 * 
 * @author Fredrick Ottensmeyer and Grace DuMez
 */
public class ResultView extends JPanel {

	JScrollPane scrollPane;
	JTextArea textArea;
	JEditorPane editorPane;
	JTextField resultsField;
	BibleReaderModel bibleModel = new BibleReaderModel(); 

	// You will probably want to use a JScrollPane and JTextArea or JEditorPane
	// for this, possibly in addition to some textfields, etc.
	// JEditorPanes can be set up to display simple HTML, which will come
	// in handy in future stages, so you might look into this.

	/**
	 * Construct a new ResultView and set its model to myModel. It needs to
	 * model to look things up.
	 * 
	 * @param myModel
	 *            The model this view will access to get information.
	 */
	public ResultView(BibleReaderModel myModel) {
		
		this.bibleModel = myModel;
		setResults();
	}

	/**
	 * This method will create a new EditorPane and ScrollPane.  
	 * and place the Scroll Pane onto the editor Pane.  And set the two panes
	 * making them visible on the content window on the BibleReaderApp.
	 */
	public void setResults() {
		setLayout(new BorderLayout(10, 10));

		editorPane = new JEditorPane();
		editorPane.setContentType("text/html");

		scrollPane = new JScrollPane(editorPane);
		scrollPane.setPreferredSize(new Dimension(600, 300));

		resultsField = new JTextField(50);

		// scrollPane.add(editorPane);
		this.add(resultsField);
		this.add(scrollPane);

	}

	/**
	 * This is the action GUI method.  This will create and set up the table.
	 * As well as get into the BibleReaderModel to retrieve the: Version, Text, and Reference.
	 * And set them up in a consistent ordering that the user can read.
	 * 
	 * @param references
	 * @param text
	 */
	public void displaySearchResults(ReferenceList references, String text) {
		StringBuffer buffer = new StringBuffer();
		if (references.isEmpty()) {
			buffer.append("No results were found");
		} else {
			buffer.append("<table>");
			buffer.append("<tr>");
			buffer.append("<td valign='top' width='100'>" + "Verse" + "</td><td>" + "KJV" + "</td></tr>");

			// for (String version : bibleModel.getVersions()){
			// buffer.append("<th>");
			// buffer.append(version);
			// buffer.append("<th>");
			// }
			VerseList verses = bibleModel.getVerses("KJV", references);
			// -> Verse List of references
			// Verses v : ^ v.getText
			for (Verse v : verses) {
				buffer.append("<tr>");
				buffer.append("<td valign='top'>" + v.getReference() + "</td>");
				buffer.append("<td>" + v.getText() + "</td>");

			}
			// buffer.append(r.toString());
		}
		editorPane.setText(buffer.toString());

	}

}
