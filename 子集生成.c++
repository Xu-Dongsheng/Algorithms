//①增量构造法（每次选出一个元素放到集合中）
#include<cstdio>
using namespace std;

void print_subset(int n, int* A, int cur) {
	for (int i = 0; i < cur; i++) printf("%d ", A[i]); // 打印当前集合    
	printf("\n");
	int s = cur ? A[cur-1] + 1 : 1; // 确定当前元素的最小可能值
	for (int i = s; i <= n; i++) {
		A[cur] = i;
		print_subset(n, A, cur + 1); // 递归构造子集
	}
}



int A[10];
int main() {
	int n;
	scanf_s("%d", &n);
	print_subset(n, A, 0);
	return 0;
}
//②位向量法
#include<cstdio>
using namespace std;

void print_subset(int n, int*B, int cur) {
	if (cur == n) {
		for (int i = 0; i < cur; i++)
			if (B[i]) printf("%d ", i + 1);
		printf("\n");
			return;
	}
	B[cur] = 1;
	print_subset(n, B, cur + 1);
	B[cur] = 0;
	print_subset(n, B, cur + 1);
}

int B[10];
int main() {
	int n;
	scanf_s("%d", &n);
	print_subset(n, B, 0);
	return 0;
}
//③二进制法
#include <cstdio>
using namespace std;

void print_subset(int n, int s) {
	for (int i = 0; i < n; i++)
		if (s & (1 << i)) printf("%d", i + 1);
	printf("\n");
}

int main() {
	int n;
	scanf_s("%d", &n);
	for (int i = 0; i < (1 << n); i++)
		print_subset(n, i);
	return 0;
}
