package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import model.API;



public class PNInicial extends JPanel implements ActionListener {

	
	JButton novaPartida = new JButton("Nova Partida");
    JButton continuarPartida = new JButton("Continuar Partida");  
    FRBlackJack FRBlackJack;
     //PNBlackJack PNBlack;

    
    public PNInicial(FRBlackJack painel) {
    	FRBlackJack = painel;
    	novaPartida.addActionListener(this);
    	continuarPartida.addActionListener(this);
    	this.add(novaPartida);
    	this.add(continuarPartida);
    }
    
    public void actionPerformed(ActionEvent e) {
    	if (e.getSource() == novaPartida) {
    		this.setVisible(false);
    		PNPlayer pnPlayer = new PNPlayer();
    		FRBlackJack.add(pnPlayer);
    		revalidate();
    	}
	
    }
}  