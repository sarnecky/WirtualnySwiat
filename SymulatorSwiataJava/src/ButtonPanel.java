import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Rectangle2D;
import java.io.FileNotFoundException;

import javax.swing.JButton;
import javax.swing.JPanel;

import Organizmy.Swiat;
import Wyjatki.Wyjatek;


public class ButtonPanel extends JPanel implements ActionListener{

	private JButton nowaTura, nowaPlansza, zapisPlanszy;
	private Swiat _swiat;
	private JPanel _panel;
	public ButtonPanel(Swiat swiat,JPanel panel){
		_panel = panel;
		_swiat = swiat;
		//nowaTura = new JButton("Nowa Tura");
		nowaPlansza = new JButton("Wczytaj plansze");
		zapisPlanszy = new JButton("Zapisz stan planszy");
		
        //nowaTura.setPreferredSize(new Dimension(150,50));
        nowaPlansza.setPreferredSize(new Dimension(150,50));
        zapisPlanszy.setPreferredSize(new Dimension(150,50));
        
       // nowaTura.addActionListener(this);
        nowaPlansza.addActionListener(this);
        zapisPlanszy.addActionListener(this);
 
      //  add(nowaTura, BorderLayout.PAGE_END);
        add(nowaPlansza, BorderLayout.PAGE_END);
        add(zapisPlanszy, BorderLayout.PAGE_END);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object s = e.getSource();
		//if(s == nowaTura)
		////{
		//	System.out.println("nowatura");
		//	_swiat.wykonajTure(_swiat, 0);
		////}
		 if(s == nowaPlansza)
		{
			System.out.println("plansza");
			try {
				_swiat.Odczyt(_swiat);
				_panel.repaint();
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			} catch (Wyjatek e1) {
				e1.printStackTrace();
			}
			
		}
		else if(s == zapisPlanszy)
		{
			System.out.println("zapis");
			try {
				_swiat.Zapis();
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
			
	}

}
