package problems;

public class BinaryDecimal {
	public static int binaryToDecimal(int b) {
		int d=0;
		int i=0;
		while(b>0) {
			int r=b%10;
			d+=r*Math.pow(2, i++);
			b/=10;
		}
		return d;
	}
	public static int decimalToBinary(int d) {
		int b=0;
		while(d>0) {
			int r=d%2;
			d/=2;
			b=b*10+r;
		}
		return b;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(binaryToDecimal(101));
		System.out.println(decimalToBinary(5));
	}

}
