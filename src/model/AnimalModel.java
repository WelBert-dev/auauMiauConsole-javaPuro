package src.model;

public class AnimalModel 
{
    private int id;
    private String nomeAnimal;
    private String nomeDono;
    private char sexo;
    private String especie;
    private String raca;
    private float pesoAtual;
    private String identificacao;
    private String vacinas;
    private String infoComp;
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNomeAnimal() {
        return nomeAnimal;
    }
    public void setNomeAnimal(String nomeAnimal) {
        this.nomeAnimal = nomeAnimal;
    }
    public String getNomeDono() {
        return nomeDono;
    }
    public void setNomeDono(String nomeDono) {
        this.nomeDono = nomeDono;
    }
    public char getSexo() {
        return sexo;
    }
    public void setSexo(char sexo) {
        this.sexo = sexo;
    }
    public String getEspecie() {
        return especie;
    }
    public void setEspecie(String especie) {
        this.especie = especie;
    }
    public String getRaca() {
        return raca;
    }
    public void setRaca(String raca) {
        this.raca = raca;
    }
    public float getPesoAtual() {
        return pesoAtual;
    }
    public void setPesoAtual(float pesoAtual) {
        this.pesoAtual = pesoAtual;
    }
    public String getIdentificacao() {
        return identificacao;
    }
    public void setIdentificacao(String identificacao) {
        this.identificacao = identificacao;
    }
    public String getVacinas() {
        return vacinas;
    }
    public void setVacinas(String vacinas) {
        this.vacinas = vacinas;
    }
    public String getInfoComp() {
        return infoComp;
    }
    public void setInfoComp(String infoComp) {
        this.infoComp = infoComp;
    }
}