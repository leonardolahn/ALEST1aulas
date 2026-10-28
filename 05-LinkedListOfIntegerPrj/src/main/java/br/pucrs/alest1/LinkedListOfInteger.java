package br.pucrs.alest1;

public class LinkedListOfInteger {

    // Classe interna Node
    private class Node {
        public Integer element; // guarda o valor armazenado no nodo
        public Node next; // referência para o próximo nodo da lista (ou null se for o último)

        public Node(Integer element) {
            this.element = element; // define o valor do nodo
            next = null; // inicialmente não aponta pra nenhum outro nodo
        }

        public Node(Integer element, Node next) {
            this.element = element; // define o valor do nodo
            this.next = next; // já conecta com o próximo nodo passado por parâmetro
        }
    }

    // Referência para o primeiro elemento da lista encadeada.
    private Node head;
    // Referência para o último elemento da lista encadeada.
    private Node tail;
    // Contador para a quantidade de elementos que a lista contem.
    private int count;

    /**
     * Construtor da lista.
     */
    public LinkedListOfInteger() {
        head = null; // lista começa vazia, não há primeiro nodo ainda
        tail = null; // nem último nodo
        count = 0; // nenhum elemento armazenado
    }

    /**
     * Esvazia a lista
     */
    public void clear() {
        head = null; // remove a referência ao primeiro nodo (o garbage collector cuida do resto)
        tail = null; // remove a referência ao último nodo
        count = 0; // zera a contagem de elementos
    }

    /**
     * Adiciona um elemento ao final da lista.
     *
     * @param element elemento a ser adicionado ao final da lista
     */
    public void add(Integer element) { // O(1)
        Node n = new Node(element); // cria o novo nodo que vai guardar o elemento
        if (head == null) { // se a lista está vazia
            head = n; // o novo nodo passa a ser também o primeiro da lista
        } else {
            tail.next = n; // encadeia o novo nodo depois do último nodo existente
        }
        tail = n; // atualiza a referência de último nodo para o novo nodo inserido
        count++; // aumenta a quantidade de elementos
    }

    @Override
    public String toString() { // O(n)
        StringBuilder s = new StringBuilder(); // monta a string de forma eficiente

        Node aux = head; // ponteiro auxiliar começa no primeiro nodo, para não perder a referência de head

        while (aux != null) { // percorre a lista enquanto houver nodo
            s.append(aux.element.toString()); // adiciona o valor do nodo atual na string
            s.append("\n"); // quebra de linha entre os elementos
            aux = aux.next; // avança para o próximo nodo da lista
        }

        return s.toString(); // converte o StringBuilder em String de fato
    }

    ///////////////////////////////////////////////////
    //// A REFAZER
    ///////////////////////////////////////////////////

    public boolean isEmpty() // O(1)
    {
        // se o head for nulo, retorna true
        return head == null;
    }

    // 2 - size()
    public int size() // O(1)
    {
        // retorna a quantidade de elementos
        return count;
    }

    // 3 - get(int index)
    public int get(int index) // O(n)
    {
        // exceção: se o índice for menor que zero ou maior que a quantidade, é acionada
        if (index < 0 || index >= count)
        {
            throw new IndexOutOfBoundsException("Index = " + index);
        }
        // cria um nodo auxiliar começando no head
        Node aux = head;
        // percorre a lista, até uma posição antes do index
        for (int i = 0; i < index; i++)
        {
            // o aux vira o aux.next, ou seja, anda uma posição
            aux = aux.next;
        }
        // retorna o elemento que está naquele nodo
        return aux.element;
    }

    // 4 - set(int index, Integer element)
    public int set(int index, Integer element) // O(n)
    {
        // exceção: se o índice for menor que zero ou maior que a quantidade, é acionada
        if (index < 0 || index >= count)
        {
            throw new IndexOutOfBoundsException("Index = " + index);
        }
        // cria um nodo auxiliar começando no head
        Node aux = head;
        // percorre a lista, até uma posição antes do index
        for (int i = 0; i < index; i++)
        {
            // o aux vira o aux.next, ou seja, anda uma posição
            aux = aux.next;
        }
        // guarda o valor antigo (elemento em que o for parou) antes de sobrescrever
        int antigo = aux.element;

        // coloca o novo valor no nodo
        aux.element = element;

        // devolve o valor antigo guardado anteriormente
        return antigo;
    }

    // 5 - add(int index, Integer element)
    // 6 - removeByIndex(int index)
    // 7 - contains(Integer element)
    // 8 - indexOf(Integer element)
    // 9 - remove(Integer element)
}
