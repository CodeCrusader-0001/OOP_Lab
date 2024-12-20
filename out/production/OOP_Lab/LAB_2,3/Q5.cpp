#include <iostream>
#include <cstring>
using namespace std;

class Student {
private:
    int admno;
    char name[20];
    float marksEng, marksMaths, marksSci, total;

    void compute() {
        total = marksEng + marksMaths + marksSci;
    }

public:
    void readData() {
        cout << "Enter Admission Number: ";
        cin >> admno;
        cout << "Enter Name: ";
        cin.ignore();
        cin.getline(name, 20);
        cout << "Enter Marks (English, Maths, Science): ";
        cin >> marksEng >> marksMaths >> marksSci;
        compute();
    }

    void showData() const {
        cout << "Admission No: " << admno << "\nName: " << name
             << "\nMarks - English: " << marksEng
             << ", Maths: " << marksMaths
             << ", Science: " << marksSci
             << "\nTotal: " << total << endl;
    }
};

int main() {
    Student s;
    s.readData();
    s.showData();
    return 0;
}
