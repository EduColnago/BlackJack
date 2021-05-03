package model;

public class API {
	private static API api = null;
	private API() {
		 public CtrlRegras ctrl = new CtrlRegras();
	}

	public static API getAPI() {
		if(api==null) {
			api = new API();
		}
		return api;
	}	
	
	public CtrlRegras Hit(String flag) {
		return ctrl.hit(flag);
		
	}
	
}
