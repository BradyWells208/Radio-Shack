public class Satellite extends Radio{
    public int num_Satellites;
    public Satellite(String Brand, String Item_Name, int RadioFrequency, int num_Satellites){
        super(Brand, Item_Name, RadioFrequency);
        this.num_Satellites = num_Satellites;
    }
    public Satellite(String Brand, String Item_Name, int RadioFrequency){
        super(Brand, Item_Name, RadioFrequency);
        num_Satellites = 1;
    }
    public int getNum_Satellites() {
        return num_Satellites;
    }
    public void setNum_Satellites(int num_Satellites) {
        this.num_Satellites = num_Satellites;
    }
    public String toString() {
        return super.toString()+", Number of Available Satellites: "+num_Satellites;
    }
    
}
