#include <iostream>
#include <fstream>
#include <string>
#include <algorithm>

int main()
{
    std::ifstream fin("parity.in");

    std::string num;

    while(fin >> num && num != "#")
    {
        auto num_ones = std::count(num.begin(), num.end(), '1');

        bool is_even = num_ones % 2 == 0;

        bool needs_even = num.back() == 'e';

        if(needs_even && is_even)
        {
            std::replace(num.begin(), num.end(), 'e', '0');
        }
        if(needs_even && !is_even)
        {
            std::replace(num.begin(), num.end(), 'e', '1');
        }
        if(!needs_even && is_even)
        {
            std::replace(num.begin(), num.end(), 'o', '1');
        }
        if(!needs_even && !is_even)
        {
            std::replace(num.begin(), num.end(), 'o', '0');
        }

        std::cout << num << std::endl;
    }
    fin.close();
}
