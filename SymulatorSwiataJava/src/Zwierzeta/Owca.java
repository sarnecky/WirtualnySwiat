package Zwierzeta;
import java.awt.Color;

import Organizmy.*;

public class Owca extends Zwierze {

	private Zasoby a;
	@Override
	public void akcja(Swiat swiat, int i, int j) {
		nowe = losuj();
		kolizja(swiat, i, j);
		wiek++;
	}
	
	public Owca(int x1, int y1)
	{
		wiek = 0;
		x = x1;
		y = y1;
		wyglad = 'O';
		inicjatywa = 4;
		sila = 4;
		color = Color.CYAN;
	}

}
