package dota;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.json.JSONObject;

public class Abilities implements Cloneable {
	private List<Ability> abilities;
	public static List<String> heroes;
	public static StringBuilder output;
	
	public Abilities() {
		super();
	}
	
	public Abilities(final JSONObject o) throws IOException {
		super();
		abilities = new ArrayList<Ability>();
		output = new StringBuilder();
		if (o == null)
			throw new NullPointerException("Can't copy from a null Abilities object");
		Set<String> key_set = o.getMap().keySet();
		loadinHeroes();
		for (String key : key_set) {
			if (!(o.getMap().get(key) instanceof String)) {
				boolean contained = false;
				String heroname = "";
				for (String hero : heroes) {
					if (key.startsWith(hero)) {
						contained = true;
						heroname = hero;
					}
				}
				if (contained) {
					output.append(HeroAbility.getHeroName(heroname) + ": " + HeroAbility.getSkillName(heroname, key) + "\n");
					abilities.add(new HeroAbility(key, (JSONObject)o.getMap().get(key)));
				} else {
					abilities.add(new Ability(key, (JSONObject)o.getMap().get(key)));									
				}
			} else {		
			}
		}
		writeoutInfo();
	}
	public List<Ability> getAbilities() {
		return abilities;
	}
	public void setAbilities(List<Ability> abilities) {
		this.abilities = abilities;
	}
	/*public void copyAbilities(List<Ability> abilities) {
		this.abilities = new ArrayList<Ability>();
		for (Ability o : abilities)
			this.abilities.add(new Ability(o));
	}*/
	public static void loadinHeroes() throws IOException {
		String file = "Heroes.txt";
		String line;
		InputStream fis = new FileInputStream(file);
		BufferedReader br = new BufferedReader(new InputStreamReader(fis, Charset.forName("UTF-8")));
		heroes = new ArrayList<String>();
		while ((line = br.readLine()) != null) {
		    heroes.add(line);
		}
		// Done with the file
		br.close();		
//		System.out.println(heroes.size());
//		for (String s : heroes)
//			System.out.println(s);	
	}
	
	public static void writeoutInfo() throws IOException {
		FileWriter fw = new FileWriter("temp.txt");
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write(output.toString());
		bw.close();
	}
}
