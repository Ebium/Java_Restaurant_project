import java.util.*;
import java.util.concurrent.TimeUnit;

public class Main{
    public static void main(String[] args){
        String line = "|----------------------------------------------------------------|";
        
        Stock mystock = Stock.getInstance();

        Scanner input = new Scanner(System.in);
        /*---- VARIABLE ----*/
        int valeur_commande = 0;
        int demarrage = 1;
        int lineval = 0;
        int pret = 0;


        /*-------- DECLARIATION FASTFOOD ET RISQUE INCENDIE -------- */
        FastFood myfastfood = new FastFood(mystock);
        if (myfastfood.incendie()){
            MyUtils.clear();

            System.out.println("                        ALERTE INCENDIE !\n");
            MyUtils.wait(2000);
            System.out.println("                 NOUS DEVONS FERMER LE FASTFOOD !\n");
            MyUtils.wait(2000);
            System.out.println("                DESOLE POUR LA GENE OCCASIONNEE !\n");
            System.out.println(line);
        }
        
        else{
            /*-------- CHOIX ARRIVEE --------- */
            MyUtils.clear();
            System.out.println("Bonjour, voulez vous passer une commande ? -> |oui - 1| / |non - 0|"); 
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
                    MyUtils.clear();
                } 

            
                while(pret != 1){
                
                    Commande mycommande = new Commande();
                    System.out.println("    \nQue souhaitez vous ajouter à votre commande actuelle ? \n");
                    System.out.println("1 - Valider la commande actuelle");
                    System.out.println("2 - Ajouter un burger");
                    System.out.println("3 - Ajouter un dessert");
                    System.out.println("4 - Ajouter une boisson");
                    pret = input.nextInt();
                
                    if(pret == 1){               /*-------- VALIDATION COMMANDE --------*/
                        MyUtils.clear();
                        System.out.println("               Validation de la commande en cours...\n");
                        MyUtils.wait(2000);
                        System.out.println("\n                      Commande ajoutée !\n");
                        MyUtils.wait(2000);
                        MyUtils.clear();
                    }

                    if(pret == 3){               /*-------- AJOUT DESSERT --------*/

                    }

                    if(pret == 4){               /*-------- VALIDATION BOISSON --------*/

                    }

                    if(pret == 2){               /*-------- VALIDATION BURGER --------*/

                    }
                }



                System.out.println("\n  Souhaitez vous ajouter une commande ? -> |oui - 1| / |non - 0|");
                demarrage = input.nextInt(); 
                System.out.print("\033[H\033[2J");  
                if (demarrage == 0){
                    System.out.println(line);
                    if(valeur_commande == 0) System.out.println("\nVous n'avez rien commandé donc je vous souhaite une bonne journée ! \n");
                    else System.out.println("\n         Très bien, nous allons procéder au payement : \n");
                    break;            
                } 
                else pret = 0;
            } /*------------------------------------FIN WHILE PRINCIPAL ----------------------------------------------*/
        
            //mettre un code de promo si y'a
        }   /* fin incendie */

    }
}