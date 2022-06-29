class heapsortNum
{
  private void swap(int[] vetor, int posi1, int posi2)
  {
    int tmp;
    tmp = vetor[posi1];
    vetor[posi1] = vetor[posi2];
    vetor[posi2] = tmp;
  }

  public int[] heapsort(int[] array)
  {
    int n = array.Length;
    // Alterar o vetor ignorando a posicao zero
    int[] tmp = new int[n + 1];
    for (int i = 0; i < n; i++)
    {
      tmp[i + 1] = array[i];
    }
    array = tmp;

    // Contrucao do heap
    int tamHeap = 0;
    for (tamHeap = 2; tamHeap <= n; tamHeap++)
    {
      construir(tamHeap, array);
    }

    // Ordenacao propriamente dita
    tamHeap = n;
    while (tamHeap > 1)
    {
      swap(array, 1, tamHeap--);
      reconstruir(tamHeap, array);
    }

    // Alterar o vetor para voltar a posicao zero
    tmp = array;
    array = new int[n];
    for (int i = 0; i < n; i++)
    {
      array[i] = tmp[i + 1];
    }

    return array;
  }

  public void construir(int tamHeap, int[] array)
  {
    for (int i = tamHeap; i > 1 && array[i] > array[i / 2]; i /= 2)
    {
      swap(array, i, i / 2);
    }
  }

  public void reconstruir(int tamHeap, int[] array)
  {
    int i = 1;
    while (i <= (tamHeap / 2))
    {
      int filho = getMaiorFilho(i, tamHeap, array);
      if (array[i] < array[filho])
      {
        swap(array, i, filho);
        i = filho;
      }
      else
      {
        i = tamHeap;
      }
    }
  }

  public int getMaiorFilho(int i, int tamHeap, int[] array)
  {
    int filho;
    if (2 * i == tamHeap || array[2 * i] > array[2 * i + 1])
    {
      filho = 2 * i;
    }
    else
    {
      filho = 2 * i + 1;
    }
    return filho;
  }
}