package Zwierzeta;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import Organizmy.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Czlowiek extends Zwierze{
	
	 private Zasoby a;
	// private boolean _calopalenie;
	 //private int _tury;
	 private int _pauza;
	 
	 public Czlowiek(int x1, int y1)
	 {
		    wiek = 0;
			sila = 5;
			inicjatywa = 4;
			wyglad = 'C';
			x = x1;
			y = y1;
			_calopalenie = false;
			_tury = 0;
			_id = 0;
			_pauza = 0;
			color = Color.BLACK;
	 }
	 
	 public void akcja(Swiat swiat, int i, int j)
	 {
		 //sterowanie
		    kolizja(swiat, i, j);
			wiek++;
	 }
	
	 public void kolizja(Swiat swiat, int i, int j)
	 {
		//i,j indexy pola na ktore wchodzi czlowiek
			int oldX, oldY;
			
			//calopalenie
			calopalenie(swiat,i,j);
			
				if (swiat.getSymbol(i,j) != ' ') //trafienie na inny organizm
				{
					if (getSila() > swiat.getSilaOrganizmu(i,j))
					{
						if (swiat.getSymbol(i, j) == 'G')
						{
							swiat.wywolajKolizje(swiat, i, j,getx(), gety() );
						}

						swiat.logi(rysowanie(), " zabija ", swiat.getSymbol(i, j));
						zabijOrganizm(swiat, i, j);

						oldX = getx();
						oldY = gety();
						set(i, j);
						zmianaMiejsca(swiat, oldX, oldY);
					}
					else
					{
						swiat.logi(rysowanie(), " zostaje zabity przez ", swiat.getSymbol(i, j));
						swiat.zabijStworzenie(swiat, getx(), gety());
					}
				}
				else  //trafienie na puste pole
				{
					oldX = getx();
					oldY = gety();
					set(i, j);
					zmianaMiejsca(swiat, oldX, oldY);
				}
	 }
	 
	 public void calopalenie(Swiat swiat, int i, int j)
	 {
		 if (_calopalenie)
			{
			 System.out.println("pale");
				if (getx() + 1< 20 && swiat.getSymbol(getx() + 1, gety()) != ' ')
				{
					swiat.zabijStworzenie(swiat, getx() + 1, gety());
				}
				if (getx() - 1 > 0 && swiat.getSymbol(getx() - 1, gety()) != ' ')
				{
					swiat.zabijStworzenie(swiat, getx() - 1, gety());
				}
				if (gety() + 1 > 0 && swiat.getSymbol(getx(), gety() + 1) != ' ')
				{
					swiat.zabijStworzenie(swiat, getx(), gety() + 1);
				}
				if (gety() - 1 <20 && swiat.getSymbol(getx(), gety() - 1) != ' ')
				{
					swiat.zabijStworzenie(swiat, getx(), gety() - 1);
				}
				_tury++;
				_pauza = 0;
			}
			if (_tury == 5) //calopalenie dziala 5 rund
			{
				_calopalenie = false;

			}
			if (_pauza <5 && _tury == 5 && _calopalenie == false) //warunek przerwy 5 rund 
			{
				_pauza++;
			}
			else if (_pauza == 5) //po minieciu 10 rund, znowu mozna uruchomic moc
			{
				_pauza = 0;
				_tury = 0;
			}
	 }
}
