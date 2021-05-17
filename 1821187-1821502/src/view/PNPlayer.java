package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.API; 

public class PNPlayer extends JPanel implements ActionListener{
	
	JButton novoJogador = new JButton("Inserir jogador");
    JButton Start = new JButton("Começar Partida");  
    JTextField caixa = new JTextField(40);
    
    
    public PNPlayer() {  
    	novoJogador.addActionListener(this);
    	Start.addActionListener(this);
    	this.add(novoJogador);
    	this.add(Start);
    	this.add(caixa);
    	Start.setEnabled(false);
    	
    	
    }


	@Override
	public void actionPerformed(ActionEvent e) {
		if(API.getAPI().getnumberofplayer()<4) {
			if (e.getSource() == novoJogador) {
	    			String nome = caixa.getText();	    		
	    			API.getAPI().criaJogador(nome);		    		
	    			caixa.setText("");	    		
	    	}
			
		}
		if(API.getAPI().getnumberofplayer()==4) {
			novoJogador.setEnabled(false);
			caixa.setEnabled(false);
		}
		if(API.getAPI().getArrPlayer()[0]!=null) {
			Start.setEnabled(true);
		}
		
		
		
		
	}
}
