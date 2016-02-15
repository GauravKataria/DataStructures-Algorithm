package com.interview.datastructure.binarytree;

class NodeSpl {
	 
    int data;
    NodeSpl left, right, nextRight;
 
    NodeSpl(int item) {
        data = item;
        left = right = nextRight = null;
    }
}
 
public class ConnectNodeAtSameLevel {
	NodeSpl root;
	
	public static void connectAtSameLevel(NodeSpl root){
		if(root==null) return;
		
		if(root.left!=null) {
			if(root.right!=null) {
				root.left.nextRight=root.right;
				root.right.nextRight=getNextRight(root);
			}else {
				root.left.nextRight = getNextRight(root);
			}
		}
		
		connectAtSameLevel(root.left);
		connectAtSameLevel(root.right);
		
	}
	
	private static NodeSpl getNextRight(NodeSpl n){
		NodeSpl temp = n.nextRight;
		
		if(temp!=null){
			if(temp.left!=null) return temp.left;
			else if(temp.right!=null) return temp.right;
			else if(temp.nextRight!=null) return getNextRight(temp);
		}
		
		return null;
	}
	
	public static void main(String args[]) {
		ConnectNodeAtSameLevel tree = new ConnectNodeAtSameLevel();
        tree.root = new NodeSpl(10);
        tree.root.left = new NodeSpl(8);
        tree.root.right = new NodeSpl(2);
        tree.root.left.left = new NodeSpl(3);
        tree.root.right.right = new NodeSpl(90);
 
        // Populates nextRight pointer in all nodes
        connectAtSameLevel(tree.root);
 
        // Let us check the values of nextRight pointers
        int a = tree.root.nextRight != null ? tree.root.nextRight.data : -1;
        int b = tree.root.left.nextRight != null ? tree.root.left.nextRight.data : -1;
        int c = tree.root.right.nextRight != null ? tree.root.right.nextRight.data : -1;
        int d = tree.root.left.left.nextRight != null ? tree.root.left.left.nextRight.data : -1;
        int e = tree.root.right.right.nextRight != null ? tree.root.right.right.nextRight.data : -1;
         
        // Now lets print the values
        System.out.println("Following are populated nextRight pointers in "
                + " the tree(-1 is printed if there is no nextRight)");
        System.out.println("nextRight of " + tree.root.data + " is " + a);
        System.out.println("nextRight of " + tree.root.left.data + " is " + b);
        System.out.println("nextRight of " + tree.root.right.data + " is " + c);
        System.out.println("nextRight of " + tree.root.left.left.data + " is " + d);
        System.out.println("nextRight of " + tree.root.right.right.data + " is " + e);
    }
}
