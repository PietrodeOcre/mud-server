package mud.modules;

import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import mud.Command;
import mud.MUDObject;
import mud.game.Faction;
import mud.interfaces.GameModule;
import mud.interfaces.Ruleset;
import mud.misc.Currency;
import mud.misc.Slot;
import mud.misc.SlotType;
import mud.misc.SlotTypes;
import mud.objects.Item;
import mud.objects.ItemType;
import mud.objects.ItemTypes;
import mud.objects.Player;
import mud.objects.Thing;
import mud.objects.ThingType;
import mud.objects.ThingTypes;
import mud.rulesets.d20.D20;

public class DND35 implements GameModule {
	private static Map<String, Command> commands;
	private static Map<String, Item> prototypes;
	private static Map<String, Thing> prototypes1;

	private static List<Faction> factions;
	
	public static final Currency COPPER = new Currency("Copper", "cp", null, 1.0);
	public static final Currency SILVER = new Currency("Silver", "sp", COPPER, 100.0);
	public static final Currency GOLD = new Currency("Gold", "gp", SILVER, 100.0);
	public static final Currency PLATINUM = new Currency("Platinum", "pp", GOLD, 100.0);
	
	@Override
	public String getName() {
		return "Dungeons & Dragons 3.5e";
	}

	@Override
	public Integer getVersion() {
		return 0;
	}
	
	@Override
	public boolean hasClasses() {
		return true;
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub

	}

	public void init_player(Player player) {
		// TODO Auto-generated method stub

	}
	
	@Override
	public void PCInit(Player player) {
		// add/initialize slots
		player.addSlot("helmet",   new Slot(SlotTypes.HEAD,   ItemTypes.ARMOR));
		player.addSlot("necklace", new Slot(SlotTypes.NECK,   ItemTypes.NECKLACE));
		player.addSlot("armor",    new Slot(SlotTypes.CHEST,  ItemTypes.ARMOR));
		player.addSlot("cloak",    new Slot(SlotTypes.BACK,   ItemTypes.CLOTHING));
		player.addSlot("ring1",    new Slot(SlotTypes.FINGER, ItemTypes.RING));
		player.addSlot("ring2",    new Slot(SlotTypes.FINGER, ItemTypes.RING));
		player.addSlot("ring3",    new Slot(SlotTypes.FINGER, ItemTypes.RING));
		player.addSlot("ring4",    new Slot(SlotTypes.FINGER, ItemTypes.RING));
		player.addSlot("ring5",    new Slot(SlotTypes.FINGER, ItemTypes.RING));
		player.addSlot("ring6",    new Slot(SlotTypes.FINGER, ItemTypes.RING));
		player.addSlot("gloves",   new Slot(SlotTypes.HANDS,  ItemTypes.CLOTHING));
		player.addSlot("weapon",   new Slot(SlotTypes.RHAND,  ItemTypes.WEAPON, ItemTypes.WAND));
		player.addSlot("weapon1",  new Slot(SlotTypes.LHAND,  ItemTypes.WEAPON, ItemTypes.WAND));
		player.addSlot("weapon2",  new Slot(SlotTypes.HANDS,  ItemTypes.WEAPON));
		player.addSlot("belt",     new Slot(SlotTypes.WAIST,  ItemTypes.CLOTHING));
		player.addSlot("boots",    new Slot(SlotTypes.FEET,   ItemTypes.CLOTHING));
		player.addSlot("other",    new Slot(SlotTypes.NONE,   ItemTypes.NONE ));
	}

	@Override
	public List<Faction> getFactions() {
		// TODO write up a list of factions I can use
		return null;
	}

	@Override
	public Ruleset getRuleset() {
		return D20.getInstance();
	}
	
	@Override
	public ItemType getItemType(final Integer typeId) {
		return ItemTypes.getType(typeId);
	}
	
	public ItemType getItemType(final String typeName) {
		return ItemTypes.getType(typeName);
	}
	
	@Override
	public SlotType getSlotType(final Integer typeId) {
		return SlotTypes.getType(typeId);
	}
	
	@Override
	public SlotType getSlotType(final String typeName) {
		return SlotTypes.getType(typeName);
	}
	
	@Override
	public ThingType getThingType(final Integer typeId) {
		return ThingTypes.getType(typeId);
	}
	
	@Override
	public ThingType getThingType(final String typeName) {
		return ThingTypes.getType(typeName);
	}
	
	@Override
	public Map<String, Item> getItemPrototypes() {
		return null;
	}

	@Override
	public Map<String, Thing> getThingPrototypes() {
		return null;
	}

	@Override
	public Item loadItem(final String itemData) {
		return null;
	}

	@Override
	public Thing loadThing(final String itemData) {
		return null;
	}

	@Override
	public void run() {
	}

	@Override
	public void op(String input, Player player) {
	}

	@Override
	public boolean use(Player p, MUDObject m) {
		return false;
	}

	@Override
	public void test() {
		// TODO Auto-generated method stub
		
	}
}