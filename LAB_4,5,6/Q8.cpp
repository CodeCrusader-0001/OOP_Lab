#include <iostream>
using namespace std;

class Integer {
private:
    int value;

public:
    Integer(int val = 0) : value(val) {} // Constructor with default value

    // Friend function to overload the + operator
    friend Integer operator+(const Integer& a, const Integer& b) {
        return Integer(a.value + b.value); // Add the two values
    }

    void display() const {
        cout << "Value: " << value << " Heloo Mam"<< endl;
    }
};

int main() {
    Integer num1(42), num2(28);

    Integer sum = num1 + num2; // Using overloaded + operator
    sum.display();

    return 0;
}
