package myclassproject.mystorygraph;

import static myclassproject.mystorygraph.MyStoryEntities.*;

import java.util.List;

import com.storygraph.*;
import com.actions.*;
import com.sequences.*;


public class MyNodeBuilder extends NodeBuilder{
	public MyNodeBuilder(List<Node> list) {
		super(list);
	}

	/**
	 * Write a method for each node. 
	 * Use get to get a reference to the node using its label.
	 * The method adds Camelot actions that execute in order when visiting that node. 
	 * These methods must have a BuilderMethod annotation.
	 */
	
	
	
	//Viv Heurtevant
	
	@BuilderMethod
	public void rootActions() {
		var root = get(MyNodeLabels.root.toString());
		root.add(new CreateAll(List.of(CastleCrossroads,GreatHall,DiningRoom,CastleBedroom,Cottage, BlueKey, ChickenLeg, BlueBook, PurpleCloth, Skull, RedPotion,Sword)))
			.add(new CreateCharacterSequence(player)).add(new CreateCharacterSequence(wife)).add(new CreateCharacterSequence(maid)).add(new CreateCharacterSequence(chef))
			.add(new SetPosition(player, CastleCrossroads)).add(new SetPosition(wife, CastleBedroom)).add(new SetPosition(maid, Cottage)).add(new SetPosition(chef, DiningRoom))
			.add(new SetCameraFocus(player)).add(new ShowMenu());
			
		
		}

	
	@BuilderMethod
	public void OutsideManorActions() {	
		var node = get(MyNodeLabels.OutsideManor.toString());
		node.add(new HideMenu()).add(new EnableInput());
		
	}
		
		
	@BuilderMethod
	public void KnockOnDoorActions() {
		var node = get(MyNodeLabels.KnockOnDoor.toString());
		node.add(new NarrationSequence("No one answered the door. Perhaps you should explore outside."));

	}
	@BuilderMethod
	public void LookInBushesActions() {
		var node = get(MyNodeLabels.LookInBushes.toString());
		node.add(new HideNarration()).add(new Pickup(player, BlueBook)).add(new NarrationSequence("You found a journal containing an ominous message scribbled in pink,glittery ink: 'The King Will Pay For This!'. The rest of the pages have been ripped out.")).add(new HideNarration()).add(new Pocket(player, BlueBook));

	}
	@BuilderMethod
	public void UnderDoormatActions() {
		var node = get(MyNodeLabels.UnderDoormat.toString());
		node.add(new Pickup(player, BlueKey)).add(new OpenFurniture(player, Door)).add(new Pocket(player, BlueKey));
		

	}
	@BuilderMethod
	public void EnterManorActions() {
		var node = get(MyNodeLabels.EnterManor.toString());
		node.add(new DisableInput()).add(new Exit(player, Door, true)).add(new Enter(player, ManorDoor, true)).add(new EnableInput());
	}
	@BuilderMethod
	public void MasterBedroomActions() {
		var node = get(MyNodeLabels.MasterBedroom.toString());
		node.add(new DisableInput()).add(new Exit(player, ManorDoor, true)).add(new Enter(player, BedroomDoor, true)).add(new EnableInput());

	}
	// Mohini Yadav
	
	@BuilderMethod
	public void WifeAlibiActions() {
		var node = get(MyNodeLabels.WifeAlibi.toString()); 

		node.add(new NarrationSequence("Inside the Master Bedroom, you find the Queen, she claims that she was away at a tea party the day the murder occured. ")); 

		node.add(new HideNarration()); 

	}
	// Viv Heurtevant
	
	@BuilderMethod
	public void PinkGlitterActions() {
		var node = get(MyNodeLabels.PinkGlitter.toString());
		node.add(new HideNarration()).add(new Pickup(player, RedPotion)).add(new NarrationSequence("A vial of pink glitter. It matches the writing you saw on the journal.").add(new Pocket(player, RedPotion)).add(new HideNarration()));
		
		
	}
	@BuilderMethod
	public void LaundryRoomActions() {
		var node = get(MyNodeLabels.LaundryRoom.toString());
		node.add(new DisableInput()).add(new Exit(player, ManorDoor, true)).add(new Enter(player, LaundryDoor, true)).add(new EnableInput());

	}
	// Mohini Yadav
	
