#include <iostream>
#include <string>
using namespace std;

struct Publication {
    string title;
    string author;
    float price;
};

struct Book : Publication {
    int pageCount;

    void getData() {
        cout << "Enter title, author, price, and page count: ";
        cin >> title >> author >> price >> pageCount;
    }

    void display() {
        cout << "Book: " << title << " by " << author << ", Price: " << price << ", Pages: " << pageCount << endl;
    }
};

struct Ebook : Publication {
    float playingTime;

    void getData() {
        cout << "Enter title, author, price, and playing time: ";
        cin >> title >> author >> price >> playingTime;
    }

    void display() {
        cout << "Ebook: " << title << " by " << author << ", Price: " << price << ", Time: " << playingTime << " mins" << endl;
    }
};

int main() {
    Book book;
    Ebook ebook;

    book.getData();
    ebook.getData();

    book.display();
    ebook.display();

    return 0;
}
