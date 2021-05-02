package model;
import java.util.ArrayList;
 class Mao {
	public ArrayList<Carta> Mao_Cartas = new ArrayList<Carta>();
	
	
	public int Conta_Pontos() {	
	    // retorna o valor de pontos na sua mao e fazendo o melhror caso para o as
		//para chegar o mais perto de 21
		int pontos=0;
		ArrayList<Carta> as = new ArrayList<Carta>();
		for(Carta item : Mao_Cartas) {
			if(item.getRank()==1) {
				as.add(item);
			}
			else {
				pontos+=item.getRank();
			}
		}
		
		for(Carta item :as) {
			int qtd=as.size();
			if(pontos>=21||pontos==21&&qtd>1) {
				return -1;
			}
			
		}
		
		
	return pontos;
	}
}

