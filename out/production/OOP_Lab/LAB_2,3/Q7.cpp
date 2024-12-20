#include <iostream>
using namespace std;

class Array {
private:
    int *arr;
    int size;

public:
    Array(int s) : size(s) {
        arr = new int[s];
        cout << "Enter " << s << " elements: ";
        for (int i = 0; i < s; i++) {
            cin >> arr[i];
        }
    }

    int findLargest() const {
        int largest = arr[0];
        for (int i = 1; i < size; i++) {
            if (arr[i] > largest) {
                largest = arr[i];
            }
        }
        return largest;
    }

    ~Array() {
        delete[] arr;
    }
};

int main() {
    int n;
    cout << "Enter size of array: ";
    cin >> n;

    Array a(n);
    cout << "Largest element: " << a.findLargest() << endl;
    return 0;
}
