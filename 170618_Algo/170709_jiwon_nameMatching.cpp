#include <iostream>
#include <vector>
using namespace std;


vector<int> calc(const vector<int>& a) {
	vector<int> ret(a.size() - 1);
	for (int i = 0; i < a.size() - 1; ++i) {
		ret[i] = (a[i] + a[i + 1]) % 10;
	}
	return ret;
}

int main() {
	int n;
	cin >> n;
	vector<int> a(n);
	for (int i = 0; i < n; ++i) cin >> a[i];
	while (a.size() > 2) {
		a = calc(a);
	}
	cout << a[0] << a[1] << '\n';

	system("pause");
	return 0;
}
