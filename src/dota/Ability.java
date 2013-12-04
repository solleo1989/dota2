package dota;
//import javax.xml.bind.annotation.XmlAccessType;
//import javax.xml.bind.annotation.XmlAccessorType;
//import javax.xml.bind.annotation.XmlAttribute;
//import javax.xml.bind.annotation.XmlElement;
//import javax.xml.bind.annotation.XmlSeeAlso;
//import javax.xml.bind.annotation.XmlType;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.json.JSONObject;



public class Ability implements Cloneable {
	
	/**
	 * Contents
	 */
	// General
    protected String name;
    protected AbilityIntAttribute id;
    protected AbilityTypeAttribute abilityType; 
    protected AbilityTypeAttribute abilityBehavior;
    protected AbilityLevelBasedAttribute maxLevel;
    protected AbilityStrAttribute hotKeyOverride;
    protected AbilityTypeAttribute abilityUnitTargetTeam;
    protected AbilityTypeAttribute abilityUnitTargetType;
    protected AbilityTypeAttribute abilityUnitTargetFlags;
    protected AbilityLevelBasedAttribute onCastbar;
    protected AbilityLevelBasedAttribute onLearnbar;
    protected AbilityLevelBasedAttribute modelScale;
    protected AbilityTypeAttribute abilityUnitDamageType;
    // Casting
    protected AbilityLevelBasedAttribute abilityCastRange;
    protected AbilityLevelBasedAttribute abilityCastRangeBuffer;
    protected AbilityLevelBasedAttribute abilityCastPoint;
    protected AbilityLevelBasedAttribute abilityChannelTime;
    //Time
    protected AbilityLevelBasedAttribute abilityCooldown;
    protected AbilityLevelBasedAttribute abilityDuration;
    protected AbilityLevelBasedAttribute abilitySharedCooldown;
    // Damage
    protected AbilityLevelBasedAttribute abilityDamage;
    // Cost
    protected AbilityLevelBasedAttribute abilityManaCost;
    // Stats
    protected AbilityLevelBasedAttribute abilityModifierSupportValue;
    protected AbilityLevelBasedAttribute abilityModifierSupportBonus;
    // Special
    protected AbilitySpecial abilitySpecial;
    
    /** 30
     * AbilityBehavior, AbilityCastRangeBuffer, AbilityCastRange,
     * ItemInitialCharges, AbilityDamage, AbilityManaCost, ItemPermanent, ID,
     * AbilityDuration, AbilitySharedCooldown, AbilityChannelTime,
     * ItemCombinable, AbilityCastPoint, ItemShareability, ItemSellable,
     * AbilityType, ItemDisassemblable, ItemRecipe, ItemKillable,
     * AbilityCooldown, ItemRequiresCharges, OnLearnbar, ItemStackable,
     * ItemDeclaresPurchase, OnCastbar, ItemDroppable,
     * AbilityModifierSupportValue, AbilityModifierSupportBonus,
     * ItemPurchasable, ItemCost
     */
    // General
    protected final String ID 								= "ID";
    protected final String ABILITY_TYPE						= "AbilityType";
    protected final String ABILITY_BEHAVIOR 				= "AbilityBehavior";
    protected final String MAX_LEVEL						= "MaxLevel";
    protected final String HOT_KEY_OVERRIDE					= "HotKeyOverride";
    
    // Unite Target
    protected final String ABILITY_UNIT_TARGET_TEAM			= "AbilityUnitTargetTeam";
    protected final String ABILITY_UNIT_TARGET_TYPE			= "AbilityUnitTargetType";
    protected final String ABILITY_UNIT_TARGET_FLAGS 		= "AbilityUnitTargetFlags";
    protected final String ON_CAST_BAR		 				= "OnCastbar";
    protected final String ON_LEARN_BAR						= "OnLearnbar";
    protected final String MODEL_SCALE						= "Modelscale";
    protected final String ABILITY_UNIT_DAMAGE_TYPE			= "AbilityUnitDamageType";
    
    // Casting
    protected final String ABILITY_CAST_RANGE 				= "AbilityCastRange";
    protected final String ABILITY_CAST_RANGE_BUFFER		= "AbilityCastRangeBuffer";
    protected final String ABILITY_CAST_POINT				= "AbilityCastPoint";
    protected final String ABILITY_CHANNEL_TIME				= "AbilityChannelTime";

    // Time
    protected final String ABILITY_COOLDOWN 				= "AbilityCooldown";
    protected final String ABILITY_DURATION					= "AbilityDuration";
    protected final String ABILITY_SHARED_COOLDOWN			= "AbilitySharedCooldown";

    // Damage
    protected final String ABILITY_DAMAGE					= "AbilityDamage";
    
    // Cost
    protected final String ABILITY_MANA_COST 				= "AbilityManaCost";
    
    // Stats
    protected final String ABILITY_MODIFIER_SUPPORT_VALUE	= "AbilityModifierSupportValue";
    protected final String ABILITY_MODIFIER_SUPPORT_BONUS	= "AbilityModifierSupportBonus";
    
    // Special
    protected final String ABILITY_SPECIAL					= "AbilitySpecial";

