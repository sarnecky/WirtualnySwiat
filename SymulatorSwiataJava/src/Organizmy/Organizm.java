package Organizmy;

import java.awt.Color;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JPanel;
public abstract class Organizm{

		protected int sila,_id;
		protected int x, y;
		protected char wyglad;
		protected int wiek;
		protected int inicjatywa;
		protected Color color;
		protected int _tury;
		protected boolean _calopalenie;
		//Swiat swiat;
		public abstract void akcja(Swiat swiat, int i, int j);
		public abstract void kolizja(Swiat swiat, int i, int j);
		
        public char rysowanie()
		{
		   return wyglad;
		}
        
        public void setWiek(int w)
		{
			wiek = w;
		}
        
        public int getx()
		{
			return x;
		}

        public int getInicjatywa()
		{
			return inicjatywa;
		}

        public int getWiek()
		{
			return wiek;
		}

        public int gety()
		{
			return y;
		}

        public int getId()
		{
			return _id;
		}

        public void setId(int id)
		{
			_id = id;
		}

        public void setSila(int x)
		{
			sila += x;
		}

        public int getSila()
		{
			return sila;
		}
        
        public void moc()
		{
			_calopalenie = true;
		}
		
		public int getTury()
		{
			 return _tury;
		}
		
        public void zabijOrganizm(Swiat swiat, int x, int y)
		{
			swiat.zabijStworzenie(swiat, x, y);
		}
		
		public Polozenie losuj()
		{
			int ch_x=0, ch_y=0, flaga = 0;
			int wybor=0; //liczby 0-7
			Random gen = new Random();
			while (flaga == 0)
			{
				wybor = gen.nextInt(4); //0-3
				if (wybor == 0) //w prawo
				{
					ch_x = 1;
					ch_y = 0;

				}
				else if (wybor == 1) //w lewo
				{
					ch_x = -1;
					ch_y = 0;
			
				}
				else if (wybor == 2) //w dol
				{
					ch_x = 0;
					ch_y = 1;
			
				}
				else if (wybor == 3) // do gory
				{
					ch_x = 0;
					ch_y = -1;
				}

				//warunki zapobiegajace wyjsciu poza tablice
				if ((getx() + ch_x) >= 0 &&
					(getx() + ch_x) < 20 &&
					(gety() + ch_y) >= 0 &&
					(gety() + ch_y) < 20) flaga = 1;
			}

			Polozenie nowa = new Polozenie();
			nowa.x = getx() + ch_x;
			nowa.y = gety() + ch_y;

			return nowa;

		}

		public void dodajOrganizm(Swiat swiat, int i, int j)
		{
			swiat.dodajStworzenie(swiat, x, y);
		}

	
}
