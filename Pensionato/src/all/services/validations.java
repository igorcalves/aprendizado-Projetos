package all.services;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.regex.Pattern;

public class validations {

    public static boolean IsValidNumeric(String numeric){
       try {
            Integer.parseInt(numeric);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }

    }

    public static boolean isValidDoubleNumeric(String numeric){
        try {
             Double.parseDouble(numeric);
             return true;
         } catch (NumberFormatException e) {
             return false;
         }
 
     }

    public  static boolean rangeNumeric(String numberInString){
        if(IsValidNumeric(numberInString)){
            int number = Integer.parseInt(numberInString);
            if(number >=0 && number <=9){return true;}
        }
        return false;
    }

    public static boolean isNameValid(String name) {
        if(name.isBlank()) return false;   
        char[] chars = name.toCharArray();
        for (char c : chars) {
            if (!Character.isLetter(c) && !Character.isWhitespace(c)) {
                return false;
            }
        }
    
        return true;
    }

    public static boolean isValidEmail(String email) {
        if(email.isBlank()) return false; 
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." +
                            "[a-zA-Z0-9_+&*-]+)*@" +
                            "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                            "A-Z]{2,7}$";
        Pattern pattern = Pattern.compile(emailRegex);
        return pattern.matcher(email).matches();
    }

    public static boolean isValidDate(String date){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        
        if(date.isBlank()) return false;
        try {
            LocalDate.parse(date,formatter);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean tagValidation(String tag){
        if (tag.isBlank()) return false;

        if(tag.equalsIgnoreCase("c")|| tag.equalsIgnoreCase("u") || tag.equalsIgnoreCase("i")){
            return true;
        }
        return false;
    }


    
    
    
}