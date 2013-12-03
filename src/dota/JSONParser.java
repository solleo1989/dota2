package dota;

import java.util.Set;

import org.json.JSONObject;

public class JSONParser {
	protected Abilities abilities_parser;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	@SuppressWarnings("unchecked")
	public JSONParser(JSONObject o) {
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
