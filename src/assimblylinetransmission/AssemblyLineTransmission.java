/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package assimblylinetransmission;

/**
 *
 * @author bilal
 */


/*
Name: Bilal Zahid
Class: BSCS2-A
Reg # 450
SEECS NUST
*/
public class AssemblyLineTransmission {
    int n=5;
    int[] l1 = new int[n];
    int[] l2 = new int[n];
    int l = 0;
    int[] a1,a2,t1,t2,f1,f2 ;
    int e1,e2,x1,x2;
    int f=0;
    
    public AssemblyLineTransmission(int a[][],int t[][],int e[],int x[],int n) {
        this.n=n;
        l1 = new int[n];
        l2 = new int[n];
        a1 = new int[n];
        a2 = new int[n];
        t1 = new int[n];
        t2 = new int[n];
        f1 = new int[n];
        f2 = new int[n];
        
        for(int i=0;i<n;i++){
            a1[i]=a[0][i];
            a2[i]=a[1][i];
            t1[i]=t[0][i];
            t2[i]=t[1][i];
        }
        
        e1=e[0];
        e2=e[1];
        x1=x[0];
        x2=x[1];
        
    }
    
    public int[] FastestWay(){
        
        f1[0] = e1 + a1[0];
        f2[0] = e2 + a2[0];
        
        for (int j=1;j<n;j++){
            if(f1[j-1]+a1[j]<f2[j-1]+t2[j-1]+a1[j]){
                f1[j] = f1[j-1]+a1[j];
                l1[j-1] = 1;
            }
            else{
                f1[j] = f2[j-1] + t2[j-1] + a1[j];
                l1[j-1] = 2;
            }
                               
            if(f2[j-1]+a2[j]<f1[j-1]+t1[j-1]+a2[j]){
                f2[j] = f2[j-1] + a2[j];
                l2[j-1] = 2;
            }
            else{
                f2[j] = f1[j-1] + t1[j-1] + a2[j];
                l2[j-1] = 1; 
            }
        }
        
        if(f1[n-1]+x1<f2[n-1]+x2){
            f = f1[n-1] + x1;
            l = 1;
        }
        else{
            f = f2[n-1] + x2;
            l = 2;
        }
        
        if(l==1){
            l1[n-1] = l;
            System.out.println(f);
            return l1;
            
        }
        else{
            l2[n-1] = l;
            System.out.print(f);
            return l2;
        }
    }
}

