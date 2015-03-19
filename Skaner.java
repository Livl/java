package skaner;

// string.charAt(i)

public class Skaner {
    
    public static int iloscliczb(String str){
        char[] strchar=str.toCharArray();
        int ilosc=1;
        for(int i=0;i<strchar.length;i++)
            if (strchar[i]=='+' || strchar[i]=='-')
               ++ilosc; 
        return ilosc;
    }
    
    public static Integer sprawdz(String str){
        char[] strchar= str.toCharArray();
        char[] dzialania=new char[iloscliczb(str)-1];
        int[] liczby=new int [iloscliczb(str)];
        int wynik=0;
        
        for(int i=0, nr=0, nrd=0; i<strchar.length; i++){
            System.out.println("i=" + i + "  nr=" + nr);
            if(strchar[i]=='+'){
                dzialania[nrd]='+';
                nrd++;
            }
            else if (strchar[i]=='-'){
                dzialania[nrd]='-';
                nrd++;
            }
            else if (Character.isDigit(strchar[i])){
                String tmp=Character.toString(strchar[i]);
                
                for(int j=i+1;j<strchar.length;j++){
                    if(Character.isDigit(strchar[j])) {
                        tmp += Character.toString(strchar[j]);
                        i++;
                    }
                    else if(!Character.isDigit(strchar[j]))
                        break;      
                }
                
                liczby[nr] = Integer.parseInt(tmp);
                nr++;
                
                System.out.println(liczby[0]+" "+liczby[1]);
            }              
        } 
        
        for (int i=0;i<dzialania.length;i++){
            System.out.println(liczby[0]+" "+liczby[1]);
            for (int j=0;j<liczby.length-1;j+=2){
                if(dzialania[i]=='+'){
                    //return liczby[i]+liczby[i+1];
                    wynik = liczby[j]+liczby[j+1];
                    System.out.println("w "+wynik);
                    }
                else if(dzialania[i]=='-')
                    return liczby[j]-liczby[j+1];
                    //wynik += liczby[i]-liczby[i+1];
                
            }
        }
        return wynik;
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        Integer result = sprawdz("1+91");
        System.out.println(result);
        //System.out.println(result == 0);         
    }
}
