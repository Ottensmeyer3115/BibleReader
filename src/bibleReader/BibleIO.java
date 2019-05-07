package bibleReader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import bibleReader.model.Bible;
import bibleReader.model.BookOfBible;
import bibleReader.model.Verse;
import bibleReader.model.VerseList;

/**
 * A utility class that has useful methods to read/write Bibles and Verses.
 * 
 * @author Fred Ottensmeyer
 */
public class BibleIO {

	/**
	 * Read in a file and create a Bible object from it and return it.
	 * 
	 * @param bibleFile
	 * @return
	 */
	public static VerseList readBible(File bibleFile) {
		String name = bibleFile.getName();
		String extension = name.substring(name.lastIndexOf('.') + 1, name.length());

		// Call the read method based on the file type.
		if ("atv".equals(extension.toLowerCase())) {
			return readATV(bibleFile);
		} else if ("xmv".equals(extension.toLowerCase())) {
			return readXMV(bibleFile);
		} else {
			return null;
		}
	}

	/**
	 * Read in a Bible that is saved in the "ATV" format. The format is
	 * described below.
	 * 
	 * @param bibleFile
	 *            The file containing a Bible with .atv extension.
	 * @return A Bible object constructed from the file bibleFile, or null if
	 *         there was an error reading the file.
	 */
	private static VerseList readATV(File bibleFile) {
		VerseList v = null;
		try {
			FileReader FR = new FileReader(bibleFile);
			BufferedReader BR = new BufferedReader(FR);
			String line = BR.readLine();
			if (line.length() == 0) {
				v = new VerseList("unknown", "");
			} else {
				if (line.contains(": ")) {
					String[] L = line.split(": ");
					if (L.length == 1) {
						v = new VerseList(L[0], "");
					} else if (L.length < 1) {
						return null;
					}
					v = new VerseList(L[0], L[1]);
				} else {
				  v = new VerseList(line, "");
				}
			}

			line = BR.readLine();
			while (line != null) {
				String[] parts = line.split("@");
				if (parts.length < 3) {
					return null;
				}
				BookOfBible book = BookOfBible.getBookOfBible(parts[0]);
				if (book == null) {
					return null;
				}
				String[] CV = parts[1].split(":");
				if (CV.length < 2) {
					return null;
				}
				int chapter = Integer.parseInt(CV[0]);
				int verse = Integer.parseInt(CV[1]);
				// make a new verse object, and add it to the list.
				Verse vers = new Verse(book, chapter, verse, parts[2]);
				v.add(vers);
				line = BR.readLine();

			}
		} catch (IOException e) {
			return null;
		}
		return v;
	}

	/**
	 * Read in the Bible that is stored in the XMV format.
	 * 
	 * @param bibleFile
	 *            The file containing a Bible with .xmv extension.
	 * @return A Bible object constructed from the file bibleFile, or null if
	 *         there was an error reading the file.
	 */
	private static VerseList readXMV(File bibleFile) {
		// TODO Implement me: Stage 8

		// The XMV is sort of XML-like, but it doesn't have end tags.
		// No description of the file format is given here.
		// You need to look at the file to determine how it should be parsed.

		// TODO Documentation: Stage 8 (Update the Javadoc comment to describe
		// the format of the file.)
		return null;
	}

	// Note: In the following methods, we should really ensure that the file
	// extension is correct
	// (i.e. it should be ".atv"). However for now we won't worry about it.
	// Hopefully the GUI code
	// will be written in such a way that it will require the extension to be
	// correct if we are
	// concerned about it.

	/**
	 * Write out the Bible in the ATV format.
	 * 
	 * @param file
	 *            The file that the Bible should be written to.
	 * @param bible
	 *            The Bible that will be written to the file.
	 */
	public static void writeBibleATV(File file, Bible bible) {
		// TODO Implement me: Stage 8
		// Don't forget to write the first line of the file.
		// HINT: This and the next method are very similar. It seems like you
		// might be
		// able to implement one of them and then call it from the other one.
	}

	/**
	 * Write out the given verses in the ATV format, using the description as
	 * the first line of the file.
	 * 
	 * @param file
	 *            The file that the Bible should be written to.
	 * @param description
	 *            The contents that will be placed on the first line of the
	 *            file, formatted appropriately.
	 * @param verses
	 *            The verses that will be written to the file.
	 */
	public static void writeVersesATV(File file, String description, VerseList verses) {
		// TODO Implement me: Stage 8
	}

	/**
	 * Write the string out to the given file. It is presumed that the string is
	 * an HTML rendering of some verses, but really it can be anything.
	 * 
	 * @param file
	 * @param text
	 */
	public static void writeText(File file, String text) {
		// TODO Implement me: Stage 8
		// This one should be really simple.
		// My version is 4 lines of code (not counting the try/catch code).
	}
}
