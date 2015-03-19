package skaner.java;

// string.charAt(i)

public class Skaner {
    //obliczanie wielkosci tablicy
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
        //segregacja wyrazenia
        for(int i=0, nr=0, nrd=0; i<strchar.length; i++){
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
            }              
        } 
        //obliczanie
        for (int i=0;i<liczby.length-1;i++){
            if(i==0){
                if(dzialania[i]=='+')
                    wynik+=liczby[i]+liczby[i+1];
                else if (dzialania[i]=='-')
                    wynik+=liczby[i]-liczby[i+1];
            }
            else{
                if(dzialania[i]=='+')
                    wynik+=liczby[i+1];
                else if (dzialania[i]=='-')
                    wynik-=liczby[i+1];
            }
         
        }
        return wynik;
    }
    
    public static void main(String[] args) {
        Integer result = sprawdz("91-91+4+5+111");
        System.out.println(result);       
    }
}
