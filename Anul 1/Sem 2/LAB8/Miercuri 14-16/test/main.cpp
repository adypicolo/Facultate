///
/// 1. Creati un vector care trebuie sa contina entitati din
///    fiecare tip de asigurare definit mai sus.

/// 2. Sortati vectorul in functie de pretul asociat fiecarei asigurari.
///    Afisati toate atributele obiectelor din vector intr-un fisier.

/// 3. Identificati medicul cu cel mai mare tarif_ora care apare in asigurarile vandute.


#include <iostream>
#include <vector>
#include <string>
#include <string.h>
#include <fstream>
using namespace std;

class Baza{
    public:
        //virtual void afisare() const = 0;
        virtual double getPret() const = 0;
        virtual ~Baza() { };
};

class AB: public Baza{
    protected:
        int nr_max;
        char* detalii = NULL;
        int pret; /// pret total = pret

    /// C F P
    AB():nr_max(0),detalii(NULL),pret(0) {}

    /// C C P
    AB(int nr, char *d, int p):nr_max(nr),pret(p){
        if(d != NULL){
            delete []detalii;
            detalii = new char[strlen(d)+1];
            strcpy(detalii, d);

        } else detalii = NULL;
    }

    /// OP=
    AB& operator=(const AB &a){
        nr_max = a.nr_max;
        if(a.detalii != NULL){
            delete []detalii;
            detalii = new char[strlen(a.detalii)+1];
            strcpy(detalii, a.detalii);

        } else detalii = NULL;
        pret = a.pret;

        return *this;
    }

    /// C COPIERE
    AB(const AB &a){
        *this = a;
    }

    /// DESTRUCTOR
    ~AB(){
        delete []detalii;
    }

    /// getPret
    double getPret() const{
        return pret;
    }
    /// afisare
    friend ostream& operator<<(ostream &dev, const AB &a){
        dev << a.nr_max << " " << a.detalii << " " << a.pret;
        return dev;
    }

};

class Medic{
    char cod[6];
    int tarif_ora;

    public:
    /// C F P
    Medic():tarif_ora(0){
        strcpy(cod, "");
    }

    /// C C P
    Medic(char c[6], int to):tarif_ora(to){
        strcpy(cod, c);
    }

    /// afisare
    friend ostream& operator<<(ostream &dev, const Medic &m){
        dev << m.cod << " " << m.tarif_ora;
        return dev;
    }
    /// getPret
    double getPret() const {
        return tarif_ora;
    }

};

class AP: public AB{
    protected:
        string *investigatii;
        int nr;
        Medic m;
        int nom; ///pret total = pret + nom * tarif_ora medic m
    public:
        /// C F P
        AP():investigatii(NULL),nr(0),m("", 0),nom(0){}
        /// C C P
        AP(int nrr, char *d, int p, string *in, int n, Medic med, int no):AB(nrr, d, p), nr(n), m(med), nom(no){
            if (in != NULL){
                delete []investigatii;
                investigatii = new string[n];
                for (int i = 0; i < n; i++)
                    investigatii[i] = in[i];
            } else investigatii = NULL;
        }
        /// OP=
        AP& operator=(const AP& a){
            AB::operator=(a);

            if (a.investigatii != NULL){
                delete []investigatii;
                investigatii = new string[a.nr];
                for (int i = 0; i < a.nr; i++)
                    investigatii[i] = a.investigatii[i];
            } else investigatii = NULL;
            nr = a.nr;
            m = a.m;
            nom = a.nom;

            return *this;
        }
        /// C C
        AP(const AP &a){
            *this = a;
        }
        /// D
        ~AP(){
            delete []investigatii;
        }
        /// getPret
        double getPret(){
            return AB::getPret() + nom * m.getPret();
        }
        /// afisare
        friend ostream& operator<<(ostream &dev, const AP &a){
            dev << a.nr_max << " " << a.detalii << " " << a.pret;;
            for (int i = 0; i < a.nr; i++)
                dev << a.investigatii[i] << " ";
            dev << a.nr << " " << a.m << " " << a.nom;
            return dev;
        }

};

class AU: public Baza{
    int baza_pret;
    int nr_ani; /// pret total = (100 % nr_ani * 2%)*baza_pret

    ///CFP
    AU():baza_pret(0),nr_ani(0) {}
    ///CCP
    AU(int b, int n): baza_pret(b),nr_ani(n) {}
    ///DESTRUCTOR
    ~AU() {};
    ///afisare
    friend ostream& operator<<(ostream &dev, const AU &a){
        dev << a.baza_pret << " " << a.nr_ani;
        return dev;
    }
    ///getPret
    double getPret() const{
        return (100 % nr_ani * ((double)(2/100)))*baza_pret;
    }
};

void sortare(vector<Baza *> v){
    for (int i = 0; i < v.size()-1; i++)
        for (int j = i + 1; j < v.size(); j++)
            if (v[i]->getPret() > v[j]->getPret()){
                //vector<Baza *> aux = v[i];
                v[i] = v[j];
                //v[j] = aux;
            }

}

int main(){
    vector<Baza *> v;
    //v.push_back(new AB(...));
    //v.push_back(new AU(...));
    //v.push_back(new AP(...));

    ///2.
    sortare(v);
    fstream g("output.txt", ios::out|ios::app);
    for (int i = 0; i < v.size(); i++){
        g << v[i] << endl;
    }

    ///3.
    for (int i = 0; i < v.size(); i++){

    }



}
