package com.form;

import com.bean.Ville;

public class Distance {
	
	public float getDistance(Ville villeDepart, Ville villeArrivee) {
		float distance = 0;
		
		float deltaX = (float) Math.pow(Math.abs(Float.parseFloat(villeDepart.getLatitude()) - Float.parseFloat(villeArrivee.getLatitude())), 2.0);
		float deltaY = (float) Math.pow(Math.abs(Float.parseFloat(villeDepart.getLongitude()) - Float.parseFloat(villeArrivee.getLongitude())), 2.0);
		distance = (float) Math.sqrt(deltaX + deltaY);

		return distance;
	}
	
}
