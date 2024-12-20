#include <iostream>
using namespace std;

class Data {
private:
    int day, month, year;

public:
    Data(int d = 12, int m = 10, int y = 2000) : day(d), month(m), year(y) {}
    Data(const Data &obj) : day(obj.day), month(obj.month), year(obj.year) {}

    void display() const {
        cout << "Date: " << day << "-" << month << "-" << year << endl;
    }
};

int main() {
    Data defaultDate;
    defaultDate.display();

    Data paramDate(25, 12, 2021);
    paramDate.display();

    Data copyDate(paramDate);
    copyDate.display();

    return 0;
}
