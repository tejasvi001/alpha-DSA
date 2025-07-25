package recursion;

public class IntToString {
	static String digits[]= {"zero","one","two","three","four","five","six","seven","eight","nine"};
	public static void numToString(int n) {
		if(n==0)
			return;
		int lastDigit=n%10;
		numToString(n/10);
		System.out.print(digits[lastDigit]+" ");
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		numToString(124);
	}

}
