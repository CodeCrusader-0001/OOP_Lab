#include <iostream>
#include <string>
using namespace std;

class Integer {
private:
    int value;

public:
    Integer(int val = 0) : value(val) {} // Constructor with default value

    // Overloading the `==` operator to compare Integer with string
    bool operator==(const string& str) const {
        return to_string(value) == str; // Compare integer value as string
    }
}; 

int main() {
    Integer num(123); // Initialize with a value
    string str = "123";

    if (num == str) {
        cout << "The Integer is equal to the string." << endl;
    } else {
        cout << "The Integer is not equal to the string." << endl;
    }

    return 0;
}
