import java.util.Scanner;

class Cluedo2 {

    private static Scanner clavier = new Scanner(System.in);

    public static void main(String[] args) {
    	
    	String nom = "==> Le personnage auquel vous pensez est ";
    	
        System.out.print("Pensez a un personnage : Mlle Rose, ");
        System.out.println("le Professeur Violet, le Colonel Moutarde,");
        System.out.println("le Reverend Olive ou Mme Leblanc.\n");

        System.out.print("Est-ce que votre personnage est un homme ? ");
        boolean homme = clavier.nextBoolean();
        
        if(homme){
        	
        	System.out.print("Votre personnage a-t-il des moustaches ? ");
            System.out.print("(true : oui, false : non) ");
            boolean moustaches = clavier.nextBoolean();
            if(moustaches){
            	nom+="le Colonel Moutarde";
            	
            }else {
            	System.out.print("Votre personnage porte-t-il un chapeau ? ");
                boolean chapeau = clavier.nextBoolean();
                if(chapeau){
                	 nom+="le Professeur Violet";
                }else{
                	 nom+="le Reverend Olive";
                }
            }
            
        }else{
        	System.out.print("Votre personnage porte-t-il des lunettes ? ");
            boolean lunettes = clavier.nextBoolean();
            
            if(!lunettes){
            	nom+="Mlle Rose";
            	
            }else{
            	nom+="Mme Leblanc";
            }
        }
        
        System.out.print(nom);

        System.out.println();
    }
}
