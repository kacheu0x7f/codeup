package solved;
import java.util.*;

class Main {
  static int cnt;
  static int[] d = new int[1010], ck = new int[1010];
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    for(int i=1; i<=N; i++)
      d[i] = sc.nextInt();
    for(int i=1; i<=N; i++)
      if(ck[i]==0) f(i, i);
    System.out.printf("%d\n", N-cnt);
    sc.close();
  }
  static boolean f(int k, int n) {
    if(ck[k]==1) return true;
    ck[k] = 1;
    if(d[k]!=0&&f(d[k], n)) {
    	cnt += 1;
    	return true;
    }
    ck[k] = 0;
    return false;
  }
}