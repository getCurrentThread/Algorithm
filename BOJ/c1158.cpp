#include <iostream>
#include <vector>

using namespace std;

typedef struct _Node {
	int data;
	struct _Node* next;
}Node;

vector<int> v;

int main() {

	int n, k;
	Node* phead;
	Node* temp;

	phead = new Node;
	phead->data = 1;
	phead->next = phead;

	scanf("%d %d", &n, &k);

	for (int i = 2; i <= n; i++)
	{
		temp = new Node;
		temp->data = i;
		temp->next = phead->next;
		phead->next = temp;
		phead = temp;
	}
	phead = phead->next;
	
	if(k != 1){
		while (phead != phead->next) {
			for (int i = 1; i < k - 1; i++)
			{
				phead = phead->next;
			}
			temp = phead->next;
			v.push_back(temp->data);
			phead->next = temp->next;
			phead = phead->next;
			delete temp;
		}
		v.push_back(phead->data);
		delete phead;
	}
	else {
		for(int i=1; i <= n; i++){
			temp = phead;
			phead = phead->next;
			delete temp;
			v.push_back(i);
		}
	}
	if(v.size() != 1){
	printf("<%d", v[0]);
	for (int i = 1; i < v.size() - 1; i++) {
		printf(", %d", v[i]);
	}
	printf(", %d>", v[v.size()-1]);
	}
	else {
		printf("<%d>", v[0]);
	}
	return 0;
}