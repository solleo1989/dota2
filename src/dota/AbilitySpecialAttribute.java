package dota;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.json.JSONObject;

public class AbilitySpecialAttribute extends AbilityAttribute {
	
	private String attribute_type;
	private String attribute_levelkey;
	private List<Double> attribute_values;
	
	public AbilitySpecialAttribute(String name, String value) {
		super(name, value);
	}
	public AbilitySpecialAttribute(JSONObject o) {
		super(o);
		Map map = o.getMap();
		Set<String> key_set = o.getMap().keySet();
		for (String key : key_set) {
			String value = (String) map.get(key);
			if (key.equals("var_type")) {
				attribute_type = value;
			} else if (key.equals("levelkey")) { 
				attribute_levelkey = value;
			} else {
				this.setAttribute_name(key);
				this.setAttribute_value(value);
				attribute_values = new ArrayList<Double>();
				String[] values = value.split(" ");
				StringBuilder output = new StringBuilder(key + ": ");
				for (String s : values) {
					attribute_values.add(Double.parseDouble(s));
				}
			}
		}
		String name = this.getAttribute_name();
		String value = this.getAttribute_value();
		updateOutput(name, value, attribute_type);
		
	}

	public void updateOutput(String name, String value, String type) {
		StringBuilder output = new StringBuilder("\t" + name + "<" + type + ">: ");
		String[] values = value.split(" ");
		for (String s : values) {
			output.append("<" + Double.parseDouble(s) + "> ");
		}
		output.append("\n");
		Abilities.output.append(output);
	}

}
