#include <iostream>
using namespace std;

class Matrix {
private:
    int rows, cols;
    int **data;

public:
    Matrix(int r, int c) : rows(r), cols(c) {
        data = new int*[rows];
        for (int i = 0; i < rows; i++) {
            data[i] = new int[cols];
        }
    }

    void input() {
        cout << "Enter matrix elements:" << endl;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                cin >> data[i][j];
            }
        }
    }

    Matrix add(const Matrix &m) const {
        Matrix result(rows, cols);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result.data[i][j] = data[i][j] + m.data[i][j];
            }
        }
        return result;
    }

    void display() const {
        cout << "Matrix:" << endl;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                cout << data[i][j] << " ";
            }
            cout << endl;
        }
    }

    ~Matrix() {
        for (int i = 0; i < rows; i++) {
            delete[] data[i];
        }
        delete[] data;
    }
};

int main() {
    int rows, cols;
    cout << "Enter rows and columns for matrices: ";
    cin >> rows >> cols;

    Matrix m1(rows, cols), m2(rows, cols);
    cout << "Input for Matrix 1:" << endl;
    m1.input();

    cout << "Input for Matrix 2:" << endl;
    m2.input();

    Matrix result = m1.add(m2);
    cout << "Resultant Matrix:" << endl;
    result.display();

    return 0;
}
