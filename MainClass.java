import java.net.InetAddress;
import java.net.*;
public class MainClass
{
    public static void main(String[] args){
        String ip=null;
        boolean isContinuos=false;
        int NUMBER_OF_TRY=4;
        switch (args.length) {
            case 0:
                break;
            case 1:
                ip = args[0];
                break;
            case 2:
                if("-t".equalsIgnoreCase(args[1])){
                    isContinuos=true;
                    ip=args[0];
                }
                break;
            default:
                break;
        }
        if(ip!=null){
            try {
                InetAddress inet = InetAddress.getByName(ip);
                if(isContinuos){
                    while(true){
                        ping(inet);
                        Thread.sleep(3000);
                    }
                }else{
                    while(NUMBER_OF_TRY>0){
                        NUMBER_OF_TRY--;
                        ping(inet);
                        Thread.sleep(1000);
                    }
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        
    }
    private static void ping(InetAddress inet){
        try {
            if(inet.isReachable(5000)){
                System.out.println(" reacheable");
            }else{
                System.out.println(" unreacheable");
            }
        }catch(Exception e){
            e.printStackTrace();
        }     
    }
}