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
	@BuilderMethod
	public void rootActions() {
		//Example:
		//var root = get(NodeLabels.root.toString());
		//root.add(new CreateAll(List.of(cottage, town, sword))); 
		
		
		//root.add(new CreateAll(List.of(ForestPath, town, sword))).add(new CreateCharacterSequence(bandit))
		//		.add(new CreateCharacterSequence(player)).add(new SetPosition(bandit, cottage, "Chest"))
		//		.add(new SetPosition(player, cottage)).add(new Face(bandit, player)).add(new Draw(bandit, sword))
		}
	
	// Viv Heurtevant
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
		node.add(new HideNarration()).add(new Pickup(player, BlueBook)).add(new Pocket(player, BlueBook));

	}
	@BuilderMethod
	public void UnderDoormatActions() {
		var node = get(MyNodeLabels.UnderDoormat.toString());
		node.add(new Pickup(player, BlueKey)).add(new OpenFurniture(Door)).add(new Pocket(player, BlueKey));
		

	}
	@BuilderMethod
	public void EnterManorActions() {
		var node = get(MyNodeLabels.EnterManor.toString());
		node.add(new DisableInput()).add(new Exit(player, placeholder, true)).add(new Enter(player, placeholder, true)).add(new EnableInput());
	}
	@BuilderMethod
	public void MasterBedroomActions() {
		var node = get(MyNodeLabels.MasterBedroom.toString());
		
	}
	@BuilderMethod
	public void WifeAlibiActions() {

	}
	@BuilderMethod
	public void PinkGlitterActions() {

	}
	@BuilderMethod
	public void LaundryRoomActions() {

	}
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
	@BuilderMethod
	public void EatChickenRouteAActions() {

	}
	
	
	//Sara Vannoni
	
	@BuilderMethod
	public void EatChickenRouteBActions() {
		var node = get(NodeLabels.EatChickenRouteB.toString));
		node.add(new Pickup(player, ChickenWing)).add(new Mouth(player, ChickenWing));

//		Eat Chicken -> bad ending death
	}
	
	@BuilderMethod
	public void BadEndingRouteAActions() {
		var node = get(NodeLabels.BadEndingRouteA.toString());
		node.add(new NarrationSequence("You take a bite of chicken. It tastes like cleaning supplies. Oh no!"));
//		node.add(new HideDialog()).add(new NarrationSequence("You take a bite of chicken. It tastes like cleaning supplies. Oh no!"));
		node.add(new HideNarration()).add(new FadeOut());
		//		Player dies from eating chicken (early entry to kitchen)
	}
	@BuilderMethod
	public void BadEndingRoute1BActions() {
		var node = get(NodeLabels.BadEndingRoute1B.toString());
		node.add(new NarrationSequence("You take a bite of chicken. It tastes like cleaning supplies. Oh no!"));
		node.add(new HideNarration()).add(new FadeOut());
		//		Player dies from eating chicken (2nd time entry)
	}
	@BuilderMethod
	public void BadEndingRoute2BActions() {
		var node = get(NodeLabels.BadEndingRoute2B.toString());
		node.add(new NarrationSequence("You turn away to continue investigating and feel yourself get stabbed! Oh no!"));
		node.add(new HideNarration()).add(new FadeOut());
		//		Player dies because he believed chef
	}

	@BuilderMethod
	public void FindSkullActions() {
		var node = get(NodeLabels.FindSkull.toString());
		node.add(new DialogSequence(player, chef, List.of("What do you do?"),
				List.of("Believe Chef", "Arrest Chef")));
//		Player investigates and picks up a skull
	}	
	@BuilderMethod
	public void ArrestChefActions() {
		var node = get(NodeLabels.ArrestChef.toString());
		node.add(new NarrationSequence("You handcuff the Chef and take him into custody."));
//		Player arrests the chef
	}

	@BuilderMethod
	public void BelieveChefActions() {
		var node = get(NodeLabels.BelieveChef.toString());
		node.add(new HideDialog()).add(new NarrationSequence("The player says 'Ok! I beleive you.'"));
//		Player says that he believes chef
	}

	@BuilderMethod
	public void GoodEndingActions() {
		var node = get(NodeLabels.GoodEnding.toString());
		node.add(new HideNarration()).add(new NarrationSequence("The city police reward you with 10 million gold coins for solving the mystery! You can retire in peace."));
		node.add(new HideNarration()).add(new FadeOut());
		//		Player wins!
	}
}
