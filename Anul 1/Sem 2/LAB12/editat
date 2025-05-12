#include <assert.h>
#include <iostream>
#include <string>
using namespace std;

template <typename T>
class vector {
    int dim;
    T* buf;

public:
    vector();
    vector(int, T*);
    vector(const vector&);
    vector& operator=(const vector&);
    ~vector();

    T& operator[](int i);
    int getDim();

    void sortare();                          // cerinta 2
    void addElem(int, const T&);             // cerinta 2
    void removeElem(int);                    // cerinta 2

    friend ostream& operator<<(ostream& dev, vector& v) {
        dev << "Vector:\n";
        dev << "Nr Elem: " << v.dim << endl;
        for (int i = 0; i < v.dim; i++) {
            dev << v.buf[i];
            if (i < v.dim - 1)
                dev << ", ";
            else
                dev << ".\n";
        }
        dev << endl;
        return dev;
    }
};

template <typename T>
vector<T>::vector() {
    dim = 0;
    buf = NULL;
}

template <typename T>
vector<T>::vector(int d, T* b) {
    dim = d;
    if (b == NULL) buf = NULL;
    else {
        buf = new T[dim];
        for (int i = 0; i < dim; i++)
            buf[i] = b[i];
    }
}

template <typename T>
vector<T>::vector(const vector<T>& v) {
    dim = v.dim;
    if (v.buf == NULL) buf = NULL;
    else {
        buf = new T[dim];
        for (int i = 0; i < dim; i++)
            buf[i] = v.buf[i];
    }
}

template <typename T>
vector<T>::~vector() {
    delete[] buf;
}

template <typename T>
vector<T>& vector<T>::operator=(const vector& v) {
    if (this == &v) return *this;

    if (buf != NULL) delete[] buf;
    dim = v.dim;
    if (v.buf == NULL) buf = NULL;
    else {
        buf = new T[dim];
        for (int i = 0; i < dim; i++)
            buf[i] = v.buf[i];
    }
    return *this;
}

template <typename T>
T& vector<T>::operator[](int i) {
    assert(i >= 0 && i < dim);
    return buf[i];
}

template <typename T>
int vector<T>::getDim() {
    return dim;
}

// ===================== CERINTA 2 =====================

template <typename T>
void vector<T>::addElem(int poz, const T& val) {
    if (poz < 0 || poz > dim) return;
    T* newBuf = new T[dim + 1];
    for (int i = 0; i < poz; i++)
        newBuf[i] = buf[i];
    newBuf[poz] = val;
    for (int i = poz; i < dim; i++)
        newBuf[i + 1] = buf[i];
    delete[] buf;
    buf = newBuf;
    dim++;
}

template <typename T>
void vector<T>::removeElem(int poz) {
    if (poz < 0 || poz >= dim) return;
    if (dim == 1) {
        delete[] buf;
        buf = NULL;
        dim = 0;
        return;
    }
    T* newBuf = new T[dim - 1];
    for (int i = 0; i < poz; i++)
        newBuf[i] = buf[i];
    for (int i = poz + 1; i < dim; i++)
        newBuf[i - 1] = buf[i];
    delete[] buf;
    buf = newBuf;
    dim--;
}

template <typename T>
void vector<T>::sortare() {
    for (int i = 0; i < dim - 1; i++)
        for (int j = i + 1; j < dim; j++)
            if (buf[j] < buf[i]) {
                T aux = buf[i];
                buf[i] = buf[j];
                buf[j] = aux;
            }
}

// ===================== CLASA COMPLEX =====================

class complex {
    double re, im;

public:
    complex(double r = 0, double i = 0) : re(r), im(i) {}

    bool operator<(const complex& other) const {
        return re < other.re;
    }

    friend ostream& operator<<(ostream& d, complex x) {
        d << x.re << " j" << x.im;
        return d;
    }
};

// ===================== CLASA PERECHE =====================

template <typename X, typename Y>
class pereche {
    X elem1;
    Y elem2;

public:
    pereche(const X& e1 = X(), const Y& e2 = Y()) {
        elem1 = e1;
        elem2 = e2;
    }

    bool operator<(const pereche& alt) const {
        return elem1 < alt.elem1; // sortare lexicografica dupa elem1
    }

    friend ostream& operator<<(ostream& d, const pereche& x) {
        d << x.elem1 << " -> " << x.elem2;
        return d;
    }
};

// ===================== CLASA PERSONALIZATA (CERINTA 4) =====================

class Masina {
    string marca;
    int an;

public:
    Masina(string m = "", int a = 0) : marca(m), an(a) {}

    bool operator<(const Masina& alta) const {
        return an < alta.an;
    }

    friend ostream& operator<<(ostream& d, const Masina& m) {
        d << m.marca << " (" << m.an << ")";
        return d;
    }
};

// ===================== MAIN =====================

int main() {
    // Cerinta 1: vector<string> si vector<int>
    string vs[3] = { "mere", "pere", "banane" };
    vector<string> v1(3, vs);
    cout << v1;

    int vi[4] = { 7, 2, 5, 1 };
    vector<int> v2(4, vi);
    cout << v2;

    // Cerinta 2: test sortare, addElem, removeElem
    v2.sortare();
    cout << "Sortat: " << v2;

    v2.addElem(2, 10);
    cout << "Dupa adaugare: " << v2;

    v2.removeElem(1);
    cout << "Dupa stergere: " << v2;

    // Cerinta 3: dictionar cu pereche<string, string>
    pereche<string, string> d[3] = {
        pereche<string, string>("apple", "mar"),
        pereche<string, string>("banana", "banana"),
        pereche<string, string>("pear", "para")
    };
    vector<pereche<string, string>> dict(3, d);
    dict.sortare();
    cout << "Dictionar sortat:\n" << dict;

    // Cerinta 4: vector<Masina>
    Masina m[3] = {
        Masina("Dacia", 2005),
        Masina("Ford", 2010),
        Masina("BMW", 2000)
    };
    vector<Masina> vm(3, m);
    vm.sortare();
    cout << "Masini sortate:\n" << vm;

    return 0;
}
