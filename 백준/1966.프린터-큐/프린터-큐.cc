#include <iostream>
#include <queue>
#include <list>

using namespace std;

typedef struct _Doc {
	int docNum;
	int docPriority;
}Doc;

int main() {

	int tcase;
	int n, m;
	Doc Tdoc;

	int priority;

	scanf("%d", &tcase);

	for (int i = 0; i < tcase; i++)
	{
		scanf("%d %d", &n, &m);
		queue<Doc, list<Doc> > q;
		priority_queue<int> qp;
		for (int i = 0; i < n; i++) {
			scanf("%d", &priority);
			Tdoc.docNum = i;
			Tdoc.docPriority = priority;
			q.push(Tdoc);
			qp.push(priority);
		}
		
		int printNum = 0;
		while (!qp.empty()) {
			priority = qp.top(); qp.pop();
			
			while (!q.empty()){
				Tdoc = q.front(); q.pop();
				if (Tdoc.docPriority == priority) {
					printNum++;
					break;
				}
				else {
					q.push(Tdoc);
				}
			}

			if (Tdoc.docNum == m) {
				printf("%d\n", printNum);
				break;
			}
		}

		
	}


	return 0;
}