#include <iostream>
using namespace std;

class Class2; // Forward declaration

class Class1 {
private:
    int data1;

public:
    Class1(int val) : data1(val) {}

    inline friend void exchange(Class1 &c1, Class2 &c2);
    inline void display() const {
        cout << "Class1 Data: " << data1 << endl;
    }
};

class Class2 {
private:
    int data2;

public:
    Class2(int val) : data2(val) {}

    inline friend void exchange(Class1 &c1, Class2 &c2);
    inline void display() const {
        cout << "Class2 Data: " << data2 << endl;
    }
};

void exchange(Class1 &c1, Class2 &c2) {
    int temp = c1.data1;
    c1.data1 = c2.data2;
    c2.data2 = temp;
}

int main() {
    Class1 obj1(100);
    Class2 obj2(200);

    cout << "Before Exchange:" << endl;
    obj1.display();
    obj2.display();

    exchange(obj1, obj2);

    cout << "After Exchange:" << endl;
    obj1.display();
    obj2.display();

    return 0;
}
