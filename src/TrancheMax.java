import java.util.ArrayList;
import java.util.Scanner;

class TrancheMax {

    private static Scanner clavier = new Scanner(System.in);

    public static void main(String[] args) {

        // Entree de la matrice
        System.out.println("Saisie de la matrice :");
        String matrice = clavier.nextLine();
        System.out.format("Matrice saisie :\n%s\n", matrice);

        // stocke les indices des lignes contenant la plus grande sequence de
        // '1' consecutifs dans la matrice
        ArrayList<Integer> maxConsecutifList = new ArrayList<Integer>();

        /*******************************************
         * Completez le programme a partir d'ici.
         *******************************************/
        // Si la matrice es vide 
        if(matrice.replaceAll("\\s", "").length()==0){
        	System.out.println("Matrice vide!");
        	System.exit(0);
        }else{
        	
        	String regex = "((\\s*)((0|1)*))+"; //regex pour la forme de la matrice
            
            if(matrice.matches(regex)){
            	
            	matrice = matrice.trim();
            	
            	String[] lignes = matrice.split(" {1,}");
                	
            	int longeurLigne = lignes[0].length();
                boolean longeurValide = true;	
                // Test de longueur valide
            	for (int i = 1; i < lignes.length; i++) {
            		
            		if(lignes[i].length() != longeurLigne){
            			System.out.println("Matrice invalide, lignes de longueurs differentes!");
            			longeurValide = false;
            			System.exit(0);
            		}
            	}
            	if(longeurValide){
            		int max = 2;
            		ArrayList<Integer> lst = new ArrayList<>();
            		
            		for (int i = 0; i < lignes.length; i++) {
            			
            			int j = longeurLigne;
            			lst.add(i, 0);
						while (j>=max) {
							
							String reg = "(.*)(1{"+j+"})(.*)";
							if(lignes[i].matches(reg)){
								max = j;
								lst.add(i, j);
								break;
							}
							j-=1;
						}
						
					}
            		for (int i = 0; i < lst.size(); i++) {
						if(lst.get(i)>=max){
							maxConsecutifList.add(i);
						}
					}
            	}
            	
            }else{
            	System.out.println("Matrice invalide, seulement '1' , '0' et ' ' admis!");
            	System.exit(0);
            }
        }
        

        /*******************************************
         * Ne rien modifier apres cette ligne.
         *******************************************/

        if (maxConsecutifList.isEmpty()) {
            System.out.println("Pas de lignes avec des 1!");
        } else {
            System.out.println("Ligne(s) avec le plus de 1 consecutifs:");
            for (Integer index : maxConsecutifList) {
                System.out.println(index);
            }
        }
    }
}