import java.util.*;
public class TrabalhoSpotify {
    class Musica {
        private int id;
        private String titulo;
        private String artista;
        private double duracao;

        public Musica(int id,String titulo,String artista,double duracao) {
            this.id = id;
            this.titulo = titulo;
            this.artista = artista;
            this.duracao = duracao;
        }

        public int getId() {
            return id;
        }

        public String getTitulo() {
            return titulo;
        }

        public String getArtista() {
            return artista;
        }

        public double getDuracao() {
            return duracao;
        }

        public String toString() {
            return "Id:" + id + "/" + titulo + "/" + artista + "/" + duracao;
        }
    }
    class No {
        Musica musica;
        No anterior;
        No proximo;

        public No(Musica musica) {
            this.musica = musica;
            this.anterior = null;
            this.proximo = null;
        }
    }

    class Playlist {
        private String nome;
        private No primeiro;
        private No ultimo;

        public Playlist(String nome) {
            this.nome = nome;
            this.primeiro = null;
            this.ultimo = null;
        }

        public String getNome() {
            return nome;
        }

        public No getPrimeiro() {
            return primeiro;
        }

        public void adicionarMusica(Musica musica) {
            No novo = new No(musica);
            if(primeiro==null) {
                primeiro = ultimo = novo;
            }else {
                ultimo.proximo = novo;
                novo.anterior = ultimo;
                ultimo = novo;
            }
        }
        public boolean removerPorId(int id) {
            No atual = primeiro;
            while(atual !=null) {
                if(atual.musica.getId() == id) {
                    if(atual.anterior != null) {
                        atual.anterior.proximo = atual.proximo;
                    }else {
                        primeiro = atual.proximo;
                    }
                    if(atual.proximo != null) {
                        atual.proximo.anterior = atual.anterior;
                    }else {
                        ultimo = atual.anterior;
                    }
                    return true;
                }
                atual = atual.proximo;
            }
            return false;
        }

        public boolean removerPorTitulo(String titulo) {
            No atual = primeiro;
            while(atual != null) {
                if(atual.musica.getTitulo().equalsIgnoreCase(titulo)) {
                    if(atual.anterior != null) {
                        atual.anterior.proximo = atual.proximo;
                    }else {
                        primeiro = atual.proximo;
                    }
                    if(atual.proximo != null) {
                        atual.proximo.anterior = atual.anterior;
                    }else {
                        ultimo = atual.anterior;
                    }
                    return true;
                }
                atual = atual.proximo;
            }
            return false;
        }

        public No buscarNo(int id) {
            No atual = primeiro;
            while(atual != null) {
                if(atual.musica.getId() == id) {
                    return atual;
                }
                atual = atual.proximo;
            }
            return null;
        }

        public void ordenar(String criterio) {
            if(primeiro == null)return;
            List<No> listaNos = new ArrayList<>();
            No atual = primeiro;
            while(atual != null) {
                listaNos.add(atual);
                atual = atual.proximo;
            }
            for(int i=0;i<listaNos.size()-1;i++) {
                for(int j=0;j<listaNos.size()-i-1;j++) {
                    No a = listaNos.get(j);
                    No b = listaNos.get(j+1);

                    int comparacao = 0;
                    switch(criterio) {
                        case "id": comparacao = Integer.compare(a.musica.getId(),b.musica.getId());break;
                        case "titulo": comparacao = a.musica.getTitulo().compareToIgnoreCase(b.musica.getTitulo());break;
                        case "artista": comparacao = a.musica.getArtista().compareToIgnoreCase(b.musica.getArtista());break;
                        case "duracao": comparacao = Double.compare(a.musica.getDuracao(),b.musica.getDuracao());break;
                    }
                    if(comparacao>0) {
                        No temporario = listaNos.get(j);
                        listaNos.set(j,listaNos.get(j+1));
                        listaNos.set(j+1,temporario);
                    }
                }
            }
            primeiro = null;
            ultimo = null;
            for(No no : listaNos) {
                no.anterior = null;
                no.proximo = null;
                if(primeiro == null) {
                    primeiro = ultimo = no;
                }else {
                    ultimo.proximo = no;
                    no.anterior = ultimo;
                    ultimo = no;
                }
            }
        }

        public void mostrar() {
            if(primeiro == null) {
                System.out.println("A playlist está vazia");
                return;
            }
            No atual = primeiro;
            while(atual !=null) {
                System.out.println(atual.musica);
                atual=atual.proximo;
            }
        }
    }

    public class SistemaSpotify {
        private static final Map<Integer,Musica> biblioteca = new HashMap<>();//criei esse mapa para armazenar as musicas disponiveis
        private static final Map<Integer,Playlist> playlist = new HashMap<>();//criei esse mapa para armazenar as playlist disponiveis
        private static String playListAtual = null;
        private static final Scanner input = new Scanner(System.in);
    
        private static void adicionarMusicasABiblioteca() {
            biblioteca.put(1, new Musica(26, "Moça da Chácara", "Ana Castela", 3.26));
            biblioteca.put(2, new Musica(13,"Latitude do Amor", "Jorge & Mateus",3.19));
            biblioteca.put(3, new Musica(7,"Chuva de Vaquejada","Vitor Fernandes",3.04));
            biblioteca.put(4, new Musica(4,"Cowboy Fora da Lei 2.0","Gusttavo Lima",3.33));
            biblioteca.put(5, new Musica(2,"Caminhonete Branca","Zé Neto & Cristiano",3.21));
            System.out.println("Foi adicionada essas musicas" + biblioteca.size() +"a biblioteca");
        }
        private static void mostrarMenu() {
            System.out.println("Sistema Spotify");
            System.out.println("1-Cadastrar nova playlist");
            System.out.println("2-Adicionar musica a uma playlist");
            System.out.println("3-Remover musica da playlist");
            System.out.println("4-Ordenar playlist");
            System.out.println("5-Reproduzir na ordem (anterior/proxima)");
            System.out.println("6-Mostrar playlist atual");
            System.out.println("7-Mudar entre as playlists");
            System.out.println("0-Sair do sistema");
            System.out.println("Escolha uma opcao de 1 a 7 se quiser fazer algo no sistema ou escolha a opcao 0 para sair");
        }
        private static void adicionarNovaPlaylist() {
            System.out.print("Digite o nome para a playlist");
            String nome = input.nextLine().trim();
            if(playlist.containsKey(nome)) {
                System.out.println("Playlist com esse nome ja existe");
                return;
            }
            Playlist novaPlaylist = new Playlist(nome);
            playlists.put(nome, novaPlaylist);
            playlistAtual = nome;
            System.out.println("Essa playlist" + nome + "foi adicionada");
            System.out.println("Adicionar musicas,digite 0 para sair");
            adicionarMusicasIniciais(novaPlaylist);
        }        
    }    
}
