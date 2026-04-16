public class Main {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();

        biblioteca.adicionarLivro(new Livro("O Senhor dos Anéis", "J.R.R. Tolkien", "978-0261103573"));
        biblioteca.adicionarLivro(new Livro("1984", "George Orwell", "978-0451524935"));
        biblioteca.adicionarLivro(new Livro("Dom Casmurro", "Machado de Assis", "978-8525406941"));
        biblioteca.adicionarLivro(new Livro("A Revolução dos Bichos", "George Orwell", "978-0451526342"));

        System.out.println("=== Livros (ordenado por TÍTULO) ===");
        biblioteca.imprimirTodosLivros();

        System.out.println("\nBusca por título '1984': " + 
                (biblioteca.buscarPorTitulo("1984") ? "Encontrado" : "Não encontrado"));

        System.out.println("\nLivros de George Orwell:");
        biblioteca.buscarPorAutor("George Orwell");

        biblioteca.alterarCriterioOrdenacao(false);
        System.out.println("\n=== Agora ordenado por AUTOR ===");
        biblioteca.imprimirTodosLivros();
    }
}