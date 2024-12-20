#include <iostream>
#include <string>
using namespace std;

class Employee {
private:
    int emp_id;
    string emp_name;
    int age;

public:
    Employee() : emp_id(0), emp_name(""), age(0) {}

    void setData(int id, string name, int a) {
        emp_id = id;
        emp_name = name;
        age = a;
    }

    int getEmpID() const {
        return emp_id;
    }

    void display() const {
        cout << "Employee ID: " << emp_id << ", Name: " << emp_name << ", Age: " << age << endl;
    }
};

int main() {
    Employee employees[3];

    // Input data for 3 employees
    for (int i = 0; i < 3; i++) {
        int id, age;
        string name;
        cout << "Enter details for employee " << i + 1 << " (ID, Name, Age): ";
        cin >> id >> ws;
        getline(cin, name);
        cin >> age;
        employees[i].setData(id, name, age);
    }

    // Search employee by ID
    int search_id;
    cout << "Enter Employee ID to search: ";
    cin >> search_id;

    bool found = false;
    for (int i = 0; i < 3; i++) {
        if (employees[i].getEmpID() == search_id) {
            cout << "Employee Found: ";
            employees[i].display();
            found = true;
            break;
        }
    }

    if (!found) {
        cout << "Employee with ID " << search_id << " not found." << endl;
    }

    return 0;
}
