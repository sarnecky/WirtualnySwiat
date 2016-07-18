package Rosliny;
import java.awt.Color;

import Organizmy.*;

public class WilczaJagoda extends Roslina {

	private Zasoby a;
	@Override
	public void akcja(Swiat swiat, int i, int j) {
		
		zasiew(swiat, i, j);
	}

	@Override
	public void kolizja(Swiat swiat, int i, int j) {
		
		//zabija 
	}
	
	public WilczaJagoda(int x1, int y1)
	{
		wiek = 0;
		sila = 99;
		wyglad = 'J';
		inicjatywa = 0;
		x = x1;
		y = y1;
		color = Color.BLUE;
	}

	
}
