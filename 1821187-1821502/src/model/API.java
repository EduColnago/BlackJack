package model;

public class API {
	private static API api = null;
	private CtrlRegras ctrl;
	private API() {
		ctrl = new CtrlRegras();
	}

	public static API getAPI() {
		if(api==null) {
			api = new API();
		}
		return api;
	}	
	public void criaJogador(String jogadores) {
		 ctrl.criaJogador(jogadores);
	}
	public void setVez(int vez) {
		ctrl.setVez(vez);
	}
	
	public int Hit(String flag) {
		return ctrl.Hit(flag);
	}
	
	/*
	public void Double() {
		ctrl.Double();
	}
	
	 * 
	 */
	
	public void Stand() {
		ctrl.Stand();
	}
	
	public void Split() {
		ctrl.Split();
	}	
	
	public void Distribuir_cartas() {
		ctrl.Distribuir_cartas();
	}
	
	public int aposta(int x , int y) {
		return ctrl.aposta(x, y);
	}
	public void compara_player_Dealer() {
		ctrl.compara_player_Dealer();
	}
	
	public int getnumberofplayer() {
		return ctrl.getnumberofplayer();
	}
	
	
	public Player[] getArrPlayer() {
		return ctrl.getArrPlayer();
		
	}
}


