package song;

public class Song {

	String title;
	String interpreter;
	String genre;

	public Song(String title, String interpreter) {
		this.title = title;
		this.interpreter = interpreter;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getInterpreter() {
		return interpreter;
	}

	public void setInterpreter(String interpreter) {
		this.interpreter = interpreter;
	}
}
