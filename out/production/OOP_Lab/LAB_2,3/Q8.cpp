#include <iostream>
#include <string>
using namespace std;

class BankAccount {
private:
    string accountHolder;
    int accountNumber;
    double balance;

public:
    BankAccount(string name, int accNum, double initialBalance = 0.0)
        : accountHolder(name), accountNumber(accNum), balance(initialBalance) {}

    void deposit(double amount) {
        balance += amount;
        cout << "Deposited Rs. " << amount << ". New balance: Rs. " << balance << endl;
    }

    void withdraw(double amount) {
        if (amount > balance) {
            cout << "Insufficient balance!" << endl;
        } else {
            balance -= amount;
            cout << "Withdrawn Rs. " << amount << ". New balance: Rs. " << balance << endl;
        }
    }

    void display() const {
        cout << "Account Holder: " << accountHolder << "\nAccount Number: " 
             << accountNumber << "\nBalance: Rs. " << balance << endl;
    }
};

int main() {
    BankAccount account("Tony Stark", 9999999, 5000);

    account.display();
    account.deposit(2000);
    account.withdraw(3000);
    account.withdraw(5000);

    return 0;
}
