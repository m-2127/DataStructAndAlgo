#include <iostream>

int get_change(int m) {
  //write your code here
  if(m == 0){
	  return 0;
  }
  else if(m < 0){
	  return -2;
  }
  
  
  int one = get_change(m-1)+1;
  int three = get_change(m-3)+1;
  int four = get_change(m-4)+1;
  
  int least = 10000; //since input m is less than 1000
  
  if(one < least && one >= 0){
	  least = one;
  }
  if(three < least && three >= 0){
	  least = three;
  }
  if(four < least && four >= 0){
	  least = four;
  }
  
  return least;
}

int main() {
  int m;
  std::cin >> m;
  std::cout << get_change(m) << '\n';
}
