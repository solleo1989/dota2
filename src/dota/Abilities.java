package dota;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.json.JSONObject;

public class Abilities implements Cloneable {
	private List<Ability> abilities;
	
	public Abilities() {
		super();
	}
	public Abilities(final Abilities o) {
		super();
		if (o == null)
			throw new NullPointerException("Can't copy from a null Abilities object");
		if (o.getAbilities() != null)
			this.copyAbilities(o.getAbilities());
			
	}
	public Abilities(final JSONObject o) {
		super();
		if (o == null)
			throw new NullPointerException("Can't copy from a null Abilities object");
		Set<String> key_set = o.getMap().keySet();
		for (String key : key_set) {
			System.out.println(key);
			abilities.add(new Ability(key, (JSONObject)o.getMap().get(key)));
		}
	}
	public List<Ability> getAbilities() {
		return abilities;
	}
	public void setAbilities(List<Ability> abilities) {
		this.abilities = abilities;
	}
	public void copyAbilities(List<Ability> abilities) {
		this.abilities = new ArrayList<Ability>();
		for (Ability o : abilities)
			this.abilities.add(new Ability(o));
	}
	
}
