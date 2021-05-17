package view;

import javax.swing.JFrame;

import view.PNInicial;

public class FRBlackJack extends JFrame{
	private static final long serialVersionUID = 1L;
	public static final int TXT_X=655;
	public static final int TXT_Y=678;
	public PNInicial PNInicial = new PNInicial(this);
	public FRBlackJack() {
		setBounds(1200,700,TXT_X,TXT_Y);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().add(PNInicial);
		setTitle("BlackJack");
	}

}
