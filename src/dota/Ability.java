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
    protected String name;
    protected AbilityTypeAttribute abilityBehavior;
    protected AbilityTypeAttribute abilityUnitTargetType;
    protected AbilityTypeAttribute abilityUnitDamageType;
    protected AbilityTypeAttribute abilityUnitTargetTeam;
    protected AbilityTypeAttribute abilityUnitTargetFlags;
    protected AbilityTypeAttribute abilityType; 
    
    protected AbilityLevelBasedAttribute abilityCastRange;
    protected AbilityLevelBasedAttribute abilityCastRangeBuffer;
    protected AbilityLevelBasedAttribute abilityManaCost;
    protected AbilityLevelBasedAttribute abilityCastPoint;
    protected AbilityLevelBasedAttribute abilityDamage;
    protected AbilityLevelBasedAttribute abilityCooldown;
    protected AbilityLevelBasedAttribute abilityDuration;
    
    protected AbilityLevelBasedAttribute abilityChannelTime;

    protected List<AbilityLevelBasedType> channelTime;
    protected List<AbilityLevelBasedType> duration;
    protected List<AbilityLevelBasedType> damage;
    protected List<AbilitySpecial> special;
    
    protected AbilityIntAttribute id;
    protected AbilityIntAttribute onCastbar;
    protected AbilityIntAttribute onLearnbar;
    
    protected AbilityIntAttribute maxLevel;
    protected AbilityStrAttribute hotKeyOverride;
    protected AbilityDouAttribute abilityModifierSupportValue;
    protected AbilityIntAttribute abilityModifierSupportBonus;
    
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
    protected final String ABILITY_BEHAVIOR 				= "AbilityBehavior";
    protected final String ABILITY_CAST_RANGE_BUFFER		= "AbilityCastRangeBuffer";
    protected final String ABILITY_CAST_RANGE 				= "AbilityCastRange";
    protected final String ITEM_INITIAL_CHARRGES			= "ItemInitialCharges";
    protected final String ABILITY_DAMAGE					= "AbilityDamage";
    protected final String ABILITY_MANA_COST 				= "AbilityManaCost";
    protected final String ITEM_PERMANENT					= "ItemPermanent";
    protected final String ID 								= "ID";
    protected final String ABILITY_DURATION					= "AbilityDuration";
    protected final String ABILITY_SHARED_COOLDOWN			= "AbilitySharedCooldown";
    protected final String ABILITY_CHANNEL_TIME				= "AbilityChannelTime";
    protected final String ITEM_COMBINABLE 					= "ItemCombinable";
    protected final String ABILITY_CAST_POINT				= "AbilityCastPoint";
    protected final String ITEM_SHAREABILITY 				= "ItemShareability";
    protected final String ITEM_SELLABLE	 				= "ItemSellable";
    protected final String ABILITY_TYPE						= "AbilityType";
    protected final String ITEM_DISASSEMBLABLE 				= "ItemDisassemblable";
    protected final String ITEM_RECIPE		 				= "ItemRecipe";
    protected final String ITEM_KILLABLE	 				= "ItemKillable";
    protected final String ABILITY_COOLDOWN 				= "AbilityCooldown";
    protected final String ITEM_REQUIRE_CHARGES				= "ItemRequiresCharges";
    protected final String ON_LEARN_BAR						= "OnLearnbar";
    protected final String ITEM_STACKABLE					= "ItemStackable";
    protected final String ITEM_DECLARES_PURCHASE			= "ItemDeclaresPurchase";
    protected final String ON_CAST_BAR		 				= "OnCastbar";
    protected final String ITEM_DROPPABLE		 			= "ItemDroppable";
    protected final String ABILITY_MODIFIER_SUPPORT_VALUE	= "AbilityModifierSupportValue";
    protected final String ABILITY_MODIFIER_SUPPORT_BONUS	= "AbilityModifierSupportBonus";
    protected final String ITEM_PURCHASABLE					= "ItemPurchasable";
    protected final String ITEM_COST						= "ItemCost";
    
    protected final String ABILITY_UNIT_DAMAGE_TYPE			= "AbilityUnitDamageType";
    protected final String ABILITY_UNIT_TARGET_TYPE			= "AbilityUnitTargetType";
    protected final String ABILITY_UNIT_TARGET_TEAM			= "AbilityUnitTargetTeam";
    protected final String ABILITY_UNIT_TARGET_FLAGS 		= "AbilityUnitTargetFlags";
    protected final String ABILITY_SPECIAL					= "AbilitySpecial";
    
    protected final String HOT_KEY_OVERRIDE					= "HotKeyOverride";
    protected final String MAX_LEVEL						= "MaxLevel";
    protected final String MODEL_SCALE						= "Modelscale";
    
    
    public Set<String> rest ;
    
    
    public Ability() {
    	super();
    }
	public Ability(String name, JSONObject o) {
    	super();
    	Map map = o.getMap();
    	Set<String> key_set = map.keySet();
    	rest = new HashSet<String>();
   
    	Abilities.output.append(">> " + name + "\n");
		for (String key : key_set) {
			String value = "";
			if (map.get(key) instanceof String)
				value = (String) map.get(key);
			switch(key) {
				case ABILITY_BEHAVIOR :
					abilityBehavior = new AbilityTypeAttribute(key, value);
					break;
				case ABILITY_CAST_RANGE_BUFFER :
					abilityCastRangeBuffer = new AbilityLevelBasedAttribute(key, value);
					break;
				case ABILITY_CAST_RANGE :
					abilityCastRange = new AbilityLevelBasedAttribute(key, value);
					break;
//				case ITEM_INITIAL_CHARRGES :
//					break;
				case ABILITY_DAMAGE :
					abilityDamage = new AbilityLevelBasedAttribute(key, value);
					break;
				case ABILITY_MANA_COST :
					abilityManaCost = new AbilityLevelBasedAttribute(key, value);
					break;
//				case ITEM_PERMANENT :
//					break;
				case ID :
					id = new AbilityIntAttribute(key, value);
					break;
				case ABILITY_DURATION :
					abilityDuration = new AbilityLevelBasedAttribute(key, value);
					break;
//				case ABILITY_SHARED_COOLDOWN :
//					break;
				case ABILITY_CHANNEL_TIME :
					abilityChannelTime = new AbilityLevelBasedAttribute(key, value);
					break;
//				case ITEM_COMBINABLE :
//					break;
				case ABILITY_CAST_POINT :
					abilityCastPoint = new AbilityLevelBasedAttribute(key, value);
					break;
//				case ITEM_SHAREABILITY :
//					break;
//				case ITEM_SELLABLE :
//					break;
				case ABILITY_TYPE :
					abilityType = new AbilityTypeAttribute(key, value);
					break;
//				case ITEM_DISASSEMBLABLE :
//					break;
//				case ITEM_RECIPE :
//					break;
//				case ITEM_KILLABLE :
//					break;
				case ABILITY_COOLDOWN :
					abilityCooldown = new AbilityLevelBasedAttribute(key, value);
					break;
//				case ITEM_REQUIRE_CHARGES :
//					break;
				case ON_LEARN_BAR :
					onLearnbar = new AbilityIntAttribute(key, value);
					break;
//				case ITEM_STACKABLE :
//					break;
//				case ITEM_DECLARES_PURCHASE :
//					break;
				case ON_CAST_BAR :
					onCastbar = new AbilityIntAttribute(key, value);
					break;
//				case ITEM_DROPPABLE :
//					break;
				case ABILITY_MODIFIER_SUPPORT_VALUE :
					abilityModifierSupportValue = new AbilityDouAttribute(key, value);
					break;
				case ABILITY_MODIFIER_SUPPORT_BONUS :
					abilityModifierSupportBonus = new AbilityIntAttribute(key, value);
					break;
//				case ITEM_PURCHASABLE :
//					break;
//				case ITEM_COST :
//					break;
				case ABILITY_UNIT_DAMAGE_TYPE :
					abilityUnitDamageType = new AbilityTypeAttribute(key, value);
					break;
				case  ABILITY_UNIT_TARGET_TYPE:
					abilityUnitTargetType = new AbilityTypeAttribute(key, value);
					break;
				case ABILITY_UNIT_TARGET_TEAM :
					abilityUnitTargetTeam = new AbilityTypeAttribute(key, value);
					break;
				case ABILITY_UNIT_TARGET_FLAGS :
					abilityUnitTargetFlags = new AbilityTypeAttribute(key, value);
					break;
				case ABILITY_SPECIAL :
					abilitySpecial = new AbilitySpecial(key, (JSONObject)map.get(key)):
					break;
				case HOT_KEY_OVERRIDE :
					hotKeyOverride = new AbilityStrAttribute(key, value);
					break;
				case MAX_LEVEL :
					maxLevel = new AbilityIntAttribute(key, value);
					break;
//				case MODEL_SCALE :
//					break;
					
				default : 	
					rest.add(key);
					System.out.println(">> " + key);
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
