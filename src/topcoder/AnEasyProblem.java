package topcoder;

/**
 * TopCoder 2014 TCO Algorithm Celebrity Match - Division I, Level One
 * 
 * @author Andrei Palade
 */
public class AnEasyProblem {
    
  
    public int solve(long sum) {
        
        long i = 1;
        long prev = 0;
               
        for(; prev < sum; i++) prev += i;
        
        i = i - 1;

        if(prev == sum) {
            return (int)i;
        }
        long temp = 0;
        long j = i - 2; // initial index i 
        long k = 0;
        while(true) {   
            
            temp = (prev -= i);
            i = i - 1;        
            temp += k;
            while(j > 0) {

                temp +=j;
                k += j;
                j -= 1;
                
                if(!(temp < sum)){
                    break;
                }
            }
            
            if (temp == sum) {
                return (int) (i + i - j - 1);
            } 
            
            if (j <= 0) {
                return -1;
            }
            k = k - (i - 1);
        }
    }
 
    public static void main(String[] args) {
        
        AnEasyProblem group = new AnEasyProblem();
        
        long[] test = {14};
        
     //   long[] test = {1000000000000L};
        
       // long[] test = {8};
        
        for(int i = 0; i < test.length; i++){
            System.out.println(i + ": " + group.solve(test[i]));
        }
    }

}
