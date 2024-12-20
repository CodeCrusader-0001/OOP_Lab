#include <iostream>
#include <string>
using namespace std;

class Telephone {
    string name;
    int calls;
    float billAmount;

public:
    void input() {
        cout << "Enter customer's name and number of calls: ";
        cin >> name >> calls;
    }

    void computeBill() {
        if (calls <= 100) {
            billAmount = 200;
        } else if (calls <= 150) {
            billAmount = 200 + (calls - 100) * 0.60;
        } else if (calls <= 200) {
            billAmount = 200 + 50 * 0.60 + (calls - 150) * 0.50;
        } else {
            billAmount = 200 + 50 * 0.60 + 50 * 0.50 + (calls - 200) * 0.40;
        }
    }

    void output() {
        cout << "Customer: " << name << ", Bill: Rs. " << billAmount << endl;
    }
};

int main() {
    Telephone t;
    t.input();
    t.computeBill();
    t.output();
    return 0;
}
