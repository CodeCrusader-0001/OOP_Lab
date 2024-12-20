#include <iostream>
using namespace std;

class Class1; // Forward declaration

class Class2 {
private:
    int num2;

public:
    Class2(int n) : num2(n) {}
    friend float calculateMean(const Class1 &c1, const Class2 &c2);
};

class Class1 {
private:
    int num1;

public:
    Class1(int n) : num1(n) {}
    friend float calculateMean(const Class1 &c1, const Class2 &c2);
};

float calculateMean(const Class1 &c1, const Class2 &c2) {
    return (c1.num1 + c2.num2) / 2.0;
}

int main() {
    Class1 obj1(10);
    Class2 obj2(20);

    cout << "Mean of numbers: " << calculateMean(obj1, obj2) << endl;

    return 0;
}