	@BuilderMethod
	public void MaidAlibiActions() {
		
		var node = get(MyNodeLabels.MaidAlibi.toString()); 

		node.add(new NarrationSequence("You ask her where she was the day the murder took place. She tells you she wasnt even aware of a murder but tells you there is something peculiar she did find")); 

		node.add(new HideNarration()); 

	}
	@BuilderMethod
	public void BloodyRagsActions() {
		var node = get(MyNodeLabels.BloodyRags.toString()); 

		node.add(new NarrationSequence("\"I found these rags in the kitchen,\" she says, as she gestures to a pile of bloody rags tucked away in the corner of the room.")); 

		node.add(new HideNarration()).add(new Pickup(player, PurpleCloth)).add(new Pocket(player, PurpleCloth)); 

	}
	@BuilderMethod
	public void ReturnToManorActions() {
		var node = get(MyNodeLabels.ReturnToManor.toString()); 

		node.add(new DisableInput()).add(new Exit(player, ManorDoor, true)).add(new Enter(player, ManorDoor, true)).add(new EnableInput()); 

	}
	@BuilderMethod
	public void KitchenRouteAActions() {
		var node = get(MyNodeLabels.KitchenRouteA.toString()); 

		node.add(new NarrationSequence("You decide to explore the kitchen.")); 

		node.add(new HideNarration()); 

		node.add(new DisableInput()).add(new Exit(player, ManorDoor, true)).add(new Enter(player, DinerDoor, true)).add(new EnableInput()); 

	}
	@BuilderMethod
	public void KitchenRouteBActions() {
		var node = get(MyNodeLabels.KitchenRouteB.toString()); 

		node.add(new NarrationSequence("You decide to explore the kitchen.")); 

		node.add(new HideNarration()); 

		node.add(new DisableInput()).add(new Exit(player, ManorDoor, true)).add(new Enter(player, DinerDoor, true)).add(new EnableInput()); 

	}
	@BuilderMethod
	public void ChefAlibiRouteAActions() {
		var node = get(MyNodeLabels.ChefAlibiRouteA.toString()); 

		node.add(new NarrationSequence(" In the kitchen you see the Manors chef. He explains that he doesnt know about any murder- he has been cutting vegetables all day")); 

		node.add(new HideNarration()); 

		node.add(new HideNarration());
		node.add(new Draw(chef,ChickenLeg)); 
		

	}
	@BuilderMethod
	public void ChefAlibiRouteBActions() {
		var node = get(MyNodeLabels.ChefAlibiRouteB.toString()); 

		node.add(new DialogSequence(player, chef, List.of(" In the kitchen you see the Manors chef. He explains that he has been cutting vegetables all day and offers you a plate of the chicken he has been cooking. What do you choose to do?"), 

				List.of("Eat the chicken", "Investigate further"))); 

		node.add(new HideNarration()).add(new Pickup(chef,ChickenLeg)); 

// player has a choice of whether or not to eat the chicken  

	}
	//Sara Vannoni

	@BuilderMethod
	public void EatChickenRouteAActions() {
		var node = get(MyNodeLabels.EatChickenRouteA.toString());
		node.add(new Pickup(player, ChickenLeg));
// 		Eat Chicken -> bad ending RA death
	}
		

	@BuilderMethod
	public void EatChickenRouteBActions() {
		var node = get(MyNodeLabels.EatChickenRouteB.toString());
		node.add(new Pickup(player, ChickenLeg));
//		Eat Chicken -> bad ending RB death
	}
	
	@BuilderMethod
	public void BadEndingRouteAActions() {
		var node = get(MyNodeLabels.BadEndingRouteA.toString());
		node.add(new NarrationSequence("You take a bite of chicken. It tastes like poison. Oh no!"));
		node.add(new Die(player));
		node.add(new HideNarration()).add(new FadeOut());
		//		Player dies from eating chicken (early entry to kitchen)
	}
	@BuilderMethod
	public void BadEndingRoute1BActions() {
		var node = get(MyNodeLabels.BadEndingRoute1B.toString());
		node.add(new NarrationSequence("You take a bite of chicken. It tastes like poison. Oh no!"));
		node.add(new Die(player));
		node.add(new HideNarration()).add(new FadeOut());
		//		Player dies from eating chicken (2nd time entry)

	}
	@BuilderMethod
	public void BadEndingRoute2BActions() {
		var node = get(MyNodeLabels.BadEndingRoute2B.toString());
		node.add(new HideNarration());
		node.add(new NarrationSequence("You let your guard down and feel yourself get stabbed by the chef's kitchen knife! Oh no!"));
		node.add(new Pickup(chef, Sword));
		node.add(new Die(player));
		node.add(new HideNarration()).add(new FadeOut());
		//		Player dies because he believed chef
	}

	@BuilderMethod
	public void FindSkullActions() {
		var node = get(MyNodeLabels.FindSkull.toString());
		node.add(new Draw(player, Skull));
		node.add(new DialogSequence(player, chef, List.of("Do you believe me?"),
				List.of("Believe Chef", "Arrest Chef")));
//		Player investigates and picks up a skull
	}	
	@BuilderMethod
	public void ArrestChefActions() {
		var node = get(MyNodeLabels.ArrestChef.toString());
		node.add(new Putdown(player, Skull));
		node.add(new NarrationSequence("You handcuff the Chef and take him into custody."));
//		Player arrests the chef
	}

	@BuilderMethod
	public void BelieveChefActions() {
		var node = get(MyNodeLabels.BelieveChef.toString());
		node.add(new NarrationSequence("The player says 'Ok! I beleive you.'"));
//		Player says that he believes chef
	}

	@BuilderMethod
	public void GoodEndingActions() {
		var node = get(MyNodeLabels.GoodEnding.toString());
		node.add(new HideNarration());
		node.add(new NarrationSequence("The city police reward you with 10 million gold coins for solving the mystery! You can retire in peace."));
		node.add(new HideNarration()).add(new FadeOut());
	}
//		Player wins!
}
