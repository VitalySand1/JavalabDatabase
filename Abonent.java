import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;

public class Abonent {
    private String imya;
    private String familiya;
    private int nomer_telefona;
    private LocalDate dateofbirth;

    public int getPhonebookID() {
        return phonebookID;
    }

    public void setPhonebookID(int phonebookID) {
        this.phonebookID = phonebookID;
    }

    private int phonebookID;
    Abonent(){
        imya = "";
        familiya = "";
        nomer_telefona = 0;
        dateofbirth = LocalDate.of(1998,04,12);
        phonebookID = 0;
    }
    Abonent(String imya,String familiya, int nomer_telefona, LocalDate d,int phonebookid){
        this.imya = imya;
        this.familiya = familiya;
        this.nomer_telefona = nomer_telefona;
        this.dateofbirth = d;
        this.phonebookID = phonebookid;

    }
    public void setImya(String imya) {
        this.imya = imya;
    }
    public void setFamiliya(String familiya) {
        this.familiya = familiya;
    }
    public void setNomer_telefona(int nomer_telefona) {
        this.nomer_telefona = nomer_telefona;
    }
    public void setDateofbirth(LocalDate d){
        this.dateofbirth = d;
    }

    public String getImya() {
        return imya;
    }
    public String getFamiliya() {
        return familiya;
    }

    public long getNomer_telefona() {
        return nomer_telefona;
    }
    public LocalDate getDateofbirth(){
        return  this.dateofbirth;
    }


    public boolean IfPensioner(){
        Period p = Period.between(this.dateofbirth, LocalDate.now());
        return p.getYears() >= 60;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Abonent abonent = (Abonent) o;
        return
                nomer_telefona == abonent.nomer_telefona &&
                Objects.equals(imya, abonent.imya) &&
                Objects.equals(familiya, abonent.familiya) &&
                Objects.equals(dateofbirth, abonent.dateofbirth);
    }

    @Override
    public int hashCode() {

        return Objects.hash(imya, familiya, nomer_telefona, dateofbirth);
    }

    public static void main(String args[]){
       /* Abonent A = new Abonent("Vitaly", "Sand",false,03722424, LocalDate.of(1998,12,14));
        A.IfPensioner();*/
    }
}
