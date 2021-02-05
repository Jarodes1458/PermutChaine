import java.math.BigInteger;

class DemoFactorielle
{
	
	public static void main (String[] args)
    {
		System.out.println (factorielle(5));
//		System.out.println (factorielle(15));
//		System.out.println (factorielle(16));
//		System.out.println (factorielle(17));
//
//    	int nombrePlus = 15;
//    	affichage(nombrePlus);
//    	System.out.println ();
//    	int nombreMoins = 17;
//    	affichage(nombreMoins);
		

    }
    
    
    static int factorielle(int n)
    {
//    	if ( n == 0)
//    		return 1;
//    	else
    		return n*factorielle(n-1);
    }
		
	static BigInteger factorielle(BigInteger bi)
	{
	  	if (bi.equals(BigInteger.ZERO))
	    		return BigInteger.ONE;
	    	else
	    		return bi.multiply(factorielle(bi.subtract(BigInteger.ONE)));		
	}
	
	
	    private static void affichage(int nombre)
    {
    	System.out.println ("La factorielle de "+nombre+" vaut ");
    	System.out.println ("calculée en int :" + factorielle(nombre));
    	BigInteger bi = factorielle(new BigInteger(nombre+""));
    	System.out.println ("et "+bi+" calculée en BigInteger");
    	BigInteger modulo2puis32 = bi.mod(new BigInteger("2").pow(32));
    	System.out.print ("qui vaut mod 2^32 ");
    	// pour info 2 puissance 32 = 4294967296
		if ( modulo2puis32.compareTo(new BigInteger("2").pow(31)) == 1 )
			//dans ce cas le nombre est considéré comme négatif
			System.out.println (modulo2puis32.subtract(new BigInteger("2").pow(32)));
		else
			System.out.println (modulo2puis32);
    }

}

/*
 *>>> bin(2004310016)
'0b1110111011101110101100000000000'
>>> bin(1307674368000)
'0b10011000001110111011101110101100000000000'
          '0b1110111011101110101100000000000'

# en comparant on voit que les 32 derniers bits sont les mêmes
#'0b10011000001110111011101110101100000000000' = bin(1307674368000)
#          '0b1110111011101110101100000000000' = bin(2004310016)


>>> 2004310016+2**36+2**37+2**40 # parce que seuls les bits en position 36, 37 et 40 sont à 1
1307674368000


>>> bin(-288522240)
'-0b10001001100101000000000000000'
>>> bin(355687428096000)
'0b1010000110111111011101110110011011000000000000000'

# en comparant on voit que les 32 derniers bits sont les mêmes
#'0b1010000110111111011101110110011011000000000000000' = bin(355687428096000)
#                 '0b11101110110011011000000000000000' = bin(-288522240+2**32) = bin(4006445056)
#                 '0b11101110110011011000000000000000' = 
#                   '-0b10001001100101000000000000000'
*/