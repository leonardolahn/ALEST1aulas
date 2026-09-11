package br.pucrs.alest1;

public class ListArrayOfInteger {

    private static final int INITIAL_SIZE = 10; // tamanho padrão do array quando não é definido
    private Integer[] data;
    private int count;

    public ListArrayOfInteger() {
        this(INITIAL_SIZE);
    }

    public ListArrayOfInteger(int tam) {
        if (tam <= 0) { // se o tamanho pedido é inválido
            tam = INITIAL_SIZE; // usa o tamanho padrão
        }
        data = new Integer[tam]; // cria o array com o tamanho
        count = 0; // começa vazio
    }

    public void clear() { // O(1)
        data = new Integer[INITIAL_SIZE]; // cria um array com o tamanho padrão
        count = 0; // com a quantidade de elementos = 0
    }

    public boolean isEmpty() { // O(1)
        return (count == 0); // se estiver vazio, true
    }

    public int size() { // O(1)
        return count; // retorna a quantidade de elemento presentes no array
    }

    public void add(Integer element) { // O(n)
        if (count == data.length) { // se a quantidade for igual ao tamanho do array
            setCapacity(data.length * 2); // dobra a capacidade do array definindo a capacidade
        }
        data[count] = element; // adiciona o novo elemento na primeira posição livre do array
        count++; // aumenta a quantidade após a adição
    }

    public void add(int index, Integer element) {

        if ((index < 0) || (index > count)) { // se o índice não tá dentro dos limites da lista (0 a count)
            throw new IndexOutOfBoundsException("Index = " + index); // posição inválida e avisa o chamador
        }

        if (count == data.length) { // se a quantidade for igual ao tamanho do array
            setCapacity(data.length * 2); // dobra a capacidade do array definindo a capacidade
        }

        for (int i = count; i > index; i--) // aponta para a primeira posição livre da lista, vai até a posição desejada
        {
            data[i] = data[i - 1]; // copia o valor da casa anterior pra atual, empurrando tudo pra direita
        }
        data[index] = element; // armazena o elemento na posição desejada
        count++; // aumenta a quantidade após a adição
    }

    public int get(int index) { // O(1)
        if ((index < 0) || (index >= count)) { // se a posição não existe
            throw new IndexOutOfBoundsException("Index = " + index); // posição inválida e avisa o chamador
        }
        return data[index]; // retorna o que estiver armazenado naquela posição
    }

    public int set(int index, int element) {
        if ((index < 0) || (index >= count)) { // se a posição não existe
            throw new IndexOutOfBoundsException("Index = " + index); // posição inválida e avisa o chamador
        }

        int aux = data[index]; // aux guarda o valor antigo antes de sobrescrever
        data[index] = element; // sobrescreve com o valor novo
        return aux; // retorna o valor antigo
    }

    public int removeByIndex(int index) { // O(n)
        if ((index < 0) || (index >= count)) { // verifica se a posição existe de verdade na lista
            throw new IndexOutOfBoundsException("Index = " + index); // posição inválida, avisa o chamador
        }
        int aux = data[index]; // guarda o valor que será removido, para retornar depois
        for (int i = index; i < count - 1; i++) { // percorre da posição removida até o penúltimo elemento
            data[i] = data[i + 1]; // puxa o elemento seguinte para a posição atual, fechando o buraco
        }
        count--; // diminui a quantidade, já que um elemento foi removido
        return aux; // retorna o valor antigo que foi removido
    }

    public boolean remove(int element)
    {
        int index = indexOf(element); // procura a posição do elemento (-1 se não achar) com a reutilização do indexOf
        if (index != -1) // se o index for diferente de -1 (se encontrou)
        {
            removeByIndex(index); // reutiliza o removeByIndex, removendo usando o índice encontrado
            return true; // e retorna true
        }
        return false; // se não estava na lista, retorna false
    }

    public boolean contains(Integer element) { // O(n)
        for (int i = 0; i < count; i++) { // percorre apenas as posições ocupadas da lista
            if (data[i].equals(element)) { // se o que estiver em determinada posição for igual ao elemento
                return true; // achou o elemento, retorna true
            }
        }
        return false; // senão retorna false
    }

    public int indexOf(Integer element)
    {
        for (int i = 0; i < count; i++) { // percorre apenas as posições ocupadas da lista
            if (data[i].equals(element)) { // se o que estiver em determinada posição for igual ao elemento
                return i; // retorna a posição do elemento
            }
        }
        return -1; // senão encontra o elemento, retorna -1
    }

    @Override
    public String toString() { // O(n)
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < count; i++) {
            s.append(data[i]);
            if (i != (count - 1)) {
                s.append(",");
            }
        }
        s.append("\n");
        return s.toString();
    }

    private void setCapacity(int newCapacity) {
        if (newCapacity != data.length) {
            int min = 0;
            Integer[] newData = new Integer[newCapacity];
            if (data.length < newCapacity) {
                min = data.length;
            } else {
                min = newCapacity;
            }
            for (int i = 0; i < min; i++) {
                newData[i] = data[i];
            }
            data = newData;
        }
    }
}
