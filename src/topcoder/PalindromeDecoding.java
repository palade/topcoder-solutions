package topcoder;

/**
 * TopCoder Single Round Match 324 Round 1 - Division I, Level One 
 * 
 * @author Andrei Palade
 */
public class PalindromeDecoding {

    public String decode(String code, int[] position, int[] length) {
        StringBuilder string = new StringBuilder(code);
        for(int i = 0; i < position.length; i++){       
            string.insert(position[i] + length[i], 
                    new StringBuilder(
                            code.substring(position[i], position[i] + length[i]))
                            .reverse().toString()); 
            code = string.toString();
        }        
        return code;
    }
    
    
    public static void main(String[] args) {

        PalindromeDecoding group = new PalindromeDecoding();

        System.out.println(group.decode("ab", new int[]{0}, new int[]{2}));
        System.out.println(group.decode("TC206", new int[]{1,2,5}, new int[]{1,1,1}));
        System.out.println(group.decode("Misip", new int[]{2,3,1,7}, new int[]{1,1,2,2}));
    }
    
}
