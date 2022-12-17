public class AmFm extends Radio{
    private String AmorFm;
    public AmFm(String Brand, String Item_Name, int RadioFrequency, String AmorFm){
        super(Brand, Item_Name, RadioFrequency);
        this.AmorFm = AmorFm;
    }
    public String getAmorFm() {
        return AmorFm;
    }
    public void setAmorFm(String amorFm) {
        AmorFm = amorFm;
    }
    public String toString() {
        return super.toString()+", Am or Fm: "+AmorFm;
    }
}
