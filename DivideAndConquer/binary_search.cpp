#include <iostream>
#include <cassert>
#include <vector>

using std::vector;

bool check(int ele, int k)
{
    if (k <= ele) {
        return 1;
    }
    else {
        return 0;
    }
}

int binary_search(const vector<int> &a, int x) {
  long long left = 0, right = (long long)a.size();
  
  while(left < right){
		
		long long mid = (left + right) / 2;
        if (check(a[mid], x)) {
            right = mid;
        }
        else {
            left = mid + 1;
        }
  }
  
  if (a[left] == x){
	  return left;
  }
  else{
	    return -1;
  }
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
  vector<int> a(n);
  for (size_t i = 0; i < a.size(); i++) {
    std::cin >> a[i];
  }
  
  int m;
  std::cin >> m;
  vector<int> b(m);
  for (int i = 0; i < m; ++i) {
    std::cin >> b[i];
  }
  for (int i = 0; i < m; ++i) {
    //replace with the call to binary_search when implemented
    std::cout << linear_search(a, b[i]) << ' ';
  }
}
