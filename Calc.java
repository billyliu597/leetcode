
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.lang.*;

public class InvalidInputException extends Exception {
  public InvalidInputException() { super(); }
  public InvalidInputException(String message) { super(message); }
  public InvalidInputException(String message, Throwable cause) { super(message, cause); }
  public InvalidInputException(Throwable cause) { super(cause); }
}

public class HelloWorld{

     public static void main(String []args){
        PrintUsage();
        
        String input = ReadInput();
        
        if ("quit".equalsIgnoreCase(input)){
            System.out.println("E: quit");
            return;
        }else{
            try{
                String[] tokens = Tokenize(input);
                String result = Calc(tokens);
                System.out.println("E: "+ result);
            }
            catch (InvalidInputException e){
                 System.out.println("E: ERROR");
            }
        }
     }
     
     public static void PrintUsage(){
         System.out.println("Hello");
         /// TODO
         // Print the usage
     }
     
     public static String ReadInput(){
         Scanner scan = new Scanner(System.in);
         return scan.next();
     }
     
     private static String[] Tokenize(String input){
       return input.Split(" ");
    }
    
    
    private static String Calc(String[] tokens){
        if (tokens == null || tokens.length <= 1){
            // Invalid input when there is just one token
            return "ERROR";
        }else{
            switch (tokens[0]){
                case "|":
                    return ProcessAbsCommand(token);
                    break;
                case "v":
                    return ProcessSqrtCommand(token);
                    break;
            }
        }
    }
    
    private static String ProcessSqrtCommand(String[] tokens){
        if (tokens.Length != 2){
            throw new InvalidInputException("");
        }
        
        int num = ParseInt(tokens[1]);
        
        return Math.sqrt(num).toString();
    }
    
    private static String ProcessAbsCommand(String[] tokens){
        if (tokens.Length != 2){
            throw new InvalidInputException("");
        }
        
        int num = ParseInt(tokens[1]);
        
        return Math.abs(num).toString();
    }
    
    private static int ParseInt(String token){
        try{
            return int.Parse(token);
        }catch (Exception e){
            throw new InvalidInputException(token);
        }
    }

}
