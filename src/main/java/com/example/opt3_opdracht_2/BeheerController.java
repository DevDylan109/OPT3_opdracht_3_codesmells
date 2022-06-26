package com.example.opt3_opdracht_2;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;

public class BeheerController {

    private Medewerker medewerker;
    private ProductList productList;
    private Product product;
    private Login loginInstance;
    private FactoryList factoryList;
    private Data data;

    @FXML
    private Button createProductBtn;
    @FXML
    private Button addProductBtn;
    @FXML
    private Label MedewerkersLabel;
    @FXML
    private TableView<ProductFactory> FactoryView;
    @FXML
    private TableColumn<ProductFactory, String> Soort;

    protected void initialize(Data data){
        factoryList = new FactoryList();
        this.data = data;
        this.medewerker = data.getMedewerker();
        this.productList = data.getProductList();
        this.loginInstance = data.getLogin();
        setLabel();
        setFactoryView();
    }


    private void setLabel(){
        MedewerkersLabel.setText("Beheerder: " + medewerker.getNaam());
    }

    private void setFactoryView(){
        //Factories factories = new Factories();
        ObservableList<ProductFactory> factoryList;
        factoryList = FXCollections.observableArrayList();
        factoryList.setAll(this.factoryList.getFactoryList());
        FactoryView.setItems(factoryList);
        Soort.setCellValueFactory(new PropertyValueFactory<>("FactoryName"));
    }

    @FXML
    protected void OnCreateBtnClick(){
        ProductFactory factory;
        factory = FactoryView.getSelectionModel().getSelectedItem();
        product = factory.createProduct();
        product.drawInputScreen();
        addProductBtn.setText("add: " + product.getNaam());
    }

    @FXML
    protected void OnAddBtnClick(){
        productList.addProduct(product);
    }

    @FXML
    protected void OnHoofdmenuClick() throws IOException {
        NaarHoofdmenu();
    }

    private void NaarHoofdmenu() throws IOException {
        SceneSwitcher switcher = new currentSceneSwitcher();
        switcher.PrepareScene("hoofdmenu-view.fxml", addProductBtn);

        //acces the controller and call a method
        HoofdmenuController controller = switcher.getLoader().getController();
        controller.initialize(data);
        switcher.SwitchToScene();
    }
    

}
