package arrays;

public class MatrixProblems {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[][]= {
				{1,2,3,4},
				{5,6,7,8},
				{9,10,11,12},
				{13,14,15,16}
		};
		spiralMatrix(arr);
		int arr1[][]= {
				{1,2,3},
				{4,5,6}
		};
		int res[][]=transpose(arr1);
		for(int i=0;i<res.length;i++) {
			for(int j=0;j<res[0].length;j++) {
				System.out.print(res[i][j]+" ");
			}
			System.out.println();
		}
	}
	public static void spiralMatrix(int arr[][]) {
		int startRow=0,startCol=0, endRow=arr.length-1,endCol=arr[0].length-1;
		while(startRow<endRow&&startCol<endCol) {
			for(int i=startCol;i<=endCol;i++) {
				System.out.print(arr[startRow][i]+" ");
			}
			for(int i=startRow+1;i<=endRow;i++) {
				System.out.print(arr[i][endCol]+" ");
			}
			for(int i=endCol-1;i>=startCol;i--) {
				System.out.print(arr[endRow][i]+" ");
			}
			for(int i=endRow-1;i>startRow;i--) {
				System.out.print(arr[i][startRow]+" ");
			}
			startRow++;
			endRow--;
			startCol++;
			endCol--;
		}
	}
	public static boolean searchInSortedMatrix(int arr[][],int key) {
		int row=0,col=arr[0].length-1;
		while(row<arr.length&&col>=0) {
			if(arr[row][col]==key) {
				return true;
			}
			else if(arr[row][col]>key) {
				col--;
			}else {
				row++;
			}
		}
		return false;
	}
	public static int[][] transpose(int arr[][]){
		int res[][]=new int[arr[0].length][arr.length];
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[0].length;j++) {
				res[j][i]=arr[i][j];
			}
		}
		return res;
	}
}
