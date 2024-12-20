#include <iostream>
using namespace std;

class Library {
public:
    static void calculateDueDate(int day, int month, int year, int daysDue = 15) {
        day += daysDue;
        while (day > 30) { // Assume each month has 30 days.
            day -= 30;
            month++;
            if (month > 12) {
                month = 1;
                year++;
            }
        }
        cout << "Due Date: " << day << "-" << month << "-" << year << endl;
    }
};

int main() {
    int day, month, year, daysDue;
    cout << "Enter current date (day month year): ";
    cin >> day >> month >> year;
    cout << "Enter no. of days due: ";
    cin >> daysDue;

    Library::calculateDueDate(day, month, year, daysDue);
    return 0;
}
