package com.netxforge.netxstudio.common;

import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;

import com.google.common.base.Function;
import com.google.common.collect.Lists;

public class AllPurposeCache<Key, Value> {

	private final Map<Key, Value> content;
	private final ReentrantReadWriteLock readWriteLock;
	private final ReadLock readLock;
	private final WriteLock writeLock;
	private final Function<Key, Value> f;

	public AllPurposeCache(Function<Key, Value> f) {
		if (f == null) {
			throw new IllegalArgumentException("function may not be null");
		}
		this.readWriteLock = new ReentrantReadWriteLock();
		this.readLock = readWriteLock.readLock();
		this.writeLock = readWriteLock.writeLock();
		this.f = f;
		this.content = new WeakHashMap<Key, Value>();
	}
	
	public List<Key> getKeys(){
		return Lists.newArrayList(content.keySet());
	}
	
	public Value get(Key k) {
		Value result = null;
		try {
			readLock.lock();
			result = content.get(k);
			if (result != null || content.containsKey(k))
				return result;
		} finally {
			readLock.unlock();
		}
		result = f.apply(k);
		try {
			writeLock.lock();
			// f.apply(k) should produce equal results for equal keys
			// it is save to put the new result without checking for a
			// value that has been set meanwhile
			content.put(k, result);
		} finally {
			writeLock.unlock();
		}
		return result;
	}

	public void clear() {
		try {
			writeLock.lock();
			if (!content.isEmpty())
				content.clear();
		} finally {
			writeLock.unlock();
		}
	}

	public void discard(Key k) {
		try {
			writeLock.lock();
			content.remove(k);
		} finally {
			writeLock.unlock();
		}
	}
	
	// for testing purpose
	
	public boolean hasCachedValue(Key key) {
		try {
			readLock.lock();
			return content.containsKey(key);
		} finally {
			readLock.unlock();
		}
	}
	
	public int getSize() {
		try {
			readLock.lock();
			return content.size();
		} finally {
			readLock.unlock();
		}
	}

	public boolean isEmpty() {
		try {
			readLock.lock();
			return content.isEmpty();
		} finally {
			readLock.unlock();
		}
	}

}