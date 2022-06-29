#include <string>
#include <vector>
#include <unordered_map>

using namespace std;

string solution(vector<string> participant, vector<string> completion) {
	unordered_map<string, int> grp;
	for (string person : participant) {
		++grp[person];
	}
	for (string person : completion) {
		--grp[person];
	}
	for (auto p : grp) {
		if (p.second > 0) {
			return p.first;
		}
	}
}