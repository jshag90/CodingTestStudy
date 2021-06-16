package com.ji.beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class TreeTraversal {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int nodeCount = Integer.valueOf(br.readLine());

		List<BinaryTreeNode> bTreeNodeList = new ArrayList<BinaryTreeNode>();
		for (int i = 0; i < nodeCount ; i++) {
			String[] nodeInfo = br.readLine().split(" ");
			BinaryTreeNode binaryTreeNode = new BinaryTreeNode();
			binaryTreeNode.setData(nodeInfo[0]);

			BinaryTreeNode leftTreeNode = new BinaryTreeNode();
			BinaryTreeNode rightTreeNode = new BinaryTreeNode();
			leftTreeNode.setData(nodeInfo[1].equals(".") ? null : nodeInfo[1]);
			rightTreeNode.setData(nodeInfo[2].equals(".") ? null : nodeInfo[2]);

			binaryTreeNode.setLeftNode(leftTreeNode);
			binaryTreeNode.setRightNode(rightTreeNode);

			bTreeNodeList.add(binaryTreeNode);
		}
		
		for(BinaryTreeNode node : bTreeNodeList) {
			System.out.println(node.getData());
		}

	}

	static void PreOrder(List<BinaryTreeNode> bTreeNodeList, BinaryTreeNode root) {
		if (root != null) {
			System.out.println(root.getData() + " ");
			PreOrder(bTreeNodeList, root.getLeftNode());
			PreOrder(bTreeNodeList, root.getRightNode());
		}
	}

	public BinaryTreeNode getNodeByData(List<BinaryTreeNode> bTreeNodeList, String data) {
		BinaryTreeNode result = new BinaryTreeNode();
		for (BinaryTreeNode treeNode : bTreeNodeList) {
			if (treeNode.getData().equals(data)) {
				result = treeNode;
				break;
			}
		}
		return result;
	}

}

class BinaryTreeNode {
	public String data;
	public BinaryTreeNode leftNode;
	public BinaryTreeNode rightNode;

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public BinaryTreeNode getLeftNode() {
		return leftNode;
	}

	public void setLeftNode(BinaryTreeNode leftNode) {
		this.leftNode = leftNode;
	}

	public BinaryTreeNode getRightNode() {
		return rightNode;
	}

	public void setRightNode(BinaryTreeNode rightNode) {
		this.rightNode = rightNode;
	}

}
