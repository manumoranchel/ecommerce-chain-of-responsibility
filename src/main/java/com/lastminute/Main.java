package com.lastminute;

import java.util.LinkedList;
import java.util.Queue;

class Main {
  static class Node {
    String name;
    Node left;
    Node right;

    Node(String name) {
      this.name = name;
    }
  }

  private static Node buildTree() {
    Node a = new Node("A");
    Node b = new Node("B");
    Node c = new Node("C");
    Node d = new Node("D");
    Node e = new Node("E");
    Node f = new Node("F");
    Node g = new Node("G");
    Node h = new Node("H");
    a.left = b;
    a.right = c;

    b.left = d;
    b.right = e;

    c.left = f;
    c.right = g;

    e.right = h;

    return a;
  }

  static String traverse(Node root) {
	  Queue<Node> ret = new LinkedList<Node>();
	  String orderedString = root.name + " -> ";
	  ret.addAll(getChilds(root));
	  while (!ret.isEmpty()) {
		Node currentNode = (Node) ret.remove();
//		System.out.println("Adding Node" + currentNode.name);
		ret.addAll(getChilds(currentNode));
		orderedString += currentNode.name + " -> ";
		
	}
	return orderedString.substring(0, orderedString.lastIndexOf(" -> "));
  }
  
  static private Queue<Node> getChilds(Node node) {
	  Queue<Node> ret = new LinkedList<Node>();
	  if (node.left != null) {
		  ret.add(node.left);
	}
	  if (node.right != null) {
		  ret.add(node.right);
	}

	 return ret;
	  
  }
  
  

  public static void main(String[] args) {
    Node root = buildTree();
    System.out.println(traverse(root));
  }
}
