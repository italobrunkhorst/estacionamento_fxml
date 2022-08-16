package ifpr.pgua.eic.estacionamento.controllers;

import ifpr.pgua.eic.estacionamento.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class JanelaPrincipal {
    

    @FXML
    private void carregaTelaCadastro(ActionEvent evento){
        App.pushScreen("CADASTRO");
    }

    @FXML
    private void carregaTelaListar(ActionEvent evento){
        App.pushScreen("LISTAR");
    }

}
