package boundaries;

import controleur.ControlVerifContent;

public class BoundaryVerifContent {
	private ControlVerifContent controlVerifContent = new ControlVerifContent();
	
	
	//Les méthodes
	public boolean testDouble(String text) {
		return controlVerifContent.testDouble(text);
	}
	public boolean testInteger(String text) {
		return controlVerifContent.testInteger(text);
	}

}
