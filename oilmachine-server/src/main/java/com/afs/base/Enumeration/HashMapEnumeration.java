package com.afs.base.Enumeration;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Set;

public class HashMapEnumeration<E> implements Enumeration<E> {

	private Set<E> data;
	private int pos = 0;
	private int len;
	
	private Object[] key;
	
	public HashMapEnumeration(Set<E> data){
		this.data = data;
		this.len = data.size();
		this.key = data.toArray();
	}
	
	public boolean hasMoreElements() {
		return pos<len;
	}

	public E nextElement() {
		return (E)key[pos++];
	}

}
