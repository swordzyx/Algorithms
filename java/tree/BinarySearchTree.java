public class BinarySearchTree {

	private Node root;

	public Node find(int data) {
		Node result = null;
		Node currentNode = root;
		while(currentNode != null) {
			if(currentNode.data > data) {
				currentNode = currentNode.left
			} else {
				if(currentNode.data == data) {
					result = currentNode;
				}
				currentNode = currentNode.right;
			}
		}
		return result;
	}

	public void insert(int data) {
		Node currentNode = root;
		while(currentNode != null) {
			if(currentNode.data > data) {
				currentNode = currentNode.left;
			} else {
				currentNode = currentNode.right
			}

		}
		currentNode = new Node(data);
	}

	public void delete(int data) {
		Node deleteNode;
		Node deleteNodeParent;
		Node current = root;
		while(current != null) {
			if(current.data > data) {
				deleteNodeParent = current;
				current = current.left;
			} else if(current.data < data) {
				deleteNodeParent = current;
				current = current.right;
			} else {
				deleteNode = current
			}
		}

		if(deleteNode == null) {
			return;
		}

		//1. 要删除的节点有两个子节点
		if(deleteNode.left != null && deleteNode.right != null) {
			//找到右子树中的最小节点
			Node rightMinNode = deleteNode;
			Node rightMinNodeParent = null;
			while(rightMinNode != null) {
				rightMinNodeParent = rightMinNode;
				rightMinNode = rightMinNode.right;
			}

			//将要删除的节点的值替换为右子树的最小节点
			deleteNode.data = rightMinNode.data

			//删除右子树的最小节点
			deleteNode = rightMinNode
			deleteNodeParent = rightMinNodeParent
		}

		//2. 要删除的节点有一个子节点或者没有子节点，用要删除的节点的子节点替换要删除的节点
		//2.1 获取用于代替被删除节点的子节点
		Node newChildNode;
		if(deleteNode.left != null) {
			newChildNode = deleteNode.left;
		} else {
			newChildNode = deleteNode.right;
		}

		if (deleteNodeParent == null) {
			//要删除的节点是根节点，根节点有一个子节点或者没有子节点
			//newChildNode 在有一个子节点时会指向这个子节点，在没有子节点时会指向 null，
			root = newChildNode;
		} else if(deleteNodeParent.left == deleteNode) {
			deleteNodeParent.left = newChildNode;
		} else {
			deleteNodeParent.right = newChildNode;
		}
	}

	//查找前驱节点
	public Node findPrev(int data) {
		//记录上一次右拐点
		Node lastRightNode = null;
		Node current = root;
		while(current != null) {
			if (current.data != data) {
				if(data < current.data) {
					//位于左子树
					current = current.left;
				} else if (data > current.data) {
					//位于右子树
					lastRightNode = current;
					current = current.right;
				}
			} else {
				if (current.left != null) {
					//找到左子树的最大节点
					Node leftMax = current.left
					while(leftMax != null) {
						if (leftMax.right != null) {
							leftMax = leftMax.right;
						} else {
							return leftMax;
						}
					}
				} else {
					//返回上一次右拐点
					return lastRightNode;
				}
			}
		}
		return null;
	}


	//查找后继节点
	public Node findNext(int data) {
		Node current = root;
		//记录
		Node lastLeftNode = null;
		while(current != null) {
			if (data != current.data) {
				if(data > current.data) {
					current = current.right;
				} else {
					lastLeftNode = current;
					current = current.left;
				}
			} else {
				if (current.right != null) {
					Node rightMin = current.right;
					while(rightMin != null) {
						if(rightMin.left != null) {
							rightMin = rightMin.left;
						} else {
							return rightMin;
						}
					}
				} else {
					return lastLeftNode;
				}
			}
		}
		return null;
	}

	public static class Node {
		private int data;
		private Node left;
		private Node right;

		public Node(int data) {
			this.data = data;
		}
	}	

}