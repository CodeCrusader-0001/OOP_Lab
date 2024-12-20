#include <iostream>
using namespace std;

int main() {
    float weight, postage = 0;
    cout << "Enter the weight of the letter in grams: ";
    cin >> weight;

    if (weight <= 50) {
        postage = 0.50 * (weight / 10);
    } else if (weight <= 150) {
        postage = 0.50 * 5 + 0.40 * ((weight - 50) / 10);
    } else if (weight <= 400) {
        postage = 0.50 * 5 + 0.40 * 10 + 0.25 * ((weight - 150) / 10);
    } else {
        postage = 0.50 * 5 + 0.40 * 10 + 0.25 * 25 + (25 * ((weight - 400) / 1000));
    }

    cout << "Postage to be paid: Rs. " << postage << endl;
    return 0;
}
