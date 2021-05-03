package model;

	public class Carta {
		
		   public enum Naipe
		   {
			   ESPADAS, CORAÇAO, DIAMANTE, COPAS;
		   }

		  
		  public static final int MIN_RANK = 1;
		  public  static final int MAX_RANK = 13;

		  
		  public int rank;
		  public Naipe naipe;

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
