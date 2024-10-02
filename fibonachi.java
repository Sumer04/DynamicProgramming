public class fibonachi {

     public static void main(String[] args) {
        int n =9;
        System.out.println(fibonachi(n));
     }
     public static int fibonachi(int n)
     {
        if(n==0 || n==1)
        {
            return n;
        }
        return fibonachi(n-1)+fibonachi(n-2);
     }
}