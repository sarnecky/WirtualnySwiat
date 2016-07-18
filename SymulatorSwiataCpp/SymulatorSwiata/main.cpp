#include <iostream>
#include "Swiat.h"
#include <fstream>
#include <string>
#include <time.h>
#include "Wyjatek.h"
#include "Wyjatek2.h"
#include "zasoby.h"
#include <conio.h>
using namespace std;

int main()
{
	/*
	//TODO
	* KOLIZJA WIRTUALNA
	* prawdopodobienstwo zasiania nowej rosliny
	* jak liczyc wiek ?
	* zrobic destruktory
	* blad z sila
	* zrobic mlode  
	* usunac true z glownej petli
	*/
	try
	{
		srand((unsigned int)time(NULL));
		ofstream zapis("pl_zapis.txt");
		ifstream odczyt("pl_odczyt.txt"); 
		Swiat swiat;
		odczyt >> swiat;
		//swiat.stworzOrganizm(swiat, LIS, 15, 15);
		//swiat.usunOrganizm(swiat, 0, 0);
		swiat.rysujSwiat();
		swiat.wykonajTure(swiat);
		zapis << swiat;
		/*Swiat *swiat2 = new Swiat(swiat);*/
		//  transfer obiektu
		/*Swiat swiat3;
		swiat3.transport(swiat,4);
		swiat3.rysujSwiat();*/
	}
	catch (Wyjatek &w)
	{
		cout << "Wyjatek\n" << w.tekst;
	}
	catch (Wyjatek2 &w)
	{
		cout << "Wyjatek\n" << w.tekst<<" Ten znak to: "<<w.znak<<" Pozycja: "<<w.x<<" "<<w.y;
	}
	

	getchar();
	return 0;
}