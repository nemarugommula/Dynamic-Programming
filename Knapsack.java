import java.util.*;
public class Knapsack{
  public static void main(String args[]){
    Scanner in = new Scanner(System.in);
    System.out.println("Enter capacity");
    int capacity = in.nextInt();
    System.out.println("Enter length of products");
    int itemslen = in.nextInt();
    int []itemsweight = new int [itemslen];
    int []itemsprice = new int[itemslen];
    System.out.println("Enter price of the products");
    for(int i =0;i<itemslen;i++){
      itemsprice[i] = in.nextInt();
    }
    System.out.println("Enter Weight of the products");
    for(int i =0;i<itemslen;i++){
      itemsweight[i] = in.nextInt();
    }
    int [][]dp = new int[itemslen][capacity+1];
    for(int []t : dp){
      Arrays.fill(t,-1);
    }
    int ret = maxprofit(0, capacity, itemsprice, itemsweight,dp);
    System.out.println("maximum profit is : "+ret);
  }
  public static int maxprofit(int index,int remtar,int itemsprice[],int []itemsweight,int [][]dp){
    if(index==itemsprice.length||remtar<=0){
      return 0;
    }
    if(dp[index][remtar]==-1){
      dp[index][remtar] = 0;
      if(itemsweight[index]<=remtar){
        dp[index][remtar] = Math.max(dp[index][remtar],itemsprice[index]+maxprofit(index+1,remtar-itemsweight[index],itemsprice,itemsweight,dp));
      }
      dp[index][remtar] = Math.max(dp[index][remtar],maxprofit(index+1,remtar,itemsprice,itemsweight,dp));
    }

    return dp[index][remtar];
  }
}
