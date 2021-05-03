package ModelTest;

import static org.junit.Assert.*;

import org.junit.Test;


import model.Carta;
import model.Carta.Naipe;
import model.Mao;

public class MaoTest {

	@Test
	public void TestAS() {
	   Mao mao = new Mao();
	   Carta carta1=new Carta(9,Naipe.DIAMANTE);
	   Carta carta2=new Carta(1,Naipe.DIAMANTE);
	   Carta carta3=new Carta(1,Naipe.DIAMANTE);
	   
	   mao.Mao_Cartas.add(carta1);
	   mao.Mao_Cartas.add(carta2);
	   mao.Mao_Cartas.add(carta3);
	   int result= mao.Conta_Pontos();
	    assertEquals(result,21);
	}
	@Test
	public void TestAS2() {
	   Mao mao = new Mao();
	   Carta carta1=new Carta(10,Naipe.DIAMANTE);
	   Carta carta2=new Carta(1,Naipe.DIAMANTE);
	   Carta carta3=new Carta(1,Naipe.DIAMANTE);
	   
	   mao.Mao_Cartas.add(carta1);
	   mao.Mao_Cartas.add(carta2);
	   mao.Mao_Cartas.add(carta3);
	   int result= mao.Conta_Pontos();
	    assertEquals(result,-1);
	}
	@Test
	public void TestAS3() {
	   Mao mao = new Mao();
	   Carta carta1=new Carta(10,Naipe.DIAMANTE);
	   Carta carta2=new Carta(10,Naipe.DIAMANTE);
	   Carta carta3=new Carta(1,Naipe.DIAMANTE);
	   
	   mao.Mao_Cartas.add(carta1);
	   mao.Mao_Cartas.add(carta2);
	   mao.Mao_Cartas.add(carta3);
	   int result= mao.Conta_Pontos();
	    assertEquals(result,21);
	}
	
	@Test
	public void TestMaior21() {
		 Mao mao = new Mao();
		 Carta carta1=new Carta(10,Naipe.DIAMANTE);
		 Carta carta2=new Carta(10,Naipe.DIAMANTE);
		 Carta carta3=new Carta(5,Naipe.DIAMANTE);
	 
		 mao.Mao_Cartas.add(carta1);
		 mao.Mao_Cartas.add(carta2);
		 mao.Mao_Cartas.add(carta3);
		 int result= mao.Conta_Pontos();
		  assertEquals(result,-1);
		
	
	}
	
	@Test
	public void TestResetList() {
		 Mao mao = new Mao();
		 Carta carta1=new Carta(10,Naipe.DIAMANTE);
		 Carta carta2=new Carta(10,Naipe.DIAMANTE);
		 Carta carta3=new Carta(5,Naipe.DIAMANTE);
	 
		 mao.Mao_Cartas.add(carta1);
		 mao.Mao_Cartas.add(carta2);
		 mao.Mao_Cartas.add(carta3);
		 mao.zera_mao();
		 int tam =mao.Mao_Cartas.size();
		assertEquals(tam,0);
		  
		
	
	}
	

}
