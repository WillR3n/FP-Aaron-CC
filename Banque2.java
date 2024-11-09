class Client {
    private String nom;
    private String ville;
    private Compte compteP;
    private Compte compteE;

    public Client(String nom, String ville, double taux1, double solde1, double taux2, double solde2) {
        this.nom = nom;
        this.ville = ville;
        this.compteP = new Compte(taux1,  solde1);
        this.compteE = new Compte(taux2,  solde2);
    }

    public void afficher() {
        System.out.println("Client " + nom + " de " + ville);
        System.out.println("Compte prive: " + compteP.getSolde() + " francs.");
        System.out.println("Compte epargne: " + compteE.getSolde() + " francs.");
    }
    public void boucler() {
            compteP.boucler();
            compteE.boucler();
    }
}

class Compte {
    private double taux;
    private double solde;

    public Compte(double taux, double solde) {
        this.taux = taux;
        this.solde = solde;
    }

    public double getSolde() {
        return solde;
    }

    public void boucler() {
        double interets = taux * solde;
        solde += interets;
    }
}

class Banque2 {
    public static void main(String[] args) {
        double taux1 = 0.01;
        double taux2 = 0.02;

        Client c1 = new Client("Pedro", "Genève", taux1, 1000.0, taux2, 2000.0);
        Client c2 = new Client("Alexandra", "Lausanne", taux1, 3000.0, taux2, 4000.0);

        System.out.println("Donnees avant le bouclement des comptes:");
        c1.afficher();
        c2.afficher();

        c1.boucler();
        c2.boucler();

        System.out.println("Donnees apres le bouclement des comptes:");
        c1.afficher();
        c2.afficher();
    }
}

