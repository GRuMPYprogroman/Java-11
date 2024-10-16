#include <iostream>
#include <vector>
#include <memory>
#include <cmath>
#include <algorithm>

class Cafe
{
    public:
        int x;
        int y;
        unsigned int rate;

        Cafe() : x(0), y(0), rate(0) {}
};

class User
{
    public:
        int x;
        int y;
        User() : x(0), y(0) {}
};

int main()
{
    std::shared_ptr<User> cur_us = std::make_shared<User>();
    std::cout << "Please, enter user's coordinates: ";
    std::cin >> cur_us->x >> cur_us->y;
    std::cout << "\n";

    size_t cafe_amount;
    std::cout << "Please, enter how many cafes are around: ";
    std::cin >> cafe_amount;
    std::cout << "\n";

    std::vector<std::shared_ptr<Cafe>> cafes;
    cafes.reserve(cafe_amount);
    std::cout << "Enter cafes' coordinates (x;y) and rating: ";
    for (unsigned int i = 0; i < cafe_amount; ++i)
    {
        auto cafe = std::make_unique<Cafe>();
        std::cout << "Cafe " << (i + 1) << ": ";
        std::cin >> cafe->x >> cafe->y >> cafe->rate;
        cafes.push_back(std::move(cafe));
    }

    unsigned int to_find;
    std::cout << "Please, enter how many cafes to find: ";
    std::cin >> to_find;

    std::vector<std::shared_ptr<Cafe>> nearest_cafes;
    nearest_cafes.reserve(to_find);

    for (const auto& cafe : cafes)
    {
        if (cafe->rate < 4)
        {
            continue;
        }

        double curr_dist = std::sqrt(std::pow((cafe->x - cur_us->x), 2) + std::pow((cafe->y - cur_us->y), 2));

        if (nearest_cafes.size() < to_find)
        {
            nearest_cafes.push_back(cafe);
        }
        else
        {
            //Здесь используется стандарный алгоритм, для поиска и замены(в случае, если новая кафешка ближе находится) самой далекой кафешки.
            //farthest_it - самая далекая кафешка из всех онных для вектора nearest_cafes, [&] - захват cur_us-ера по ссылке.
            auto farthest_it = std::max_element(nearest_cafes.begin(), nearest_cafes.end(),
                [&](const std::shared_ptr<Cafe>& a, const std::shared_ptr<Cafe>& b) {
                    double dist_a = std::sqrt(std::pow((a->x - cur_us->x), 2) + std::pow((a->y - cur_us->y), 2));
                    double dist_b = std::sqrt(std::pow((b->x - cur_us->x), 2) + std::pow((b->y - cur_us->y), 2));
                    return dist_a < dist_b;
                });

            double farthest_dist = std::sqrt(std::pow(((*farthest_it)->x - cur_us->x), 2) + std::pow(((*farthest_it)->y - cur_us->y), 2));

            if (curr_dist < farthest_dist)
            {
                *farthest_it = cafe;
            }
        }
    }

    //если у всех рейтинг меньше 4-х
    if (!nearest_cafes.size())
    {
        std::cout << "There are no cafes with a suitable rating.\n";
    }
    else
    {
        std::cout << "\nNearest Cafes:\n";
        for (size_t i = 0; i < nearest_cafes.size(); ++i)
        {
            auto cafe = nearest_cafes[i];
            double distance = std::sqrt(std::pow((cafe->x - cur_us->x), 2) + std::pow((cafe->y - cur_us->y), 2));

            std::cout << "Cafe " << (i + 1) << ": (" << cafe->x << ", " << cafe->y << "), Rating: " << cafe->rate << ".\n";
        }
    }
    

    return 0;
}