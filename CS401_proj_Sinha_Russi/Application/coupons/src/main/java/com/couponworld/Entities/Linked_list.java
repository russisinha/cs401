package com.couponworld.Entities;

import java.text.ParseException;

import com.couponworld.Interface.*;

public class Linked_list implements Linked_list_interface{
	public LL_Node[] lln;
	private int arr_length = 30;
	private int elemCount = 0;
	private int first;
	private int free;
	
	public Linked_list(){
		lln = new LL_Node[arr_length];
		first = -1;
		free = getFreeSpaces(-1);
	}
	
	public Linked_list(int val){
		lln = new LL_Node[val];
		first = -1;
		free = getFreeSpaces(-1);
	}
	
	public List_iterator list_iterator() {
		List_iterator iter = new List_iterator(this);
		return iter;
	}
	
	public int getFirst() {
		return first;
	}
	
	private int getFreeSpaces(int arrElm) {
		int temp = arrElm;
		try {
			temp++;
			while(lln[temp] != null) {
				temp++;
			}
			if(lln[temp] == null) {
				lln[temp] = new LL_Node();
			}
			lln[temp].setLink(getFreeSpaces(temp));
		}
		catch(Exception e){
			temp = -1;
		}
		return temp;
	}
	
	public void add(Linked_list list) {
		int n = list.getFirst();
		while(n != -1) {
			LL_Node node = list.lln[n];
			this.add(node.getInfo());
			n = node.getLink();
		}
	}
	
	public void add(coupon_entity e) {
		LL_Node newNode = new LL_Node(e);
		if(is_full()) {
			enlarge();
		}
		if(first == -1) {
			first = 0;
		}
		else {
			int tempitem = first;
			LL_Node node = lln[tempitem];
			while(tempitem != -1) {
				node = lln[tempitem]; 
				tempitem = node.getLink();
			}
			node.setLink(free);
		}
		int nextfree = lln[free].getLink();
		lln[free] = newNode;
		free = nextfree;
		elemCount++;
	}
	
	private void enlarge() {
		LL_Node[] ll_new = (LL_Node[]) new Object[lln.length + arr_length];
		for(int i = 0; i < size(); i++) {
			ll_new[i] = lln[i];
		}
		lln = ll_new;
		free = getFreeSpaces(-1);
	}
	
	public int size() {
		return elemCount;
	}
	
	public coupon_entity remove() {
		LL_Node temp = lln[first];
		lln[first] = new LL_Node();
		lln[first].setLink(free);
		free = first;
		first = temp.getLink();
		elemCount--;
		return temp.getInfo();
	}
	
	public coupon_entity removeAt(LL_Node prev, LL_Node curr) {
		if (prev == null) {
			return remove();
		}
		else {
			int tempfree = free;
			free = prev.getLink();
			prev.setLink(curr.getLink());
			lln[free] = new LL_Node();
			lln[free].setLink(tempfree);
			elemCount--;
		}
		return curr.getInfo();
	}
	
	public boolean is_full() {
		return lln.length == elemCount;
	}
	
	public boolean is_empty() {
		return elemCount == 0;
	}
	
	public void sortadd(LL_Node node, String column) throws ParseException {
		int num = getFirst();
		LL_Node previous = null;
		LL_Node curr;
		
		if(num == -1) {
			add(node.getInfo());
			return;
		}
		
		while(num != -1) {
			System.out.println("num="+num);

			curr = lln[num];
			System.out.println("compare="+curr.comparevar(node, column));
			
			if(curr.comparevar(node, column) > 0) {
				System.out.println(9);

				int tempfree = free;
				if(previous == null) {
					node.setLink(first);
					free = lln[free].getLink();
					lln[tempfree] = node;
					first = tempfree;
				}
				else {
					node.setLink(previous.getLink());
					free = lln[free].getLink();
					lln[tempfree] = node;
					previous.setLink(tempfree);
				}
				elemCount++;
				return;
			}
			previous = curr;
			num = curr.getLink();
		}
		System.out.println(node.getInfo()+"--"+node.getLink());
		add(node.getInfo());
		return;
		
	}
	
	@Override
	public String toString() {
		String res = "";
		int temp = first;
		while(temp != -1) {
			res += lln[temp].getInfo() + ", ";
			temp = lln[temp].getLink();
		}
		return "Linked_list [ll=" + res + "]";
	}
	
	
}
