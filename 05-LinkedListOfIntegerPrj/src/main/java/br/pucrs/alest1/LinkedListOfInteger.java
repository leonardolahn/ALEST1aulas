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
    public void add(Integer element) {
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

        Node aux = head; // ponteiro auxiliar que começa no primeiro nodo, para não perder a referência de head

        while (aux != null) { // percorre a lista enquanto houver nodo
            s.append(aux.element.toString()); // adiciona o valor do nodo atual na string
            s.append("\n"); // quebra de linha entre os elementos
            aux = aux.next; // avança para o próximo nodo da lista
        }

        return s.toString(); // converte o StringBuilder em String de fato
    }

    public boolean isEmpty()
    {
        return (head == null); // se o head estiver vazio
    }

    public int size()
    {
        return count; // para saber o tamanho retorna a contagem
    }

    public int get(int index)
    {
        if ((index < 0) || (index >= count)) // verifica se a posição existe na lista
        {
            throw new IndexOutOfBoundsException("Index = " + index); // se for inválida, aciona a exceção
        }
        Node aux = head; // ponteiro auxiliar começa no primeiro nodo
        for (int i = 0; i < index; i++) // avança index vezes para chegar no nodo desejado
        {
            aux = aux.next; // move o ponteiro pro próximo nodo
        }
        return aux.element; // retorna o elemento do nodo em que o ponteiro parou
    }

    public void addFront(int element)
    {
        // cria um novo nodo que guarda o valor recebido
        Node aux = new Node(element);

        // se a lista está vazia
        if (head == null)
        {
            // o novo nodo é o primeiro e o último da lista, por ser o único
            head = aux;
            tail = aux;
        }
        else // caso contrário
        {
            // liga o novo nodo ao antigo primeiro nodo
            aux.next = head;
            // o novo nodo passa a ser o primeiro da lista
            head = aux;
        }
        // a lista ganhou um nodo, então o contador aumenta
        count++;
    }
}
