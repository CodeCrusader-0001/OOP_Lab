#include <iostream>
using namespace std;

class Integer {
private:
    int value;

public:
    Integer() : value(0) {} // Default constructor

    // Friend function to overload >> operator for input
    friend istream& operator>>(istream& in, Integer& obj) {
        cout << "Enter an integer: ";
        in >> obj.value;
        return in;
    }

    // Friend function to overload << operator for output
    friend ostream& operator<<(ostream& out, const Integer& obj) {
        out << "Integer value: " << obj.value;
        return out;
    }
};

int main() {
    Integer num;
    cin >> num; // Input using >> operator
    cout << num; // Output using << operator
    return 0;
}
