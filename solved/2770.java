package solved;
import java.util.*;

class Main {
  static int N, t, m = 30010;
  static int[][] DT = new int[5][30010];
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    N = sc.nextInt();
    for(int i=1; i<=N; i++) {
      t = sc.nextInt();
      for(int j=1; j<=2; j++)
        DT[j][i] = DT[j][i-1]+(t==j?1:0);
    }
    if(N==DT[1][N]||N==DT[2][N]) {
      m = 0;
    } else {
      for(int i=0; i<=N; i++) {
        int a = DT[1][N]-DT[1][i];
        int b = DT[2][i];
        m = min(m, b+a);
      }
    }
    System.out.printf("%d\n", m);
    sc.close();
  }
  static int min(int a, int b) {
    return a<b?a:b;
  }
}
