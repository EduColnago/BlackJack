package model;

	class Carta {
		
		   public enum Naipe
		   {
			   ESPADAS, CORACAO, DIAMANTE, COPAS;
		   }

		  
		   private static final int MIN_RANK = 1;
		   private static final int MAX_RANK = 13;

		  
		   private int rank;
		   private Naipe naipe;

		   public Carta(int rank, Naipe naipe)
		   {
		      setRank(rank);
		      setNaipe(naipe);
		   }

		   public int getRank()
		   {
		      return rank;
		   }

		   
		   public void setRank(int rank)
		   {
		      this.rank = rank;
		   }

		   public Naipe getNaipe()
		   {
		      return naipe;
		   }


		   public void setNaipe(Naipe naipe)
		   {
		      this.naipe = naipe;
		   }

		 
		
		   public static int getMinRank()
		   {
		      return MIN_RANK;
		   }

	
		   public static int getMaxRank()
		   {
		      return MAX_RANK;
		   }

		   public static Naipe[] getSuits()
		   {
		      return Naipe.values();
		   }

		  
		  

}
