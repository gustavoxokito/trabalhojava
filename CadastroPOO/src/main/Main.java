import model.*;

public class Main {
    public static void main(String[] args) {
        try {
            // Testando PessoaFisicaRepo
            PessoaFisicaRepo repo1 = new PessoaFisicaRepo();
            repo1.inserir(new PessoaFisica(1, "Marcos Silva", "123.456.789-00", 18));
            repo1.inserir(new PessoaFisica(2, "Danielle Oliveira", "987.654.321-00", 36));
            repo1.persistir("pessoasFisicas.dat");

            PessoaFisicaRepo repo2 = new PessoaFisicaRepo();
            repo2.recuperar("pessoasFisicas.dat");
            for (PessoaFisica pf : repo2.obterTodos()) {
                pf.exibir();
            }

            // Testando PessoaJuridicaRepo
            PessoaJuridicaRepo repo3 = new PessoaJuridicaRepo();
            repo3.inserir(new PessoaJuridica(1, "Empresa A", "00.000.000/0001-00"));
            repo3.inserir(new PessoaJuridica(2, "Empresa B", "11.111.111/1110-00"));
            repo3.persistir("pessoasJuridicas.dat");

            PessoaJuridicaRepo repo4 = new PessoaJuridicaRepo();
            repo4.recuperar("pessoasJuridicas.dat");
            for (PessoaJuridica pj : repo4.obterTodos()) {
                pj.exibir();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
