package all;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import all.entities.Comment;
import all.entities.Post;

public class App {

    public static void main(String[] args) throws ParseException{

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

        Post post = new Post(sdf.parse("21/06/2023 13:53:23"), "Vou Logo Viajar", "Dia 3 do 9 vou viajar com minha familia a negocios", 3);

        post.addComments(new Comment("Boa viagem meu amigo"));
        post.addComments(new Comment("Cuidado na viagem"));
        post.addComments(new Comment("Traga presentes"));


        System.out.println(post);
        

    }
  
}
