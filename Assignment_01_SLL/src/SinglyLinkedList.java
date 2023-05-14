
public class SinglyLinkedList implements IList{

	Node head;
	int sz;
	
	boolean listIsEmpty(){
		if(head == null)
		{
			return true;
		}
		else {
			return false;
		}
	}
	
	@Override
	public void add(int item) {
		// TODO Auto-generated method stub
		
		Node newNode = new Node();
		newNode.value =  item;
		sz++;
		if(listIsEmpty()) {
			head = newNode;
		}
		else {
			Node tmpNode = head;
			while(tmpNode.next !=null){
				tmpNode = tmpNode.next;
			}
			tmpNode.next = newNode;
		}
	}
	
	

	@Override  
	public void add(int index, int item) {
		// TODO Auto-generated method stub
		
		if(index == 0) {
			 Node temp = new Node();
		      temp.value = item;
		      temp.next = head;
		      head = temp;
               sz++;
		}
		
		else if(index >sz) {
			add(item);
		}
		else 
		{
		
			Node node = new Node();
			node.value = item;
			
			Node temp = head;
			if(temp != null) {
			for(int i =0; i< index - 1; i++) {
				temp = temp.next;
			}
			node.next = temp.next;
			temp.next = node;
			sz++;
		}
	 }   
   }
	
	
	

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		head = null;
		sz = 0;
	}

	@Override
	public int indexOf(int item) {
		// TODO Auto-generated method stub
		
		 Node current = head;
		  var index = 0;
		  while (current != null) {
		    if (current.value == item) {
		      return index;
		    }
		    current = current.next;
		    index++;
		   }
		   return -1;
		
	}

	@Override
	public int get(int index) {
		// TODO Auto-generated method stub
		
		if (sz == 0) {
	        return -1;
	      } 
		else if (index < 0 || index >= sz) {
	        return -1;
	      } 
		else {
	        Node temp = head;
	        for (int i = 0; i < index; i++) {
	          temp = temp.next;
	        }
	        return temp.value;
	      }
	
	}

	@Override
	public boolean remove(int index) {
		// TODO Auto-generated method stub
		
		Node temp = head;
		Node prev = head;
		
		if(index < 0 || index >= sz)
			{
				return false;
			}
			if(index == 0 ) {
	
		    head = head.next;
		    temp.next = null;

		}
		
		else if(index == sz - 2)
		{
		
		for(int i=0 ; i< index - 1 ; i++) {
			prev = prev.next;
		}
		temp = prev.next;
		prev.next = temp.next;
		temp.next = null;
		}
		
		sz--;
		return false;
	}

	@Override
	public boolean removeAll(int item) {
		
		// TODO Auto-generated method stub
	     Node current = head, index = null, temp = null;  
	     Node newNode = new Node();
	     newNode.value = item;
	     
	        if(head == null) {  
	            return true;  
	        }  
	        else {  
	            while(current != null){  
	                temp = current;
	                index = current.next;  
	  
	                while(index != null) {  
	                    if(newNode.value == index.value) {  
	                        temp.next = index.next;
	                    }
	                    else { 
	                        temp = index;  
	                    }  
	                    index = index.next;
	                }
	                current = current.next;  
	            }  
	        } 
		return true;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		
		return sz;
	}

	@Override
	public void reverse() {
		// TODO Auto-generated method stub
		 Node previous = null;
	     Node current = head;
	     Node Next;

		while(current != null) 
		{
				    Next = current.next;
				    current.next = previous;
				    previous = current;    
				    current = Next;
	    }
				  head = previous;
	}
				


	
	@Override
	public void sort() {
		// TODO Auto-generated method stub
		
		int count = 0;
		
		if(head != null) {
			Node temp = head;
			while(temp != null) {
				temp = temp.next;
				count++;
			}
		}
		
		for(int i =0; i<count ; i++) {
			Node temp = head;
			Node temp1 = temp.next;
			int demo;
			
			for(int j=0 ; j <count -i -1; j++) {
				if(temp.value > temp1.value) {
					demo = temp.value;
					temp.value = temp1.value;
					temp1.value = demo;
				}
				temp = temp1;
				temp1 = temp1.next;
			}
	    }		
	}	
		
		
		

	
	public String toString()
	{
		Node start=head;
		String str="";
		if(start==null) return "List Empty!";
		while(start.next!=null)
		{
			str+=start.value+" -> ";
			start=start.next;
		}
		str+=start.value+".";	
		return "List items: "+str;
	}
}






























