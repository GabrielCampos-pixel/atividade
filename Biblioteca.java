import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    private No cabeca;
    private boolean ordenadoPorTitulo;

    public Biblioteca() {
        this.cabeca = null;
        this.ordenadoPorTitulo = true;
    }

    public void alterarCriterioOrdenacao(boolean porTitulo) {
        if (this.ordenadoPorTitulo == porTitulo) {
            return;
        }
        this.ordenadoPorTitulo = porTitulo;
        ordenarLista();
        System.out.println("✅ Critério de ordenação alterado para: " +
                (porTitulo ? "TÍTULO" : "AUTOR"));
    }

    private void ordenarLista() {
        if (cabeca == null || cabeca.proximo == null) {
            return;
        }

        List<Livro> livros = new ArrayList<>();
        No atual = cabeca;
        while (atual != null) {
            livros.add(atual.livro);
            atual = atual.proximo;
        }

        livros.sort((l1, l2) -> {
            if (ordenadoPorTitulo) {
                return l1.getTitulo().compareTo(l2.getTitulo());
            } else {
                return l1.getAutor().compareTo(l2.getAutor());
            }
        });

        cabeca = null;
        No ultimo = null;
        for (Livro livro : livros) {
            No novoNo = new No(livro);
            if (cabeca == null) {
                cabeca = novoNo;
            } else {
                ultimo.proximo = novoNo;
            }
            ultimo = novoNo;
        }
    }

    public void adicionarLivro(Livro novoLivro) {
        No novoNo = new No(novoLivro);

        if (cabeca == null || compare(novoLivro, cabeca.livro) <= 0) {
            novoNo.proximo = cabeca;
            cabeca = novoNo;
            return;
        }

        No atual = cabeca;
        while (atual.proximo != null && compare(novoLivro, atual.proximo.livro) > 0) {
            atual = atual.proximo;
        }

        novoNo.proximo = atual.proximo;
        atual.proximo = novoNo;
    }

    private int compare(Livro l1, Livro l2) {
        if (ordenadoPorTitulo) {
            return l1.getTitulo().compareTo(l2.getTitulo());
        } else {
            return l1.getAutor().compareTo(l2.getAutor());
        }
    }

    public boolean removerLivro(String isbn) {
        if (cabeca == null) return false;

        if (cabeca.livro.getIsbn().equals(isbn)) {
            cabeca = cabeca.proximo;
            return true;
        }

        No atual = cabeca;
        while (atual.proximo != null) {
            if (atual.proximo.livro.getIsbn().equals(isbn)) {
                atual.proximo = atual.proximo.proximo;
                return true;
            }
            atual = atual.proximo;
        }
        return false;
    }

    public boolean emprestarLivro(String isbn) {
        No atual = cabeca;
        while (atual != null) {
            if (atual.livro.getIsbn().equals(isbn)) {
                if (atual.livro.isDisponivel()) {
                    atual.livro.setDisponivel(false);
                    return true;
                }
                return false;
            }
            atual = atual.proximo;
        }
        return false;
    }

    public boolean devolverLivro(String isbn) {
        No atual = cabeca;
        while (atual != null) {
            if (atual.livro.getIsbn().equals(isbn)) {
                if (!atual.livro.isDisponivel()) {
                    atual.livro.setDisponivel(true);
                    return true;
                }
                return false;
            }
            atual = atual.proximo;
        }
        return false;
    }

    public boolean buscarPorTitulo(String titulo) {
        No atual = cabeca;
        while (atual != null) {
            int cmp = atual.livro.getTitulo().compareTo(titulo);
            if (cmp == 0) {
                return true;
            }
            if (ordenadoPorTitulo && cmp > 0) {
                break;
            }
            atual = atual.proximo;
        }
        return false;
    }

    public void buscarPorAutor(String autor) {
        No atual = cabeca;
        boolean encontrou = false;
        boolean ordenadoPorAutor = !ordenadoPorTitulo;

        while (atual != null) {
            int cmp = atual.livro.getAutor().compareTo(autor);
            if (cmp == 0) {
                System.out.println("→ Título: " + atual.livro.getTitulo() +
                        " | ISBN: " + atual.livro.getIsbn() +
                        " | Disponível: " + (atual.livro.isDisponivel() ? "Sim" : "Não"));
                encontrou = true;
            } else if (ordenadoPorAutor && cmp > 0) {
                break;
            }
            atual = atual.proximo;
        }

        if (!encontrou) {
            System.out.println("Nenhum livro encontrado para o autor: " + autor);
        }
    }

    public void imprimirTodosLivros() {
        No atual = cabeca;
        if (atual == null) {
            System.out.println("Biblioteca vazia.");
            return;
        }
        System.out.println("Lista de livros (" + (ordenadoPorTitulo ? "ordenado por Título" : "ordenado por Autor") + "):");
        while (atual != null) {
            System.out.println(atual.livro);
            atual = atual.proximo;
        }
    }
}