import java.util.HashMap;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Programación Dinámica");

        long startime, endtime = 0;
        startime = System.nanoTime();
        System.out.println(fibonacci(40));
        endtime = System.nanoTime();
        System.out.println("Time taken: " + (endtime - startime)/1000000000.0+ " segundos");
        System.out.println();

        startime = System.nanoTime();
        System.out.println(fibonacciWithCaching(40));
        endtime = System.nanoTime();
        System.out.println("Time taken: " + (endtime - startime)/1000000000.0 + " segundos");

        startime = System.nanoTime();
        System.out.println(fibonacciCaching(40));
        endtime = System.nanoTime();
        System.out.println("Time taken: " + (endtime - startime)/1000000000.0+ " ns");
        System.out.println(String.format("Time taken: %9f segundos",(endtime - startime)/1_000_000_000.0));

        /// Ejericio 1
        // runEjercicio();

    }

    // Normal recursive method
    public static int fibonacci(int n) {
        if(n<=1){
            return n;
        }
    return fibonacci(n-1)+fibonacci(n-2);

    }

    // First caching method: Using a Map

    private static Map<Integer,Integer> cache=new HashMap<>();
    public static int fibonacciWithCaching(int n) {
        if(n<=1){
            return n;
        }
        if(cache.containsKey(n)){
            return cache.get(n);

        }
        int result=fibonacciWithCaching(n-1)+fibonacciWithCaching(n-2);
        cache.put(n, result);
        return result;

        }


    // Second caching method: Using an array
    public static int fibonacciCaching(int n) {
        int []cache=new int[n+1];
        return fibonacciArregloR(n,cache);
    }

    private static int fibonacciArregloR(int n, int[] cache) {
    if(n<=1){
        return n;
    }
    if(cache[n]!=0){
        return cache[n];
    }
    cache[n]=fibonacciArregloR(n-1,cache)+fibonacciArregloR(n-2,cache);
    return cache[n];
    }

    public static void runEjercicio() {

        // boolean[][] grid = {
        // { true, true, true, true },
        // { false, false, false, true },
        // { true, true, false, true },
        // { true, true, false, true }
        // };

    }
}
