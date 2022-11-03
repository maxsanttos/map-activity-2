package model.entities;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Paciente extends Pessoa{
    private Date primeiraDose;
    private Date segundaDose;
    private Date terceiraDose;
    private Date quartaDose;

    private static final  SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public Paciente(String cpf, String nome,Date primeiraDose,Date segundaDose,Date terceiraDose,Date quartaDose) {
        super(cpf, nome);
        this.primeiraDose = primeiraDose;
        this.segundaDose = segundaDose;
        this.terceiraDose = terceiraDose;
        this.quartaDose = quartaDose;
        // verificando as informações das datas
        if (primeiraDose.before(segundaDose) && terceiraDose.before(quartaDose)) {
            Calendar cal = Calendar.getInstance();
            cal.setTime(primeiraDose);
            cal.add(Calendar.MONTH,4);
            primeiraDose = cal.getTime();

            cal.setTime(terceiraDose);
            cal.add(Calendar.MONTH,4);
            terceiraDose = cal.getTime();

            if (primeiraDose.equals(segundaDose) && terceiraDose.equals(quartaDose)) {
                System.out.println("Cidadão Cadastrado!");
            }
            else{
                System.out.println("O cidadão ainda não tem direito a uma nova data!");
            }
        }
    }

    public Date getPrimeiraDose() {
        return primeiraDose;
    }

    public void setPrimeiraDose(Date primeiraDose) {
        this.primeiraDose = primeiraDose;
    }

    public Date getSegundaDose() {
        return segundaDose;
    }

    public void setSegundaDose(Date segundaDose) {
        this.segundaDose = segundaDose;
    }

    public Date getTerceiraDose() {
        return terceiraDose;
    }

    public void setTerceiraDose(Date terceiraDose) {
        this.terceiraDose = terceiraDose;
    }

    public Date getQuartaDose() {
        return quartaDose;
    }

    public void setQuartaDose(Date quartaDose) {
        this.quartaDose = quartaDose;
    }

    @Override
    public String toString(){
        return "Nome: "
                + getNome()
                + "\n"
                + "Primeira Dose: "
                + sdf.format(primeiraDose)
                + "\n"
                + "Segunda Dose: "
                + sdf.format(segundaDose)
                + "\n"
                + "Terceira Dose: "
                + sdf.format(terceiraDose)
                + "\n"
                + "Quarta Dose: "
                + sdf.format(quartaDose)
                +"\n";
    }
}
