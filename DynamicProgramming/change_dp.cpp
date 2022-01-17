#include <iostream>
#include <algorithm>

int get_change(int m, int *counter) {
  //write your code here
  if(m == 0){
	  return 0;
  }
  else if(m < 0){
	  return -2;
  }
  
  int one = 10000, three = 10000, four = 10000;
  
  if((m-2)>=0){
	if(counter[m-2] >= 0)
	  one = counter[m-2];
	else
	  one = get_change(m-1, counter)+1;
	  counter[m-2] = one;
  }
  else{
	one = get_change(m-1, counter)+1;
  }

  
  if((m-4)>=0){
	if(counter[m-4] >= 0)
	  three = counter[m-4];
	else
	  three = get_change(m-3, counter)+1;
	  counter[m-4] = three;
  }
  else{
	three = get_change(m-3, counter)+1;
  }
  
  if((m-5)>=0){
	if(counter[m-5] >= 0)
	  four = counter[m-5];
	else
	  four = get_change(m-4, counter)+1;
	  counter[m-5] = four;
  }
  else{
	four = get_change(m-4, counter)+1;
  }
  
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
  int counter[m];
  std::fill_n(counter, m, -1);
  std::cout << get_change(m, counter) << '\n';
}
