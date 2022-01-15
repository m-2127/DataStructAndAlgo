#include <algorithm>
#include <iostream>
#include <vector>

using std::vector;

int get_majority_element(vector<int> &a, int left, int right) {
  if(left == right){
		return a[left];
	}
	
	int mid = left + (right - left)/2;
	
	int first = get_majority_element( a, left, mid);
	int second = get_majority_element( a, mid+1, right);
	int firstCount = 0;
	int secondCount = 0;

	
	for (int i = left; i <= right; i++){
		if(a[i] == first){
			firstCount++;
		}
		else if (a[i] == second){
			secondCount++;
		}
	}
	
	if(firstCount > ((right+1-left)/2)){
		return first;
	}
	else if(secondCount > ((right+1-left)/2)){
		return second;
	}
	else{
		return -1;
	}
}

int main() {
  int n;
  std::cin >> n;
  vector<int> a(n);
  for (size_t i = 0; i < a.size(); ++i) {
    std::cin >> a[i];
  }
  std::cout << (get_majority_element(a, 0, a.size()-1) != -1) << '\n';
}
