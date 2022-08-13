package src.model;

public class MoradiaModel 
{
    private String pais; // pais
    private String estado; // estado
    private String logradouro; // logradouro
    private String bairro; // bairro1
    private String endereco; // endereco 
    private int cep; // cep
    
    public String getPais() {
        return pais;
    }
    public void setPais(String pais) {
        this.pais = pais;
    }
    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }
    public String getLogradouro() {
        return logradouro;
    }
    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }
    public String getBairro() {
        return bairro;
    }
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }
    public String getEndereco() {
        return endereco;
    }
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    public int getCep() {
        return cep;
    }
    public void setCep(int cep) {
        this.cep = cep;
    }
}
