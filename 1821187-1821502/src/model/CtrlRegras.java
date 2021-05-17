package model;

class CtrlRegras {
	private Baralho baralho;
	private Dealer dealer;
	private int number_of_player=0;
	private int vez = 0;
	private Player[] player= new Player[4];
	
	
	public CtrlRegras() {
		baralho = new Baralho();
		dealer = new Dealer();
	}
	
	
	public int getnumberofplayer() {
		return number_of_player;
	}
	
	
	public Player[] getArrPlayer() {
		return player;
		
	}
	
	public void criaJogador(String jogadores) {		
		player[number_of_player]= new Player(jogadores);
		number_of_player+=1;
	}
	
	public void setVez(int vez) {
		if (vez==number_of_player) {
			while(dealer.mao.Conta_Pontos()<17 && dealer.mao.Conta_Pontos()<=21) {
				Hit("D");
			}
			compara_player_Dealer();
			for(Player item : player) {
				item.mao.zera_mao();
			}
			vez=0;
		}
		else {
			vez+=1;
		}
	}
	
	public int Hit(String flag) {
		if(flag=="P") {
		 player[vez].mao.Mao_Cartas.add(baralho.pegaCarta());
		 int pontos=player[vez].mao.Conta_Pontos();
		 if (pontos==-1) {
			return -1; 
		 }
		return 1;
		}
		else {
			dealer.mao.Mao_Cartas.add(baralho.pegaCarta());
			int pontos=dealer.mao.Conta_Pontos();
			 if (pontos==-1) {
				return -1; 
			 }
			return 1;
			}
		}
		
	

