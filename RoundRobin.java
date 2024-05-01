
package com.mycompany.aoa;
import java.util.Scanner;
import java.util.Arrays;
public class  RoundRobin {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the no. of Process");
        int np = sc.nextInt();
        int[] process = new int[np];
        int[] BT = new int[np];
        int[] tempBT = new int[np];
        int[] FT = new  int[np];
        int[] TAT = new int[np];
        int[] WT = new int[np];
         for (int i = 0; i < np; i++) {
             System.out.print("\nP["+(i+1)+"] Name  is : ");
             process[i] =sc.nextInt();
             System.out.print("\nP["+(i+1)+"] BURST TIME  is : ");
             BT[i] =sc.nextInt();
             tempBT[i] = BT[i];
        }
         System.out.println("Enter the Time Qountam");
         int qt = sc.nextInt();
         int temp = 0;
         boolean[] status =  new boolean[np];
         for (int i = 0; i < np; i++) {
             for (int j = 0; j < np; j++) {
                 
                 if (tempBT[j]>qt && status[j]!=true) {
                     tempBT[j] = tempBT[j]-qt;
                     temp = temp + qt;
                     
                 }else if (tempBT[j]==qt && status[j]!=true) {
                     tempBT[j] = tempBT[j]-qt;
                     temp = temp +qt;
                     FT[j] = temp;
                     status[j]=true;
                     
                 }else if(tempBT[j]<qt && status[j]!=true){
                     temp = temp + tempBT[j];
                     tempBT[j] = tempBT[j]-tempBT[j];
                     FT[j]=temp;
                     status[j]=true;
                 }
                 
             }
            
        }
//         Calculation 
                double ttat =0 ,twt =0;
            for (int i = 0; i < np; i++) {
            TAT[i]  = FT[i] -0;
            WT[i] = TAT[i] - BT[i];
            ttat += TAT[i];
            twt +=WT[i];
            
        }
         System.out.println("prcess\tAT\tBT\tFT\tTAT\tWT");
         for (int i = 0; i < np; i++) {
             System.out.println("P["+(i)+"]\t"+(0)+"\t"+BT[i]+"\t"+FT[i]+"\t"+TAT[i]+"\t"+WT[i]);
        }
         System.out.println("AVERAGE TAT TIME "+ttat/np);
         System.out.println("AVERAGE WT TIME "+twt/np);
        
    
    }
    
}
    
    
    

