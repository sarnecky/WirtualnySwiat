package Rosliny;
import java.awt.Color;

import Organizmy.*;

public class Guarana extends Roslina{
	
	private Zasoby a;

	@Override
	public void akcja(Swiat swiat, int i, int j) {
		// TODO Auto-generated method stub
		
		zasiew(swiat, i, j);
	}

	@Override
	public void kolizja(Swiat swiat, int i, int j) {
		// TODO Auto-generated method stub
		
		//+3 do sily
		swiat.setSila(3, i, j); //zwiekszenie sily o 3
	}
	
	public Guarana(int x1, int y1)
	{
		wiek = 0;
		sila = 0;
		wyglad = 'G';
		inicjatywa = 0;
		x = x1;
		y = y1;
		color = Color.YELLOW;
	}

}
