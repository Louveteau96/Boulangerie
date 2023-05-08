package boundaries;

import controleur.ControlPresentation;

public class BoundaryPresentation {
	
	private ControlPresentation controlPresentation;
	
	public BoundaryPresentation(ControlPresentation controlPresentation) {
		this.controlPresentation = controlPresentation;
	}
	
	
	
	
	public String bienvenue() {
		return controlPresentation.bienvenue();
	}

}
