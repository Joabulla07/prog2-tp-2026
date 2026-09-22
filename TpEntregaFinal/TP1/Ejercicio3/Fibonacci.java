package TpEntregaFinal.TP1.Ejercicio3;

public class Fibonacci {

    /**
     * Calcula el número de Fibonacci de forma recursiva.
     * 
     * Complejidad: O(2^n) - tiempo exponencial
     * Caso base: n == 0 -> 0, n == 1 -> 1
     * Caso recursivo: fibonacci(n-1) + fibonacci(n-2)
     * 
     * @param n el número de la secuencia de Fibonacci a calcular
     * @return el número de Fibonacci correspondiente
     * @throws StackOverflowError para n > ~45 debido al crecimiento exponencial de llamadas
     */
    public int fibonacciRecursivo(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return fibonacciRecursivo(n - 1) + fibonacciRecursivo(n - 2);
    }
    

    /**
     * Calcula el número de Fibonacci de forma iterativa.
     * 
     * Complejidad: O(n) - tiempo lineal
     * Usa un bucle simple para calcular fibonacci sin recursión.
     * No hay riesgo de StackOverflowError ya que no usa pila de llamadas.
     * 
     * @param n el número de la secuencia de Fibonacci a calcular
     * @return el número de Fibonacci correspondiente
     */
    public int fibonacciIterativo(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        
        int a = 0, b = 1;
        for (int i = 2; i <= n; i++) {
            int siguiente = a + b;
            a = b;
            b = siguiente;
        }
        return b;
    }
}
