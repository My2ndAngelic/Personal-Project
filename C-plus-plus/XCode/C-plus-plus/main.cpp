//
//  main.cpp
//  C-plus-plus
//
//  Created by My2ndAngelic on 01/12/2020.
//  Copyright © 2020 My2ndAngelic. All rights reserved.
//

#include <iostream>

int main(int argc, const char * argv[]) {
    // insert code here...
    std::cout << "Hello, please enter your name: ";
    std::string a;
    std::cin >> a;
    std::cout << "Hello " << a << ". Please enter your age: ";
    std::int32_t b;
    std::cin >> b;
    std::cout << "You are " << b << " years old." << std::endl;
    return 0;
}
