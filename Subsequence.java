import java.util.*;
public class Subsequence{
  public static void main(String args[]){
    Scanner in = new Scanner(System.in);
    String str1 = in.next();
    String str2 = in.next();
    int m = str1.length()-1;
    int n = str2.length()-1;
    int dp[][] = new int[m+1][n+1];
    for(int []t : dp){
      Arrays.fill(t,-1);
    }
    int ret = recur(str1,str2,m,n,dp);
    System.out.println("answer : "+ret);
  }
  public static int recur(String str1,String str2,int m,int  n,int [][]dp){
    if(m<0||n<0)return 0;
      if(dp[m][n]==-1){
        if(str1.charAt(m)==str2.charAt(n)){
          dp[m][n]= 1+recur(str1,str2,m-1,n-1,dp);
        }else{
          dp[m][n]=Math.max(recur(str1,str2,m-1,n,dp),recur(str1,str2,m,n-1,dp));
        }
        }
        return dp[m][n];
    }
}
