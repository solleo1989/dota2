package dota;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.json.JSONObject;

public class AbilitySpecial {
	private List<AbilitySpecialAttribute> ability_special_attributes;
	
	public AbilitySpecial() {
		super();
	}
	public AbilitySpecial(String name, JSONObject o) {
		super();
		if (o == null)
			throw new NullPointerException("Cannot create a copy of 'AbilitySpecial' from 'null'.");
		Set<String> key_set = o.getMap().keySet();
		Map map = o.getMap();
		Abilities.output.append(name + "\n");
		ability_special_attributes = new ArrayList<AbilitySpecialAttribute>();
		List<String> keys = new ArrayList<String>(key_set);
		Collections.sort(keys);
		for (String key : keys) {
			ability_special_attributes.add(new AbilitySpecialAttribute((JSONObject) map.get(key)));
			
		}
	}
	
}
