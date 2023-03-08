public class App {
    public static void main(String[] args) throws Exception {
        
    private String nome = "Maria";
    private String ultimoNome = "Silva";
    private char genero = 'F';
    private int idade = 35;
    private String cpf = "123.456.789-00";
    private String estadoCivil = "Casada";
    private String cep = "12345678";

    public PessoaFisica() throws Exception {
        this.setCpf(cpf);
        this.setCep(cep);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUltimoNome() {
        return ultimoNome;
    }

    public void setUltimoNome(String ultimoNome) {
        this.ultimoNome = ultimoNome;
    }

    public char getGenero() {
        return genero;
    }

    public void setGenero(char genero) {
        this.genero = genero;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) throws Exception {
        if (!validaCPF(cpf)) {
            throw new Exception("CPF inválido!");
        }
        this.cpf = cpf;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) throws Exception {
        if (cep.length() != 8 || !cep.matches("[0-9]+")) {
            throw new Exception("CEP inválido!");
        }
        this.cep = cep;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        final PessoaFisica other = (PessoaFisica) obj;
        if (!Objects.equals(this.cpf, other.cpf)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.cpf);
        return hash;
    }

    public String toString() {
        return "Nome: " + nome + " " + ultimoNome +
                "\nGênero: " + genero +
                "\nIdade: " + idade +
                "\nCPF: " + cpf +
                "\nEstado civil: " + estadoCivil +
                "\nCEP: " + cep;
    }

    private boolean validaCPF(String cpf) {
        cpf = cpf.replace(".", "").replace("-", "");
        if (cpf.length() != 11) {
            return false;
        }
        int soma = 0;
        for (int i = 0; i < 9; i++) {
            soma += (cpf.charAt(i) - '0') * (10 - i);
        }
        int digito1 = 11 - (soma % 11);
        if (digito1 > 9) {
            digito1 = 0;
        }
        soma = 0;
        for (int i = 0; i < 10; i++) {
            soma += (cpf.charAt(i) - '0') * (11 - i);
        }
        int digito2 = 11 -
