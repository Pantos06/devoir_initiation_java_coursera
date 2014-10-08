import java.util.Scanner;
import java.text.DecimalFormat;

public class Population {
    public static void main(String[] args) {

        DecimalFormat df = new DecimalFormat("#0.000");
        Scanner keyb = new Scanner(System.in);

        int anneeInitiale = 2011;        // annee initiale
        double tauxCroissance = 1.2;     // taux de croissance, en %
        double populationInitiale = 7.0; // population initiale, en milliard d'humains

        double populationCourante = populationInitiale; // population mondiale pour l'annee courante
        int anneeCourante = anneeInitiale;              // annee de calcul

        System.out.println("====---- PARTIE 1 ----====");
        System.out.println("Population en " + anneeCourante + " : " + df.format(populationCourante));
        /*******************************************
         * Completez le programme a partir d'ici.
         *******************************************/

        // ===== PARTIE 1 =====
        do{
        	System.out.print("Quelle année (> 2011) ? ");
            anneeCourante = keyb.nextInt();
            
        }while(anneeCourante<=anneeInitiale);
        
        populationCourante = populationInitiale * Math.exp((anneeCourante-anneeInitiale)*(tauxCroissance/100));
        System.out.println("Population en " + anneeCourante + " : " + df.format(populationCourante));
       
        // ===== PARTIE 2 =====
        System.out.println("\n====---- PARTIE 2 ----====");
        
        anneeCourante = anneeInitiale; // initialisation anneeCourante
        populationCourante = populationInitiale; // initialisation populationCourante
        
        double populationCible = populationInitiale;
        
        do{
            System.out.print("Combien de milliards (> 7.0) ? ");
        	populationCible = keyb.nextDouble();	
        }while(populationCible<=populationInitiale);
        
        while(populationCourante<=populationCible){
        	
        	anneeCourante+=1;
        	populationCourante = populationInitiale * Math.exp((anneeCourante-anneeInitiale)*(tauxCroissance/100));
            System.out.print("Population en " + anneeCourante + " : " + df.format(populationCourante)+"\n");
        }
        
        // ===== PARTIE 3 =====
        System.out.println("\n====---- PARTIE 3 ----====");
        
        DecimalFormat df2 = new DecimalFormat("#0.0");
        anneeCourante = anneeInitiale; // initialisation anneeCourante
        populationCourante = populationInitiale; // initialisation populationCourante
        
        int aux = (int) populationInitiale;
        
        while(populationCourante<populationCible){
        	
        	anneeCourante+=1;
        	populationCourante = populationInitiale * Math.exp((anneeCourante-anneeInitiale)*(tauxCroissance/100));
            
            int aux2 = (int )populationCourante;
           
            if((aux2>aux) &&(aux2 % aux ==0)){
            	
            	anneeInitiale = anneeCourante;
            	populationInitiale = populationCourante;
            	
            	tauxCroissance = tauxCroissance/2;
            	
            	aux=aux2;
            }
            System.out.println("Population en " + anneeCourante + " : " + df.format(populationCourante) +
            		" ; taux de croissance : "+df2.format(tauxCroissance)+"%");
        }
        
        /*******************************************
         * Ne rien modifier apres cette ligne.
         *******************************************/
    }
}
