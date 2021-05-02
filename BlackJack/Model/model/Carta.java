package model;
import java.util.Objects;
	class Carta {
		 /**
		    * Enum representing playing card suits.
		    */
		   public enum Naipe
		   {
		      SPADES, HEARTS, DIAMONDS, CLUBS;
		   }

		   // The min and max valid card ranks
		   private static final int MIN_RANK = 1;
		   private static final int MAX_RANK = 13;

		   // This instance's rank and suit
		   private int rank;
		   private Naipe suit;

		   /**
		    * Construct a Carta with a given rank and suit.
		    */
		   public Carta(int rank, Naipe suit)
		   {
		      setRank(rank);
		      setNaipe(suit);
		   }

		   /**
		    * Return the card's rank.
		    */
		   public int getRank()
		   {
		      return rank;
		   }

		   /**
		    * Set the card's rank, with input validation.
		    */
		   public void setRank(int rank)
		   {
		      if (rank < MIN_RANK || rank > MAX_RANK)
		         throw new RuntimeException(
		            String.format("Invalid rank: %d (must be between %d and %d inclusive)",
		                          rank, MIN_RANK, MAX_RANK));
		      this.rank = rank;
		   }

		   /**
		    * Return the card's suit.
		    */
		   public Naipe getNaipe()
		   {
		      return suit;
		   }

		   /**
		    * Set the card's suit, with input validation.
		    */
		   public void setNaipe(Naipe suit)
		   {
		      if (suit == null)
		         throw new RuntimeException("Naipe must be non-null");
		      this.suit = suit;
		   }

		   @Override
		   public String toString()
		   {
		      return String.format("%s[rank=%d, suit=%s]",
		                           getClass().getSimpleName(),
		                           getRank(),
		                           getNaipe().name());
		   }

		   @Override
		   public boolean equals(Object obj)
		   {
		      if (!(obj instanceof Carta))
		         return false;
		      if (obj == this)
		         return true;

		      Carta that = (Carta)obj;
		      return that.getRank() == getRank() && that.getNaipe() == getNaipe();
		   }

		   @Override
		   public int hashCode()
		   {
		      return Objects.hash(getRank(), getNaipe());
		   }

		   /**
		    * Return the minimum allowed rank.
		    */
		   public static int getMinRank()
		   {
		      return MIN_RANK;
		   }

		   /**
		    * Return the maximum allowed rank.
		    */
		   public static int getMaxRank()
		   {
		      return MAX_RANK;
		   }

		   /**
		    * Return an array of the available suits.
		    */
		   public static Naipe[] getSuits()
		   {
		      return Naipe.values();
		   }

		  
		  

}
