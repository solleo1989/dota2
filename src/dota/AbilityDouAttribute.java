package dota;

public class AbilityDouAttribute extends AbilityAttribute {
	private Double attribute_values;
	
	public AbilityDouAttribute(String name, String value) {
		super(name, value);
		attribute_values = Double.parseDouble(value);
		updateOutput(name, value);
	}
	public void updateOutput(String name, String value) {
		StringBuilder output = new StringBuilder(name + ": ");
		output.append("<" + value + "> \n");
		Abilities.output.append(output);
	}
}
