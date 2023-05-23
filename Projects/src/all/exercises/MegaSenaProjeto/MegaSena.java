package all.exercises.MegaSenaProjeto;

import all.exercises.MegaSenaProjeto.view.MegaSenaTela;
import all.services.MegaSenaService;

public class MegaSena {
    public static void main(String[] args) {
        MegaSenaService ms = new MegaSenaService();
        MegaSenaTela mgt = new MegaSenaTela(ms);

        

    
}
}