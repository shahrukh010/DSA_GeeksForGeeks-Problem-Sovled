package com.code.main.binarytree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.stream.Collectors;

class Node {

	protected int data;
	protected Node left;
	protected Node right;

	public Node(int data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}

	@Override
	public String toString() {

		return this.data + "";
	}

}

public class Tree {

	public Node add(int value) {

		return new Node(value);
	}

	public void preOrder(Node current) {

		if (current != null) {

			System.out.println(current.data);
			preOrder(current.left);
			preOrder(current.right);
		}
	}

	public void inOrder(Node current) {

		if (current != null) {

			inOrder(current.left);
			System.out.println(current.data);
			inOrder(current.right);
		}
	}

	public void postOrder(Node current) {

		if (current != null) {

			postOrder(current.left);
			postOrder(current.right);
			System.out.print(current.data + " ");
		}

	}

	public void levelOrder(Node current) {

		Queue<Node> q1 = new LinkedList<>();
		Queue<Node> q2 = new LinkedList<>();

		q1.add(current);

		while (!q1.isEmpty()) {

			Node tmp = q1.remove();
			q2.add(tmp);
			if (tmp.left != null)
				q1.add(tmp.left);
			if (tmp.right != null)
				q1.add(tmp.right);

		}
		String result = q2.stream().map(node -> String.valueOf(node)).collect(Collectors.joining("-", "{", "}"));
		System.out.println(q2);
	}

	public void itrPreOrder(Node current) {

		Stack<Node> stack = new Stack();
		stack.push(current);
		while (!stack.isEmpty()) {

			Node tmp = stack.pop();
			System.out.println(tmp.data);
			if (tmp.right != null)
				stack.push(tmp.right);
			if (tmp.left != null)
				stack.push(tmp.left);

		}
	}

	public void itrInorder(Node current) {

		Stack<Node> stack = new Stack();
		Node tmp = current;

		while (tmp != null || !stack.isEmpty()) {

			if (tmp != null) {

				stack.push(tmp);
				tmp = tmp.left;
			} else {

				tmp = stack.pop();
				System.out.print(tmp.data + " ");
				tmp = tmp.right;
			}
		}
	}

	public static void itrPostOrder(Node current) {

		Stack<Node> stack = new Stack<>();
		Stack<Node> ans = new Stack<>();
		stack.push(current);
		while (!stack.isEmpty()) {

			ans.push(stack.pop());
			if (ans.peek().left != null)
				stack.add(ans.peek().left);
			if (ans.peek().right != null)
				stack.push(ans.peek().right);
		}

		while (!ans.isEmpty()) {
			System.out.print(ans.pop() + " ");

		}

	}

	public static void main(String[] args) {

		Tree tree = new Tree();
		Node node = tree.add(1);
//		node.left = tree.add(2);
//		node.right = tree.add(3);
//		node.left.left = tree.add(4);
//		node.left.right = tree.add(5);
//		node.left.right.left = tree.add(6);
//		node.right.left = tree.add(7);
//		node.right.right = tree.add(8);
//		node.right.right.left = tree.add(9);
//		node.right.right.right = tree.add(10);

//		node.left = tree.add(2);
//		node.right = tree.add(7);
//		node.left.left = tree.add(3);
//		node.left.right = tree.add(4);
//		node.left.right.left = tree.add(5);
//		node.left.right.right = tree.add(6);
		node.left = tree.add(2);
		node.left.left = tree.add(4);
		node.left.right = tree.add(5);
		node.left.right.left = tree.add(6);
		node.left.right.right = tree.add(7);
		node.right = tree.add(3);

//		tree.preOrder(node);
//		tree.inOrder(node);
//		tree.postOrder(node);
//		tree.levelOrder(node);
//		tree.itrPreOrder(node);
//		tree.itrInorder(node);
		tree.itrPostOrder(node);

	}
}
