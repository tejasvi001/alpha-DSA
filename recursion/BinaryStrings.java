package recursion;
//PAYTM - INTERVIEW 
public class BinaryStrings {
	public static void printBinStrings(int n,int lastPlace, String str) {
		if(n==0) {
			System.out.println(str);
			return;
		}
		printBinStrings(n-1,0,str+"0");
		if(lastPlace==0) {
			printBinStrings(n-1,1,str+"1");
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		printBinStrings(3,0,"");
	}

}
