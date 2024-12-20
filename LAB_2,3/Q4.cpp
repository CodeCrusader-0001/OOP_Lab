#include <iostream>
using namespace std;

class Fraction {
private:
    int numerator, denominator;

public:
    Fraction(int num = 1, int denom = 1) : numerator(num), denominator(denom) {}

    Fraction add(const Fraction &f) const {
        return Fraction(numerator * f.denominator + f.numerator * denominator, denominator * f.denominator);
    }

    void subtract(const Fraction &f) {
        numerator = numerator * f.denominator - f.numerator * denominator;
        denominator = denominator * f.denominator;
    }

    void multiply(const Fraction *f) {
        numerator *= f->numerator;
        denominator *= f->denominator;
    }

    void display() const {
        cout << numerator << "/" << denominator << endl;
    }
};

int main() {
    Fraction f1(1, 2), f2(1, 3);
    Fraction sum = f1.add(f2);

    f1.display();
    f2.display();
    
    cout << "Sum: ";
    sum.display();

    f1.subtract(f2);
    cout << "Difference: ";
    f1.display();

    f1.multiply(&f2);
    cout << "Product: ";
    f1.display();

    return 0;
}
