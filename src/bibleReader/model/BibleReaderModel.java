package bibleReader.model;

import java.util.HashMap;

/**
 * The model of the Bible Reader. It stores the Bibles and has methods for
 * searching for verses based on words or references.
 * 
 * @author Fredrick Ottensmeyer and Grace DuMez, February 20th, 2017
 */
public class BibleReaderModel implements MultiBibleModel {

	// ---------------------------------------------------------------------------

	// One field of type HashMap. This is used to map several Bible Objects to a
	// String.
	private HashMap<String, Bible> bibles;
	private ReferenceList searchField;

	/**
	 * Construction instantiates the field: bibles. The following methods are
	 * for stage 5.
	 */
	public BibleReaderModel() {
		bibles = new HashMap<String, Bible>();
	}

	/**
	 * This method will get all the versions by going into the bibles HashMap
	 * and matching the key (String) and converting the keySet to an Array.
	 * 
	 * @return the String[].
	 */
	@Override
	public String[] getVersions() {
		
		return bibles.keySet().toArray(new String[0]);
	}

	/**
	 * This method will go into the bibles HashMap and get the total number of
	 * keys.
	 * 
	 * @return the size of the keySet(number of versions).
	 */
	@Override
	public int getNumberOfVersions() {
		return bibles.keySet().size();
	}

	/**
	 * This method will go into the bibles HashMap and grab a specific version
	 * of a bible. And store that version in the HashMap.
	 */
	@Override
	public void addBible(Bible bible) {
		bibles.put(bible.getVersion(), bible);
	}

	/**
	 * This method will go into the bibles HashMap and grab a specific version
	 * of a bible.
	 * 
	 * @return the Bible object from the HashMap.
	 */
	@Override
	public Bible getBible(String version) {
		return bibles.get(version);
	}

	/**
	 * This method will create a ReferenceList. Then iterate through the bibles
	 * HashMap Values, and find the "words" the user inputs, as long as it isn't
	 * null. Then store all of the matches to "words" the user inputs into the
	 * Reference List.
	 * 
	 * @return ReferenceList.
	 */
	@Override
	public ReferenceList getReferencesContaining(String words) {

		ReferenceList RL = new ReferenceList();
		for (Bible bible : bibles.values()) {
			if (bible.getReferencesContaining(words) == null) {
				return null;
			} else {
				RL.addAll(bible.getReferencesContaining(words));
			}
		}
		return RL;
	}

	/**
	 *This method will create a new Verse List with the parameters version and empty string("").
	 *Then iterate through the bibles HashMap values, and store the values that match the version
	 *and references the user inputs.  And store those into the verse List.
	 *
	 *@return VerseList
	 */
	@Override
	public VerseList getVerses(String version, ReferenceList references) {

		VerseList VL = new VerseList(version, "");
		for (Bible bible : bibles.values()) {
			if (bible.getVersion() == null) {
				return null;
			} else {
				VL.addAll(bible.getVerses(references));
			}
		}
		return VL;
	}
	// ---------------------------------------------------------------------

	@Override
	public String getText(String version, Reference reference) {
		// TODO Implement me: Stage 7
		return null;
	}

	@Override
	public ReferenceList getReferencesForPassage(String reference) {
		// TODO Implement me: Stage 7
		return null;
	}

	// -----------------------------------------------------------------------------
	// The next set of methods are for use by the getReferencesForPassage method
	// above.
	// After it parses the input string it will call one of these.
	//
	// These methods should be somewhat easy to implement. They are kind of
	// delegate
	// methods in that they call a method on the Bible class to do most of the
	// work.
	// However, they need to do so for every version of the Bible stored in the
	// model.
	// and combine the results.
	//
	// Once you implement one of these, the rest of them should be fairly
	// straightforward.
	// Think before you code, get one to work, and then implement the rest based
	// on
	// that one.
	// -----------------------------------------------------------------------------

	@Override
	public ReferenceList getVerseReferences(BookOfBible book, int chapter, int verse) {
		// TODO Implement me: Stage 7
		return null;
	}

	@Override
	public ReferenceList getPassageReferences(Reference startVerse, Reference endVerse) {
		// TODO Implement me: Stage 7
		return null;
	}

	@Override
	public ReferenceList getBookReferences(BookOfBible book) {
		// TODO Implement me: Stage 7
		return null;
	}

	@Override
	public ReferenceList getChapterReferences(BookOfBible book, int chapter) {
		// TODO Implement me: Stage 7
		return null;
	}

	@Override
	public ReferenceList getChapterReferences(BookOfBible book, int chapter1, int chapter2) {
		// TODO Implement me: Stage 7
		return null;
	}

	@Override
	public ReferenceList getPassageReferences(BookOfBible book, int chapter, int verse1, int verse2) {
		// TODO Implement me: Stage 7
		return null;
	}

	@Override
	public ReferenceList getPassageReferences(BookOfBible book, int chapter1, int verse1, int chapter2, int verse2) {
		// TODO Implement me: Stage 7
		return null;
	}

	// ------------------------------------------------------------------
	// These are the better searching methods.
	//
	@Override
	public ReferenceList getReferencesContainingWord(String word) {
		// TODO Implement me: Stage 12
		return null;
	}

	@Override
	public ReferenceList getReferencesContainingAllWords(String words) {
		// TODO Implement me: Stage 12
		return null;
	}

	@Override
	public ReferenceList getReferencesContainingAllWordsAndPhrases(String words) {
		// TODO Implement me: Stage 12
		return null;
	}
}
