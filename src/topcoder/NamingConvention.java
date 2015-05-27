package topcoder;

/**
 * TopCoder Single Round Match 638 Round 1 - Division II, Level One
 * 
 * Can be done with a StringBuilder, instead of using primitives
 * Possibly more efficient since we traverse only once
 * 
 * @author Andrei Palade
 */
public class NamingConvention {

    public String toCamelCase(String variableName) {
        char[] var = variableName.toCharArray();
        int size = 1;
        for(int i = 1; i < var.length - 1; i++){
            if (var[i] == '_'){
                var[i+1] = (char)(var[i+1] - 32);
                size++;
            }
        }
        if(var[var.length - 1] == '_') {
            size++;
        }
        char[] var2 = new char[var.length - size + 1];
        
        for(int i = 0, j = 0; i < var.length; i++) {
            if (var[i] != '_') {
                var2[j] = var[i];
                j++;
            }
        }
        
        return new String(var2);
    }
    
    
    public static void main(String[] args) {
        
        NamingConvention group = new NamingConvention();
        
        String[] test = {"sum_of_two_numbers", "variable", "t_o_p_c_o_d_e_r"};

        for(int i = 0; i < test.length; i++){
            System.out.println(i + ": " + group.toCamelCase(test[i]));
        }
    }
}
