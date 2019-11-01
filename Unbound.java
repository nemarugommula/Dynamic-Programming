import java.util.*;
public class Unbound{
  public static void main(String args[]){
    Scanner in = new Scanner(System.in);
    System.out.println("Enter the number of products");
    int N = in.nextInt();
    int []arr = new int[N];
    for(int i=0;i<N;i++){
      arr[i] = in.nextInt();
    }
    System.out.println("Enter the target");
    int target = in.nextInt();
    List<Integer> a = new ArrayList<>();
    int dp[][] = new int[N][target+1];
    for(int []t : dp){
      Arrays.fill(t,-1);
    }
    int ret = recur(arr,target,0,a,dp);
    System.out.println(" answer : "+ret);
  }
  public static int recur(int []arr,int rem,int index,List<Integer> temp,int [][]dp){
    if(index==arr.length&&rem!=0||rem<0){
      return 0;
    }
    if(rem==0){
        System.out.println(temp.toString());
        return 1;
      }
      if(dp[index][rem]==-1){
        List<Integer> temp1 = new ArrayList<>(temp);
        dp[index][rem] = recur(arr,rem,index+1,temp1,dp);
        List<Integer> temp2 = new ArrayList<>(temp);
        temp2.add(arr[index]);
        dp[index][rem]+= recur(arr,rem-arr[index],index,temp2,dp);
      }
      return dp[index][rem];
  }
}
