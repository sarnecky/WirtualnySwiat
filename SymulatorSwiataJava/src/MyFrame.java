import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

import Organizmy.*;
public class MyFrame extends JFrame {
	JTextArea textArea;
	public MyFrame(Swiat swiat){
		super("Wirtualny Swiat");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		textArea = new JTextArea(20, 20);
		String[] aktorzyS = { "Lis", "Wilk", "Owca", "Zó³w", "Antylopa", "Trawa", "Mlecz", "Guaranna", "JagodaWilcza" };
		JComboBox aktorzyList;
		aktorzyList = new JComboBox();
		
		for(int i=0;i<aktorzyS.length;i++)
		{
			aktorzyList.addItem(aktorzyS[i]);
		}
		
		JPanel panel = new MyPanel(swiat, textArea, aktorzyList);
		JPanel buttonPanel = new ButtonPanel(swiat,panel);
		textArea.setEditable ( false );
	    setSize(700,520);
	    JScrollPane scrollPane = new JScrollPane(textArea); 
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		
		add(panel, BorderLayout.CENTER);
		add(scrollPane,BorderLayout.LINE_END );
		add(buttonPanel);
		add(aktorzyList);

		setLayout(new FlowLayout());
		setVisible(true);
	}
}
