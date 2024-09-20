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

//mohini yadav
		public void rootActions() {
			var root = get(NodeLabels.root.toString());
			root.add(new CreateAll(List.of(ForestPath, town, sword))).add(new CreateCharacterSequence(bandit))
					.add(new CreateCharacterSequence(player)).add(new SetPosition(bandit, cottage, "Chest"))
					.add(new SetPosition(player, cottage)).add(new Face(bandit, player)).add(new Draw(bandit, sword))

	
		
		
		// viv 
		

	}

	
}
