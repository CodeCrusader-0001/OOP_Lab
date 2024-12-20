#include <iostream>
#include <math.h>
using namespace std;

class Cube; // Forward declaration

class Cuboid {
private:
    int length, breadth, height;

public:
    Cuboid(int l, int b, int h) : length(l), breadth(b), height(h) {}

    int calculateArea() const {
        return 2 * (length * breadth + breadth * height + length * height);
    }

    friend class Cube;
};

class Cube {
private:
    int side;

public:
    Cube() : side(0) {}

    void convertFromCuboid(const Cuboid &c) {
        int volume = c.length * c.breadth * c.height;
        side = cbrt(volume); // Approximate conversion to cube
    }

    int calculateArea() const {
        return 6 * side * side;
    }

    void display() const {
        cout << "Cube Side: " << side << endl;
    }
};

int main() {
    Cuboid cuboid(4, 5, 6);
    cout << "Area of Cuboid: " << cuboid.calculateArea() << endl;

    Cube cube;
    cube.convertFromCuboid(cuboid);
    cube.display();
    cout << "Area of Cube: " << cube.calculateArea() << endl;

    return 0;
}
