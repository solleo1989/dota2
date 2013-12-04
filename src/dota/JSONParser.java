package dota;

import java.io.IOException;
import java.util.Set;

import org.json.JSONObject;

public class JSONParser {
	protected Abilities abilities_parser;

	
	@SuppressWarnings("unchecked")
	public JSONParser(JSONObject o) throws IOException {
		Set<String> key_set = o.getMap().keySet();
		String key = "";
		for (String k : key_set) {
			System.out.println(k);
			key = k;
		}
		switch(key) {
			case "DOTAAbilities" :
				abilities_parser = new Abilities((JSONObject)o.getMap().get(key));
				break;
			default : 
				break;
		}
		
	}

}
