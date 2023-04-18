package solved;
import java.util.*;

class Main {
  static int N;
  static char[] o = {' ', '+', '-'}, c = new char[10];
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    N = sc.nextInt();
    f(0);
    sc.close();
  }
  static void f(int k) {
    if(k==N-1) {
      int t = (c[0]==' ')?12:1;
      for(int i=(c[0]==' ')?1:0; i<N-1; i++) {
        if(c[i+1]==' ') {
          if(c[i]=='+') t += ((i+2)*10+i+3);
          if(c[i]=='-') t -= ((i+2)*10+i+3);
          i++;
        } else {
          if(c[i]=='+') t += (i+2);
          if(c[i]=='-') t -= (i+2);
        }
      }
      if(t==0) {
        for(int i=0; i<N-1; i++)
          System.out.printf("%d%c", i+1, c[i]);
        System.out.printf("%d\n", N);
      }
      return;
    }
    for(int i=0; i<3; i++){
      if(k!=0&&i==0&&c[k-1]==' ') continue;
      c[k] = o[i];
      f(k+1);
    }
  }
}
