#include <iostream>
#include <vector>
#include <algorithm>
#include <string>
#include <cstring>
#include <unordered_set>

using namespace std;

vector<string> poke;
vector<pair<string, int>> cop;

int n, m;

int binarySearch(int left, int right, string target)
{
    int mid;
    while (left <= right)
    {
        mid = (left + right) / 2;
        if (cop[mid].first == target)
            return cop[mid].second;
        else if (cop[mid].first < target)
            left = mid + 1;
        else
            right = mid - 1;
    }
    return -1;
}

int main(void)
{
    ios::sync_with_stdio(false);
    cin.tie(NULL);

    cin >> n >> m;

    for (int i = 1; i <= n; i++)
    {
        string pokemon;
        cin >> pokemon;
        poke.push_back(pokemon);
        cop.push_back({pokemon, i});
    }
    sort(cop.begin(), cop.end());

    for (int i = 0; i < m; i++)
    {
        string search;
        cin >> search;

        if (search[0] >= '1' && search[0] <= '9')
        {
            cout << poke[stoi(search) - 1] << '\n';
        }
        else
        {
            cout << binarySearch(0, poke.size() - 1, search) << '\n';
        }
    }
}