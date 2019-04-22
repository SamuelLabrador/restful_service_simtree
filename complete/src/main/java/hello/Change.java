package hello;

public class Change {
	private final String target; // String to find
	private final String replacement; // What to replace String with

	public Change(String target, String replacement){
		this.target = target;
		this.replacement = replacement;
	}

	public String getTarget(){
		return target;
	}

	public String getReplacement(){
		return replacement;
	}

}