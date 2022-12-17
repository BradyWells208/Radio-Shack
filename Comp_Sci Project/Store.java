import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Store{
    static ArrayList<Radio> radios;
    static Scanner sc = new Scanner(System.in);
    static String checkname;


    @SuppressWarnings("unchecked") public static void main(String[] args) {

       
        //Load the data if available ### DO NOT CHANGE THIS PART
        
        try{
            radios = (ArrayList<Radio>)loadData("radios");
        }catch(Exception e){
            radios = new ArrayList<>();
        }
        //############## MAIN MENU STARTS HERE ##############
        


        System.out.println("##### WELCOME #####");
        int choice = 1;
        while(choice > 0){
            //Print the Menu
            System.out.println("1) Add Radio"); 
            System.out.println("2) Radio Settings"); 
            System.out.println("3) List Inventory"); 
            System.out.println("4) Remove Radio");
            System.out.println("0) Exit"); 

            System.out.println();//EMPTY LINE
            //get the choice
            System.out.println("Choice: ");
            choice = sc.nextInt();
            sc.nextLine();//You have to do this
            if(choice  == 1){
                AddRadio();
            }else if(choice == 2){
                RadioSettings();
            }else if(choice == 3){
                listInventory();
            }else if(choice == 4){
                removeRadio();
            }else if(choice == 0){
                try{
                    saveData();
                }catch(Exception e){}
            }
        }
    }
    public static void AddRadio(){
        int choice = 1;
        System.out.print("Brand: ");
        String n = sc.nextLine();
        System.out.print("Name: ");
        String gl = sc.nextLine();
        System.out.print("Base Frequency: ");
        int Hz = sc.nextInt();
        sc.nextLine();
        while(choice>0){
            System.out.println("1. Am/Fm");
            System.out.println("2. Satellite");
            System.out.println("Choice: ");
            choice = sc.nextInt();
            sc.nextLine();//You have to do this
            if(choice  == 1){
                System.out.print("Am or Fm: ");
                String k = sc.nextLine();
                radios.add(new AmFm(n,gl,Hz,k));
                choice = 0;
            }else if(choice == 2){
                int c = 1;
                System.out.println("Do You Want more than one Satellite?");
                System.out.println("1. Yes");
                System.out.println("2. No");
                System.out.println("Choice: ");
                c = sc.nextInt();
                sc.nextLine();//You have to do this
                if(c == 1){
                    System.out.print("How many Satellite Stations can this Radio Access?: ");
                    int k = sc.nextInt();
                    sc.nextLine();
                    radios.add(new Satellite(n,gl,Hz,k));
                    choice = 0;
                }else{
                    radios.add(new Satellite(n,gl,Hz));
                    choice = 0;
                }     
        }
    }
    }
    public static void RadioSettings(){
        int choice = 1;
        System.out.println("Radios: ");
        listInventory();
        System.out.println();
        System.out.println("Choice: ");
        int n = sc.nextInt();
        sc.nextLine();
        Radio s = radios.get(n-=1);
        while(choice>0){
            System.out.println("0) Exit");
            System.out.println("1) Increase Frequency: ");
            System.out.println("2) Decrease Frequency: ");
            System.out.println();//EMPTY LINE
            //get the choice
            System.out.println("Choice: ");
            choice = sc.nextInt();
            if(choice == 1){
                int l = s.getRadioFrequency();
                l+=1;
                s.setRadioFrequency(l);
                System.out.println("Radio Frequency: "+s.getRadioFrequency());
            }
            if(choice == 2){
                int q = s.getRadioFrequency();
                q-=1;
                s.setRadioFrequency(q);
                System.out.println("Radio Frequency: "+s.getRadioFrequency());
            }
    }
}


    
    public static void listInventory(){
        int i = 1;
        for(Radio q:radios){
            System.out.print(i+". "+q+"\n");
            i+=1;
        }
    }
    public static void removeRadio(){
        System.out.println("Remove Radio: ");
        listInventory();
        System.out.println();
        System.out.println("Choice: ");
        int n = sc.nextInt();
        sc.nextLine();
        radios.remove(n-=1);
    }
    //#### DO NOT CHANGE THIS FUNCTION ####
    public static void saveData()throws Exception{
        FileOutputStream f1 = new FileOutputStream("students");
        ObjectOutputStream os = new ObjectOutputStream(f1);
        os.writeObject(radios);
        os.close();
        f1.close();
    }

    //#### DO NOT CHANGE THIS FUNCTION ####
    public static Object loadData(String name) throws Exception{
        FileInputStream fis = new FileInputStream(name);
        ObjectInputStream ois = new  ObjectInputStream(fis);   
        Object o = ois.readObject();
        ois.close();
        fis.close();
        return o;
    }
}