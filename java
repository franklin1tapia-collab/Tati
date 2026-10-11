public static void main(String[] args) {

    System.out.println("========================================");
    System.out.println("          FACTORIZACION LU");
    System.out.println("========================================");

    double[][] A = {
        {2, 3, 1},
        {6, 6, 5},
        {4, 7, 9}
    };

    int n = A.length;

    double[][] L = new double[n][n];
    double[][] U = new double[n][n];

    // Crear la matriz identidad L
    for (int i = 0; i < n; i++) {
        L[i][i] = 1;
    }

    // Copiar A en U
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            U[i][j] = A[i][j];
        }
    }

    // Factorización LU
    for (int i = 0; i < n; i++) {

        for (int j = i + 1; j < n; j++) {

            double factor = U[j][i] / U[i][i];

            L[j][i] = factor;

            for (int k = i; k < n; k++) {
                U[j][k] =
                    U[j][k] - factor * U[i][k];
            }
        }
    }

    System.out.println("\nMATRIZ A:");
    mostrarMatriz(A);

    System.out.println("\nMATRIZ L:");
    mostrarMatriz(L);

    System.out.println("\nMATRIZ U:");
    mostrarMatriz(U);

    // Multiplicar L por U
    double[][] resultado = multiplicarMatrices(L, U);

    System.out.println("\nRESULTADO DE L * U:");
    mostrarMatriz(resultado);

    // Comprobar resultado
    System.out.println("\n¿L * U = A?");
    System.out.println(matricesIguales(A, resultado));
}

public static void mostrarMatriz(double[][] matriz) {

    for (int i = 0; i < matriz.length; i++) {

        for (int j = 0; j < matriz[i].length; j++) {

            System.out.printf("%10.2f", matriz[i][j]);

        }

        System.out.println();
    }
}

public static double[][] multiplicarMatrices(
        double[][] A, double[][] B) {

    int filas = A.length;
    int columnas = B[0].length;
    int comunes = B.length;

    double[][] resultado =
        new double[filas][columnas];

    for (int i = 0; i < filas; i++) {

        for (int j = 0; j < columnas; j++) {

            for (int k = 0; k < comunes; k++) {

                resultado[i][j] +=
                    A[i][k] * B[k][j];
            }
        }
    }

    return resultado;
}

public static boolean matricesIguales(
        double[][] A, double[][] B) {

    double tolerancia = 0.000001;

    for (int i = 0; i < A.length; i++) {

        for (int j = 0; j < A[i].length; j++) {

            if (Math.abs(A[i][j] - B[i][j])
                    > tolerancia) {

                return false;
            }
        }
    }

    return true;
}
}