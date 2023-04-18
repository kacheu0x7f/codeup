package solved;
import java.util.*;

class Main {
  static int N, mv[][] = {{0, 0, 1, -1}, {1, -1, 0, 0}};
  static char[][] g = new char[30][30];
  static String s;
  static ArrayList<Integer> d = new ArrayList<>();
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    N = sc.nextInt();
    for(int i=0; i<N; i++) {
      s = sc.next();
      for(int j=0; j<N; j++) g[i][j] = s.charAt(j);
    }
    for(int i=0; i<N; i++)
      for(int j=0; j<N; j++)
        if(g[i][j]=='1') d.add(f(i, j));
    Collections.sort(d);
    System.out.printf("%d\n", d.size());
    for(int i=0; i<d.size(); i++)
      System.out.printf("%d\n", d.get(i));
    sc.close();
  }
  static boolean safe(int x, int y) {
    return (0<=x&&x<N)&&(0<=y&&y<N);
  }
  static int f(int x, int y) {
    int a, b, r = 0;
    g[x][y] = '0';
    for(int i=0; i<4; i++) {
      a = x+mv[0][i];
      b = y+mv[1][i];
      if(safe(a, b)&&g[a][b]=='1') r += f(a, b);
    }
    return r+1;
  }
}