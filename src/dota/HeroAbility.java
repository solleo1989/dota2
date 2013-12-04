package dota;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.json.JSONObject;

public class HeroAbility extends Ability {
	private String hero_name;
	private static Set<String> redWords = new HashSet<String>(Arrays.asList("the", "of"));
	
	public HeroAbility(String name, JSONObject o) {
		super(name, o);
		for (String hero : Abilities.heroes) {
			if (name.startsWith(hero))
				hero_name = hero;
		}
	}
	public static String getHeroName(String hero) {
		StringBuilder heroname = new StringBuilder();
		String[] parts = hero.split("_");
		for (String part : parts) {
			if (!redWords.contains(part)) {
				heroname.append(" " + part.toUpperCase().charAt(0) + part.substring(1));
			} else {
				heroname.append(" " + part);
			}
		}
		return ">> "+ heroname.toString().trim();
	}
	public static String getSkillName(String hero, String name) {
		String skill = name.substring(hero.length() + 1);
		StringBuilder skillname = new StringBuilder();
		String[] parts = skill.split("_");
		for (String part : parts) {
			if (!redWords.contains(part)) {
				skillname.append(" " + part.toUpperCase().charAt(0) + part.substring(1));
			} else {
				skillname.append(" " + part);
			}
		}
		return skillname.toString().trim();
	}
	
	
}
