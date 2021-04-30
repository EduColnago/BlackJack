package model;
import java.util.Iterator;
import java.util.Random;

import model.Carta.Naipe;

import java.util.NoSuchElementException;
 class Baralho {
	 private final Carta[] cards;
	   private int top;

	   /**
	    * Construct a deck. The cards will start out in an unspecified but
	    * deterministic order - you must call shuffle() yourself.
	    */
	   public Baralho()
	   {
		   //colocar 52cartas* 4###############################################
	      cards = new Carta[Carta.getSuits().length * (Carta.getMaxRank() - Carta.getMinRank() + 1)];
	      refresh();
	   }

	   /**
	    * Repopulate the deck with a full set of cards.
	    */
	   public void refresh()
	   {
	      Carta.Naipe[] suits = Carta.getSuits();
	      int min_rank = Carta.getMinRank();
	      int max_rank = Carta.getMaxRank();

	      int i = 0;
	      for (Carta.Naipe suit : suits)
	         for (int rank = min_rank; rank <= max_rank; rank++)
	            cards[i++] = new Carta(rank, suit);

	      top = cards.length - 1;
	      assert cards[top] != null;
	   }

	   /**
	    * Shuffle the deck, leaving the cards in a random order.
	    */
	   public void shuffle()
	   {
	      // Collections.shuffle(Arrays.asArray(cards));

	      Random rng = new Random();

	      for (int i = cards.length - 1; i > 0; i--) {
	         // Swap the i-th card with a random one
	         int j = rng.nextInt(i + 1);
	         Carta tmp = cards[j];
	         cards[j] = cards[i];
	         cards[i] = tmp;
	      }
	   }

	   /**
	    * Return true if the deck is empty.
	    */
	   public boolean empty()
	   {
	      return top < 0;
	   }

	   /**
	    * Take a card from the deck and return it.
	    */
	   public Carta takeCard()
	   {
	      if (empty())
	         throw new IllegalStateException("Can't deal from an empty deck.");
	      return cards[top--];
	   }

	   /**
	    * Print the current state of the deck.
	    */
	   public void print()
	   {
	      if (empty()) {
	         System.out.println("The deck is empty.");
	         return;
	      }

	      System.out.println("The current deck:");
	      for (Carta card : this.cards)
	         System.out.println("  " + card);
	   }

	   /**
	    * Return an iterator of the deck's cards.
	    *
	    * The behavior is unspecified if you modify the deck (including taking a
	    * card) during the lifetime of an iterator.
	    */
	   public Iterator<Carta> iterator()
	   {
	      return new Iterator<Carta>()
	      {
	         private int cursor = top;

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