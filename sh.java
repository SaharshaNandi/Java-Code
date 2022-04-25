import java.text.SimpleDateFormat;
import java.util.*;
public class sh {
    public static Map<String,Integer> calcu (Map<String,Integer> inp)throws Exception{
        Map<String,Integer> res=new HashMap<String,Integer>();
        String ar[]={"Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday"};

        for (Map.Entry<String,Integer> entry : inp.entrySet()) {
            String s=entry.getKey();
            Date date;
            date = new SimpleDateFormat("yyyy-mm-dd").parse(s);
            String nm=new SimpleDateFormat("EEEE").format(date);
            //System.out.println(nm+" "+s+" "+entry.getValue());
            if(res.containsKey(nm))
                res.put(nm,res.get(nm)+entry.getValue());
            else
                res.put(nm,entry.getValue());
        }
        
        for(int i=1,l;i<6;i++){
        	//System.out.println(res+" "+i+ar[i]);
			if(!(res.containsKey(ar[i]))){
				for(l=1;!(res.containsKey(ar[i+l])) && i+l<7;l++);
				for(int c=l-1;c>=0;c--)
					res.put(ar[i+c], 
					(int)((res.get(ar[i-1])+(c+1)*( res.get(ar[i+l]) - res.get(ar[i-1]) )/(double)(l+1) )));
				i+=l;
			}
			
		}
        
        return  res;
    }

    public static void main(String[] args)throws Exception {
        Scanner sc = new Scanner(System.in);
        int n;
        n=sc.nextInt();
        Map<String,Integer> inp=new HashMap<String,Integer> ();
        for(int i=0;i<n;i++)
            inp.put(sc.next(),sc.nextInt());

        System.out.println(calcu(inp));

    }
}
/*
8
2020-01-01
4
2020-01-02
4
2020-01-03
6
2020-01-04
8
2020-01-05
2
2020-01-06
-6
2020-01-07
2
2020-01-08
-2
    
5
2020-01-01
6
2020-01-04
12
2020-01-05
14
2020-01-06
2
2020-01-07
4

*/
