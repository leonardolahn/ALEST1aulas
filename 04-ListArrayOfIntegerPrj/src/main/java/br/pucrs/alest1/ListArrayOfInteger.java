package br.pucrs.alest1;

public class ListArrayOfInteger
{
    // capacidade padrão quando nenhum tamanho válido é informado
    private static final int INITIAL_SIZE = 10;
    // arranjo que guarda os elementos da lista
    private Integer[] data;
    // quantidade de elementos realmente armazenados (não é o tamanho do arranjo)
    private int count;

    public ListArrayOfInteger()
    {
        // chama o outro construtor usando a capacidade padrão
        this(INITIAL_SIZE);
    }

    public ListArrayOfInteger(int tam)
    {
        // tamanho inválido
        if (tam <= 0)
        {
            // usa a capacidade padrão no lugar
            tam = INITIAL_SIZE;
        }
        // cria o arranjo com a capacidade definida
        data = new Integer[tam];
        // lista começa vazia
        count = 0;
    }

    public void clear() // O(1)
    {
        // descarta o arranjo antigo e cria um novo, vazio
        data = new Integer[INITIAL_SIZE];
        // zera a contagem de elementos
        count = 0;
    }

    public boolean isEmpty() // O(1)
    {
        // vazia quando não há nenhum elemento armazenado
        return (count == 0);
    }

    public int size() // O(1)
    {
        // número de elementos armazenados
        return count;
    }

    /**
     * Retorna o elemento de uma determinada posicao da lista.
     * @param index a posicao da lista
     * @return o elemento da posicao especificada
     * @throws IndexOutOfBoundsException se (index < 0 || index >= size())
     */

    @Override
    public String toString() // O(n)
    {
        // evita criar várias Strings ao concatenar
        StringBuilder s = new StringBuilder();
        // percorre só até count, não até data.length
        for (int i = 0; i < count; i++)
        {
            // adiciona o elemento atual
            s.append(data[i]);
            // se não for o último elemento
            if (i != (count - 1))
            {
                // coloca o separador
                s.append(",");
            }
        }
        // quebra de linha no final
        s.append("\n");
        // converte o StringBuilder em String
        return s.toString();
    }

    private void setCapacity(int newCapacity) // O(n), pois copia os elementos
    {
        // só faz algo se a capacidade realmente mudar
        if (newCapacity != data.length)
        {
            // quantos elementos serão copiados
            int min = 0;
            // novo arranjo com a nova capacidade
            Integer[] newData = new Integer[newCapacity];
            // se o novo arranjo é maior
            if (data.length < newCapacity)
            {
                // copia todo o arranjo antigo
                min = data.length;
            }
            // se o novo arranjo é menor
            else
            {
                // copia só o que cabe
                min = newCapacity;
            }
            // copia posição por posição
            for (int i = 0; i < min; i++)
            {
                newData[i] = data[i];
            }
            // passa a usar o novo arranjo
            data = newData;
        }
    }

    public int get(int index) // O(1)
    {
        // se o índice for menor que zero ou maior ou igual ao count (índice fora do intervalo dos elementos válidos)
        if ((index < 0) || (index >= count))
        {
            // sinaliza o erro
            throw new IndexOutOfBoundsException("Index = " + index);
        }
        // acesso direto pela posição
        return data[index];
    }

    public void add(Integer element) // O(1) amortizado, O(n) quando precisa redimensionar
    {
        // arranjo cheio
        if (count == data.length)
        {
            // estratégia "dobro": dobra a capacidade
            setCapacity(data.length * 2);
        }
        // coloca o novo elemento na primeira posição livre
        data[count] = element;
        // atualiza a contagem após inserir
        count++;
    }

    public void add(int index, Integer element)
    {

    }
}
