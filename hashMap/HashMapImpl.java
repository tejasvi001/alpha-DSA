package hashMap;

import java.util.ArrayList;
import java.util.LinkedList;

public class HashMapImpl {
	static class HashMap<K,V>{
		private class Node{
			K key;
			V value;
			public Node(K key, V value) {
				this.key=key;
				this.value=value;
			}
		}
		private double threshold;
		private int bucketSize;
		private int size;//n
		private LinkedList<Node> buckets[];//N
		@SuppressWarnings("unchecked")
		public HashMap() {
			this.threshold=2.0;
			this.size=0;
			this.bucketSize=4;
			this.buckets=new LinkedList[bucketSize];
			for(int i=0;i<bucketSize;i++) {
				this.buckets[i]=new LinkedList<>();
			}
		}
		private int hashFunction(K key) {
			int hc=key.hashCode();		
			return Math.abs(hc)%bucketSize;
		}
		private int searchInLL(K key,int bi) {
			LinkedList<Node> ll=buckets[bi];
			for(int i=0;i<ll.size();i++) {
				Node node=ll.get(i);
				if(node.key==key) {
					return i;
				}
			}
			return -1;
		}
		private void reHash() {
			LinkedList<Node> oldBuckets[]=buckets;
			buckets=new LinkedList[bucketSize*2];
			bucketSize*=2;
			for(int i=0;i<bucketSize;i++) {
				this.buckets[i]=new LinkedList<>();
			}
			//nodes retrieve and add to new ll
			for(int i=0;i<oldBuckets.length;i++) {
				LinkedList<Node> ll=oldBuckets[i];
				for(int j=0;j<ll.size();j++) {
					Node node=ll.get(j);
					put(node.key,node.value);
				}
			}
		}
		public void put(K key, V value) {
			int bi=hashFunction(key);
			int di=searchInLL(key,bi);
			if(di!=-1) {
				Node node=buckets[bi].get(di);
				node.value=value;
			}else {
				buckets[bi].add(new Node(key,value));
				size++;
			}
			double lambda=(double) size/bucketSize;
			if(lambda>threshold) {
				reHash();
			}
			
		}
		public boolean containsKey(K key) {
			int bi=hashFunction(key);
			int si=searchInLL(key,bi);
			if(si==-1)
				return false;
			return true;
		}
		public V get(K key) {
			int bi=hashFunction(key);
			int di=searchInLL(key,bi);
			if(di!=-1) {
				Node node=buckets[bi].get(di);
				return node.value;
			}else {
				return null;
			}
		}
		public V remove(K key) {
			int bi=hashFunction(key);
			int di=searchInLL(key,bi);
			if(di!=-1) {
				Node node=buckets[bi].remove(di);
				size--;
				return node.value;
				
			}else {
				return null;
			}
		}
		public int size() {
			return size;
		}
		public boolean isEmpty() {
			return size!=0;
		}
		public ArrayList<K> getKey(){
			ArrayList<K> keys=new ArrayList<>();
			for(int i=0;i<buckets.length;i++) {
				LinkedList<Node> ll=buckets[i];
				for(int j=0;j<ll.size();j++) {
					Node node=ll.get(j);
					keys.add(node.key);
				}
			}
			return keys;
		}
	}
	public HashMapImpl() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<String, Integer> hm=new HashMap<>();
		hm.put("India", 100);
		hm.put("China", 150);
		hm.put("US", 50);
		hm.put("Nepal", 5);
		System.out.println("India get "+ hm.get("India"));
		System.out.println("India "+hm.containsKey("India"));
		ArrayList<String> keys=hm.getKey();
		System.out.println(keys);
	}

}
