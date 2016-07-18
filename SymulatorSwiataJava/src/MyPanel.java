import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.geom.Rectangle2D;
import java.io.FileNotFoundException;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

import Wyjatki.Wyjatek;
import Zwierzeta.Antylopa;
import Zwierzeta.Czlowiek;
import Zwierzeta.Lis;
import Zwierzeta.Owca;
import Zwierzeta.Wilk;
import Zwierzeta.Zolw;
import Organizmy.Swiat;
import Rosliny.Guarana;
import Rosliny.Mlecz;
import Rosliny.Trawa;
import Rosliny.WilczaJagoda;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MyPanel extends JPanel implements MouseListener, KeyListener{
	
	private int x_temp,y_temp,x,y;
	private boolean clik;
	private Swiat _swiat;
	JFrame frame;
	JTextArea _textArea;
	JScrollPane scrollPane;
	JPanel panell;
	JComboBox _aktorzyList;
	String _wybor;
	
	public MyPanel(Swiat swiat, JTextArea textArea, JComboBox aktorzyList){
		 frame = new JFrame("Log");
		 frame.setSize(200, 200);
		_textArea = textArea;
		_aktorzyList = aktorzyList;
		addMouseListener(this);	
		setPreferredSize(new Dimension(400,400));
		_swiat = swiat;
		clik = false;
		textArea.setEditable(false);
		
		_aktorzyList.setEditable(false);
		
        
		_aktorzyList.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				_wybor = (String) ((JComboBox)arg0.getSource()).getSelectedItem();
				System.out.println("wybrales"+_wybor);
			}
			
		});
		addKeyListener(this);
	}
	@Override
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D)g;
		requestFocus(); 
		
		//kratka
		for(int i=0;i<=300;i+=15)
		{
			g2d.drawLine(i,0,i,300);
		}
		for(int i=0;i<=300;i+=15)
		{
			g2d.drawLine(0, i, 300, i);
		}
		
		_textArea.append(_swiat.wyswietlLogi());
		_textArea.repaint();
		
		//repaint();
		_swiat.rysujSwiat(g2d);
		if(clik)
		{
			//tu bedziesz dodawac do tablicy 
			g2d.setColor(Color.BLACK);
			g2d.fillRect(x, y, 15, 15);
			clik = false;
		}
	}
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent arg0) {
		//char z = losuj();
		//System.out.println(z);
		x_temp = arg0.getX();
		y_temp = arg0.getY();
		if(_wybor=="Wilk")
			_swiat.stworzOrganizm(_swiat, 'W' , (x_temp/15), (y_temp/15));
		if(_wybor=="Owca")
			_swiat.stworzOrganizm(_swiat, 'O' , (x_temp/15), (y_temp/15));
		if(_wybor=="Lis")
			_swiat.stworzOrganizm(_swiat, 'L' , (x_temp/15), (y_temp/15));
		if(_wybor=="Zó³w")
			_swiat.stworzOrganizm(_swiat, 'Z' , (x_temp/15), (y_temp/15));
		if(_wybor=="Antylopa")
			_swiat.stworzOrganizm(_swiat, 'A' , (x_temp/15), (y_temp/15));
		if(_wybor=="Trawa")
			_swiat.stworzOrganizm(_swiat, 'T' , (x_temp/15), (y_temp/15));
		if(_wybor=="Mlecz")
			_swiat.stworzOrganizm(_swiat, 'M' , (x_temp/15), (y_temp/15));
		if(_wybor=="Guaranna")
			_swiat.stworzOrganizm(_swiat, 'G' , (x_temp/15), (y_temp/15));
		if(_wybor=="JagodaWilcza")
			_swiat.stworzOrganizm(_swiat, 'J' , (x_temp/15), (y_temp/15));
		
		x = (int)(x_temp/15)*15;
		y = (int)(y_temp/15)*15;
		clik = true;
		_swiat.logi(_wybor.charAt(0), "zostal utworzony", ' ');
		
		repaint();
    }
	
	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	private char losuj()
	{
		Random gen = new Random();
		int z = gen.nextInt(9);
		
		if (z == 0)
			return 'W';
		if (z == 1)
			return 'L';
		if (z == 2)
			return 'O';
		if (z == 3)
			return 'Z';
		if (z == 4)
			return 'A';
		if (z ==5)
			return 'T';
		if (z == 6)
			return 'J';
		if (z == 7)
			return 'M';
		if (z == 8)
			return 'G';
		
		return 0;
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		switch(e.getKeyCode()){
        case KeyEvent.VK_UP:
            System.out.println("wcisles up");
            _swiat.wykonajTure(_swiat,e.getKeyCode());
            repaint();
            break;
        case KeyEvent.VK_DOWN:
            System.out.println("wcisles down");
            _swiat.wykonajTure(_swiat,e.getKeyCode());
            repaint();
            break;
        case KeyEvent.VK_LEFT:
            System.out.println("wcisles left");
            _swiat.wykonajTure(_swiat,e.getKeyCode());
            repaint();
            break;
        case KeyEvent.VK_RIGHT:
            System.out.println("wcisles right");
            _swiat.wykonajTure(_swiat,e.getKeyCode());
            repaint();
            break;
        case KeyEvent.VK_ENTER:
            System.out.println("wcisles enter");
            _swiat.wykonajTure(_swiat, e.getKeyCode());
            break;
    }
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
