package myclassproject.mystorygraph;

import static myclassproject.questexample.QuestStoryEntities.bandit;
import static myclassproject.questexample.QuestStoryEntities.cottage;
import static myclassproject.questexample.QuestStoryEntities.player;
import static myclassproject.questexample.QuestStoryEntities.sword;
import static myclassproject.questexample.QuestStoryEntities.town;

import java.util.List;

import com.actions.Draw;
import com.actions.Face;
import com.actions.SetPosition;
import com.sequences.CreateAll;
import com.sequences.CreateCharacterSequence;
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
	@BuilderMethod
	public void EatChickenRouteBActions() {

	}
	@BuilderMethod
	public void BadEndingRouteAActions() {

	}
	@BuilderMethod
	public void BadEndingRoute1BActions() {

	}
	@BuilderMethod
	public void BadEndingRoute2BActions() {

	}
	@BuilderMethod
	public void FindSkullActions() {

	}
	@BuilderMethod
	public void ArrestChefActions() {

	}
	@BuilderMethod
	public void BelieveChefActions() {

	}
	@BuilderMethod
	public void GoodEndingActions() {

	}
}
	
	//Sara Vannoni