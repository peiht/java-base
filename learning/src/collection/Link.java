package collection;

/**
 * �������ʵ��
 * @author Administrator
 *
 */
public class Link {

	Node head = null;
	/**
	 * �ڵ㣬data��ֵ��next��ָ���¸��ڵ������
	 * @author Administrator
	 *
	 */
	class Node{
		Node next = null;//�ڵ�����ã�ָ����һ���ڵ�
		Object data;//�ڵ������
		
		public Node(Object data){
			this.data = data;
		}
	}
	
	public void add(Object d){
		Node newNode = new Node(d);
		if(head ==null){
			head = newNode;
			return;
		}
		Node tmp = head;
		while(tmp.next != null){
			tmp = tmp.next;
		}
		tmp.next = newNode;
	}
	
	public void del(int index) throws Exception
	{
		if(index < 1 || index > length())
		{
			throw new Exception("false");
		}else {
		    
		}
	}
	
	public Object find(Object obj) throws Exception {
	    if(head == null)
	        throw new Exception("the linkList is null");
	    Node cur = head;
	    while(cur != null) {
	        if(cur.data.equals(obj)) {
	            
	        }
	    }
	    return null;
	}
	
	public int length(){
		int length = 0;
		Node tmp = head;
		while(tmp != null){
			length++;
			tmp = tmp.next;
		}
		return length;
	}
	
	public void printList(){
		Node tmp = head;
		while(tmp != null){
			System.out.println(tmp.data);
			tmp = tmp.next;
		}
	}
	public static void main(String[] args) {
		Link link = new Link();
		link.add(1);
		link.add(2);
		link.add(4);
		System.out.println(link.head.next.data);
		link.printList();

	}

}
