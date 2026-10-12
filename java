public class Main {

    public static void main(String[] args) {

        System.out.println("====================================");
        System.out.println("       FACTORIZACION LU - A4");
        System.out.println("====================================");

        double[][] A = {
            {2, 3, 1},
            {6, 8, 5},
            {4, 7, 9}
        };

        int n = A.length;

        double[][] L = new double[n][n];
        double[][] U = new double[n][n];


        for (int i = 0; i < n; i++) {
            L[i][i] = 1;
        }

        // Factorizacion LU
        for (int i = 0; i < n; i++) {

            // Calcular matriz U
            for (int j = i; j < n; j++) {
                U[i][j] = A[i][j];

                for (int k = 0; k < i; k++) {
                    U[i][j] -= L[i][k] * U[k][j];
                }
            }

            // Calcular matriz L
            for (int j = i + 1; j < n; j++) {
                L[j][i] = A[j][i];

                for (int k = 0; k < i; k++) {
                    L[j][i] -= L[j][k] * U[k][i];
                }

                L[j][i] /= U[i][i];
            }
        }

        System.out.println("\nMatriz L:");
        mostrarMatriz(L);

        System.out.println("\nMatriz U:");
        mostrarMatriz(U);

        // Multiplicar L por U
        double[][] resultado = new double[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    resultado[i][j] += L[i][k] * U[k][j];
                }
            }
        }

        System.out.println("\nMultiplicacion L * U:");
        mostrarMatriz(resultado);

        System.out.println("\nMatriz original A4:");
        mostrarMatriz(A);
    }

    public static void mostrarMatriz(double[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.printf("%8.2f", matriz[i][j]);
            }
            System.out.println();
        }
    }
}