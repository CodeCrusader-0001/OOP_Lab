#include <iostream>
#include <cstdlib>
#include <ctime>
using namespace std;

class Period {
private:
    string subject;
    string teacher;

public:
    Period(string s, string t) : subject(s), teacher(t) {}

    void display() const {
        cout << "Subject: " << subject << ", Teacher: " << teacher << endl;
    }
};

int main() {
    srand(time(0));
    Period periods[] = {
        Period("Mathematics", "Mr. Sharma"),
        Period("Physics", "Dr. Singh"),
        Period("Chemistry", "Mrs. Verma"),
        Period("Biology", "Dr. Gupta")
    };

    int randomIndex = rand() % 4;
    cout << "Random Period Details:" << endl;
    periods[randomIndex].display();

    return 0;
}
