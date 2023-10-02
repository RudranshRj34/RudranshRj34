import java.util.*;
public class GuessTheNumber
{ 
    public static void main(String[] args) {
            Random obj=new Random();
            int num=obj.nextInt(25);
            Scanner sc=new Scanner (System.in);
            int i;
            for( i=0;i<5;i++)
            {
                int guess= sc.nextInt();
                if(num==guess)
                {
                    System.out.println("Congratulation You Won ");
                    break;
                }else if(num<guess)
                    System.out.println("Entered a bigger number");
                else
                    System.out.println("Entered a smaller number");
            }
            if (i==5){
        
                System.out.println("Sorry You Loose !! better luck next time");
            }
    }
}