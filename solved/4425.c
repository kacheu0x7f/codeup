#include <stdio.h>
#include <string.h>

char s[210];

int f(int k, char * state) {
	if(s[k]=='\0'&&!strcmp(state, "S")) return 1;
	if(!strcmp(state, "S")) {
		if(s[k]=='0'&&f(k+1, "A")) return 1;
		if(s[k]=='1'&&f(k+1, "B1")) return 1;
	}
	if(!strcmp(state, "A")) {
		if(s[k]=='1'&&f(k+1, "S")) return 1;
	}
	if(!strcmp(state, "B1")) {
		if(s[k]=='0'&&f(k+1, "B2")) return 1;
	}
	if(!strcmp(state, "B2")) {
		if(s[k]=='0'&&f(k+1, "B3")) return 1;
	}
	if(!strcmp(state, "B3")) {
		if(s[k]=='0'&&f(k+1, "B3")) return 1;
		if(s[k]=='1'&&f(k+1, "B4")) return 1;
	}
	if(!strcmp(state, "B4")) {
		if(s[k]=='1'&&f(k+1, "B4")) return 1;
		if(f(k, "S")) return 1;
	}
	return 0;
}

int main(int argc, const char * argv[]) {
	scanf(" %s", s);
	printf(f(0, "S")==1?"SUBMARINE\n":"NOISE\n");
	
	return 0;
}
