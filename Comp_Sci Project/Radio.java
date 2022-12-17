public class Radio{
    String Brand;
    String Item_Name;
    int RadioFrequency;
    public Radio(String Brand, String Item_Name, int RadioFrequency){
        this.Brand = Brand;
        this.Item_Name = Item_Name;
        this.RadioFrequency = RadioFrequency;
    }
    public String getBrand() {
        return Brand;
    }
    public void setBrand(String brand) {
        Brand = brand;
    }
    public String getItem_Name() {
        return Item_Name;
    }
    public void setItem_Name(String item_Name) {
        Item_Name = item_Name;
    }
    public int getRadioFrequency() {
        return RadioFrequency;
    }
    public void setRadioFrequency(int radioFrequency) {
        RadioFrequency = radioFrequency;
    }
    public String toString(){
        return "Brand: "+Brand+", Item Name: "+Item_Name+", Frequency: "+RadioFrequency;
    }
    
}