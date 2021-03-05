class ArbreBin
{
    Noeud racine;

    ArbreBin()//crée un arbre vide
    {
        racine = null;
    }

    boolean estVide()
    {
        return racine == null;
    }

    void parcours()//parcours d'un arbre
    {
        if ( estVide() )
            System.out.println("Arbre vide");
        else //on appelle le parcours à partir d'un Noeud
            racine.parcours();
    }

    void ajouter(int v)
    {
        if ( estVide() )
            racine = new Noeud(v);
        else
            racine.ajouter(v);
    }

    int compterNoeuds()
    {
        if ( estVide() )
            return 0;
        else
            return racine.compterNoeuds();
    }

    int sommeFeuilles()
    {
        if ( estVide() )
            return 0;
        else
            return racine.sommeFeuilles();
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
        System.out.println(valeur);
        if ( filsDroit != null )
            filsDroit.parcours();
    }

    void ajouter(int v)
    {
        if ( v < valeur )
            if ( filsGauche == null )
                filsGauche = new Noeud(v);
            else
                filsGauche.ajouter(v);
        else
            if ( filsDroit == null )
                filsDroit = new Noeud(v);
            else
                filsDroit.ajouter(v);
    }

    int compterNoeuds()
    {
        int r = 1; // pour compter le noeud où on est
        if ( filsGauche != null )
            r += filsGauche.compterNoeuds();
        if ( filsDroit != null )
            r += filsDroit.compterNoeuds();
        return r;
    }

    public int sommeFeuilles()
    {
        if ( filsGauche == null && filsDroit == null )
            return valeur;
        else
        {
            int r = 0;
            if ( filsGauche != null )
                r += filsGauche.sommeFeuilles();
            if ( filsDroit != null )
                r += filsDroit.sommeFeuilles();
            return r;
        }
    }
}
