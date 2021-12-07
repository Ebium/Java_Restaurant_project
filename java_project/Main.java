import java.util.*;

public class Main{
    public static void main(String[] args){
        String line = "|----------------------------------------------------------------|";
        
        Stock sto = Stock.getInstance();

        Scanner input = new Scanner(System.in);

        /*---- VARIABLE ----*/
        int valeur_commande = 0;
        int demarrage = 1;
        int lineval = 0;
        int pret = 0;

        /*-------- CHOIX ARRIVEE --------- */
        System.out.print("\033[H\033[2J");
        System.out.println(line); 
        System.out.println("\nBonjour, voulez vous passer une commande ? -> |oui - 1| / |non - 0|"); 
        demarrage = input.nextInt();
        System.out.print("\033[H\033[2J"); 
        if(demarrage==0) System.out.println("\nTrès bien, je ne le prend pas du tout mal, salut !\n");
        else System.out.println(line+"\n            Bienvenue à MAKER ! Make your own Burger !\n");


        /*-------------------------------WHILE PRINCIPAL-------------------------------*/
        while(demarrage != 0){
            if (lineval == 1) System.out.println(line);
            else{
                lineval = 1;
                System.out.println("Que souhaitez vous faire ? \n");
                System.out.println("1 - Passer une commande");
                System.out.println("0 - Tout annuler");
                valeur_commande = input.nextInt();
                System.out.print("\033[H\033[2J"); 
            } 

            
            while(pret != 1){
                System.out.println(line);
                System.out.println("\nSouhaitez vous ajoutez un ingrédient ou autre chose à votre commande actuelle ? \n");
                System.out.println("1 - Valider la commande actuelle");
                System.out.println("2 - Ajouter un ingrédient");
                System.out.println("3 - Ajouter un déssert");
                System.out.println("4 - Ajouter une boisson");
                
                pret = input.nextInt();
            }



            System.out.println(line);
            System.out.println("\n  Souhaitez vous ajouter une commande ? -> |oui - 1| / |non - 0|");
            demarrage = input.nextInt(); 
            System.out.print("\033[H\033[2J");  
            if (demarrage == 0){
                System.out.println(line);
                if(valeur_commande == 0) System.out.println("\nVous n'avez rien commandé donc je vous souhaite une bonne journée ! \n");
                else System.out.println("\nTrès bien, nous allons procéder au payement : \n");
                break;            
            } 
        } /*------------------------------------FIN WHILE PRINCIPAL ----------------------------------------------*/
        


    }
}