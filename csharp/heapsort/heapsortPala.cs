class heapsortPala
{
  public void swap(String[] vetor, int posi1, int posi2)
  {

    String tmp;

    tmp = vetor[posi1];
    vetor[posi1] = vetor[posi2];
    vetor[posi2] = tmp;

  }
  public String[] heapsort(String[] array, PC p)
  {
    int n = array.Length;
    // Alterar o vetor ignorando a posicao zero
    String[] tmp = new String[n + 1];
    for (int i = 0; i < n; i++)
    {
      tmp[i + 1] = array[i];
    }
    array = tmp;

    // Contrucao do heap
    int tamHeap = 0;
    for (tamHeap = 2; tamHeap <= n; tamHeap++)
    {
      construir(tamHeap, array, p);
    }

    // Ordenacao propriamente dita
    tamHeap = n;
    while (tamHeap > 1)
    {
      swap(array, 1, tamHeap--);
      reconstruir(tamHeap, array, p);
    }

    // Alterar o vetor para voltar a posicao zero
    tmp = array;
    array = new String[n];
    for (int i = 0; i < n; i++)
    {
      array[i] = tmp[i + 1];
    }

    return array;
  }

  public void construir(int tamHeap, String[] array, PC p)
  {
    for (int i = tamHeap; i > 1 && (p.palavrasCRESCENTES(array[i], array[i / 2]) == 1); i /= 2)
    {
      swap(array, i, i / 2);
    }
  }

  public void reconstruir(int tamHeap, String[] array, PC p)
  {
    int i = 1;
    while (i <= (tamHeap / 2))
    {
      int filho = getMaiorFilho(i, tamHeap, array, p);
      if ((p.palavrasCRESCENTES(array[i], array[filho]) == 0))
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

  public static int getMaiorFilho(int i, int tamHeap, String[] array, PC p)
  {
    int filho;
    if (2 * i == tamHeap || (p.palavrasCRESCENTES(array[2 * i], array[2 * i + 1]) == 1))
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