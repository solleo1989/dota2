package dota;

public class AbilityStrAttribute extends AbilityAttribute {
	private String attribute_values;
	
	public AbilityStrAttribute(String name, String value) {
		super(name, value);
		attribute_values = value;
		updateOutput(name, value);
	}
	public void updateOutput(String name, String value) {
		StringBuilder output = new StringBuilder(name + ": ");
		output.append("<" + value + "> \n");
		Abilities.output.append(output);
	}
}
