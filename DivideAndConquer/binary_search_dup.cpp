#include <iostream>
#include <cassert>
#include <vector>

using std::vector;

long long binary_search(const vector<long long> &a, long long x) {
  long long left = 0, right = (long long)a.size();
  
   for (long long i = 0; left <= right;) {
		i =  (left + right) / 2;
		
		if(x == a[i]){
		  if(x != a[i-1]){
			return i;	
		  }
		  right = i - 1;
		}
		else if(x < a[i]){
			right = i - 1;
		}
		else{
			left = i + 1;
		}
  }
 
   return -1;
}

int linear_search(const vector<int> &a, int x) {
  for (size_t i = 0; i < a.size(); ++i) {
    if (a[i] == x) return i;
  }
  return -1;
}

int main() {
	
  int n;
  std::cin >> n;
  vector<long long> a(n);
  for (size_t i = 0; i < a.size(); i++) {
    std::cin >> a[i];
  }
  
  int m;
  std::cin >> m;
  vector<long long> b(m);
  for (int i = 0; i < m; ++i) {
    std::cin >> b[i];
  }
  for (int i = 0; i < m; ++i) {
    //replace with the call to binary_search when implemented
    std::cout << binary_search(a, b[i]) << ' ';
  }
}
