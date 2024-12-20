#include <algorithm> // For std::remove
#include <string>   
#include <iostream>
#include <vector>
#include <sstream> // For string stream to handle input in specific format
using namespace std;

class Vector {
private:
    vector<int> elements;

public:
    Vector() {}

    // Overload >> operator to input a vector object in the form [10, 20, 30, ...]
    friend istream &operator>>(istream &in, Vector &v) {
        string input;
        getline(in, input);

        // Remove brackets and parse the numbers
        input.erase(remove(input.begin(), input.end(), '['), input.end());
        input.erase(remove(input.begin(), input.end(), ']'), input.end());

        stringstream ss(input);
        int num;
        while (ss >> num) {
            v.elements.push_back(num);
            if (ss.peek() == ',' || ss.peek() == ' ') {
                ss.ignore();
            }
        }
        return in;
    }

    // Overload << operator to output a vector object
    friend ostream &operator<<(ostream &out, const Vector &v) {
        out << "[ ";
        for (const auto &elem : v.elements) {
            out << elem << " ";
        }
        out << "]";
        return out;
    }

    // Overload + operator to add two vector objects
    Vector operator+(const Vector &v) const {
        Vector result;
        size_t size = min(elements.size(), v.elements.size());

        for (size_t i = 0; i < size; i++) {
            result.elements.push_back(elements[i] + v.elements[i]);
        }
        return result;
    }

    // Overload - operator to subtract a vector object from another
    Vector operator-(const Vector &v) const {
        Vector result;
        size_t size = min(elements.size(), v.elements.size());

        for (size_t i = 0; i < size; i++) {
            result.elements.push_back(elements[i] - v.elements[i]);
        }
        return result;
    }
};

int main() {
    Vector v1, v2;

    // Input two vectors
    cout << "Enter first vector in the format [10, 20, 30, ...]: ";
    cin >> v1;

    cout << "Enter second vector in the format [10, 20, 30, ...]: ";
    cin >> v2;

    // Display the vectors
    cout << "First Vector: " << v1 << endl;
    cout << "Second Vector: " << v2 << endl;

    // Add the vectors
    Vector vSum = v1 + v2;
    cout << "Sum of Vectors: " << vSum << endl;

    // Subtract the vectors
    Vector vDiff = v1 - v2;
    cout << "Difference of Vectors: " << vDiff << endl;

    return 0;
}
