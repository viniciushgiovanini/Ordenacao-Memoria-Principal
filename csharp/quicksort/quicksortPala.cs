class quicksortPala
{
  public void swap(String[] vetor, int posi1, int posi2)
  {
    String tmp;
    tmp = vetor[posi1];
    vetor[posi1] = vetor[posi2];
    vetor[posi2] = tmp;
  }

  public void quicksort(int esq, int dir, String[] array, PC p)
  {
    int i = esq, j = dir;
    String pivo = array[(dir + esq) / 2];

    while (i <= j)
    {
      int teste = p.palavrasCRESCENTES(array[i], pivo);
      int teste2 = p.palavrasCRESCENTES(array[j], pivo);
      while (teste == 0)
      {
        i++;
        teste = p.palavrasCRESCENTES(array[i], pivo);
      }
      while (teste2 == 1)
      {
        j--;
        teste2 = p.palavrasCRESCENTES(array[j], pivo);
      }

      if (i <= j)
      {
        swap(array, i, j);
        i++;
        j--;
      }
    }
    if (esq < j)
      quicksort(esq, j, array, p);
    if (i < dir)
      quicksort(i, dir, array, p);
  }
}