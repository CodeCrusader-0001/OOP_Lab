#include <iostream>
#include <string>
#include <vector>
#include <climits>
using namespace std;

class Book {
private:
    string title;
    string subject;
    double price;

public:
    Book(string t, string s, double p) : title(t), subject(s), price(p) {}

    double getPrice() const { return price; }
    string getTitle() const { return title; }
    string getSubject() const { return subject; }

    void display() const {
        cout << "Title: " << title << ", Subject: " << subject << ", Price: Rs. " << price << endl;
    }
};

void findCheapestBook(const vector<Book> &books, const string &subject) {
    double minPrice = INT_MAX;
    Book cheapestBook("", "", 0);

    for (const auto &book : books) {
        if (book.getSubject() == subject && book.getPrice() < minPrice) {
            minPrice = book.getPrice();
            cheapestBook = book;
        }
    }

    if (minPrice == INT_MAX) {
        cout << "No books available for the subject \"" << subject << "\"." << endl;
    } else {
        cout << "Cheapest Book in \"" << subject << "\":" << endl;
        cheapestBook.display();
    }
}

int main() {
    vector<Book> books = {
        Book("C++ Basics", "Programming", 250),
        Book("Java Fundamentals", "Programming", 300),
        Book("Data Structures", "Programming", 200),
        Book("Physics 101", "Science", 150)
    };

    string subject;
    cout << "Enter subject to find cheapest book: ";
    cin >> subject;

    findCheapestBook(books, subject);
    return 0;
}
