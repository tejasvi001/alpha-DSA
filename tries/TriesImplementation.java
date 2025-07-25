package tries;

public class TriesImplementation {
	static class Node{
		Node children[]=new Node[26];
		boolean endOfWord=false;
		Node(){
			for(int i=0;i<26;i++) {
				children[i]=null;
			}
		}
	}
	public static Node root=new Node();
	public TriesImplementation() {
		// TODO Auto-generated constructor stub
	}
	public static void insert(String word) {
		Node curr=root;
		for(int level=0;level<word.length();level++) {
			if(curr.children[word.charAt(level)-'a']==null) {
				curr.children[word.charAt(level)-'a']=new Node();
			}
			curr=curr.children[word.charAt(level)-'a'];
		}
		curr.endOfWord=true;
	}
	public static boolean search(String word) {
		Node curr=root;
		for(int level=0;level<word.length();level++) {
			if(curr.children[word.charAt(level)-'a']==null) {
				return false;
			}
			curr=curr.children[word.charAt(level)-'a'];
		}
		return curr.endOfWord==true;
	}
	public static boolean startsWith(String word) {
		Node curr=root;
		for(int level=0;level<word.length();level++) {
			if(curr.children[word.charAt(level)-'a']==null) {
				return false;
			}
			curr=curr.children[word.charAt(level)-'a'];
		}
		return true;
	}
	public static boolean wordBreak(String key) {
		if(key.length()==0) {
			return true;
		}
		for(int i=1;i<=key.length();i++) {
			if(search(key.substring(0, i))&& wordBreak(key.substring(i))){
				return true;
			}
		}
		return false;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String words[]= {"i","like","sam", "samsung","mobile","ice"};
		for(String word:words) {
			insert(word);
		}
		String key="ilikesamsung";
		System.out.println(wordBreak(key));
	}

}
