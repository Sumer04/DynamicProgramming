import java.util.ArrayList;
import java.util.List;

public class LonegestCommonSubsequence {
    public static void main(String[] args) {
        String s1 = "AXYZ";
        String s2 = "BAZ";
        
        ArrayList<String> sub1 = Subsequence(s1);
        ArrayList<String> sub2 =  Subsequence(s2);

     String ans =   FindLongestSubsequece(sub1,sub2);
     System.out.println(ans);

    }


    public static ArrayList<String> Subsequence(String s1)
    {
        ArrayList<String> subsequence =  new ArrayList<>();
        generateSubsequencesHelper(s1, 0, "", subsequence);
        return subsequence;
    }
    

   
    public static void generateSubsequencesHelper(String s, int i, String current, List<String> subsequences) {
        if (i == s.length()) {
            subsequences.add(current);
            return;
        }
      
        generateSubsequencesHelper(s, i + 1, current + s.charAt(i), subsequences);
   
        generateSubsequencesHelper(s, i + 1, current, subsequences);
    }

    public static String FindLongestSubsequece(ArrayList<String> sub1,ArrayList<String> sub2)
    {
       String LongestCommonSequence = "";
       for(String subb1:sub1)
       {
        for(String subb2:sub2){
            if(subb1.equals(subb2) && subb1.length() > LongestCommonSequence.length())
            {
                LongestCommonSequence  =subb1;
            }
        }
       }
       return LongestCommonSequence ;
    }


    static int lcs(String S1, String S2, int m, int n,int memo[][]) {
        if(memo[m][n] !=-1)
        {
          return memo[m][n];
        }
        if(m==0 || n==0)
        {
          memo[m][n] =0;
        }
       else if(S1.charAt(m-1)==S2.charAt(n-1))
        {
          memo[m][n]= 1 +lcs(S1, S2, m-1, n-1,memo);
        }else{
          memo[m][n] =  Math.max(lcs(S1, S2, m, n-1,memo),lcs(S1, S2, m-1, n,memo));
        }
        return memo[m][n];
  }
  // this is a recursive approach , but we can do this using dynamic programming to add the
  static int lcsRecursion(String S1, String S2, int m, int n) {
      if (m == 0 || n == 0)
          return 0;
      if (S1.charAt(m - 1) == S2.charAt(n - 1))
          return 1 + lcsRecursion(S1, S2, m - 1, n - 1);
      else
          return Math.max(lcsRecursion(S1, S2, m, n - 1),
                          lcsRecursion(S1, S2, m - 1, n));
  }
}
