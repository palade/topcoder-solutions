package topcoder;

/**
 * TopCoder Single Round Match 653 Round 1 - Division II, Level One
 * 
 * @author Andrei Palade
 */
public class CountryGroup {

    public int solve(int[] a){
        int buffer = 0;
        int current = 0;
        int countries = 0;
        
        for(int i = 0; i < a.length; i++){
            if (current == 0){
                current = a[0];
                buffer = current;
                countries = 1;
            } 
            
            if (buffer == 0){
                current = a[i];
                buffer = current - 1;
                countries += 1;
            } 
            else {
                if (current != a[i]){
                    return -1;
                } else {
                    buffer -=1;
                }    
            }
        } 
        return buffer != 0 ? -1 : countries;
    }
    
   
    public static void main(String[] args) {
        CountryGroup group = new CountryGroup();
        
        int[][] test = {{2,2,3,3,3}, {1,1,1,1,1}, {3,3}, {4,4,4,4,1,1,2,2,3,3,3},{2,1,2,2,1,2} };
        
        for(int i = 0; i < test.length; i++){
            System.out.println(i + ": " + group.solve(test[i]));
        }
    } 
}
