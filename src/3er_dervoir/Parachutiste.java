import java.util.Scanner;

class Parachutiste {

    private static Scanner clavier = new Scanner(System.in);

    public static void main(String[] args) {

        double masse = 80.0;
        do {
            System.out.print("masse du parachutiste (>= 40) ? ");
            masse = clavier.nextDouble();
        } while (masse < 40.0);

        double h0 = 39000.0;
        do {
            System.out.print("hauteur de depart du parachutiste (>= 250) ? ");
            h0 = clavier.nextInt();
        } while (h0 < 250.0);

        /*******************************************
         * Completez le programme a partir d'ici.
         *******************************************/
        final double g = 9.81;
        double v0 = 0;
        double t0 = 0;
        double t = t0; 
        double hauteur = h0; 
        double vitesse = v0; 
        double accel = g;
        
        double s = 2.0/masse;
        
        double vitesseSon = 343;
        boolean afficheVitesseSon =true;
        
        double accelMax=0.5;
        boolean afficheVitesseMax = true;
        
        double hauteurMin=2500;
        boolean afficheHauteurMin = true;
        
        double q = Math.exp(-s*(t-t0));
        hauteur = h0 -((g/s)*(t-t0)) - ((v0-g/s)/s)*(1-q);
        
        
        while(hauteur>0){
        	
        	boolean aff = true;
        	vitesse = g/s * (1-q) + v0*q;
        	
        	if(vitesse>= vitesseSon && afficheVitesseSon){
        		System.out.print("## Felix depasse la vitesse du son\n");
        		afficheVitesseSon = false;
        	}
        	
        	accel = g - s*vitesse;
                
        	if(accel<= accelMax && afficheVitesseMax){
        		System.out.print("## Felix a atteint sa vitesse maximale\n");
        		afficheVitesseMax = false;
                	
        	}
            	
                
        	if(hauteur < hauteurMin && afficheHauteurMin){
        		if(t==0){
        			aff = false;
        			System.out.format("%.0f, %.4f, %.4f, %.5f\n",
                            t, hauteur, vitesse, accel);
        		}
        		System.out.print("## Felix ouvre son parachute\n");
        		afficheHauteurMin = false;
            		
        		if(t>0){
        			s= 25.0/masse;
        			t0 = t;
        			q = Math.exp(-s*(t-t0));
        			v0 = vitesse;
        			h0 = hauteur;
        		}
        	}
        	if(hauteur<hauteurMin && !afficheHauteurMin && t==1){
        		s= 25.0/masse;
        		t0 = t;
        		q = Math.exp(-s*(t-t0));
        		v0 = vitesse;
        		h0 = hauteur;
        	}
        	
        	if(aff){
    			System.out.format("%.0f, %.4f, %.4f, %.5f\n",
                        t, hauteur, vitesse, accel);
    		}
        	// Utilisez cette ligne pour l'affichage
        	//System.out.format("%.0f, %.4f, %.4f, %.5f\n",
             //                         t, hauteur, vitesse, accel);
        	t+=1;
        	q = Math.exp(-s*(t-t0));
        	hauteur = h0 -((g/s)*(t-t0)) - ((v0-g/s)/s)*(1-q);
            
        }
        

        /*******************************************
         * Ne rien modifier apres cette ligne.
         *******************************************/

    }
}
