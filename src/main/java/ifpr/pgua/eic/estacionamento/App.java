package ifpr.pgua.eic.estacionamento;

import ifpr.pgua.eic.estacionamento.controllers.JanelaCadastro;
import ifpr.pgua.eic.estacionamento.controllers.JanelaListar;
import ifpr.pgua.eic.estacionamento.controllers.JanelaPrincipal;
import ifpr.pgua.eic.estacionamento.models.Estacionamento;
import ifpr.pgua.eic.estacionamento.utils.BaseAppNavigator;
import ifpr.pgua.eic.estacionamento.utils.ScreenRegistryFXML;

/**
 * Classe inicial da aplicação, declara-se todas as telas bem como 
 * outros objetos que serão utilizados. * 
 */
public class App extends BaseAppNavigator {

    //Objeto centralizado para o estacionamento
    private Estacionamento estacionamento;

    //método utilizado para inicializar os outros objetos
    @Override
    public void init() throws Exception {
        super.init();

        estacionamento = new Estacionamento("Estacionamento","111-2233");
    }


    //indica qual é a tela inicial
    @Override
    public String getHome() {
        return "PRINCIPAL";
    }

    //título da aplicação
    @Override
    public String getAppTitle() {
        return "Estacionamento";
    }

    //registro de todas as telas da aplicação
    @Override
    public void registrarTelas() {
        registraTela("PRINCIPAL", new ScreenRegistryFXML(App.class, "principal.fxml", o->new JanelaPrincipal()));
        registraTela("CADASTRO", new ScreenRegistryFXML(App.class, "cadastro.fxml", o->new JanelaCadastro(estacionamento)));
        registraTela("LISTAR", new ScreenRegistryFXML(App.class, "listar.fxml", o->new JanelaListar(estacionamento)));
        
    }

    

}