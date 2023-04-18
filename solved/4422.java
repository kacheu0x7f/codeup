package solved;
import java.util.*;

class Main {
  static int[] d = new int[110], ck = new int[110];
  static ArrayList<Integer> At = new ArrayList<>();
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    for(int i=1; i<=N; i++)
      d[i] = sc.nextInt();
    ArrayList<Integer> A = new ArrayList<>();
    for(int i=1; i<=N; i++) {
      if(ck[i]==0&&f(i, i)) A.addAll(At);
      if(At.size()!=0) At.clear();
    }
    Collections.sort(A);
    System.out.printf("%d\n", A.size());
    for(int i=0; i<A.size(); i++)
      System.out.printf("%d\n", A.get(i));
    sc.close();
  }
  static boolean f(int k, int n) {
    if(ck[k]==1) return k==n;
    ck[k] = 1;
    if(f(d[k], n)) {
      At.add(k);
      return true;
    }
    ck[k] = 0;
    return false;
  }
}