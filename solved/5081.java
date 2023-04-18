package solved;
import java.util.*;

class Main {
  static int[] d = new int[110];
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int K = sc.nextInt();
    for(int i=1; i<=N; i++) d[i] = i;
    for(int i=1; i<=K; i++) {
      int t = sc.nextInt();
      int Nt = 1;
      for(int j=t; j<=N; j+=t) d[j] = 0;
      for(int j=1; j<=N; j++) {
        if(d[j]!=0) {
          d[Nt] = d[j];
          Nt += 1;
        }
      }
      N = Nt-1;
    }
    for(int i=1; i<=N; i++)
      System.out.printf("%d\n", d[i]);
    sc.close();
  }
}