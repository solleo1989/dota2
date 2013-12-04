package dota;

import java.util.ArrayList;
import java.util.List;;

public class AbilityLevelBasedAttribute extends AbilityAttribute {
	
	private List<Double> attribute_values;
	
	public AbilityLevelBasedAttribute(String name, String value) {
		super(name, value);
		attribute_values = new ArrayList<Double>();
		String[] values = value.split(" ");
		StringBuilder output = new StringBuilder(name + ": ");
		for (String s : values) {
			attribute_values.add(Double.parseDouble(s));
		}
		updateOutput(name, value);
	}
	public void updateOutput(String name, String value) {
		StringBuilder output = new StringBuilder(name + ": ");
		String[] values = value.split(" ");
		for (String s : values) {
			output.append("<" + Double.parseDouble(s) + "> ");
		}
		output.append("\n");
		Abilities.output.append(output);
	}
}
