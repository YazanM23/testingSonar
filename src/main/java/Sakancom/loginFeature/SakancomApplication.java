package Sakancom.loginFeature;
import java.io.IOException;
import java.util.Scanner;

public class SakancomApplication{

    public static void main(String[] args) {
        while(true){
            System.out.println("_____________________________________________");
            System.out.println("Choose from the following ");
            System.out.println("1-Login");
            System.out.println("2-Signup");
            System.out.print("The Value : ");
            Scanner input = new Scanner(System.in);
            int LoginOrSignUp = 0;
            LoginOrSignUp = input.nextInt();
            System.out.println("_____________________________________________");

            if (LoginOrSignUp == 1) {
                System.out.println("\n******* Login Page *******\n");
                loginEntity in=new loginEntity();

                Scanner input1 = new Scanner(System.in);
                System.out.print("Enter User Name : ");
                in.UserName = input1.nextLine();
                System.out.print("Enter the Password : ");
                in.Password = input1.nextLine();
                String role= in.checkValues(in.UserName,in.Password);


                if(role.equals("tenant")){
while(true){

    System.out.println("_____________________________________________");
    System.out.println("Choose from the following");
    System.out.println("1-View the available housing");
    System.out.println("2-Furniture");
    System.out.println("3-Control Panel");
    System.out.println("4-ShowLivedIn");
    System.out.println("5-Sign out");
    Scanner input2=new Scanner(System.in);
    int choose=input2.nextInt();
    System.out.println("_____________________________________________");
    if(choose==1){
        housingEntity e=new housingEntity();
       int avb= e.showAvailable();
       if(avb>1){
        System.out.println("do you want to book  accommodation? (Yes or No)");
        Scanner inp=new Scanner(System.in);
        String YN=new String();
        YN=inp.nextLine();
        if(YN.equals("Yes")){
            System.out.println("Enter house ID : ");
            Scanner id = new Scanner(System.in);
            String ID = id.nextLine();
            e.booking(ID,in.UserName);

        }}
    }
if(choose==2) {
    while (true) {
        System.out.println("_____________________________________________");
        System.out.println("Choose from the following");
        System.out.println("1-View the available Furnitures");
        System.out.println("2-Add Furnitures");
        System.out.println("3-Sell Furnitures");
        System.out.println("4-Back");
        Scanner inp = new Scanner(System.in);
        int ch = inp.nextInt();
        System.out.println("_____________________________________________");
        Furniture o = new Furniture();
        if (ch == 1) {
            o.displayFurniture(in.UserName);

        } else if (ch == 2) {
            Scanner inp1 = new Scanner(System.in);
            System.out.println("Enter Picture : ");
            o.Picture = inp1.nextLine();
            System.out.println("Enter Description : ");
            o.Description = inp1.nextLine();
            System.out.println("Enter Price : ");
            o.Price = inp1.nextLine();
            System.out.println("Enter ID : ");
            o.ID = inp1.nextLine();
            o.selled = "No";
            o.addFurniture(in.UserName, o.Picture, o.Description, o.Price, o.ID, o.selled);

        } else if (ch == 3) {
            Scanner inp1 = new Scanner(System.in);
            System.out.println("Enter ID to sell: ");
            o.ID = inp1.nextLine();
            o.sellFurniture(o.ID, in.UserName);

        }


        else if (ch == 4) {
            break;
        }

    }
} else if (choose==3) {
ControlPanel e=new ControlPanel();
e.displayControlPanel(in.UserName);
}
else if(choose==4){
    System.out.println("Enter House id you want to show:");
    Scanner in1=new Scanner(System.in);
    String id=in1.nextLine();
    showLivedIn e=new showLivedIn();
    e.displayLived(id);
}

else if (choose==5) {
    break;
}
}

                }
                else if(role.equals("owner")){
                }
                else if (role.equals("admin")) {

                }

                System.out.println("_____________________________________________");

            }

            else if (LoginOrSignUp==2) {

            }
        }
    }
}