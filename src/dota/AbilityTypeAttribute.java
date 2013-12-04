package dota;

import java.util.ArrayList;
import java.util.List;

public class AbilityTypeAttribute extends AbilityAttribute {
	
	private List<String> attribute_values;
	
	public AbilityTypeAttribute(String name, String value) {
		super(name, value);
		String[] values = value.split("\\|");
		attribute_values = new ArrayList<String>();
		for (String s : values) {
			attribute_values.add(s.trim());
		}
		updateOutput(name, value);
	}
	public void updateOutput(String name, String value) {
		StringBuilder output = new StringBuilder(name + ": ");
		String[] values = value.split("\\|");
		for (String s : values) {
			attribute_values.add(s.trim());
			output.append("<" + s.trim() + "> ");
		}
		output.append("\n");
		Abilities.output.append(output);
	}
}
