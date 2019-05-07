package bibleReader.model;

import java.util.ArrayList;

/**
 * A class that stores a version of the Bible.
 * 
 * @author Chuck Cusack (Provided the interface). Modified February 9, 2015.
 * @author Fred Ottensmeyer
 */
public class ArrayListBible implements Bible {

	// The Fields
	private String version;
	private String title;
	private ArrayList<Verse> theVerses;

	/**
	 * Create a new Bible with the given verses.
	 * 
	 * @param version
	 *            the version of the Bible (e.g. ESV, KJV, ASV, NIV).
	 * @param verses
	 *            All of the verses of this version of the Bible.
	 * @Auther: Fred Ottensmeyer
	 */
	public ArrayListBible(VerseList verses) {
		this.theVerses = new ArrayList<Verse>(verses);
		version = verses.getVersion();
		title = verses.getDescription();
	}

	public ArrayListBible(String version, VerseList verses, String theTitle) {
		this.version = version;
		this.theVerses = new ArrayList<Verse>(verses);
		this.title = theTitle;
	}

	@Override
	public int getNumberOfVerses() {
		return theVerses.size();
	}

	@Override
	public String getVersion() {
		return version;
	}

	@Override
	public String getTitle() {
		return title;
	}

	@Override
	public boolean isValid(Reference ref) {
		if(ref.getBookOfBible()== BookOfBible.Dummy){
			return false;
		}
		for (Verse v : theVerses) {
			if (v.getReference().equals(ref)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public String getVerseText(Reference r) {
		for (Verse v : theVerses) {
			if (v.getReference().equals(r)) {
				return v.getText();
			}
		}
		return null;
	}

	@Override
	public Verse getVerse(Reference r) {
		for (Verse v : theVerses) {
			if (v.getReference().equals(r)) {
				return v;
			}
		}
		return null;
	}

	@Override
	public Verse getVerse(BookOfBible book, int chapter, int verse) {
		Reference r = new Reference(book, chapter, verse);
		return getVerse(r);
	}

	// ---------------------------------------------------------------------------------------------
	// The following part of this class should be implemented for stage 4.
	// See the Bible interface for the documentation of these methods.
	// Do not over think these methods. All three should be pretty
	// straightforward to implement.
	// For Stage 8 (give or take a 1 or 2) you will re-implement them so they
	// work better.
	// At that stage you will create another class to facilitate searching and
	// use it here.
	// (Essentially these two methods will be delegate methods.)
	// ---------------------------------------------------------------------------------------------

	@Override
	public VerseList getAllVerses() {
		VerseList v = new VerseList(version, title, theVerses);
		return v;
	}

	@Override
	public VerseList getVersesContaining(String phrase) {
		VerseList VL = new VerseList(version, phrase);
		if (phrase.equals("")) {
			return VL;
		}
		for (Verse v : theVerses) {
			if (v.getText().toLowerCase().contains(phrase.toLowerCase())) {
				VL.add(v);
			}
		}
		return VL;
	}

	@Override
	public ReferenceList getReferencesContaining(String phrase) {
		ReferenceList RL = new ReferenceList();
		if (phrase.equals("")) {
			return RL;
		}
		for (Verse v : theVerses) {
			if (v.getText().toLowerCase().contains(phrase.toLowerCase())) {
				RL.add(v.getReference());
			}
		}
		return RL;
	}

	@Override
	public VerseList getVerses(ReferenceList references) {
		VerseList VL = new VerseList(version, "");
		for (Reference r : references) {
			VL.add(getVerse(r));
		}
		return VL;
	}
	// ---------------------------------------------------------------------------------------------
	// The following part of this class should be implemented for Stage 7.
	//
	// HINT: Do not reinvent the wheel. Some of these methods can be implemented
	// by looking up
	// one or two things and calling another method to do the bulk of the work.
	// ---------------------------------------------------------------------------------------------

	@Override
	public int getLastVerseNumber(BookOfBible book, int chapter) {
		// TODO Implement me: Stage 7
		return -1;
	}

	@Override
	public int getLastChapterNumber(BookOfBible book) {
		// TODO Implement me: Stage 7
		return -1;
	}

	@Override
	public ReferenceList getReferencesInclusive(Reference firstVerse, Reference lastVerse) {
		// TODO Implement me: Stage 7
		return null;
	}

	@Override
	public ReferenceList getReferencesExclusive(Reference firstVerse, Reference lastVerse) {
		// TODO Implement me: Stage 7
		return null;
	}

	@Override
	public ReferenceList getReferencesForBook(BookOfBible book) {
		// TODO Implement me: Stage 7
		return null;
	}

	@Override
	public ReferenceList getReferencesForChapter(BookOfBible book, int chapter) {
		// TODO Implement me: Stage 7
		return null;
	}

	@Override
	public ReferenceList getReferencesForChapters(BookOfBible book, int chapter1, int chapter2) {
		// TODO Implement me: Stage 7
		return null;
	}

	@Override
	public ReferenceList getReferencesForPassage(BookOfBible book, int chapter, int verse1, int verse2) {
		// TODO Implement me: Stage 7
		return null;
	}

	@Override
	public ReferenceList getReferencesForPassage(BookOfBible book, int chapter1, int verse1, int chapter2, int verse2) {
		// TODO Implement me: Stage 7
		return null;
	}

	@Override
	public VerseList getVersesInclusive(Reference firstVerse, Reference lastVerse) {
		// TODO Implement me: Stage 7
		return null;
	}

	@Override
	public VerseList getVersesExclusive(Reference firstVerse, Reference lastVerse) {
		// TODO Implement me: Stage 7
		return null;
	}

	@Override
	public VerseList getBook(BookOfBible book) {
		// TODO Implement me: Stage 7
		return null;
	}

	@Override
	public VerseList getChapter(BookOfBible book, int chapter) {
		// TODO Implement me: Stage 7
		return null;
	}

	@Override
	public VerseList getChapters(BookOfBible book, int chapter1, int chapter2) {
		// TODO Implement me: Stage 7
		return null;
	}

	@Override
	public VerseList getPassage(BookOfBible book, int chapter, int verse1, int verse2) {
		// TODO Implement me: Stage 7
		return null;
	}

	@Override
	public VerseList getPassage(BookOfBible book, int chapter1, int verse1, int chapter2, int verse2) {
		// TODO Implement me: Stage 7
		return null;
	}
}
