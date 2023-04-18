#include <stdio.h>

int N, x, y, w, ans, g[120][120];
int mv[5][5] = {{0, 0, 1, -1}, {1, -1, 0, 0}};

int safe(int x, int y) {
	return (0<=x&&x<102)&&(0<=y&&y<102);
}

void f(int x, int y) {
	g[x][y] = 2;
	for(int i=0; i<4; i++) {
		int a = x+mv[0][i], b = y+mv[1][i];
		if(safe(a, b)&&g[a][b]==0) f(a, b);
	}
}

int main(void) {
	scanf("%d", &N);
	for(int i=0; i<N; i++) {
		scanf("%d%d%d", &x, &y, &w);
		for(int j=x; j<100&&j<x+w; j++)
			for(int k=y; k<100&&k<y+w; k++)
				g[j][k] = 1;
	}
	f(0, 0);
	for(int i=1; i<=100; i++)
		for(int j=1; j<=100; j++)
			if(g[i][j]==1)
				for(int k=0; k<4; k++)
					ans += (g[i+mv[0][k]][j+mv[1][k]]==2?1:0);
	printf("%d\n", ans);
	
	return 0;
}
