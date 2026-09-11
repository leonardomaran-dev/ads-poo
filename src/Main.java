public class Main {
    public static void main(String[] args) {

        // ===== CRIAR MORADOR =====
        Morador m1 = new Morador("joao.png", "Joao", "99999-1111",
                "123.456.789-00", "joao@x.com", "senha1");
        m1.create();

        Morador m2 = new Morador("maria.png", "Maria", "98888-2222",
                "987.654.321-00", "maria@x.com", "senha2");
        m2.create();

        // EXIBIR MORADORES (SIMULANDO BANCO DE DADOS)
        System.out.println("************************** MORADORES **************************");
        listar();

        // BUSCAR MORADOR COM ID 1
        Morador morador = Morador.getById(1);
        System.out.println("************************ BUSCAR MORADOR ************************");
        System.out.println(morador);
        System.out.println();

        // ATUALIZAR MORADOR
        Morador moradorAlvo = Morador.getById(1);
        if (moradorAlvo != null) {
            moradorAlvo.setTelefone("97777-3333");
            moradorAlvo.update(1);
        }
        System.out.println("********************** MORADOR ATUALIZADO **********************");
        listar();

        // EXCLUIR MORADOR
        Morador moradorRemover = Morador.getById(2);
        if (moradorRemover != null) {
            moradorRemover.delete(2);
        }
        System.out.println("********************** MORADOR EXCLUIDO **********************");
        listar();
    }

    private static void listar() {
        for (Morador m : Morador.getMoradores()) {
            System.out.println(m);
        }
        System.out.println();


        // CRIANDO VISITANTE  11-09

        Visitante v1 = new Visitante(
                "carlos.png",
                "Carlos",
                "98888-5555",
                "111.222.333-44"
        );

        v1.create();


        // CRIANDO OUTRO VISITANTE

        Visitante v2 = new Visitante(
                "ana.png",
                "Ana",
                "97777-6666",
                "555.666.777-88"
        );

        v2.create();


        // LISTANDO VISITANTES

        System.out.println("\n===== LISTA DE VISITANTES =====");

        for (Visitante visitante : Visitante.getVisitantes()) {

            System.out.println(visitante);
        }


        // BUSCANDO VISITANTE

        System.out.println("\n===== BUSCAR VISITANTE =====");

        Visitante visitanteEncontrado = Visitante.getById(3);

        if (visitanteEncontrado != null) {

            System.out.println(visitanteEncontrado);

        } else {

            System.out.println("Visitante não encontrado.");
        }


        // EDITANDO VISITANTE - alterou o telefone

        System.out.println("\n===== EDITANDO VISITANTE =====");

        v1.setTelefone("96666-7777");

        v1.update(3);

        System.out.println(v1);


        // EXCLUINDO VISITANTE

        System.out.println("\n===== EXCLUINDO VISITANTE =====");

        v2.delete(4);


        // LISTANDO NOVAMENTE

        System.out.println("\n===== VISITANTES APÓS EXCLUSÃO =====");

        for (Visitante visitante : Visitante.getVisitantes()) {

            System.out.println(visitante);
        }
    }
}
