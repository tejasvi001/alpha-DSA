package bitManipulation;

public class BitManipulationProblems {
	public static int getIthBit(int n,int i) {
		int bitMask=1<<i;
		if((bitMask&n)==0) {
			return 0;
		}
		return 1;
	}
	public static int setIthBit(int n,int i) {
		int bitMask=1<<i;
		return bitMask|n;
	}
	public static int clearIthBit(int n,int i) {
		int bitMask=~(1<<i);
		return n&bitMask;	
	}
	
	public static int updateIthBit(int n,int i, int newBit) {
		n=clearIthBit(n,i);
		int bitMask=newBit<<i;
		return bitMask|n;
	}
	public static int clearLastIBits(int n,int i) {
		int bitMask=(~0)<<i;
		return n&bitMask;
	}
	public static boolean isPowerOfTwo(int n) {
		if((n&(n-1))==0)
			return true;
		return false;
	}
	public static boolean isPowerOfFour(int n) {
		if(((n&(n-1))==0)&&((n-1)%3==0))
			return true;
		return false;
	}
	public static int clearRangeOfBits(int n,int i,int j) {
		int a=(~0)<<(j+1);
		int b=(1<<i)-1;
		int bitMask=a|b;
		return n&bitMask;
	}
	public static int countBits(int n) {
		int c=0;
		while(n>0) {
			if((n&1)==1)
				c++;
			n=n>>1;
		}
		return c;
	}
	public static int fastExpo(int a,int n) {
		int ans=1;
		while(n>0) {
			if((n&1)==1)
				ans=ans*a;
			a=a*a;
			n=n>>1;
		}
		return ans;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(getIthBit(5,1));
		System.out.println(setIthBit(5,1));
	
		System.out.println(clearIthBit(15,2));
		System.out.println(clearLastIBits(15,3));
		System.out.println(updateIthBit(16,2,1));
		System.out.println(clearRangeOfBits(63,2,4));
		System.out.println(countBits(15));
		System.out.println(fastExpo(3,5));
	}

}
