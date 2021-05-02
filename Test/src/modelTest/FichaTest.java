package modelTest;

import org.junit.Test;

import model.*;

public class FichaTest  {
	
	@Test
	public void test() {
	API player = new API("Eduardo");
	player.ficha.aposta_Ficha(15, 45);
	}

}
