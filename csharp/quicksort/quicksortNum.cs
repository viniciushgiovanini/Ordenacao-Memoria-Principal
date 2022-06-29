class quicksortNum
{

  public void swap(int[] vetor, int posi1, int posi2)
  {
    int tmp;
    tmp = vetor[posi1];
    vetor[posi1] = vetor[posi2];
    vetor[posi2] = tmp;
  }

  public void quicksort(int esq, int dir, int[] array)
  {
    int i = esq, j = dir;
    int pivo = array[(dir + esq) / 2];
    while (i <= j)
    {
      while (array[i] < pivo)
        i++;
      while (array[j] > pivo)
        j--;
      if (i <= j)
      {
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

}