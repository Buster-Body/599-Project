
public class Chain {

	public Block head;
	public Block tail;

	public Chain() {
		this.head = null;
		this.tail = null;
	}

	public void add(Block newBlock) {

		if (head == null) {
			head = newBlock;
			tail = newBlock;
		} else {
			Block current = head;
			while (current.next != null) {
				current = current.next;
			}
			current.next = newBlock;
			current.next.previous = current;
			tail = newBlock;
		}
	}

	public boolean isEmpty() {
		if (head == null)
			return true;
		else
			return false;
	}

	public void printList() {
		Block current = head;

		while (current != null) {
			current.display();
			current = current.next;
		}
	}
}
