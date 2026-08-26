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
    }
}
