package all.services;

import java.util.List;
import java.util.regex.Pattern;

import all.entities.Employee;

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

    public static Boolean listContainsId(List<Employee> list, String idString){
        Boolean idIsTrue = false;
        int id = Integer.parseInt(idString);
        
        for (Employee employee : list) {
            if((id == employee.getId())){
                idIsTrue = true;
            }
        }
        if(idIsTrue){
            return true;
            }
        return false;

    }

    public static Boolean listContainsId(List<Employee> list, int id){
        Boolean idIsTrue = false;
        for (Employee employee : list) {
            if((id == employee.getId())){
                idIsTrue = true;
            }
        }
        if(idIsTrue){
            return true;
            }
        return false;

    }

    public static Employee findEmployeeById(List<Employee> list, int id){
        Employee validEmployee = null;
        for(Employee e: list){
            if(e.getId() == id){
                validEmployee = e ;
            } 
        }
        return validEmployee;
        
    }

    
    
    
}