	public void Double() {
		if(player[vez].ficha.saldo_aposta()*2<=player[vez].ficha.saldo()+player[vez].ficha.saldo_aposta()) {
			player[vez].mao.Mao_Cartas.add(baralho.pegaCarta());			
			int ct;
			int fichas[] = {100, 50, 20, 10, 5, 1};	
			int vlr = player[vez].ficha.saldo_aposta();
		    int i = 0;	   
		      while (vlr != 0) {  
		    	int temp=0;
		        ct = vlr / fichas[i];
		        if (ct != 0) { 	
		        	if(fichas[i]==100 && player[vez].ficha.getF_cem()!=0) {    	        		
		        		if(player[vez].ficha.getF_cem()<=ct) {
		        			player[vez].ficha.aposta.add(player[vez].ficha.getF_cem()*100);
		        		}
		        		else {	
		        			player[vez].ficha.aposta.add(ct*100);
		        		}
		        		player[vez].ficha.setF_cem(player[vez].ficha.getF_cem()-ct);
		        		if(player[vez].ficha.getF_cem()<0) {
		        			temp=player[vez].ficha.getF_cem()*(-1)*100;
		        			player[vez].ficha.setF_cem(0);
		        		}
		        		vlr = vlr % fichas[i]+temp;		
					}else if(fichas[i]==50 && player[vez].ficha.getF_cinquenta()!=0){	
						if(player[vez].ficha.getF_cinquenta()<=ct) {
		        			player[vez].ficha.aposta.add(player[vez].ficha.getF_cinquenta()*50);
		        		}
		        		else {	
		        			player[vez].ficha.aposta.add(ct*50);
		        		}
						player[vez].ficha.setF_cinquenta(player[vez].ficha.getF_cinquenta()-ct);
		        		if(player[vez].ficha.getF_cinquenta()<0) {
		        			temp=player[vez].ficha.getF_cinquenta()*(-1)*50;
		        			player[vez].ficha.setF_cinquenta(0);
		        		}
		        		vlr = vlr % fichas[i]+temp;		
					}
		        	

					else if(fichas[i]==20 && player[vez].ficha.getF_vinte()!=0){	
						if(player[vez].ficha.getF_vinte()<=ct) {
		        			player[vez].ficha.aposta.add(player[vez].ficha.getF_vinte()*20);
		        		}
		        		else {	
		        			player[vez].ficha.aposta.add(ct*20);
		        		}
						player[vez].ficha.setF_vinte(player[vez].ficha.getF_vinte()-ct);
		        		if(player[vez].ficha.getF_vinte()<0) {
		        			temp=player[vez].ficha.getF_vinte()*(-1)*20;
		        			player[vez].ficha.setF_vinte(0);
		        		}
		        		vlr = vlr % fichas[i]+temp;		
					}	
					else if(fichas[i]==10 && player[vez].ficha.getF_dez()!=0){	
						if(player[vez].ficha.getF_dez()<=ct) {
		        			player[vez].ficha.aposta.add(player[vez].ficha.getF_dez()*10);
		        		}
		        		else {	
		        			player[vez].ficha.aposta.add(ct*10);
		        		}				
						player[vez].ficha.setF_dez(player[vez].ficha.getF_dez()-ct);
		        		if(player[vez].ficha.getF_dez()<0) {
		        			temp=player[vez].ficha.getF_dez()*(-1)*10;
		        			player[vez].ficha.setF_dez(0);
		        		}
		        		vlr = vlr % fichas[i]+temp;		
					}
		        	
					else if(fichas[i]==5 && player[vez].ficha.getF_cinco()!=0){					
						if(player[vez].ficha.getF_cinco()<=ct) {
		        			player[vez].ficha.aposta.add(player[vez].ficha.getF_cinco()*5);
		        		}
		        		else {	
		        			player[vez].ficha.aposta.add(ct*5);
		        		}
						player[vez].ficha.setF_cinco(player[vez].ficha.getF_cinco()-ct);
		        		if(player[vez].ficha.getF_cinco()<0) {
		        			temp=player[vez].ficha.getF_cinco()*(-1)*5;
		        			player[vez].ficha.setF_cinco(0);
		        		}
		        		vlr = vlr % fichas[i]+temp;		
					}	
					else if(fichas[i]==1 && player[vez].ficha.getF_um()!=0){	
						
						if(player[vez].ficha.getF_um()<=ct) {
		        			player[vez].ficha.aposta.add(player[vez].ficha.getF_um()*1);
		        		}
		        		else {	
		        			player[vez].ficha.aposta.add(ct*1);
		        		}				
						player[vez].ficha.setF_um(player[vez].ficha.getF_um()-ct);
		        		if(player[vez].ficha.getF_um()<0) {
		        			temp=player[vez].ficha.getF_um()*(-1)*1;
		        			player[vez].ficha.setF_um(0);
		        		}
		        		vlr = vlr % fichas[i]+temp;			   
					}
		           
		        }
		        i = i + 1; 
		      }
		}
		
	}
	

	public void Stand() {
		if(player[vez].ficha.Aposta_min_max()!=-1) {
			setVez(vez);
		}
		
	}
	
	public void Split() {
		
	}
	
	public void Distribuir_cartas() {
		for(Player item: player) {
			item.mao.Mao_Cartas.add(baralho.pegaCarta());
			item.mao.Mao_Cartas.add(baralho.pegaCarta());
		}
		dealer.mao.Mao_Cartas.add(baralho.pegaCarta());
		dealer.mao.Mao_Cartas.add(baralho.pegaCarta());
	}
	
	
	public int aposta(int x , int y) {
		//esperando a 2 interacao para pegar a posicao da ficha 
		//e poder apostar com o valor dela
		return 50;
	}
	
	public void compara_player_Dealer() {// ve minha logica que ta errada e adicionar o caso player black jack
		for(Player item: player) {
			if(item.mao.Conta_Pontos()!=-1) {
				if(item.mao.Conta_Pontos()==21&& dealer.mao.Conta_Pontos()==21) {
					item.ficha.Ganha_Jogo();
				}
				else if(item.mao.Conta_Pontos()>dealer.mao.Conta_Pontos()) {
					//item.ficha.aposta=item.ficha.aposta*1.5; Resolver a lista da classe Ficha
					item.ficha.Ganha_Jogo();
				}
			}	
		}
		
	}
}
