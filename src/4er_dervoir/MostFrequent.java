class MostFrequent {

    public static void main(String[] args) {
        int[] tab1 = {2, 7, 5, 6, 7, 1, 6, 2, 1, 7, 6};
        int taille = tab1.length;

        /*******************************************
         * Completez le programme a partir d'ici.
         *******************************************/
        
        int most = 0;
        int freqMax = 0;
        for (int i = 0; i < taille; i++) {
        	int freq = 1;
		for (int j = i+1; j < taille; j++) {
				
			if(tab1[i] == tab1[j]){
				freq += 1;
			}
		}
			
		if(freq > freqMax){
			freqMax = freq;
			most = tab1[i];
		}
	}
        System.out.print("Le nombre le plus frequent dans le tableau est le :\n");
        System.out.println(most+" ("+freqMax+" x)");
        /*******************************************
         * Ne rien modifier apres cette ligne.
         *******************************************/

    }
}
