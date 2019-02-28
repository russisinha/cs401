package com.couponworld.Entities;

import java.util.*;

public class List_iterator implements ListIterator<Object>{
	Linked_list list;
	int position, previous;
	
	public List_iterator(Linked_list lst) {
		this.list = lst;
		position = -1;
		previous = -1;
	}
	
	@Override
	public boolean hasNext() {
		if(position == -1) {
			return list.getFirst() != -1;
		}
		else {
			return list.lln[position].getLink() != -1;
		}
	}
	
	@Override
	public coupon_entity next() {
		if (hasNext()) {
			previous = position;
			if(position == -1) {
				position = list.getFirst();
			}
			else {
				position = list.lln[position].getLink();
			}
			return list.lln[position].getInfo();
		}
		return null;
	}
	
	@Override
	public boolean hasPrevious() {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public coupon_entity previous() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public int nextIndex() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public int previousIndex() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public void remove() {
		// TODO Auto-generated method stub
	}

	@Override
	public void add(Object e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void set(Object e) {
		// TODO Auto-generated method stub
	}
	
}
