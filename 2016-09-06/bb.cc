// Copyright 2016 UALR ACM

#include <iostream>
#include <tuple>

int min_changes(std::string s);

int min_changes(std::string s) {
  int c;
  for (c = 0;; c++) {
    size_t i = s.find("010");
    if (i == -1) {
      return c;
    }
    s[i + 2] = '1';
  }
}

int main() {
  // read & return number/string as tuple
  auto input = [&]() -> std::tuple<int, std::string> {
    auto i = int{};
    std::cin >> i;
    auto str = std::string{};
    std::cin >> str;
    return std::make_tuple(i, str);
  };

  // loop while stdin is open
  while (!std::cin.eof()) {
    // pass string to min_changes, print output
    std::cout << min_changes(std::get<1>(input())) << std::endl;
  }
}
