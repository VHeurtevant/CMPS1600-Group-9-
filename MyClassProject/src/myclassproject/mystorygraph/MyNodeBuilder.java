package myclassproject.mystorygraph;

import static myclassproject.questexample.QuestStoryEntities.bandit;
import static myclassproject.questexample.QuestStoryEntities.cityDoor;
import static myclassproject.questexample.QuestStoryEntities.cottage;
import static myclassproject.questexample.QuestStoryEntities.cottageDoor;
import static myclassproject.questexample.QuestStoryEntities.player;
import static myclassproject.questexample.QuestStoryEntities.sword;
import static myclassproject.questexample.QuestStoryEntities.town;

import java.util.List;

import com.actions.DisableInput;
import com.actions.Draw;
import com.actions.EnableInput;
import com.actions.Enter;
import com.actions.Exit;
import com.actions.Face;
import com.actions.FadeOut;
import com.actions.HideDialog;
import com.actions.HideNarration;
import com.actions.Pocket;
import com.actions.SetPosition;
import com.actions.Take;
import com.sequences.CreateAll;
import com.sequences.CreateCharacterSequence;
import com.sequences.DialogSequence;
import com.sequences.NarrationSequence;
import com.storygraph.*;
import com.actions.*;
import com.sequences.*;
import com.entities.*;
import myclassproject.questexample.NodeLabels;

public class MyNodeBuilder extends NodeBuilder {
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
		root.add(new CreateAll(List.of(CastleCrossroads,GreatHall,DiningRoom,CastleBedroom,Cottage, BlueKey, ChickenLeg, BlueBook, PurpleCloth, Skull, RedPotion, Door,Sword)))
			.add(new CreateCharacterSequence(player)).add(new CreateCharacterSequence(wife)).add(new CreateCharacterSequence(maid)).add(new CreateCharacterSequence(chef))
			.add(new SetPosition(player, CastleCrossroads)).add(new SetPosition(wife, CastleBedroom)).add(new SetPosition(maid, Cottage)).add(new SetPosition(chef, DiningHall))
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
		node.add(new Pickup(player, BlueKey)).add(new OpenFurniture(Door)).add(new Pocket(player, BlueKey));
		

	}
	@BuilderMethod
	public void EnterManorActions() {
		var node = get(MyNodeLabels.EnterManor.toString());
		node.add(new DisableInput()).add(new Exit(player, CastleCrossroads, true)).add(new Enter(player, GreatHall, true)).add(new EnableInput());
	}
	@BuilderMethod
	public void MasterBedroomActions() {
		var node = get(MyNodeLabels.MasterBedroom.toString());
		node.add(new DisableInput()).add(new Exit(player, GreatHall, true)).add(new Enter(player, CastleBedroom, true)).add(new EnableInput());
		
	}
	// Mohini Yadav
	
	@BuilderMethod
	public void WifeAlibiActions() {

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
		node.add(new DisableInput()).add(new Exit(player, GreatHall, true)).add(new Enter(player, Cottage, true)).add(new EnableInput());

	}
	// Mohini Yadav
	
	@BuilderMethod
	public void MaidAlibiActions() {

	}
	@BuilderMethod
	public void BloodyRagsActions() {

	}
	@BuilderMethod
	public void ReturnToManorActions() {

	}
	@BuilderMethod
	public void KitchenRouteAActions() {

	}
	@BuilderMethod
	public void KitchenRouteBActions() {

	}
	@BuilderMethod
	public void ChefAlibiRouteAActions() {

	}
	@BuilderMethod
	public void ChefAlibiRouteBActions() {

	}
	//Sara Vannoni
	
	@BuilderMethod
	public void EatChickenRouteAActions() {

	}
	
	@BuilderMethod
	public void EatChickenRouteBActions() {
		var node = get(MyNodeLabels.EatChickenRouteB.toString());
		
//		Eat Chicken -> bad ending death
	}
	
	@BuilderMethod
	public void BadEndingRouteAActions() {
		var node = get(MyNodeLabels.BadEndingRouteA.toString());
		node.add(new NarrationSequence("You take a bite of chicken. It tastes like cleaning supplies. Oh no!"));
//		node.add(new HideDialog()).add(new NarrationSequence("You take a bite of chicken. It tastes like cleaning supplies. Oh no!"));
		node.add(new HideNarration()).add(new FadeOut());
		//		Player dies from eating chicken (early entry to kitchen)
	}
	@BuilderMethod
	public void BadEndingRoute1BActions() {
		var node = get(MyNodeLabels.BadEndingRoute1B.toString());
		node.add(new NarrationSequence("You take a bite of chicken. It tastes like cleaning supplies. Oh no!"));
		node.add(new HideNarration()).add(new FadeOut());
		//		Player dies from eating chicken (2nd time entry)
	}
	@BuilderMethod
	public void BadEndingRoute2BActions() {
		var node = get(MyNodeLabels.BadEndingRoute2B.toString());
		node.add(new NarrationSequence("You turn away to continue investigating and feel yourself get stabbed! Oh no!"));
		node.add(new HideNarration()).add(new FadeOut());
		//		Player dies because he believed chef
	}

	@BuilderMethod
	public void FindSkullActions() {
		var node = get(MyNodeLabels.FindSkull.toString());
		node.add(new DialogSequence(player, chef, List.of("What do you do?"),
				List.of("Believe Chef", "Arrest Chef")));
//		Player investigates and picks up a skull
	}	
	@BuilderMethod
	public void ArrestChefActions() {
		var node = get(MyNodeLabels.ArrestChef.toString());
		node.add(new NarrationSequence("You handcuff the Chef and take him into custody."));
//		Player arrests the chef
	}

	@BuilderMethod
	public void BelieveChefActions() {
		var node = get(MyNodeLabels.BelieveChef.toString());
		node.add(new HideDialog()).add(new NarrationSequence("The player says 'Ok! I believe you.'"));
//		Player says that he believes chef
	}

	@BuilderMethod
	public void GoodEndingActions() {
		var node = get(MyNodeLabels.GoodEnding.toString());
		node.add(new HideNarration()).add(new NarrationSequence("The city police reward you with 10 million gold coins for solving the mystery! You can retire in peace."));
		node.add(new HideNarration()).add(new FadeOut());
		//		Player wins!
	}


}


