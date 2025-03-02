#include <iostream>
using namespace std;

int main()
{
    int n;
    cin >> n;
    int v[n];

    ///citirea de la tastatura
    for (int i = 0; i < n; i++)
        cin >> v[i];

    for (int i = 0; i < n/2; i++)
        cout << v[i] << " " << v[n-i-1] << " ";

    if (n % 2 != 0)
        cout << v[n/2];
}
