package myclassproject.mystorygraph;

import com.entities.*;
import com.enums.FurnitureTypes;
import com.enums.ItemTypes;
import com.enums.PlaceTypes;

public final class MyStoryEntities {
	//Create an instance of Character, Place, Furniture, and Item classes 
	//for each of the characters, places, furniture, and items in your story
	//Make that instance public static final
	//e.g. public static final Characters player = new Characters("Player", BodyTypes.D, Clothing.Peasant, HairStyle.Short, Colors.Black, 6);
	//You can access these instances in your EdgeBuilder and NodeBuilder classes by importing:
	//import static myclassproject.mystorygraph.MyStoryEntities.*;
	public static final Item ChickenLeg = new Item("Chicken Leg",ItemTypes.ChickenLeg);
	public static final Item BlueKey = new Item("Manor Key",ItemTypes.BlueKey);
	public static final Item BlueBook = new Item("Journal",ItemTypes.BlueBook);
	public static final Item RedPotion = new Item("Pink Ink Vial",ItemTypes.RedPotion);
	public static final Item PurpleCloth = new Item("Bloody Rags",ItemTypes.PurpleCloth);
	public static final Item Skull = new Item("Skull",ItemTypes.Skull);
	public static final Item Sword = new Item("Sword",ItemTypes.Sword);
	public static final Place CastleCrossroads = new Place("Outdoors",PlaceTypes.CastleCrossroads);
	public static final Place GreatHall = new Place("Manor",PlaceTypes.GreatHall);
	public static final Place DiningRoom = new Place("Dining Room",PlaceTypes.DiningRoom);
	public static final Place CastleBedroom = new Place("Master Bedroom",PlaceTypes.CastleBedroom);
	public static final Place Cottage = new Place("Laundry Room",PlaceTypes.Cottage);
	public static final Furniture Door = new Furniture(CastleCrossroads,FurnitureTypes.Door);
	public static final Furniture ManorDoor = new Furniture(GreatHall,FurnitureTypes.Door);
	public static final Furniture DinerDoor = new Furniture(DiningRoom,FurnitureTypes.Door);
	public static final Furniture BedroomDoor = new Furniture(CastleBedroom,FurnitureTypes.Door);
	public static final Furniture LaundryDoor = new Furniture(Cottage,FurnitureTypes.Door);
	public static final Characters player = new Characters("Player");
	public static final Characters wife = new Characters("Wife");
	public static final Characters maid = new Characters("Maid");
	public static final Characters chef = new Characters("Chef");
}
