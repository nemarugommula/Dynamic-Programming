import java.util.*;
public class LIS{
  public static void main(String args[]){
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int []arr = new int[n];
    for(int i=0;i<n;i++){
      arr[i] = in.nextInt();
    }
    /*
    //traditional dp method
    int ret = 0;
    int []dp = new int[n];
    Arrays.fill(dp,1);
    for(int i=0;i<n;i++){
      for(int j=i-1;j>=0;j--){
        if(arr[i]>arr[j]){
          dp[i] = Math.max(dp[i],1+dp[j]);
        }
      }
      ret = Math.max(ret,dp[i]);
    }*/
    //recursive
    int dp[] = new int[n];
    Arrays.fill(dp,-1);
    int ret = 0;
    for(int i=0;i<n;i++){
      ret = Math.max(ret,1+recur(arr,i,dp));
    }
    System.out.println("answer  : "+ret);
  }
  public static int recur(int []arr,int index,int []dp){
    if(index==arr.length){
      return 0;
    }
    if(dp[index]==-1){
      dp[index ] = 0;
      for(int i=index;i<arr.length;i++){
        if(arr[index]<arr[i]){
          dp[index]=Math.max(dp[index],1+recur(arr,i,dp));
        }
      }
    }
    return dp[index];
  }
}
