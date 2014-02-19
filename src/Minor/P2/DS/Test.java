package Minor.P2.DS;


public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BST<Integer> myBST = new BST<Integer>(100);

		System.out.println("should be null: " + myBST.find(null));
		System.out.println("should be null: " + myBST.find(1));
		System.out.println("should be false: " + myBST.remove(4));
		System.out.println();

		myBST.insert(4);
		myBST.insert(3);
		myBST.insert(6);
		myBST.insert(7);

		System.out.println("should be 4: " + myBST.find(4));
		System.out.println("should be null: " + myBST.find(1));
		System.out.println("should be false: " + myBST.remove(55));
		System.out.println();

		System.out.println("should be 4:" + myBST.root.element);
		System.out.println("should be 6:" + myBST.root.right.element);
		System.out.println("should be 3:" + myBST.root.left.element);
		System.out.println("should be 4:" + myBST.root.right.parent.element);
		System.out.println("should be 4:" + myBST.root.left.parent.element);
		System.out.println("----");

		myBST.remove(4);

		System.out.println("should be 6:" + myBST.root.element);
		System.out.println("should be 7:" + myBST.root.right.element);
		System.out.println("should be 3:" + myBST.root.left.element);
		System.out.println("should be 6:" + myBST.root.right.parent.element);
		System.out.println("should be 6:" + myBST.root.left.parent.element);

		myBST.remove(7);

		System.out.println("should be null:" + myBST.root.right);
		System.out.println("AAAAA");
		myBST.clear();
		myBST.insert(4);
		myBST.insert(2);
		myBST.insert(1);
		myBST.insert(-1);
		myBST.insert(7);
		myBST.insert(6);
		myBST.insert(11);
		myBST.insert(9);
		myBST.insert(10);

		myBST.remove(4);

		System.out.println("should be 6:" + myBST.root.element);
		System.out.println("should be 7:" + myBST.root.right.element);
		System.out.println("should be null:" + myBST.root.right.left);
		System.out.println("should be 2:" + myBST.root.left.element);
		System.out.println("should be 6:" + myBST.root.right.parent.element);
		System.out.println("should be 6:" + myBST.root.left.parent.element);

		System.out.println("should be true:" + myBST.prune(2));
		System.out.println("should be null:" + myBST.root.left);

		System.out.println();
		myBST.remove(9);

		System.out.println("should be 10:"
				+ myBST.root.right.right.left.element);
		System.out.println("should be 11:"
				+ myBST.root.right.right.left.parent.element);
		System.out.println("Equals test.");

		myBST.clear();
		BST<Integer> otherBST = new BST<Integer>(100);
		System.out.println("should be false: " + myBST.equals(null));
		System.out.println("should be true: " + myBST.equals(otherBST));

		myBST.insert(4);

		System.out.println("should be false: " + myBST.equals(otherBST));

		otherBST.insert(4);
		System.out.println("should be true: " + myBST.equals(otherBST));

		myBST.insert(2);
		myBST.insert(1);
		myBST.insert(-1);
		myBST.insert(7);
		myBST.insert(6);
		myBST.insert(11);
		myBST.insert(9);
		myBST.insert(10);

		otherBST.insert(2);
		otherBST.insert(1);
		otherBST.insert(-1);
		otherBST.insert(7);
		otherBST.insert(6);
		otherBST.insert(11);
		otherBST.insert(9);
		otherBST.insert(10);

		System.out.println("should be true: " + myBST.equals(otherBST));
		otherBST.remove(-1);
		System.out.println("should be false: " + myBST.equals(otherBST));

		myBST.clear();
		myBST.insert(4);
		myBST.insert(2);
		myBST.insert(1);
		myBST.insert(-1);
		myBST.insert(7);
		myBST.insert(6);
		myBST.insert(11);
		myBST.insert(9);
		myBST.insert(10);

		System.out.println("should be 7:"
				+ myBST.root.right.left.parent.element);
		
		while (myBST.root != null) {
			myBST.remove(myBST.root.element);
		}

		System.out.println("should be null: " + myBST.root);
	}

}
