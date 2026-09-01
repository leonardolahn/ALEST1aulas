/**
 * Classe que implementa uma lista linear usando arranjo.
 * @author Isabel H. Manssour
 */

public class ListArrayOfInteger {

    // Atributos
    private static final int INITIAL_SIZE = 10;
    private Integer[] data;
    private int count;

    /**
     * Construtor da lista.
     */
    public ListArrayOfInteger() {
        this(INITIAL_SIZE);
    }

    /**
     * Construtor da lista.
     * @param tam tamanho inicial a ser alocado para data[]
     */
    public ListArrayOfInteger(int tam) {
        if (tam <= 0) {
            tam = INITIAL_SIZE;
        }
        data = new Integer[tam];
        count = 0;
    }

    /**
     * Esvazia a lista.
     */
    public void clear() { // O(1)
        data = new Integer[INITIAL_SIZE];
        count = 0;
    }

    /**
     * Retorna true se a lista nao contem elementos.
     * @return true se a lista nao contem elementos
     */
    public boolean isEmpty() { // O(1)
        return (count == 0);
    }

    /**
     * Retorna o numero de elementos armazenados na lista.
     * @return o numero de elementos da lista
     */
    public int size() { // O(1)
        return count;
    }

    /**
     * Adiciona um elemento ao final da lista.
     * @param element elemento a ser adicionado ao final da lista
     */
    public void add(Integer element) { // O(n) - amortizado, por causa do possivel resize
        if (count == data.length) {
            setCapacity(data.length * 2);
        }
        data[count] = element;
        count++;
    }

    /**
     * Insere um elemento em uma posicao especifica da lista, deslocando
     * os elementos seguintes uma posicao para a direita.
     * @param index posicao onde o elemento deve ser inserido
     * @param element elemento a ser inserido
     * @throws IndexOutOfBoundsException se (index < 0 || index > size())
     */
    public void add(int index, Integer element) { // O(n)
        if ((index < 0) || (index > count)) {
            throw new IndexOutOfBoundsException("Index = " + index);
        }
        if (count == data.length) {
            setCapacity(data.length * 2);
        }
        // desloca os elementos para a direita, de tras para frente,
        // para nao sobrescrever valores antes de move-los
        for (int i = count; i > index; i--) {
            data[i] = data[i - 1];
        }
        data[index] = element;
        count++;
    }

    /**
     * Retorna o elemento de uma determinada posicao da lista.
     * @param index a posicao da lista
     * @return o elemento da posicao especificada
     * @throws IndexOutOfBoundsException se (index < 0 || index >= size())
     */
    public int get(int index) { // O(1)
        if ((index < 0) || (index >= count)) {
            throw new IndexOutOfBoundsException("Index = " + index);
        }
        return data[index];
    }

    /**
     * Substitui o elemento de uma determinada posicao da lista por um novo
     * elemento, retornando o valor anterior.
     * @param index a posicao da lista a ser alterada
     * @param element o novo elemento
     * @return o elemento que estava anteriormente na posicao
     * @throws IndexOutOfBoundsException se (index < 0 || index >= size())
     */
    public int set(int index, Integer element) { // O(1)
        if ((index < 0) || (index >= count)) {
            throw new IndexOutOfBoundsException("Index = " + index);
        }
        int oldValue = data[index];
        data[index] = element;
        return oldValue;
    }

    /**
     * Remove a primeira ocorrencia do elemento especificado na lista,
     * deslocando os elementos seguintes uma posicao para a esquerda.
     * @param element elemento a ser removido
     * @return true se o elemento foi encontrado e removido, false caso contrario
     */
    public boolean remove(Integer element) { // O(n)
        int index = indexOf(element);
        if (index == -1) {
            return false;
        }
        // desloca os elementos para a esquerda, "fechando o buraco"
        for (int i = index; i < count - 1; i++) {
            data[i] = data[i + 1];
        }
        data[count - 1] = null; // evita referencia "fantasma"
        count--;
        return true;
    }

    /**
     * Retorna true se a lista contem o elemento especificado.
     * @param element elemento a ser procurado
     * @return true se o elemento estiver na lista
     */
    public boolean contains(Integer element) { // O(n)
        return indexOf(element) != -1;
    }

    /**
     * Retorna a posicao da primeira ocorrencia do elemento especificado
     * na lista, ou -1 se o elemento nao estiver presente.
     * @param element elemento a ser procurado
     * @return a posicao do elemento, ou -1 se nao encontrado
     */
    public int indexOf(Integer element) { // O(n)
        for (int i = 0; i < count; i++) {
            if (data[i].equals(element)) {
                return i;
            }
        }
        return -1;
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
