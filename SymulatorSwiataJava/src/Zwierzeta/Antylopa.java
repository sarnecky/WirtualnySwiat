package Zwierzeta;
import java.awt.Color;
import java.util.Random;

import Organizmy.*;

public class Antylopa  extends Zwierze{
	
    private Zasoby a;
	@Override
	public void akcja(Swiat swiat, int i, int j) {
		int ch_x = 0, ch_y = 0, flaga = 0;
		int wybor = 0; //liczby 0-4
		Random gen = new Random();
		while (flaga == 0)
		{
			wybor = gen.nextInt(4); //0-3
			if (wybor == 0) //w prawo
			{
				ch_x = 2;
				ch_y = 0;
			}
			else if (wybor == 1) //w lewo
			{
				ch_x = -2;
				ch_y = 0;
			}
			else if (wybor == 2) //w dol
			{
				ch_x = 0;
				ch_y = 2;
			}
			else if (wybor == 3) // do gory
			{
				ch_x = 0;
				ch_y = -2;
			}

			
			//warunki zapobiegajace wyjsciu poza tablice
			if ((getx() + ch_x) >= 0 &&
				(getx() + ch_x) < 20 &&
				(gety() + ch_y) >= 0 &&
				(gety() + ch_y) < 20)
			{
				flaga = 1;
				//this->set(this->getx() + ch_x, this->gety()+ch_y);
				//zmianaMiejsca(swiat, nowe.x, nowe.y);
				nowe.x = getx() + ch_x;
				nowe.y = gety() + ch_y;
				kolizja(swiat, i, j);
			}
			
		}
		//nowe = losuj();
		wiek++;
		
	}
	
	public Antylopa(int x1, int y1)
	{
		wiek = 0;
		x = x1;
		y = y1;
		wyglad = 'A';
		inicjatywa = 4;
		sila = 4;
		color = Color.PINK;
		nowe = new Polozenie();
	}

}
