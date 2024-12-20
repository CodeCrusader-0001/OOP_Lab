#include <iostream>
using namespace std;

struct Arithmetic {
    int num1, num2;
};

void add(Arithmetic a) {
    cout << "Addition: " << a.num1 + a.num2 << endl;
}

void sub(Arithmetic a) {
    cout << "Subtraction: " << a.num1 - a.num2 << endl;
}

void mul(Arithmetic a) {
    cout << "Multiplication: " << a.num1 * a.num2 << endl;
}

void div(Arithmetic a) {
    if (a.num2 != 0)
        cout << "Division: " << float(a.num1) / float(a.num2) << endl;
    else
        cout << "Division by zero is not allowed!" << endl;
}

int main() {
    Arithmetic a;
    cout << "Enter two numbers: ";
    cin >> a.num1 >> a.num2;

    add(a);
    sub(a);
    mul(a);
    div(a);

    return 0;
}
