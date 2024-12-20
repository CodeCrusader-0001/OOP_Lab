#include <iostream>
#include <string>
#include <vector>
using namespace std;

class Item {
protected:
    string title;
    string type;

public:
    Item(string t, string ty) : title(t), type(ty) {}

    virtual void display() const {
        cout << "Title: " << title << ", Type: " << type << endl;
    }
};

class Book : public Item {
public:
    Book(string t) : Item(t, "Book") {}
};

class Journal : public Item {
public:
    Journal(string t) : Item(t, "Journal") {}
};

int main() {
    vector<Item*> library;
    int choice;

    do {
        cout << "\nLibrary Menu:\n1. Add Book\n2. Add Journal\n3. Display Items\n4. Exit\nEnter choice: ";
        cin >> choice;

        if (choice == 1) {
            string title;
            cout << "Enter Book Title: ";
            cin.ignore();
            getline(cin, title);
            library.push_back(new Book(title));
        } else if (choice == 2) {
            string title;
            cout << "Enter Journal Title: ";
            cin.ignore();
            getline(cin, title);
            library.push_back(new Journal(title));
        } else if (choice == 3) {
            for (const auto &item : library) {
                item->display();
            }
        }
    } while (choice != 4);

    // Free memory
    for (auto item : library) {
        delete item;
    }

    return 0;
}
