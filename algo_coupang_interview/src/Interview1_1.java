
public class Interview1_1 {

	static class Node {
		int value;
		Node next;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node node1 = new Node();
		node1.value = 1;
		
		Node node2 = new Node();
		node2.value = 2;
		node1.next = node2;
		
		Node node3 = new Node();
		node3.value = 3;
		node2.next = node3;
		
		Node node4 = new Node();
		node4.value = 4;
		node3.next = node4;
		
		Node node5 = new Node();
		node5.value = 5;
		node4.next = node5;
		
//		Node node6 = new Node();
//		node6.value = 6;
//		node5.next = node6;
		
		Node head = getInteractSwapList(node1);
		while(head != null) {
			System.out.print("-> " + head.value);
			head = head.next;
		}
	}

	private static Node getInteractSwapList(Node head) {
		if (head == null) {
			return head;
		}

		Node preNode = null;
		Node curNode = head;
		int count = 1;

		while (curNode != null) {
			preNode = curNode;
			curNode = curNode.next;
			
			if(curNode == null) {
				break;
			}

			count++;

			if (count % 2 == 0) {
				int temp = preNode.value;
				preNode.value = curNode.value;
				curNode.value = temp;
			}
		}

		return head;
	}

}
