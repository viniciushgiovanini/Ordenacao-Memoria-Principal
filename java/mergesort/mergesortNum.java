package mergesort;

class mergesortNum {

  private static void mergesort(int esq, int dir, int[] array) {
    if (esq < dir) {
      int meio = (esq + dir) / 2;
      mergesort(esq, meio, array);
      mergesort(meio + 1, dir, array);
      intercalar(esq, meio, dir, array);
    }
  }

  /**
   * Algoritmo que intercala os elementos entre as posicoes esq e dir
   * 
   * @param int esq inicio do array a ser ordenado
   * @param int meio posicao do meio do array a ser ordenado
   * @param int dir fim do array a ser ordenado
   */
  public static void intercalar(int esq, int meio, int dir, int[] array) {
    int n1, n2, i, j, k;

    // Definir tamanho dos dois subarrays
    n1 = meio - esq + 1;
    n2 = dir - meio;

    int[] a1 = new int[n1 + 1];
    int[] a2 = new int[n2 + 1];

    // Inicializar primeiro subarray
    for (i = 0; i < n1; i++) {
      a1[i] = array[esq + i];
    }

    // Inicializar segundo subarray
    for (j = 0; j < n2; j++) {
      a2[j] = array[meio + j + 1];
    }

    // Sentinela no final dos dois arrays
    a1[i] = a2[j] = 0x7FFFFFFF;// numero muito alto.

    // Intercalacao propriamente dita
    for (i = j = 0, k = esq; k <= dir; k++) {
      array[k] = (a1[i] <= a2[j]) ? a1[i++] : a2[j++];
    }

  }

  public static void main(String[] args) {
    int vetor2[] = { 101, 500, 200, 300, 5, 10, 4, 2, 1, 0 };
    int vetorpadrao[] = { 95, 15, 42, 4 };

    mergesort(0, vetorpadrao.length - 1, vetorpadrao);

    for (int i = 0; i < vetor2.length; i++) {
      System.out.println(vetor2[i]);
    }

  }
}
