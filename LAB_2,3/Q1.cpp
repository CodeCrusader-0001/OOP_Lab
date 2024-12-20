#include <iostream>
using namespace std;

class Store {
public:
    static float computeAmount(int miners = 0, int toasters = 0, int fans = 0) {
        const float minerCost = 1500, toasterCost = 200, fanCost = 450;
        const float minerDiscount = 0.05, toasterDiscount = 0.10, fanDiscount = 0.15;
        const float salesTax = 0.10;

        float minersNet = miners * minerCost * (1 - minerDiscount);
        float toastersNet = toasters * toasterCost * (1 - toasterDiscount);
        float fansNet = fans * fanCost * (1 - fanDiscount);

        float total = minersNet + toastersNet + fansNet;
        return total * (1 + salesTax);
    }
};

int main() {
    int miners, toasters, fans;
    cout << "Enter number of miners, toasters, and fans: ";
    cin >> miners >> toasters >> fans;

    cout << "Total amount to be paid: Rs. " 
         << Store::computeAmount(miners, toasters, fans) << endl;
    return 0;
}
