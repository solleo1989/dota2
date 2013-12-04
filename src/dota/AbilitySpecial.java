package dota;

import org.json.JSONObject;

public class AbilitySpecial {
	private String abilit;
	private String value;
	private String level;
	
	public AbilitySpecial() {
		super();
	}
	public AbilitySpecial(String name, JSONObject o) {
		super();
		if (o == null)
			throw new NullPointerException("Cannot create a copy of 'AbilitySpecial' from 'null'.");
		this.setType(o.getType());
		this.setValue(o.getValue());
		this.setLevel(o.getLevel());
	}
	
}
