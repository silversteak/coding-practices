package com.tree.gfgs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

class Node {
	int data;
	Node left, right;

	Node(int data) {
		this.data = data;
	}
}

public class TreeTraversal {
	
	static Node prev = null;
	
	static Map<Node,Integer> mymap = new HashMap<>();
	
	static int diameter = 0;
	
	static int diameterOfTree = 0;
	
	static boolean v1 = false, v2 = false;
	
	public static void inOrder(Node root) {
		if (root == null)
			return;
		inOrder(root.left);
		System.out.print(root.data + " ");
		inOrder(root.right);
	}

	public static void preOrder(Node root) {
		if (root == null)
			return;
		System.out.print(root.data + " ");
		preOrder(root.left);
		preOrder(root.right);
	}

	public static void postOrder(Node root) {
		if (root == null)
			return;
		postOrder(root.left);
		postOrder(root.right);
		System.out.print(root.data + " ");
	}

	public static void levelOrder(Node root) {
		Queue<Node> q = new LinkedList<>();
		q.add(root);
		while (!q.isEmpty()) {
			int count = q.size();
			for (int i = 0; i < count; i++) {
				Node temp = q.poll();
				System.out.print(temp.data + " ");
				if (temp.left != null)
					q.add(temp.left);
				if (temp.right != null)
					q.add(temp.right);
			}
			System.out.println();
		}
	}
	
	public static int countNodes(Node root) {
		if(root == null)
			return 0;
		return (1+countNodes(root.left)+countNodes(root.right));
	}
	
	public static int countLeafs(Node root) {
		if(root == null)
			return 0;
		if(root.left == null && root.right == null)
			return 1;
		return (countLeafs(root.left) + countLeafs(root.right));
	}
	
	public static int countNonLeaves(Node root) {
		if(root == null || (root.left == null && root.right == null))
			return 0;
		return (1+ countNonLeaves(root.left) + countNonLeaves(root.right));
	}
	
	public static int heightTree(Node root) {
		if(root == null)
			return 0;
		return Math.max(heightTree(root.left)+1, heightTree(root.right)+1);
	}
	
	public static int breadthTree(Node root) {
		int result = 0;
		Queue<Node> q = new LinkedList<>();
		q.add(root);
		while (!q.isEmpty()) {
			int count = q.size();
			result = Math.max(count , result);
			for (int i = 0; i < count; i++) {
				Node temp = q.poll();
				//System.out.print(temp.data + " ");
				if (temp.left != null)
					q.add(temp.left);
				if (temp.right != null)
					q.add(temp.right);
			}
		}
		return result;
	}
	
	
	
	public static void spiralLevelOrder(Node root) {
		Stack<Node> s1 = new Stack<>();
		Stack<Node> s2 = new Stack<>();
		s1.add(root);
		
		while(!s1.empty() || !s2.empty()) {
			while(!s1.empty()) {
				Node temp = s1.pop();
				System.out.print(temp.data+ " ");
				if(temp.right!=null)
					s2.add(temp.right);
				if(temp.left!=null)
					s2.add(temp.left);
			}
			while(!s2.empty()) {
				Node temp = s2.pop();
				System.out.print(temp.data+ " ");
				if(temp.left!=null)
					s1.add(temp.left);
				if(temp.right!=null)
					s1.add(temp.right);
			}
		}
		
	}
	
