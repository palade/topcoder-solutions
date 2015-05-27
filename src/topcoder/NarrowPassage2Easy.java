package topcoder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 
 * 
 * @author Andrei Palade
 */
public class NarrowPassage2Easy {

    private static class Permutation {

        final int[] array;

        public Permutation(int[] a) {
            array = new int[a.length];
            System.arraycopy(a, 0, array, 0, a.length);
        }

        @Override
        public int hashCode() {  
            return Arrays.hashCode(this.array);
        }

        @Override
        public boolean equals(Object other) {
            return Arrays.equals(array, ((Permutation) other).array);
        }
    }

    private static void swap(int[] v, int i, int j) {
        int t = v[i]; v[i] = v[j]; v[j] = t;
    }

    // Heap's Algorithm
    public void permute(int[] ids, int[] v, int n, int s, List<Permutation> result) {
        if (n == 1) {
            result.add(new Permutation(v));
        } else {
            for (int i = 0; i < n; i++) {
                permute(ids, v, n - 1, s, result);

                if (n % 2 == 1) {
               //     if (v[ids[0]] + v[ids[1]] <= s && v[ids[n - 2]] + v[ids[n - 1]] <= s) {
                        swap(ids, 0, n - 1);
                  //  }
                } else {
                  //  if (v[ids[n - 2]] + v[ids[n - 1]] <= s && v[ids[i]] + v[ids[i+1]] <= s) {
                        swap(ids, i, n - 1);
                  //  }
                }

            }
        }
    }

    public boolean differentArrays(int[] a, int[] b) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) {
                return true;
            }
        }
        return false;
    }

    public int count(int[] size, int maxSizeSum) {
        if (size.length == 1) {
            return 1;
        }
        List<Permutation> myList = new ArrayList();
        
        int[] ids = new int[size.length];
        for(int i = 0; i < ids.length;i++){
            ids[i] = i;
        }
        
        permute(ids, size, size.length, maxSizeSum, myList);
        Set<Permutation> hs = new HashSet<>();
        hs.addAll(myList);
        return hs.size();
    }

    public static void main(String[] args) {

        NarrowPassage2Easy group = new NarrowPassage2Easy();

        int[][] test = {{2, 4, 6, 1, 3, 5}, {8}};
        // int[][] test = {{1, 2, 3}, {6}, {2,4,6,1,3,5}, {8}, {1, 1, 1, 1, 1, 1}, {2}};

        for (int i = 0; i < test.length - 1; i += 2) {
            System.out.println(i + ": " + group.count(test[i], test[i + 1][0]));

        }
    }
}
