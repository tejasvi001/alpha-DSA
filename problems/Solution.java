import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;


class Result {

    /*
     * Complete the 'getDistance' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING word as parameter.
     */

    public static int getDistance(String word) {
    // Write your code here
        int distance=0;
        word=word.toLowerCase();
        char arr[][]={
            {'q','w','e','r','t','y','u','i','o','p'},
            {'a','s','d','f','g','h','j','k','l'},
            {' ','z','x','c','v','b','n','m'}
        };
        distance+=distance('q',word.charAt(0),arr);
        for(int i=0;i<word.length()-1;i++){
            distance+=distance(word.charAt(i),word.charAt(i+1),arr);
        }
        return distance;
    }
    public static int distance(char a, char b, char arr[][]){
        int distance=0;
        int first[]=getIndex(arr, a);
        int second[]=getIndex(arr,b);
        int horizontal=first[0]>second[0]?first[0]-second[0]:second[0]-first[0];
        int vertical=first[1]>second[1]?first[1]-second[1]:second[1]-first[1];
        distance=horizontal+vertical;
        return distance;
    }
    public static  int[] getIndex(char[][] arr, char characterToFind){
        int res[]=new int[2];
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[i].length;j++){
                if(arr[i][j]==characterToFind){
                    res[0]=i;
                    res[1]=j;
                    break;
                }
            }
        }
        return res;
    }

}
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String word = bufferedReader.readLine();

        int result = Result.getDistance(word);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
