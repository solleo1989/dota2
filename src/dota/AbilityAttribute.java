package dota;

import org.json.JSONObject;

public class AbilityAttribute {
	private String attribute_name;
	private String attribute_value;

	public AbilityAttribute(String name, String value) {
		this.setAttribute_name(name);
		this.setAttribute_value(value);
		
	}
	
	public AbilityAttribute(JSONObject o) {
		
	}

	public String getAttribute_name() {
		return attribute_name;
	}

	public void setAttribute_name(String attribute_name) {
		this.attribute_name = attribute_name;
	}

	public String getAttribute_value() {
		return attribute_value;
	}

	public void setAttribute_value(String attribute_value) {
		this.attribute_value = attribute_value;
	}
}
