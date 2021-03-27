package thread.servidor;

public class ComandoClass implements Comparable<ComandoClass> {
    private String nome;
    private int prioridade;
    private String params;

    public ComandoClass(String nome, int prioridade, String params) {
        this.nome = nome;
        this.prioridade = prioridade;
        this.params = params;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(int prioridade) {
        this.prioridade = prioridade;
    }

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params;
    }

    @Override
    public int compareTo(ComandoClass o) {
        return o.prioridade - prioridade;
    }

    @Override
    public String toString() {
        return "ComandoClass{" +
                "nome='" + nome + '\'' +
                ", prioridade=" + prioridade +
                ", params='" + params + '\'' +
                '}';
    }
}
