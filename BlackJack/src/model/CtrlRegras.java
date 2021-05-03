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
	
	public int criaJogador(String[] jogadores) {
		for(int i=0;i<jogadores.length;i++) {
			player[i]= new Player(jogadores[i]);
		}
		return number_of_player+=jogadores.length;
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
		if(player[vez].ficha.saldo_aposta()*2<player[vez].ficha.saldo()) {
			player[vez].mao.Mao_Cartas.add(baralho.pegaCarta());
			for(int item : player[vez].ficha.aposta ) {
				player[vez].ficha.aposta_Ficha(item);//talvez seja necessario fazeruns cenarios para ter certeza dessa funcao
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
			if(item.mao.Conta_Pontos()>dealer.mao.Conta_Pontos()) {
				if(item.mao.Conta_Pontos()!=-1) {
					item.ficha.Ganha_Jogo();// multiplicacao pleo valor da vitoria
				}
			
			}else if(item.mao.Conta_Pontos()==21&&dealer.mao.Conta_Pontos()==21) {
				item.ficha.Ganha_Jogo();
			}
		}
	}
	
}
