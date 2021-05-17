package model;
import java.util.Iterator;
import java.util.Random;

import java.util.NoSuchElementException;
 class Baralho {
	 private final Carta[] cards;
	   private int topo;


	   public Baralho()
	   {
	      cards = new Carta[52];
	      refresh();
	   }


	   public void refresh()
	   {
	      Carta.Naipe[] suits = Carta.getSuits();
	      int min_rank = Carta.getMinRank();
	      int max_rank = Carta.getMaxRank();

	      int i = 0;
	      for (Carta.Naipe naipe : suits)
	         for (int rank = min_rank; rank <= max_rank; rank++)
	            cards[i++] = new Carta(rank, naipe);

	      topo = cards.length - 1;
	      assert cards[topo] != null;
	   }


	   public void embaralhar()
	   {
	      Random rng = new Random();

	      for (int i = cards.length - 1; i > 0; i--) {
	         int j = rng.nextInt(i + 1);
	         Carta tmp = cards[j];
	         cards[j] = cards[i];
	         cards[i] = tmp;
	      }
	   }


	   public boolean vazio()
	   {
	      return topo < 0;
	   }


	   public Carta pegaCarta()
	   {
	      if (vazio()) {
	    	  System.out.println("baralho vazio");
	      }
	      return cards[topo--];
	   }

	   public Iterator<Carta> iterator()
	   {
	      return new Iterator<Carta>()
	      {
	         private int cursor = topo;

	         public boolean hasNext()
	         {
	            return cursor >= 0;
	         }

	         public Carta next()
	         {
	            if (hasNext())
	               return cards[cursor--];
	            throw new NoSuchElementException();
	         }

	         public void remove()
	         {
	            throw new UnsupportedOperationException();
	         }
	      };
	   }

	   
}
