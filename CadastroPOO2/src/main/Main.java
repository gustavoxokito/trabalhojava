package main;

import model.*;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PessoaFisicaRepo pessoaFisicaRepo = new PessoaFisicaRepo();
        PessoaJuridicaRepo pessoaJuridicaRepo = new PessoaJuridicaRepo();

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Incluir");
            System.out.println("2. Alterar");
            System.out.println("3. Excluir");
            System.out.println("4. Exibir pelo ID");
            System.out.println("5. Exibir todos");
            System.out.println("6. Salvar dados");
            System.out.println("7. Recuperar dados");
            System.out.println("0. Finalizar");
            System.out.print("Escolha uma opcao: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (opcao) {
                case 1:
                    incluir(scanner, pessoaFisicaRepo, pessoaJuridicaRepo);
                    break;
                case 2:
                    alterar(scanner, pessoaFisicaRepo, pessoaJuridicaRepo);
                    break;
                case 3:
                    excluir(scanner, pessoaFisicaRepo, pessoaJuridicaRepo);
                    break;
                case 4:
                    exibirPorId(scanner, pessoaFisicaRepo, pessoaJuridicaRepo);
                    break;
                case 5:
                    exibirTodos(scanner, pessoaFisicaRepo, pessoaJuridicaRepo);
                    break;
                case 6:
                    salvarDados(scanner, pessoaFisicaRepo, pessoaJuridicaRepo);
                    break;
                case 7:
                    recuperarDados(scanner, pessoaFisicaRepo, pessoaJuridicaRepo);
                    break;
                case 0:
                    System.out.println("Finalizando...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opcao invalida.");
            }
        }
    }

    private static void incluir(Scanner scanner, PessoaFisicaRepo pessoaFisicaRepo, PessoaJuridicaRepo pessoaJuridicaRepo) {
        System.out.print("Tipo (1 - Fisica, 2 - Juridica): ");
        int tipo = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        if (tipo == 1) {
            System.out.print("ID: ");
            int id = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            System.out.print("Nome: ");
            String nome = scanner.nextLine();
            System.out.print("CPF: ");
            String cpf = scanner.nextLine();
            System.out.print("Idade: ");
            int idade = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            pessoaFisicaRepo.inserir(new PessoaFisica(id, nome, cpf, idade));
            System.out.println("Pessoa Fisica incluida com sucesso.");
        } else if (tipo == 2) {
            System.out.print("ID: ");
            int id = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            System.out.print("Nome: ");
            String nome = scanner.nextLine();
            System.out.print("CNPJ: ");
            String cnpj = scanner.nextLine();
            pessoaJuridicaRepo.inserir(new PessoaJuridica(id, nome, cnpj));
            System.out.println("Pessoa Juridica incluida com sucesso.");
        } else {
            System.out.println("Tipo invalido.");
        }
    }

    private static void alterar(Scanner scanner, PessoaFisicaRepo pessoaFisicaRepo, PessoaJuridicaRepo pessoaJuridicaRepo) {
        System.out.print("Tipo (1 - Fisica, 2 - Juridica): ");
        int tipo = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        if (tipo == 1) {
            System.out.print("ID da Pessoa: ");
            int id = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            PessoaFisica pessoaFisica = pessoaFisicaRepo.obter(id);
            if (pessoaFisica != null) {
                System.out.println("Dados atuais: ");
                pessoaFisica.exibir();
                System.out.print("Novo Nome: ");
                String nome = scanner.nextLine();
                System.out.print("Novo CPF: ");
                String cpf = scanner.nextLine();
                System.out.print("Nova Idade: ");
                int idade = scanner.nextInt();
                scanner.nextLine(); // Consume newline
                pessoaFisicaRepo.alterar(new PessoaFisica(id, nome, cpf, idade));
                System.out.println("Pessoa Fisica alterada com sucesso.");
            } else {
                System.out.println("Pessoa Fisica nao encontrada.");
            }
        } else if (tipo == 2) {
            System.out.print("ID da Pessoa: ");
            int id = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            PessoaJuridica pessoaJuridica = pessoaJuridicaRepo.obter(id);
            if (pessoaJuridica != null) {
                System.out.println("Dados atuais: ");
                pessoaJuridica.exibir();
                System.out.print("Novo Nome: ");
                String nome = scanner.nextLine();
                System.out.print("Novo CNPJ: ");
                String cnpj = scanner.nextLine();
                pessoaJuridicaRepo.alterar(new PessoaJuridica(id, nome, cnpj));
                System.out.println("Pessoa Juridica alterada com sucesso.");
            } else {
                System.out.println("Pessoa Juridica nao encontrada.");
            }
        } else {
            System.out.println("Tipo invalido.");
        }
    }

    private static void excluir(Scanner scanner, PessoaFisicaRepo pessoaFisicaRepo, PessoaJuridicaRepo pessoaJuridicaRepo) {
        System.out.print("Tipo (1 - Fisica, 2 - Juridica): ");
        int tipo = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.print("ID da Pessoa: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        if (tipo == 1) {
            pessoaFisicaRepo.excluir(id);
            System.out.println("Pessoa Fisica excluida com sucesso.");
        } else if (tipo == 2) {
            pessoaJuridicaRepo.excluir(id);
            System.out.println("Pessoa Juridica excluida com sucesso.");
        } else {
            System.out.println("Tipo invalido.");
        }
    }

    private static void exibirPorId(Scanner scanner, PessoaFisicaRepo pessoaFisicaRepo, PessoaJuridicaRepo pessoaJuridicaRepo) {
        System.out.print("Tipo (1 - Fisica, 2 - Juridica): ");
        int tipo = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.print("ID da Pessoa: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        if (tipo == 1) {
            PessoaFisica pessoaFisica = pessoaFisicaRepo.obter(id);
            if (pessoaFisica != null) {
                pessoaFisica.exibir();
            } else {
                System.out.println("Pessoa Fisica nao encontrada.");
            }
        } else if (tipo == 2) {
            PessoaJuridica pessoaJuridica = pessoaJuridicaRepo.obter(id);
            if (pessoaJuridica != null) {
                pessoaJuridica.exibir();
            } else {
                System.out.println("Pessoa Juridica nao encontrada.");
            }
        } else {
            System.out.println("Tipo invalido.");
        }
    }

    private static void exibirTodos(Scanner scanner, PessoaFisicaRepo pessoaFisicaRepo, PessoaJuridicaRepo pessoaJuridicaRepo) {
        System.out.print("Tipo (1 - Fisica, 2 - Juridica): ");
        int tipo = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        if (tipo == 1) {
            for (PessoaFisica pessoaFisica : pessoaFisicaRepo.obterTodos()) {
                pessoaFisica.exibir();
            }
            System.out.println("Todas as Pessoas Fisicas exibidas com sucesso.");
        } else if (tipo == 2) {
            for (PessoaJuridica pessoaJuridica : pessoaJuridicaRepo.obterTodos()) {
                pessoaJuridica.exibir();
            }
            System.out.println("Todas as Pessoas Juridicas exibidas com sucesso.");
        } else {
            System.out.println("Tipo invalido.");
        }
    }

    private static void salvarDados(Scanner scanner, PessoaFisicaRepo pessoaFisicaRepo, PessoaJuridicaRepo pessoaJuridicaRepo) {
        System.out.print("Prefixo dos arquivos: ");
        String prefixo = scanner.nextLine();

        try {
            pessoaFisicaRepo.persistir(prefixo + ".fisica.bin");
            pessoaJuridicaRepo.persistir(prefixo + ".juridica.bin");
            System.out.println("Dados salvos com sucesso.");
        } catch (IOException e) {
            System.out.println("Erro ao salvar dados: " + e.getMessage());
        }
    }

    private static void recuperarDados(Scanner scanner, PessoaFisicaRepo pessoaFisicaRepo, PessoaJuridicaRepo pessoaJuridicaRepo) {
        System.out.print("Prefixo dos arquivos: ");
        String prefixo = scanner.nextLine();

        try {
            pessoaFisicaRepo.recuperar(prefixo + ".fisica.bin");
            pessoaJuridicaRepo.recuperar(prefixo + ".juridica.bin");
            System.out.println("Dados recuperados com sucesso.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Erro ao recuperar dados: " + e.getMessage());
        }
    }
}

