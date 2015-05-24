package topcoder;

/**
 * TopCoder 2014 TCO Algorithm Celebrity Match - Division I, Level One
 * 
 * @author Andrei Palade
 */
public class AnEasyProblem {
    
    public long getSumInterval(long i, long j) {
        return i * i - ((i - j)*(i - j + 1)) / 2;
    } 
    
    public int solve(long sum) {
        
        long i = 1;
        long j = 2;
        
        while((i * (i + 1) / 2) < sum) {
            i++;
        }

        if((i * (i + 1) / 2) == sum) {
            return (int)i;
        }
        
        i = i - 1;
        
        while(i > j) {        
            long temp = getSumInterval(i, j);
            
            while(temp < sum) {
                j = j + 1;
                temp = getSumInterval(i, j);
            }
            
            if (temp == sum) {
                return (int)(i + j - 1);
            }
            
            i = i - 1;
            j = 2;
        }
        
        return -1;
    }
    
    
    public static void main(String[] args) {
        
        AnEasyProblem group = new AnEasyProblem();
        
        long[] test = {100};
        
        for(int i = 0; i < test.length; i++){
            System.out.println(i + ": " + group.solve(test[i]));
        }
    }

}
