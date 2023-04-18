package solved;
import java.util.*;

class Main {
  static int ans = -1;
  static int[] ck = new int[1000010];
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int K = sc.nextInt();
    for(int i=1; i<=N; i++) {
      int t = sc.nextInt();
      if(ck[t]!=0&&i-ck[t]<=K) ans = max(ans, t);
      ck[t] = i;
    }
    System.out.printf("%d\n", ans);
    sc.close();
  }
  static int max(int a, int b) {
    return a>b?a:b;
  }
}