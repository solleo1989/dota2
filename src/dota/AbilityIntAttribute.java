package dota;

public class AbilityIntAttribute extends AbilityAttribute {

	private Integer attribute_values;
	
	public AbilityIntAttribute(String name, String value) {
		super(name, value);
		attribute_values = Integer.parseInt(value);
		updateOutput(name, value);
	}
	public void updateOutput(String name, String value) {
		StringBuilder output = new StringBuilder(name + ": ");
		output.append("<" + value + "> \n");
		Abilities.output.append(output);
	}
	
}
