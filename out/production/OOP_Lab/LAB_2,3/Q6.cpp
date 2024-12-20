#include <iostream>
using namespace std;

struct Student {
    string name;
    float marks;
};

void findTopper(Student students[], int n) {
    int topperIndex = 0;
    for (int i = 1; i < n; i++) {
        if (students[i].marks > students[topperIndex].marks) {
            topperIndex = i;
        }
    }
    cout << "Topper: " << students[topperIndex].name << " with marks: " << students[topperIndex].marks << endl;
}

int main() {
    int n;
    cout << "Enter number of students: ";
    cin >> n;

    Student students[n];
    for (int i = 0; i < n; i++) {
        cout << "Enter name and marks of student " << i + 1 << ": ";
        cin >> students[i].name >> students[i].marks;
    }

    findTopper(students, n);
    return 0;
}
