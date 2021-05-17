package model;
import java.util.ArrayList;

  class Ficha {
	private int F_cem;
	private int F_cinquenta;
	private int F_vinte;
	private int F_dez;
	private int F_cinco;
	private int F_um;
	public ArrayList<Integer> aposta = new ArrayList<Integer>();
	
	
	
	public Ficha(){ 
		  F_cem =2;
		  F_cinquenta=2;
		  F_vinte=5;
		  F_dez=5;
		  F_cinco=8;
		  F_um=10;
	} 

	public void aposta_Ficha(int ficha) {
		if(ficha==100 && this.F_cem!=0  ) {
			this.F_cem-=1;
			aposta.add(100);
		}
		else if(ficha==50 && this.F_cinquenta!=0){
			this.F_cinquenta-=1;
			aposta.add(50);
		}
		else if(ficha==20 && this.F_vinte!=0){
			this.F_vinte-=1;
			aposta.add(20);
		}
		else if(ficha==10 && this .F_dez!=0){
			this.F_dez-=1;
			aposta.add(10);
		}
		else if(ficha==5 && this.F_cinco!=0){
			this.F_cinco-=1;
			aposta.add(5);
		}
		else if(ficha==1 && this.F_um!=0){
			this.F_um-=1;
			aposta.add(1);
		}
		else {
			//print valor invalido
		}
	}
	
	public void remove_aposta() {
		int lastElement = aposta.get(aposta.size()-1);
		int pos=aposta.size()-1;
		if(aposta.size()!=0) {
			if(lastElement==100) {
				this.F_cem+=1;
				aposta.remove(pos);
			}else if(lastElement==50){
				this.F_cinquenta+=1;
				aposta.remove(pos);
			}
			else if(lastElement==20){
				this.F_vinte+=1;
				aposta.remove(pos);
			}
			else if(lastElement==10){
				this.F_dez+=1;
				aposta.remove(pos);
			}
			else if(lastElement==5){
				this.F_cinco+=1;
				aposta.remove(pos);
			}
			else if(lastElement==1){
				this.F_um+=1;
				aposta.remove(pos);
			}
			else {
				//print valor invalido
			}
		}
	}
	
	public void Ganha_Jogo() {
		int count=0;
		int ct;
		int fichas[] = {100, 50, 20, 10, 5, 1};
		for(int item : aposta){
			count+=item;
		}
		int vlr = count;
	    int i = 0;	   
	      while (vlr != 0) {    	 
	        ct = vlr / fichas[i];
	        if (ct != 0) {
	        	if(fichas[i]==100) {
					this.F_cem+=ct;
				}else if(fichas[i]==50){
					this.F_cinquenta+=ct;
				}
				else if(fichas[i]==20){
					this.F_vinte+=ct;
				}
				else if(fichas[i]==10){
					this.F_dez+=ct;
				}
				else if(fichas[i]==5){
					this.F_cinco+=ct;
				}
				else if(fichas[i]==1){
					this.F_um+=ct;
				}
	           vlr = vlr % fichas[i];
	        }
	        i = i + 1; 
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
	
	

	
	public void Rendicao () {
		int count=0;
		int ct;
		int fichas[] = {100, 50, 20, 10, 5, 1};
		for(int item : aposta){
			count+=item;
		}
		int vlr = count/2;
	    int i = 0;	   
	      while (vlr != 0) {    	 
	        ct = vlr / fichas[i];
	        if (ct != 0) {
	        	if(fichas[i]==100) {
					this.F_cem+=ct;
				}else if(fichas[i]==50){
					this.F_cinquenta+=ct;
				}
				else if(fichas[i]==20){
					this.F_vinte+=ct;
				}
				else if(fichas[i]==10){
					this.F_dez+=ct;
				}
				else if(fichas[i]==5){
					this.F_cinco+=ct;
				}
				else if(fichas[i]==1){
					this.F_um+=ct;
				}
	           vlr = vlr % fichas[i];
	        }
	        i = i + 1; 
	      }
		
		
	}
	public int saldo_aposta() {
		int saldo=0;
		for(int item:aposta) {
			saldo+=item;
		}
		return saldo;
	}

	public int saldo() {
		int Saldo_Ficha=F_cem*100+F_cinquenta*50+F_vinte*20+F_dez*10+F_cinco*5+F_um;
		if(Saldo_Ficha>0) {
			return Saldo_Ficha;
		}
		else {
			return -1;
		}
		
	}

	public int getF_cem() {
		return F_cem;
	}

	public void setF_cem(int f_cem) {
		F_cem = f_cem;
	}

	public int getF_cinquenta() {
		return F_cinquenta;
	}

	public void setF_cinquenta(int f_cinquenta) {
		F_cinquenta = f_cinquenta;
	}

	public int getF_vinte() {
		return F_vinte;
	}

	public void setF_vinte(int f_vinte) {
		F_vinte = f_vinte;
	}

	public int getF_dez() {
		return F_dez;
	}

	public void setF_dez(int f_dez) {
		F_dez = f_dez;
	}

	public int getF_cinco() {
		return F_cinco;
	}

	public void setF_cinco(int f_cinco) {
		F_cinco = f_cinco;
	}

	public int getF_um() {
		return F_um;
	}

	public void setF_um(int f_um) {
		F_um = f_um;
	}

	public ArrayList<Integer> getAposta() {
		return aposta;
	}

	public void setAposta(ArrayList<Integer> aposta) {
		this.aposta = aposta;
	}
	
	
}
