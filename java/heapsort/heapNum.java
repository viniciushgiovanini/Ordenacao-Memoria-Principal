package heapsort;

class heapNum {

  // FUNCOES DE APOIO EM CIMA
  private static void swap(int[] vetor, int posi1, int posi2) {

    int tmp;

    tmp = vetor[posi1];
    vetor[posi1] = vetor[posi2];
    vetor[posi2] = tmp;

  }

  // FUNCOES DO HEAP

  public static int[] heapsort(int[] array) {
    int n = array.length;
    // Alterar o vetor ignorando a posicao zero
    int[] tmp = new int[n + 1];
    for (int i = 0; i < n; i++) {
      tmp[i + 1] = array[i];
    }
    array = tmp;

    // Contrucao do heap
    for (int tamHeap = 2; tamHeap <= n; tamHeap++) {
      construir(tamHeap, array);
    }

    // Ordenacao propriamente dita
    int tamHeap = n;
    while (tamHeap > 1) {
      swap(array, 1, tamHeap--);
      reconstruir(tamHeap, array);
    }

    // Alterar o vetor para voltar a posicao zero
    tmp = array;
    array = new int[n];
    for (int i = 0; i < n; i++) {
      array[i] = tmp[i + 1];
    }

    return array;
  }

  public static void construir(int tamHeap, int[] array) {
    for (int i = tamHeap; i > 1 && array[i] > array[i / 2]; i /= 2) {
      swap(array, i, i / 2);
    }
  }

  public static void reconstruir(int tamHeap, int[] array) {
    int i = 1;
    while (i <= (tamHeap / 2)) {
      int filho = getMaiorFilho(i, tamHeap, array);
      if (array[i] < array[filho]) {
        swap(array, i, filho);
        i = filho;
      } else {
        i = tamHeap;
      }
    }
  }

  public static int getMaiorFilho(int i, int tamHeap, int[] array) {
    int filho;
    if (2 * i == tamHeap || array[2 * i] > array[2 * i + 1]) {
      filho = 2 * i;
    } else {
      filho = 2 * i + 1;
    }
    return filho;
  }

  public static void main(String[] args) {
    int[] vetor = new int[] { 101, 115, 30, 63, 47, 20 };
    int vetor2[] = { 101, 500, 200, 300, 5, 10, 4, 2, 1, 0 };
    vetor = heapsort(vetor);
    vetor2 = heapsort(vetor2);
    for (int i = 0; i < vetor.length; i++) {

      System.out.println(vetor[i]);

    }

    for (int i = 0; i < vetor2.length; i++) {
      System.out.println(vetor2[i]);
    }
  }

}