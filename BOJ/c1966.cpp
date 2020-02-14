#include <iostream>
#include <queue>
#include <list>

using namespace std;

typedef struct _Doc {
	int docNum;
	int docPriority;
}Doc;

bool operator<(Doc a, Doc b) {
	return a.docNum < b.docNum;
}

int main() {

	int tcase;
	int n, m;
	Doc Tdoc;

	int priority;
	int priorMax = -1;

	scanf("%d", &tcase);

	for (int i = 0; i < tcase; i++)
	{
		scanf("%d %d", &n, &m);
		queue<Doc, list<Doc> > q;
		for (int i = 0; i < n; i++) {
			scanf("%d", &priority);
			Tdoc.docNum = i;
			Tdoc.docPriority = priority;
			q.push(Tdoc);
		}
		
		for (int i = 1; !pq.empty(); i++) {
			Tdoc = pq.top();
			pq.pop();
			if (m == Tdoc.docNum) {
				printf("%d!\n", i);
				break;
			}
		}
	}


	return 0;
}