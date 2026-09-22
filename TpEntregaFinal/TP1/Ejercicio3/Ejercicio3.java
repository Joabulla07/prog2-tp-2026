package TpEntregaFinal.TP1.Ejercicio3;

public class Ejercicio3 {

    public static void main(String[] args) {
        Fibonacci fib = new Fibonacci();
        
        int[] valores = {10, 20, 30, 45};
        
        System.out.println("Comparativa Recursiva vs Iterativa - Fibonacci");
        System.out.println("==============================================");
        System.out.println();
        
        for (int n : valores) {
            System.out.println("N = " + n);
            System.out.println("-------------------");
            
            // Fibo para recursivo
            long inicioRecursivo = System.currentTimeMillis();
            int resultadoRecursivo = fib.fibonacciRecursivo(n);
            long finRecursivo = System.currentTimeMillis();
            long tiempoRecursivo = finRecursivo - inicioRecursivo;
            
            System.out.println("Recursivo:   Resultado = " + resultadoRecursivo + ", Tiempo = " + tiempoRecursivo + " ms");
            
            // Fibo para iterativo
            long inicioIterativo = System.currentTimeMillis();
            int resultadoIterativo = fib.fibonacciIterativo(n);
            long finIterativo = System.currentTimeMillis();
            long tiempoIterativo = finIterativo - inicioIterativo;
            
            System.out.println("Iterativo:   Resultado = " + resultadoIterativo + ", Tiempo = " + tiempoIterativo + " ms");
            System.out.println("Diferencia: " + (tiempoRecursivo - tiempoIterativo) + " ms");
            System.out.println();
        }
        
        System.out.println("==============================================");
        System.out.println("ANÁLISIS DE COMPLEJIDAD:");
        System.out.println("- Recursivo: O(2^n) - Tiempo exponencial");
        System.out.println("- Iterativo: O(n) - Tiempo lineal");
        System.out.println();
        System.out.println("RIESGO DE StackOverflowError:");
        System.out.println("- La versión recursiva puede causar StackOverflowError para n > ~45");
        System.out.println("  debido al crecimiento exponencial de llamadas en la pila.");
        System.out.println("- La versión iterativa no tiene este riesgo al no usar recursión.");
    }
}
