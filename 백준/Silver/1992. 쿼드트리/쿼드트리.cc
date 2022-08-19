#include <iostream>

#define MAX 64

using namespace std;

typedef struct _square{
	int sx, sy;
	int ex, ey;
}Square;

typedef struct _node {
	char ch;
	bool isParent;
	struct _node* child[4];
}Node;

int n;
char map[MAX][MAX+1];

void solve(Node **parent, Square q) {
	Node* node = new Node;
	*parent = node;
	char ch = map[q.sx][q.sy];
	for (int i = q.sx; i < q.ex; i++) {
		for (int j = q.sy; j < q.ey; j++) {
			if (ch != map[i][j]) {
				int xHalf = (q.ex - q.sx) / 2;
				int yHalf = (q.ey - q.sy) / 2;
				node->isParent = true;
				solve(&node->child[0], { q.sx, q.sy, q.ex - xHalf, q.ey - yHalf });
				solve(&node->child[1], { q.sx, q.sy + yHalf, q.ex - xHalf, q.ey });
				solve(&node->child[2], { q.sx + xHalf, q.sy, q.ex, q.ey - yHalf });
				solve(&node->child[3], { q.sx + xHalf, q.sy + yHalf, q.ex, q.ey });
				return;
			}
		}
	}
	node->isParent = false;
	node->ch = ch;
	return;
}

void printNodeDFS(Node *curNode){
	if (curNode->isParent) {
		putchar('(');
		for (int i = 0; i < 4; i++) {
			printNodeDFS(curNode->child[i]);
		}
		putchar(')');
	}
	else {
		putchar(curNode->ch);
	}
}

int main() {
	scanf("%d", &n);
	for (int i = 0; i < n; i++) {
		scanf("%s", map[i]);
	}
	Node *root = nullptr;
	solve(&root, { 0,0,n,n });

	printNodeDFS(root);
	return 0;
}