	public static void printSpiralOrder(Node root) {
		Queue<Node> q = new LinkedList<>();
		Stack<Node> stk = new Stack<>();
		boolean reverse = false;
		q.add(root);
		
		while(!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				Node temp = q.poll();
				if(!reverse) {
					System.out.print(temp.data + " ");
				}else {
					stk.add(temp);
				}
				//System.out.print(temp.data + " ");
				if (temp.left != null)
					q.add(temp.left);
				if (temp.right != null)
					q.add(temp.right);
			}
			System.out.println();
			
			if(reverse) {
				while(!stk.isEmpty()) {
					System.out.println(stk.pop().data + " ");
				}
			}
			reverse = !reverse;
		}
		
	}
	
	public static void reverseLevelOrder(Node root) {
		Stack<Node> stk = new Stack<>();
		Queue<Node> q = new LinkedList<>();
		q.add(root);
		q.add(null);
		
		while(!q.isEmpty()) {
			Node temp = q.poll();
			if(temp == null) {
				stk.push(null);
				q.add(null);
				continue;
			}else {
				stk.push(temp);
			}
			
			//stk.push(temp);
			
			if(temp.right != null)
				q.add(temp.right);
			
			if(temp.left != null)
				q.add(temp.left);
			
		}
		
		while(!stk.isEmpty()) {
			Node temp = stk.pop(); 
			if( temp == null)
				System.out.println();
			else
				System.out.print(temp.data + " ");
		}
		
	}
	
	public static boolean isChildParentSum(Node root) {
		
		if(root == null)
			return true;
		
		if(root.left == null && root.right == null)
			return true;
		
		int sum = 0;
		
		if(root.left!=null)
			sum += root.left.data;
		if(root.right!=null)
			sum += root.right.data;
		
		if(sum == root.data && isChildParentSum(root.left) && isChildParentSum(root.right))
			return true;
		
		return false;
	}
	
	
	// This is the shortcut way to traverse a tree if one forgets the general process
	// States 0 , 1, 2 is used to represent the node 
	// Its like a normal traversal which we follow in the RavindraBabu Videos 
	
	public static void magicTraversal(Node root) {
		HashMap <Node , Integer> state = new HashMap<>();
		Stack<Node> stk = new Stack<>();
		stk.push(root);
		
		List <Integer> myList = new ArrayList<>();
		
		while(!stk.isEmpty()) {
			Node currentNode = stk.peek();
			if(currentNode == null) {
				// to pop out the null or else it will thrwow nullpointr
				stk.pop(); 
				continue;
			}	
			
			int currentState;
			if(!state.containsKey(currentNode))
				state.put(currentNode, 0);
			
			currentState = state.get(currentNode);
			
			if(currentState == 0)
				myList.add(currentNode.data);
			else if(currentState == 1)
				stk.push(currentNode.left);
			else if(currentState == 2)
				stk.push(currentNode.right);
			else
				stk.pop();
		
			state.put(currentNode, currentState + 1);
		}
		
		System.out.println(myList);
		
	}
	
	
	// here we are using a static node previous to manage the previous node.
	// an
	public static void convertToDLL(Node curr, Node head) {
		if(curr == null)
			return;	
		
		convertToDLL(curr.left, head);
		
		if(prev == null) {
			head = curr;
		}else {
			curr.left = prev;
			prev.right = curr;
		}
		prev = curr;
		
		convertToDLL(curr.right, head);
		
	}
	
	public static int diameter(Node root) {
		
		if(root == null)
			return 0;
		
		int lheight = heightMapped(root.left); 
        int rheight = heightMapped(root.right); 
  
        int ldiameter = diameter(root.left); 
        int rdiameter = diameter(root.right); 
  
        return Math.max(lheight + rheight + 1, 
                        Math.max(ldiameter, rdiameter)); 
	
	}
	
	private static int heightMapped(Node root) {
		if(root == null)
			return 0;
		
		if(!mymap.containsKey(root)) {
			int dummyHeight = Math.max(heightTree(root.left)+1, heightTree(root.right)+1);
			mymap.put(root, dummyHeight);
			return mymap.get(root);
		}
		return mymap.get(root);
	}
	
	private static int diameterOfTree(Node root) {
		
		if(root == null)
			return 0;
		int leftHeight = heightTree(root.left);
		int rightHeight = heightTree(root.right);
		
		// Here we created a static variable to store the result
		
		diameterOfTree = Math.max(leftHeight+rightHeight+1,diameterOfTree);
		
		return Math.max(leftHeight, rightHeight) + 1;
	}
	
	
	private static int inorderSuccessor(Node root, Node p) {
		
		if(root == null)
			return 0;
		
		//Case 1 if the node has a right sub tree 
			if(p.right != null) {
				p = p.right;
				while(p.left != null)
					p = p.left;
				return p.data;
			}
	
		//Case 2 if the node has not a right sub tree
			Node temp = null;
			
			while(root != null) {
				if(root == p)
					break;
				if(root.data > p.data) {
					temp = root;
					root = root.left;
				}else {
					root = root.right;
				}
			}
		return temp.data;
	}
	
	
	
	// this happens with the null check also
	
	/* case 1 - both null - return null (searching not found)
	 * case 2 - left null, right found = return the non- null
	 * case 3 - left found, right null = return the non null
	 * case 4 - both non-null = return the root - thats the LCA of the given nodes
	 * */
	
	private static Node LCA(Node root, Node p, Node q) {
		
		if(root == null)
			return null;
		
		if(root == p) {
			v1 = true;
			return root;
		}
		
		if(root == q) {
			v2 = true;
			return root;
		}
		
		Node leftLCA = LCA(root.left, p, q);
		Node rightLCA = LCA(root.right, p, q);
		
		if(leftLCA != null && rightLCA != null) {
			return root;
		}
		
		return (leftLCA != null ? leftLCA : rightLCA);
		
	}
	
	
	
	/* case 1 -  if the right Node is not null - 
	 * 			 traverse the to the leftmost part of the right of the given node to get the inorder succssor
	 * 
	 * case 2 - if the right Node is null.
	 * 			traverse from the root to the given node and check the last left ancestor of the Node is the inorder
	 * 			successor
	 * 
	 * case 3 - 
	 * */
	
	private static Node inorderSuccessorTree(Node root, Node p) {
		
		if(root ==  null)
			return null;
		
		if(p.right != null) {
			p = p.right;
			while(p.left != null)
				p = p.left;
			return p;
		}
		
		return inorderSuccessorBTUtil(root, p);
	}
	
	private static Node inorderSuccessorBTUtil(Node root, Node p) {
		
		if(root ==  null)
			return null;
		
	/*	if(root == p)
			return root;
		*/
		Node left = inorderSuccessorBTUtil(root.left, p);
		Node right = inorderSuccessorBTUtil(root.right, p);
		
		if(root == p || left != null || right != null) {
			
			
		}
		
		
		
		return null;
	}

	public static void main(String[] args) {

		/*Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		root.left.left.left = new Node(8);
		*/
		
			/*		  1
				   /     \
				  2       3
				/   \    /  \
			   4     5  6    7
			  /
			 8
 		     */
		
		Node root = new Node(8);
		root.left = new Node(3);
		root.right = new Node(11);
		root.left.left = new Node(2);
		root.left.right = new Node(5);
		root.left.left.left = new Node(1);
		root.left.right.left = new Node(4);
		root.left.right.right = new Node(6);
		root.right.left = new Node(9);
		root.right.right = new Node(12);
		
		
		
		
		
						/*	    8
						   /         \
						  3           11
						/   \        /  \
					   2     5      9     12
					  /     / \    
					 1     4   6
				   */
		
		
		
 
		/*inOrder(root);
		System.out.println();
		preOrder(root);
		System.out.println();
		postOrder(root);
		System.out.println();
		levelOrder(root);
		System.out.println("The height of tree " + heightTree(root));
		System.out.println("The breadth of tree " + breadthTree(root));
		spiralLevelOrder(root);
		System.out.println("The number of Nodes "+ countNodes(root));
		System.out.println("The number of leaves "+ countLeafs(root));
		System.out.println("The number of Non leaves "+ countNonLeaves(root));
		System.out.println("The reverse order level is ");
		System.out.println();
		//reverseLevelOrder(root);
		//magicTraversal(root);
*/		
		//System.out.println(isChildParentSum(root));
		
/*		Node p = new Node(12);
		
		System.out.println(diameter(root));
		
		diameterOfTree(root);
		
		System.out.println(diameterOfTree);
		
		//System.out.println(inorderSuccessor(root, p));
		
		Node lca = LCA(root, root.left.right.left, root.right.left);
		
		if(v1 && v2)
			System.out.println(lca.data);
		else
			System.out.println("null");
		
		
		Node inorderSuccessor = inorderSuccessorTree(root, root.left.right.left);
		
		System.out.println("The inorder Successor is "+ inorderSuccessor.data)*/;
		
		
		System.out.println("-----------------------------------------------------");
		
		printSpiralOrder(root);
		
		
	}

}
