package ifpr.pgua.eic.estacionamento.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import ifpr.pgua.eic.estacionamento.App;
import ifpr.pgua.eic.estacionamento.models.Estacionamento;
import ifpr.pgua.eic.estacionamento.models.Veiculo;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;

//Note que esta classe implementa a interface Initializable. Isso
//indica ao JavaFX que existem componentes que devem ser inicializados
//antes de mostrar a tela. No caso desta tela, significa povoar a lista
//de veículos.
public class JanelaListar implements Initializable{


    @FXML
    private ListView<Veiculo> ltvVeiculos;

    @FXML
    private TextArea taDetalhes;


    private Estacionamento estacionamento;

    public JanelaListar(Estacionamento estacionamento){
        this.estacionamento = estacionamento;
    }



    //método utilizado para inicializar os componentes visuais.
    //É executado depois do construtor e antes da tela ser mostrada.
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {

        
        ltvVeiculos.getItems().clear();
        
        //inicialização do listview
        ltvVeiculos.getItems().addAll(estacionamento.listaTodosVeiculos());    
    }


    //Evento que ao clicar em um elemento do listview é executado.
    @FXML
    private void mostrarDetalhes(MouseEvent evento){
        Veiculo veiculo = ltvVeiculos.getSelectionModel().getSelectedItem();

        if(veiculo != null){
            taDetalhes.clear();
            taDetalhes.appendText("Placa: "+veiculo.getPlaca()+"\n");
            taDetalhes.appendText("Modelo: "+veiculo.getModelo()+"\n");
            taDetalhes.appendText("Fabricante: "+veiculo.getFabricante()+"\n");
            taDetalhes.appendText("Cor: "+veiculo.getCor()+"\n");
            taDetalhes.appendText("Ano Fabricação: "+veiculo.getAnoFabricacao()+"\n");
        }
    }


    //utilizado para voltar uma tela.
    @FXML
    private void voltar(){
        App.popScreen();
    }
    
}
