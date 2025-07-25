package recursion;

public class RemoveDuplicatesFromString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringBuilder sb=new StringBuilder("");
		boolean map[]=new boolean[26];
		removeDuplicates("appnnnacollege",0,sb,map);
	}
	public static void removeDuplicates(String str,int idx,StringBuilder sb,boolean[] map) {
		if(idx==str.length()) {
			System.out.println(sb);
			return;
		}
		if(map[str.charAt(idx)-'a']==false) {
			sb.append(str.charAt(idx));
			map[str.charAt(idx)-'a']=true;
		}
		removeDuplicates(str,idx+1,sb,map);
	}
}
