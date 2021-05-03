package model;
import java.util.ArrayList;
 class Mao {
	public ArrayList<Carta> Mao_Cartas = new ArrayList<Carta>();
	
	
	public int Conta_Pontos() {	
		int pontos=0;
		ArrayList<Carta> as = new ArrayList<Carta>();
		for(Carta item : Mao_Cartas) {
			if(item.getRank()==1) {
				as.add(item);
			}
			else {
				if(item.getRank()>=11) {
					pontos+=10;
				}
				else {
				pontos+=item.getRank();
				}
			}
		}
		if(as.size()>=1) {
			for(Carta item : as) {				
				if(pontos<=10) {
					pontos+=11;
				}
				else {
					pontos+=item.getRank();
				}
				
			}
		}
		if(pontos>21) {
			return -1;
		}
	return pontos;
	}
	
	public ArrayList<Carta> zera_mao() {
		return Mao_Cartas = new ArrayList<Carta>();
		
	}
}

