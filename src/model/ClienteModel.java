package src.model;

import src.model.enums.SexoEnum;

public class ClienteModel 
{
    private String cpf; // cpf1
    private String nome; // nome_completo
    private String dtNasc; // dt_nasc
    private String dtReg; // dt_reg
    private String telCont1; // tel_cont1
    private String telCont2; // tel_cont2
    private String email; // email
    private String infosComp; // infosComp

    private SexoEnum sexo;

    private MoradiaModel moradia; // moradia

    
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getDtNasc() {
        return dtNasc;
    }
    public void setDtNasc(String dtNasc) {
        this.dtNasc = dtNasc;
    }
    public String getDtReg() {
        return dtReg;
    }
    public void setDtReg(String dtReg) {
        this.dtReg = dtReg;
    }
    public String getTelCont1() {
        return telCont1;
    }
    public void setTelCont1(String telCont1) {
        this.telCont1 = telCont1;
    }
    public String getTelCont2() {
        return telCont2;
    }
    public void setTelCont2(String telCont2) {
        this.telCont2 = telCont2;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getInfosComp() {
        return infosComp;
    }
    public void setInfosComp(String infosComp) {
        this.infosComp = infosComp;
    }
    public void setMoradia(MoradiaModel moradia)
    {
        this.moradia = moradia;
    }
    public MoradiaModel getMoradia()
    {
        return moradia;
    }
    public void setSexo(SexoEnum sexo)
    {
        this.sexo = sexo;
    }
    public SexoEnum getSexo()
    {
        return sexo;
    }
}