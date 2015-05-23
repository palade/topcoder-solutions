package topcoder;

/**
 * TopCoder Single Round Match 640 Round 1 - Division II, Level One
 * 
 * @author Andrei Palade
 */
public class ChristmasTreeDecorationDiv2 {

    public int solve(int[] col, int[] x, int[] y){
        int beautiful = 0;
        for(int i = 0; i < x.length; i++) {
            if(col[x[i] - 1] != col[y[i] - 1]){
                beautiful++;
            }
        }       
        return beautiful;
    }
    
    public static void main(String[] args) {
        
        ChristmasTreeDecorationDiv2 group = new ChristmasTreeDecorationDiv2();
        
        int[][] test = {{1,2,3,3}, {1,2,3}, {2,3,4} };
        
        for(int i = 0; i < test.length; i+=3){
            System.out.println(i + ": " + group.solve(test[i], test[i+1], test[i+2]));
        }
    }
}
