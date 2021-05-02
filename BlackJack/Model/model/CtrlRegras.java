package model;

public class CtrlRegras {
	private Baralho baralho;
	private Dealer dealer;
	private int vez =0;
	private Player[] player= new Player[4];
	
	public CtrlRegras() {
		baralho = new Baralho();
		dealer = new Dealer();
	}
	
	public void criaJogador(String nome,int qtd) {
		player[qtd]= new Player(nome);
	}
	
	public void setVez(int vez,int max) {//pensar melhor na funcao set vez**************************************************************************
		if (vez==max) {
			while(dealer.mao.Conta_Pontos()<17 && dealer.mao.Conta_Pontos()!=21) {
				Hit("D");
			}
			compara_player_Dealer();
			vez=0;
		}
		else {
			vez+=1;
		}
	}
	
	public int Hit(String flag) {
		if(flag=="P") {
		 player[vez].mao.Mao_Cartas.add(baralho.takeCard());
		 int pontos=player[vez].mao.Conta_Pontos();
		 if (pontos==-1) {
			return -1; 
		 }
		return 1;
		}
		else {
			dealer.mao.Mao_Cartas.add(baralho.takeCard());
			int pontos=dealer.mao.Conta_Pontos();
			 if (pontos==-1) {
				return -1; 
			 }
			return 1;
			}
		}
		
	
	
	public void Double() {
		if(player[vez].ficha.saldo_aposta()*2<player[vez].ficha.saldo()) {
			player[vez].mao.Mao_Cartas.add(baralho.takeCard());
			for(int item : player[vez].ficha.aposta ) {
				player[vez].ficha.aposta_Ficha(item);//talvez seja necessario fazeruns cenarios para ter certeza dessa funcao
			}
		}
		
	}
	
	public void Stand() {
		if(player[vez].ficha.Aposta_min_max()!=-1) {
			setVez(vez,2);//ageitar  funcao de mudar a vez isso&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&
		}
		
	}
	
	public void Split() {
		
	}
	
	public void Distribuir_cartas() {
		for(Player item: player) {
			item.mao.Mao_Cartas.add(baralho.takeCard());
			item.mao.Mao_Cartas.add(baralho.takeCard());
		}
		//esperar 2 interacao para implementar ou fazerna view  carta virada para baixo
		dealer.mao.Mao_Cartas.add(baralho.takeCard());
		dealer.mao.Mao_Cartas.add(baralho.takeCard());
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
