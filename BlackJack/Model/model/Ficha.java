package model;
import java.util.ArrayList;

 class Ficha {
	private int F_cem;
	private int F_cinquenta;
	private int F_vinte;
	private int F_dez;
	private int F_cinco;
	private int F_um;
	private ArrayList<Integer> aposta = new ArrayList<Integer>();

	
	
	public Ficha(String flag){ 
		if(flag=="P") {
		  F_cem =2;
		  F_cinquenta=2;
		  F_vinte=5;
		  F_dez=5;
		  F_cinco=8;
		  F_um=10;
		}
		else if(flag=="D") {
		  F_cem =Integer.MAX_VALUE;
		  F_cinquenta=Integer.MAX_VALUE;
		  F_vinte=Integer.MAX_VALUE;
     	  F_dez=Integer.MAX_VALUE;
		  F_cinco=Integer.MAX_VALUE;
		  F_um=Integer.MAX_VALUE;
		}
	}

	public void aposta_Ficha(ArrayList<Integer> aposta_arr, int ficha) {
		if(ficha==100 && this.F_cem!=0  ) {
			this.F_cem-=1;
			aposta_arr.add(100);
		}
		else if(ficha==50 && this.F_cinquenta!=0){
			this.F_cinquenta-=1;
			aposta_arr.add(50);
		}
		else if(ficha==20 && this.F_vinte!=0){
			this.F_vinte-=1;
			aposta_arr.add(20);
		}
		else if(ficha==10 && this .F_dez!=0){
			this.F_dez-=1;
			aposta_arr.add(10);
		}
		else if(ficha==5 && this.F_cinco!=0){
			this.F_cinco-=1;
			aposta_arr.add(5);
		}
		else if(ficha==1 && this.F_um!=0){
			this.F_um-=1;
			aposta_arr.add(1);
		}
		else {
			//print valor invalido
		}
	}
	
	public void remove_aposta(ArrayList<Integer> aposta_arr) {
		int lastElement = aposta_arr.size()-1;
		if(aposta_arr!=null) {
			if(lastElement==100) {
				this.F_cem+=1;
				aposta_arr.remove(lastElement);
			}else if(lastElement==50){
				this.F_cinquenta+=1;
				aposta_arr.remove(lastElement);
			}
			else if(lastElement==20){
				this.F_vinte+=1;
				aposta_arr.remove(lastElement);
			}
			else if(lastElement==10){
				this.F_dez+=1;
				aposta_arr.remove(lastElement);
			}
			else if(lastElement==5){
				this.F_cinco+=1;
				aposta_arr.remove(lastElement);
			}
			else if(lastElement==1){
				this.F_um+=1;
				aposta_arr.remove(lastElement);
			}
			else {
				//print valor invalido
			}
		}
	}
	
	public void Ganha_Jogo(ArrayList<Integer> ficha) {
		for(int item : ficha){
			if(item==100) {
				this.F_cem+=1;
			}else if(item==50){
				this.F_cinquenta+=1;
			}
			else if(item==20){
				this.F_vinte+=1;
			}
			else if(item==10){
				this.F_dez+=1;
			}
			else if(item==5){
				this.F_cinco+=1;
			}
			else if(item==1){
				this.F_um+=1;
			}
			else {
				//print valor invalido
			}
		}
	}
	
	public int Aposta_min_max() {
		int count=0;
		for(int item : aposta) {
		    count+=item;
		}
		if(count<20|| count >100) {
			return -1;
		}
		return 1;
	}
	
	public void Rendicao (ArrayList<Integer> aposta) {
		
		//dividir a aposta por 2 e devolver ao player
	}

	public int Saldo() {
		int Saldo_Ficha=F_cem*100+F_cinquenta*50+F_vinte*20+F_dez*10+F_cinco*5+F_um;
		
		return Saldo_Ficha;
	}
	
}