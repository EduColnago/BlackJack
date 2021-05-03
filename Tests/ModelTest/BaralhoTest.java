package ModelTest;

import static org.junit.Assert.*;
import org.junit.Test;

import model.Baralho;
import model.Carta;
import model.Carta.Naipe;

public class BaralhoTest {

	@Test
	public void cria_baralho_pegacarta() {
		Baralho baralho = new Baralho();
		Carta carta1 =baralho.pegaCarta();
		Carta carta2 =baralho.pegaCarta();
		
		Carta carta5 = new Carta (13,Naipe.COPAS);
		Carta carta6 = new Carta (12,Naipe.COPAS);
	
	    assertEquals(carta1.getRank(),carta5.getRank());
		assertEquals(carta1.getNaipe(),carta5.getNaipe());
	    assertEquals(carta2.getRank(),carta6.getRank());
		assertEquals(carta2.getNaipe(),carta6.getNaipe());
		 
	}
	
	@Test
	public void embaralhar() {
		// mesmo embaralahdo pode vir a mesma carta que foi escolhida para o teste
		Baralho baralho = new Baralho();
		baralho.embaralhar();
		Carta carta1 =baralho.pegaCarta();
		Carta carta2 =baralho.pegaCarta();
		
		Carta carta5 = new Carta (13,Naipe.COPAS);
		Carta carta6 = new Carta (12,Naipe.COPAS);
	
	    assertNotEquals(carta1.getRank(),carta5.getRank());
	    assertNotEquals(carta1.getNaipe(),carta5.getNaipe());
	    assertNotEquals(carta2.getRank(),carta6.getRank());
	    assertNotEquals(carta2.getNaipe(),carta6.getNaipe());
		 
	}

}
