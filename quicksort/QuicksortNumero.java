package quicksort;

public class QuicksortNumero {

  private static void swap(int[] vetor, int posi1, int posi2) {

    int tmp;

    tmp = vetor[posi1];
    vetor[posi1] = vetor[posi2];
    vetor[posi2] = tmp;

  }

  private static void quicksort(int esq, int dir, int[] array) {
    int i = esq, j = dir;
    int pivo = array[(dir + esq) / 2];
    while (i <= j) {
      while (array[i] < pivo)
        i++;
      while (array[j] > pivo)
        j--;
      if (i <= j) {
        swap(array, i, j);
        i++;
        j--;
      }
    }
    if (esq < j)
      quicksort(esq, j, array);

    if (i < dir)
      quicksort(i, dir, array);

  }

  public static void main(String[] args) {

    int vetor[] = { 100, 200, 300, 40, 30, 25, 1, 45, 0, 8, 5, 2, 6, 1, 0 };

    quicksort(0, vetor.length - 1, vetor);

    for (int i = 0; i < vetor.length; i++) {

      System.out.println(vetor[i]);

    }

  }

}
