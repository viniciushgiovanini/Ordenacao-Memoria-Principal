class mergePala
{
  private void swap(String[] vetor, int posi1, int posi2)
  {

    String tmp;

    tmp = vetor[posi1];
    vetor[posi1] = vetor[posi2];
    vetor[posi2] = tmp;

  }

  public void mergesort(int esq, int dir, String[] array, PC p)
  {
    if (esq < dir)
    {
      int meio = (esq + dir) / 2;
      mergesort(esq, meio, array, p);
      mergesort(meio + 1, dir, array, p);
      intercalar(esq, meio, dir, array, p);
    }
  }

  /**
   * Algoritmo que intercala os elementos entre as posicoes esq e dir
   * 
   * @param int esq inicio do array a ser ordenado
   * @param int meio posicao do meio do array a ser ordenado
   * @param int dir fim do array a ser ordenado
   */
  private void intercalar(int esq, int meio, int dir, String[] array, PC p)
  {
    int n1, n2, i, j, k;

    // Definir tamanho dos dois subarrays
    n1 = meio - esq + 1;
    n2 = dir - meio;

    String[] a1 = new String[n1 + 1];
    String[] a2 = new String[n2 + 1];

    // Inicializar primeiro subarray
    for (i = 0; i < n1; i++)
    {
      a1[i] = array[esq + i];
    }

    // Inicializar segundo subarray
    for (j = 0; j < n2; j++)
    {
      a2[j] = array[meio + j + 1];
    }

    // Sentinela no final dos dois arrays
    a1[i] = a2[j] = "Ó";// TEM QUE SER A ULTIMA PALAVRA DA TABELA ASCII
    // Intercalacao propriamente dita
    for (i = j = 0, k = esq; k <= dir; k++)
    {

      array[k] = ((p.palavrasCRESCENTES(a1[i], a2[j]) == 0 || (p.palavrasCRESCENTES(a1[i], a2[j]) == 2)) ? a1[i++]
          : a2[j++]);
    }

  }
}