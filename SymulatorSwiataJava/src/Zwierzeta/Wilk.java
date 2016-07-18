package Zwierzeta;
import java.awt.Color;

import Organizmy.*;

public class Wilk extends Zwierze{

	private Zasoby a;
	@Override
	public void akcja(Swiat swiat, int i, int j) {
		nowe = losuj();
		kolizja(swiat, i, j);
		wiek++;
	}
	
	public Wilk(int x1, int y1)
	{
		wiek = 0;
		x = x1;
		y = y1;
		wyglad = 'W';
		inicjatywa = 5;
		sila = 9;
		color = Color.RED;
	}

}
