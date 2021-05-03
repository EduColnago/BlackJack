package ModelTest;

import static org.junit.Assert.*;

import org.junit.Test;
import model.Ficha;

public class FichaTest {

	@Test
	public void apostarficha() {
		Ficha ficha = new Ficha();
		ficha.aposta_Ficha(100);
		ficha.aposta_Ficha(50);
		ficha.aposta_Ficha(20);
		ficha.aposta_Ficha(10);
		ficha.aposta_Ficha(5);
		ficha.aposta_Ficha(1);
		assertEquals(ficha.F_cem,1);
		assertEquals(ficha.F_cinquenta,1);
		assertEquals(ficha.F_vinte,4);
		assertEquals(ficha.F_dez,4);
		assertEquals(ficha.F_cinco,7);
		assertEquals(ficha.F_um,9);
	}
	
	
	@Test
	public void removeraposta() {
		Ficha ficha = new Ficha();	
		ficha.aposta_Ficha(1);
		ficha.aposta_Ficha(1);
		ficha.aposta_Ficha(100);
		ficha.aposta_Ficha(1);
		ficha.remove_aposta();
		ficha.remove_aposta();
		ficha.remove_aposta();
		assertEquals(ficha.F_um,9);
		assertEquals(ficha.F_cem,2);
		
	}
	
	@Test
	public void ganhajogo() {
		Ficha ficha = new Ficha();	
		ficha.aposta_Ficha(100);
		ficha.aposta_Ficha(100);
		ficha.aposta_Ficha(50);
		ficha.aposta.add(100);
		ficha.aposta.add(50);
		ficha.Ganha_Jogo();
		assertEquals(ficha.F_cem,3);
		assertEquals(ficha.F_cinquenta,3);
		
	}
	
	@Test
	public void min_max_erro() {
		Ficha ficha = new Ficha();	
		int result=ficha.Aposta_min_max();
		assertEquals(result,-1);
	}
	
	@Test
	public void min() {
		Ficha ficha = new Ficha();
		ficha.aposta_Ficha(20);
		int result=ficha.Aposta_min_max();
		assertEquals(result,1);
	}
	
	@Test
	public void max() {
		Ficha ficha = new Ficha();
		ficha.aposta_Ficha(100);
		ficha.aposta_Ficha(1);
		int result=ficha.Aposta_min_max();
		assertEquals(result,-1);
	}
	
	@Test
	public void Rendicao() {
		Ficha ficha = new Ficha();
		ficha.aposta_Ficha(100);
		ficha.aposta_Ficha(100);
		ficha.Rendicao();
		assertEquals(ficha.F_cem,1);
	}
	
	@Test
	public void Rendicao2() {
		Ficha ficha = new Ficha();
		ficha.aposta_Ficha(100);
		ficha.aposta_Ficha(100); 
		ficha.aposta_Ficha(50);
		ficha.aposta_Ficha(20);
		ficha.aposta_Ficha(10);
		

		

		ficha.Rendicao();
		assertEquals(ficha.F_cem,1);
		assertEquals(ficha.F_cinquenta,1);
		assertEquals(ficha.F_vinte,6);
		assertEquals(ficha.F_dez,4);
		assertEquals(ficha.F_cinco,8);
	}
	
	@Test
	public void Rendicao3() {
		Ficha ficha = new Ficha();
		ficha.aposta_Ficha(5);
		ficha.Rendicao();
		assertEquals(ficha.F_cinco,7);
		assertEquals(ficha.F_um,12);
	}
	
	
	@Test
	public void saldoaposta() {
		Ficha ficha = new Ficha();
		ficha.aposta_Ficha(100);
		ficha.aposta_Ficha(1);
		int result=ficha.saldo_aposta();
		assertEquals(result,101);
	}
	
	@Test
	public void saldo() {
		Ficha ficha = new Ficha();
		ficha.aposta_Ficha(100);
		int result=ficha.saldo();
		assertEquals(result,400);
	}
	
	@Test
	public void saldonegativo() {
		Ficha ficha = new Ficha();
		ficha.F_cem=0;
		ficha.F_cinquenta=0;
		ficha.F_vinte=0;
		ficha.F_dez=0;
		ficha.F_cinco=0;
		ficha.F_um=0;
		int result=ficha.saldo();
		assertEquals(result,-1);
	}

}
