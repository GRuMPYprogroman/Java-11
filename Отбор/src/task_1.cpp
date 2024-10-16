#include <iostream>
#include <vector>
#include <exception>
#include <set>
#include <functional>

int main()
{
    size_t n;
    std::cout << "Enter amount of sequence members: ";
    std::cin >> n;
    std::vector<int> sequence(n);
    std::set<int,std::greater<int> > unic_seq;
    
    try
    {
        std::cin.exceptions(std::ios::failbit | std::ios::badbit);

        for (auto index = 0; index < n;++index)
        {
            std::cin >> sequence[index];
        }

        for (auto index = 0; index < n;++index)
        {
            unic_seq.insert(sequence[index]);
        }

        if (unic_seq.size() != n)
        {
            throw "Not enough unique elements in the sequence";
        } 

        std::set<int>::iterator it = unic_seq.begin();    
        int el = 1;

        while(el != 3 )
        {
            it++;
            el++;
        }

        std::cout << "3rd greatest unique number is: " << *it << "\n";
        return 0;
        
    }
    catch(const std::ios_base::failure& e)
    {
        std::cerr << "Enter failure: unsupported data type\n";
    }
    catch (const char* error_message)
    {
        std::cout << error_message <<"\n";
    }
    catch(...)
    {
        std::cerr << "Unknown failure\n";
    }
}