    // ItemInfo
    protected final String ITEM_COST						= "ItemCost";
    protected final String ITEM_INITIAL_CHARRGES			= "ItemInitialCharges";
    protected final String ITEM_COMBINABLE 					= "ItemCombinable";
    protected final String ITEM_PERMANENT					= "ItemPermanent";
    protected final String ITEM_STACKABLE					= "ItemStackable";
    protected final String ITEM_RECIPE		 				= "ItemRecipe";
    protected final String ITEM_DROPPABLE		 			= "ItemDroppable";
    protected final String ITEM_PURCHASABLE					= "ItemPurchasable";
    protected final String ITEM_SELLABLE	 				= "ItemSellable";
    protected final String ITEM_REQUIRE_CHARGES				= "ItemRequiresCharges";
    protected final String ITEM_KILLABLE	 				= "ItemKillable";
    protected final String ITEM_DISASSEMBLABLE 				= "ItemDisassemblable";
    protected final String ITEM_SHAREABILITY 				= "ItemShareability";
    protected final String ITEM_DECLARES_PURCHASE			= "ItemDeclaresPurchase";

    
    public Ability() {
    	super();
    }
	public Ability(String name, JSONObject o) {
    	super();
    	Map map = o.getMap();
    	Set<String> key_set = map.keySet();
    	List<String> keys = new ArrayList<String>();
    	for (String abiltiy : Abilities.abilitySequence) {
    		if (key_set.contains(abiltiy))
    			keys.add(abiltiy);
    	}
    	
    	Abilities.output.append(">> " + name + "\n");
		for (String key : keys) {
			String value = "";
			if (map.get(key) instanceof String)
				value = (String) map.get(key);
			switch(key) {
				// General
				case ID :
					id = new AbilityIntAttribute(key, value);
					break;
				case ABILITY_TYPE :
					abilityType = new AbilityTypeAttribute(key, value);
					break;
				case ABILITY_BEHAVIOR :
					abilityBehavior = new AbilityTypeAttribute(key, value);
					break;
				case MAX_LEVEL :
					maxLevel = new AbilityLevelBasedAttribute(key, value);
					break;
				case HOT_KEY_OVERRIDE :
					hotKeyOverride = new AbilityStrAttribute(key, value);
					break;
				// Unit Target
				case ABILITY_UNIT_TARGET_TEAM :
					abilityUnitTargetTeam = new AbilityTypeAttribute(key, value);
					break;
				case  ABILITY_UNIT_TARGET_TYPE:
					abilityUnitTargetType = new AbilityTypeAttribute(key, value);
					break;
				case ABILITY_UNIT_TARGET_FLAGS :
					abilityUnitTargetFlags = new AbilityTypeAttribute(key, value);
					break;
				case ON_CAST_BAR :
					onCastbar = new AbilityLevelBasedAttribute(key, value);
					break;
				case ON_LEARN_BAR :
					onLearnbar = new AbilityLevelBasedAttribute(key, value);
					break;
				case MODEL_SCALE :
					modelScale = new AbilityLevelBasedAttribute(key, value);
					break;
				case ABILITY_UNIT_DAMAGE_TYPE :
					abilityUnitDamageType = new AbilityTypeAttribute(key, value);
					break;
				// Casting
				case ABILITY_CAST_RANGE :
					abilityCastRange = new AbilityLevelBasedAttribute(key, value);
					break;
				case ABILITY_CAST_RANGE_BUFFER :
					abilityCastRangeBuffer = new AbilityLevelBasedAttribute(key, value);
					break;
				case ABILITY_CAST_POINT :
					abilityCastPoint = new AbilityLevelBasedAttribute(key, value);
					break;
				case ABILITY_CHANNEL_TIME :
					abilityChannelTime = new AbilityLevelBasedAttribute(key, value);
					break;
				// Time
				case ABILITY_COOLDOWN :
					abilityCooldown = new AbilityLevelBasedAttribute(key, value);
					break;
				case ABILITY_DURATION :
					abilityDuration = new AbilityLevelBasedAttribute(key, value);
					break;
//				case ABILITY_SHARED_COOLDOWN :
//					abilitySharedCooldown = new AbilityLevelBasedAttribute(key, value);
//					break;
				// Damage
				case ABILITY_DAMAGE :
					abilityDamage = new AbilityLevelBasedAttribute(key, value);
					break;
				// Cost
				case ABILITY_MANA_COST :
					abilityManaCost = new AbilityLevelBasedAttribute(key, value);
					break;
				// Stats
				case ABILITY_MODIFIER_SUPPORT_VALUE :
					abilityModifierSupportValue = new AbilityLevelBasedAttribute(key, value);
					break;
				case ABILITY_MODIFIER_SUPPORT_BONUS :
					abilityModifierSupportBonus = new AbilityLevelBasedAttribute(key, value);
					break;
				// Special
				case ABILITY_SPECIAL :
					abilitySpecial = new AbilitySpecial(key, (JSONObject)map.get(key));
					break;
				// ItemInfo
//				case ITEM_COST :
//					break;
//				case ITEM_INITIAL_CHARRGES :
//					break;
//				case ITEM_COMBINABLE :
//					break;
//				case ITEM_PERMANENT :
//					break;
//				case ITEM_STACKABLE :
//					break;
//				case ITEM_RECIPE :
//					break;
//				case ITEM_DROPPABLE :
//					break;
//				case ITEM_PURCHASABLE :
//					break;
//				case ITEM_SELLABLE :
//					break;
//				case ITEM_REQUIRE_CHARGES :
//					break;
//				case ITEM_KILLABLE :
//					break;
//				case ITEM_DISASSEMBLABLE :
//					break;
//				case ITEM_SHAREABILITY :
//					break;
//				case ITEM_DECLARES_PURCHASE :
//					break;
				default : 	
					System.out.println(">> Missing Ability << " + key);
					break;
			}
		}
		Abilities.output.append("\n");
		
    }
	// String name
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
