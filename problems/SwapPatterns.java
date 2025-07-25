package problems;

public class SwapPatterns {
	public static String convert(String s) {
		int initialIndex=-1;
		StringBuffer sb=new StringBuffer(s);
		for(int i=0;i<sb.length();i++) {
			if(sb.charAt(i)>64&&sb.charAt(i)<91) {
				sb.setCharAt(i, (char) (sb.charAt(i)+32));
			}else if(sb.charAt(i)>96&&sb.charAt(i)<123) {
				sb.setCharAt(i, (char) (sb.charAt(i)-32));
			}else if(sb.charAt(i)>47&&sb.charAt(i)<58) {
				if(initialIndex!=-1) {
					char temp=sb.charAt(i);
					sb.setCharAt(i, sb.charAt(initialIndex));
					sb.setCharAt(initialIndex, temp);
					initialIndex=-1;
				}else {
					initialIndex=i;
				}
			}else {
				initialIndex=-1;
			}
		}
		return sb.toString();
	}
	public static void main(String args[]) {
		System.out.println(convert("2S 6 du5d4e"));
	}
}
