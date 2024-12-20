#include <iostream>
using namespace std;

struct Complex {
    int real, imag;
};

Complex add(Complex a, Complex b) {
    return {a.real + b.real, a.imag + b.imag};
}

Complex sub(Complex a, Complex b) {
    return {a.real - b.real, a.imag - b.imag};
}

Complex mul(Complex a, Complex b) {
    return {a.real * b.real - a.imag * b.imag, a.real * b.imag + a.imag * b.real};
}

Complex div(Complex a, Complex b) {
    int denom = b.real * b.real + b.imag * b.imag;
    return {(a.real * b.real + a.imag * b.imag) / denom, (a.imag * b.real - a.real * b.imag) / denom};
}

void display(Complex c) {
    if(c.imag>=0)
        cout << c.real << " + " << c.imag << "i" << endl;
    else
        cout << c.real << " - " << c.imag*(-1) << "i" << endl;
}

void menu() {
    cout << "1. Add\n2. Subtract\n3. Multiply\n4. Divide\n";
}

int main() {
    Complex a, b, result;
    cout << "Enter real and imaginary parts of the first complex number: ";
    cin >> a.real >> a.imag;
    cout << "Enter real and imaginary parts of the second complex number: ";
    cin >> b.real >> b.imag;

    int choice;
    menu();
    cout << "Enter your choice: ";
    cin >> choice;

    switch (choice) {
        case 1:
            result = add(a, b);
            break;
        case 2:
            result = sub(a, b);
            break;
        case 3:
            result = mul(a, b);
            break;
        case 4:
            result = div(a, b);
            break;
        default:
            cout << "Invalid choice!" << endl;
            return 1;
    }

    cout << "Result: ";
    display(result);
    return 0;
}
