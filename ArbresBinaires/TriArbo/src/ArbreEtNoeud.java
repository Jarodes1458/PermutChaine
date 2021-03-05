import java.util.ArrayList;

class Arbre
{
    Noeud racine;

    Arbre()//crée un arbre vide
    {
        racine = null;
    }

    void parcours()
    {
        if ( estVide() )
            System.out.println("Arbre vide");
        else
            racine.parcours();// appel du parcours de la class Noeud
    }

    boolean estVide()
    {
        return racine == null;
    }

    void ajouter(int n)
    {
        if ( estVide() )
            racine = new Noeud(n);// création d'un nouveau noeud qui est le premier
        else
            racine.ajouter(n);// appel du ajouter de la class Noeud
    }

    ArrayList<Integer> parcourlist(){
        if (!estVide())
            return racine.parcourslist();
        else
            return null;
    }

    int sommeArbre(){
        if (!estVide())
            return racine.AdditionNombre();
        else
            return 0;

    }

    int compteurNoeud()
    {
        if ( estVide() )
            return 0;
        else
            return racine.compteurNoeud();
    }

    int sommeFeuille()
    {
        if ( estVide() )
            return 0;
        else
            return racine.sommeFeuille();// appel de sommeFeuille() dans la classe Noeud
    }


}

class Noeud
{
    int valeur;
    Noeud filsGauche, filsDroit;

    Noeud(int valeur)
    {
        this.valeur = valeur;
        filsGauche = null;
        filsDroit = null;
    }

    void parcours()
    {
        if ( filsGauche != null )
            filsGauche.parcours();
        System.out.print(valeur+ " ");
        if ( filsDroit != null )
            filsDroit.parcours();
    }

    //La liste des Nombres dans l'ordre

    ArrayList<Integer> parcourslist()
    {
        ArrayList<Integer> liste = new ArrayList<>();
        if ( filsGauche != null )
            liste.addAll(filsGauche.parcourslist());
        liste.add(valeur);
        if ( filsDroit != null )
           liste.addAll( filsDroit.parcourslist());
        return liste;
    }

    // Addition des nombres de la liste
    int AdditionNombre()
    {
        int r = 0;
        if (filsGauche != null)
            r += filsGauche.AdditionNombre();
        r+= valeur;
        if (filsDroit != null)
            r += filsDroit.AdditionNombre();
        return r;
    }


    void ajouter(int n)
    {
        if ( n < valeur )//on compare la valeur à ajouter avec la valeur du noeud courant
            if ( filsGauche == null )
                filsGauche = new Noeud(n);
            else
                filsGauche.ajouter(n);
        else
            if ( filsDroit == null )
                filsDroit = new Noeud(n);
            else
                filsDroit.ajouter(n);
    }

    public int compteurNoeud()
    {
        int r = 1;// 1 pour compter le noeud où on est
        if ( filsGauche != null )
            r += filsGauche.compteurNoeud();

        if ( filsDroit != null )
            r += filsDroit.compteurNoeud();
        return r;
    }

    int sommeFeuille()
    {
        int r = 0;
        if ( filsGauche == null && filsDroit == null )// on est sur une feuille
        {
            r += valeur;//ou bien return valeur ou bien r = valeur si on commence par ce test
 //           System.out.println(valeur);
        }
        else
        {
            if (filsGauche != null)
                r += filsGauche.sommeFeuille();
            if (filsDroit != null)
                r += filsDroit.sommeFeuille();
        }
        return r;
    }




}
