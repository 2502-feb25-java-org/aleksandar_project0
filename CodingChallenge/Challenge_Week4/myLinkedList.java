//Node Object and Linked Listed classes

/*
 * Create a class to implement home-cooked Linked List;
 * Will have insert(end/index), delete, length
 */
public class myLinkedList {
	public Node head; // Creating head for LL
	public int count; // instance counter through specified LL

	public myLinkedList() {
		head = new Node(0); // noargs Constructor initializing node w/ 0
		count = 0;
	}

	/*
	 * Append data element to tail of LL
	 */
	public boolean add(int data) {
		Node tail = new Node(data);
		Node current = head;

		// iterate to last node without predecessor
		while (current.next != null) {
			current = current.next;
		}
		current.next = tail; // Set tail to the data
		count++;
		
		System.out.println("Successfully appended " + data + " to your LinkedList.");
		return true;
	}

	/*
	 * Append data element to specified index of LL - overloaded method
	 */
	public boolean add(int data, int index) {
		Node tail = new Node(data);
		Node current = head;
		int temp;

		if (index > count || index < 1) { // Simulating Index OOB Exception
			System.out.println("Invalid index");
			return false;
		} else {
			temp = 0;
			while (temp < index - 1) {
				current = current.next;
				temp++;
			}
			tail.next = current.next;
			current.next = tail;
			count++;

			System.out.println("Successfully added: " + data + " to index: " + index + ".");
			return true;
		}

	}

	/*
	 * Command line viewprint for Linked List implementation
	 */
	public void viewList() {
		Node current = head;
		System.out.print("Current LinkedList is: ");
		while (current.next != null) { // until we get to the final/tail node
			System.out.print(current.data + " -> ");
			current = current.next; // iterate to the next node
		}
		System.out.println(current.data);
	}

	/*
	 * Delete tail node
	 */
	public boolean deleteTail() {
		Node current = head;
		while (current.next.next != null) { // iterate through to the tail
			current = current.next;
		}
		current.next = null;
		count--;
		
		System.out.println("Successfully removed tail node.");
		return true;
	}
	
	

	/*
	 * Delete node at a specific index
	 */
	public boolean deleteNode(int index) {
		Node current = head;
		int temp;

		if (index > count || index < 1) { // Simulating Index OOB Exception
			System.out.println("Invalid index");
			return false;
		} else {
			temp = 0;
			while (temp < index - 1) { // iterate along until reaching specified index;
				current = current.next;
				temp++;
			}
			// At requested index;
			int toPrint = current.next.data;
			current.next = current.next.next;
			count--;
			System.out.println("Successfully removed: " + toPrint + " from index: " + index + ".");
			return true;
		}
	}
	
	
	/*
	 * Delete node with specified data
	 */
	public boolean deleteData(int data) {
		Node current = head;
		while(current.next!=null) {
			if(current.next.data==data) {
				current.next = current.next.next;
				count--;
				System.out.println("Successfully deleted first node holding data: " + data);
				return true;
			}
			current = current.next; //Otherwise keep moving until data encountered
		}
		System.out.println("Invalid data parameter");
		return false;
	}
	
	/*
	 * Return length of LinkedList
	 */
	public void getLength() {
		int temp = count; //count initialized to 0, must incremenet to reperesent lenght
		temp++;
		System.out.println("Linked list length is " + temp + ".");
	}

	/*
	 * Linked List implementation without using the implemented class that is part
	 * of Java's Collection API. Below is demonstrated: instantiation, adding to
	 * tail, adding to index, deleting
	 */
	public static void main(String[] args) {

		// Create a new Linked List object
		myLinkedList mL = new myLinkedList();
		mL.add(3);
		mL.viewList();

		mL.add(83);
		mL.viewList();

		mL.add(13, 1);
		mL.viewList();

		mL.deleteTail();
		mL.viewList();

		mL.add(99);
		mL.viewList();
		mL.getLength();

		mL.deleteNode(3);
		mL.viewList();
		
		mL.add(104);
		mL.viewList();
		mL.deleteData(104);
		mL.viewList();

		mL.getLength();
	}

}
