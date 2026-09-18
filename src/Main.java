import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final Scanner leitor = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("=================== MENU ===================");
            System.out.println("1 - Criar Morador");
            System.out.println("2 - Criar Visitante");
            System.out.println("3 - Listar Moradores");
            System.out.println("4 - Listar Visitantes");
            System.out.println("5 - Excluir Morador");
            System.out.println("0 - Sair");
            System.out.println("============================================");
            System.out.print("Escolha uma opcao: ");
            try {
                opcao = Integer.parseInt(leitor.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Opcao invalida! Digite um numero.");
                opcao = -1;
            }

            switch (opcao) {
                case 1 -> criarMorador(leitor);
                case 2 -> criarVisitante(leitor);
                case 3 -> listarMoradores();
                case 4 -> listarVisitantes();
                case 5 -> excluirMorador(leitor);
                case 0 -> System.out.println("Saindo...");
                default -> System.out.println("Opcao invalida!");
            }
        } while (opcao != 0);

    }

    private static void criarMorador(Scanner leitor) {
        String avatar = Utils.lerCampo(leitor, "Avatar: ", 1, "^.+\\.(png|jpg|jpeg)$");
        String nome = Utils.lerCampo(leitor, "Nome: ", 2, "^[a-zA-ZÀ-ú ]+$");
        String telefone = "";
        String documento = "";

        while (true) {
            System.out.print("Telefone (apenas numeros, ex: 11999991111): ");
            telefone = leitor.nextLine();
            if (!telefone.matches("\\d{11}")) {
                System.out.println("Telefone invalido! Digite 11 digitos (DDD + numero).");
            } else if (Utils.telefoneExistente(telefone)) {
                System.out.println("Este telefone ja esta cadastrado!");
            } else {
                break;
            }
        }

        while (true) {
            System.out.print("Documento (apenas numeros, ex: 12345678900): ");
            documento = leitor.nextLine();
            if (!documento.matches("\\d{11}")) {
                System.out.println("CPF invalido! Digite 11 digitos.");
            } else if (Utils.documentoExistente(Morador.getMoradores(), documento)) {
                System.out.println("Este CPF ja esta cadastrado!");
            } else {
                break;
            }
        }

        String email;
        while (true) {
            email = Utils.lerCampo(leitor, "Email: ", 1, "^[^@]+@[^@]+\\.[^@]+$");
            if (Utils.emailExistente(email)) {
                System.out.println("Este email ja esta cadastrado!");
            } else {
                break;
            }
        }

        String senha = Utils.confirmarSenha(leitor);

        Morador m = new Morador(avatar, nome, Utils.formatarTelefone(telefone), Utils.formatarCPF(documento), email, senha);
        m.create();
        System.out.println("Morador criado com sucesso!");
    }

    private static void criarVisitante(Scanner leitor) {
        String avatar = Utils.lerCampo(leitor, "Avatar: ", 1, "^.+\\.(png|jpg|jpeg)$");
        String nome = Utils.lerCampo(leitor, "Nome: ", 2, "^[a-zA-ZÀ-ú ]+$");
        String telefone = "";
        String documento = "";

        while (true) {
            System.out.print("Telefone (apenas numeros, ex: 11999991111): ");
            telefone = leitor.nextLine();
            if (!telefone.matches("\\d{11}")) {
                System.out.println("Telefone invalido! Digite 11 digitos (DDD + numero).");
            } else if (Utils.telefoneExistente(telefone)) {
                System.out.println("Este telefone ja esta cadastrado!");
            } else {
                break;
            }
        }

        while (true) {
            System.out.print("Documento (apenas numeros, ex: 12345678900): ");
            documento = leitor.nextLine();
            if (!documento.matches("\\d{11}")) {
                System.out.println("CPF invalido! Digite 11 digitos.");
            } else if (Utils.documentoExistente(Visitante.getVisitantes(), documento)) {
                System.out.println("Este documento ja esta cadastrado!");
            } else {
                break;
            }
        }

        Visitante v = new Visitante(avatar, nome, Utils.formatarTelefone(telefone), Utils.formatarCPF(documento));
        v.create();
        System.out.println("Visitante criado com sucesso!");
    }

    private static void listarMoradores() {
        System.out.println("===== MORADORES =====");
        for (Morador m : Morador.getMoradores()) {
            System.out.println(m);
        }
        System.out.println();
    }
    private static void excluirMorador(Scanner leitor) { // exclusao

        listarMoradores();

        System.out.print("Digite o ID do morador que deseja excluir: ");

        try {
            int id = Integer.parseInt(leitor.nextLine());

            Morador morador = Morador.getById(id);

            if (morador != null) {

                morador.delete(id);

                System.out.println("Morador excluido com sucesso!");

            } else {

                System.out.println("Morador nao encontrado!");
            }

        } catch (NumberFormatException e) {

            System.out.println("ID invalido! Digite um numero.");
        }
    }

    private static void listarVisitantes() {
        System.out.println("===== VISITANTES =====");
        for (Visitante v : Visitante.getVisitantes()) {
            System.out.println(v);
        }
        System.out.println();
    }
}
