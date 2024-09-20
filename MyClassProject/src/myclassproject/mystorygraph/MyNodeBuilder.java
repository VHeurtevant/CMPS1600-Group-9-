package myclassproject.mystorygraph;

import java.util.List;

import com.storygraph.*;

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
		//test 
	}
	@BuilderMethod
	public void KnockOnDoorActions() {

	}
	@BuilderMethod
	public void OutsideManorActions() {

	}
	@BuilderMethod
	public void LookInBushesActions() {

	}
	@BuilderMethod
	public void UnderDoormatActions() {

	}
	@BuilderMethod
	public void EnterManorActions() {

	}
	@BuilderMethod
	public void MasterBedroomActions() {

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
