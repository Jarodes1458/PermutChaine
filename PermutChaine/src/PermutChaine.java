import java.util.ArrayList;

public class PermutChaine
{
    public static void main(String[] args)
    {
        afficherPermutation("ABC", "");
    }

    static void afficherPermutation(String s, String prefixe)
    {
        if ( s.length() <= 1 )
            System.out.println(prefixe+s);
        else
            for (int pos = 0; pos < s.length(); pos++) {
                StringBuilder sb = new StringBuilder(s);
                sb.deleteCharAt(pos);
                String p = sb.toString();
                afficherPermutation(p, prefixe + s.charAt(pos));
//                str.add((prefixe+s + prefixe+s.charAt(pos)));
            }
//        System.out.println(str);
    }

}
