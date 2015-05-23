package topcoder;

/**
 * TopCoder Single Round Match 639 Round 1 - Division II, Level One
 * 
 * Can be a lot simpler! Maybe intersection is not necessary
 * 
 * @author Andrei
 */
public class ElectronicPetEasy {

    // intersection of two sorted arrays
    public boolean isCommon(int[] a, int[] b) {       
        int i = 0; // current index in a
        int j = 0; // current index in b
        while (i < a.length && j < b.length){
            if (a[i] == b[j]) {
                return true;
            }
            else if (a[i] > b[j]){
                j += 1;
            }
            else {
                i += 1;
            }
        }
        return false;
    }
    
    // intersection is not necessary, use only st1 and st2
    public String isDifficult(int st1, int p1, int t1, int st2, int p2, int t2) {
     
        if(st1 == st2){
            return "Difficult";
        } 
        
        int[] a = new int[t1+1];
        a[0] = st1;
        int[] b = new int[t2+1];
        b[0] = st2;

        while(t1 > 0){
            t1-=1;
            a[t1] = t1 * p1 + a[0];
        }
        while(t2 > 0){
            t2-=1;
            b[t2] = t2 * p2 + b[0];
        }

        return isCommon(a, b) ? "Difficult" : "Easy";
    }
    
    public static void main(String[] args) {
        
        ElectronicPetEasy group = new ElectronicPetEasy();
        
        int[][] test = {{3, 3, 3, 5, 2, 3}, {1, 1, 1, 2, 2, 2}};
        
        for(int i = 0; i < test.length; i+=3){
            System.out.println(i + ": " + 
                    group.isDifficult(test[i][0], test[i][1], test[i][2], test[i][3], test[i][4], test[i][5]));
        }
    }
}
