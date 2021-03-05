public class ArboGr1
{
    public static void main(String[] args)
    {
        int[] tab = {319, 7, 666, 13, 74, 69, 420, 12, 6, 36, 5, 40};

        ArbreBin a = new ArbreBin();
        a.parcours();

        for(  int v : tab )
            a.ajouter(v);

        a.parcours();

        System.out.println("Nombre de noeuds : "+ a.compterNoeuds()+" =?= "+tab.length);
        System.out.println("somme des feuilles : "+ a.sommeFeuilles());
    }
}
