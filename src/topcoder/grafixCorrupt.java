package topcoder;

/**
 * @author Andrei
 */
public class grafixCorrupt {

    public int getScore(String word, String candidate){
        int score = 0;
        for (int i = 0; i < candidate.length(); i++){
            if (candidate.charAt(i) == word.charAt(i)){
                score += 1;
            }
        }
        return score;
    }
    
    
    public int selectWord(String[] dictionary, String candidate){
        int biggest = -1;
        int index = -1;
        for(int i = 0; i < dictionary.length; i++){
            int curScore = getScore(dictionary[i], candidate);
            if (curScore > biggest){
                index = i;
                biggest = curScore;
            }
        }
        return biggest == 0? -1 : index;
    }
    
    
    public static void main(String[] args) {
        grafixCorrupt group = new grafixCorrupt();
        
        String[][] test = {{"cat", "cab", "lab"}, {"dab"}, {"cat", "cab", "lab"}, {"bic"}, {"zhadjsg", "vzptftx", "fbaslxs", "ejejncm", "xpxkeae", "ixrrtzw",
 "ovctbzx", "sfzekhh", "lxzixjk", "jixdpik", "bkianck", "laclyin",
 "uqmdkfx", "dimswqo", "fojhetr", "grntrce", "obdtqwx", "bhojwcy",
 "zuuuvst", "mvqtoly", "aftmupx", "govuidx", "qklpret", "yptccki",
 "uxdnslh", "wudrusz", "uwxbvou", "ouytqun", "pjdexqe", "xraaqdw",
 "lxmoncl", "sjnjfgb", "qrlqgvc", "fgvoadm", "yohsrxw", "udpvrsr",
 "mklucgt"}, {"vklikgf"}};
        
        for(int i = 0; i < test.length; i+=2){
            System.out.println(i + ": " + group.selectWord(test[i], test[i+1][0]));
        }
    }
}
