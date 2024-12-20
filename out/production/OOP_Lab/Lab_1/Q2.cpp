#include <iostream>
using namespace std;

int main() {
    int miners, toasters, fans;
    cout << "Enter the number of miners, toasters, and fans: ";
    cin >> miners >> toasters >> fans;

    float minerCost = miners * 1500;
    float toasterCost = toasters * 200;
    float fanCost = fans * 450;

    float discountMiner = minerCost * 0.05;
    float discountToaster = toasterCost * 0.10;
    float discountFan = fanCost * 0.15;

    float totalCost = minerCost + toasterCost + fanCost;
    float totalDiscount = discountMiner + discountToaster + discountFan;
    float netValue = totalCost - totalDiscount;

    float salesTax = netValue * 0.10;
    float amountToPay = netValue + salesTax;

    cout << "Amount to be paid by the store: Rs. " << amountToPay << endl;
    return 0;
}
