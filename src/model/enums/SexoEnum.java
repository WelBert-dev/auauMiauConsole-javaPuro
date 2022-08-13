package src.model.enums;

public enum SexoEnum
{
    FEMININO(1),
    MASCULINO(2);

    private int codigo;

    SexoEnum(int codigo)
    {
        this.codigo = codigo;
    }
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public static SexoEnum porCodigo(int codigo)
    {
        for (SexoEnum sexo : SexoEnum.values())
        {
            if (codigo == sexo.getCodigo())
            {
                return sexo;
            }
        }
        return null;
    }
}
