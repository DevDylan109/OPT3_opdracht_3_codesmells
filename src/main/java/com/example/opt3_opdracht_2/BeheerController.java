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
    private FXMLLoader loader;
    private SceneSwitcher switcher;
    private Login loginInstance;

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

    protected void initialize(Medewerker medewerker, ProductList productList){
        this.medewerker = medewerker;
        this.productList = productList;
        setLabel();
        setFactoryView();
    }

    public void initLogin(Login login){
        this.loginInstance = login;
    }

    private void setLabel(){
        MedewerkersLabel.setText("Beheerder: " + medewerker.getNaam());
    }

    private void setFactoryView(){
        Factories factories = new Factories();
        ObservableList<ProductFactory> factoryList = FXCollections.observableArrayList();
        factoryList.setAll(factories.getFactoryList());
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
        System.out.println(product.printDetails());
        productList.addProduct(product);
    }

    @FXML
    protected void OnHoofdmenuClick() throws IOException {
        NaarHoofdmenu();
    }

    private void NaarHoofdmenu() throws IOException {
        switcher = new SceneSwitcher();
        loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("hoofdmenu-view.fxml"));

        switcher.setLoader(loader);
        switcher.setNode(addProductBtn);
        switcher.PrepareStage();

        //acces the controller and call a method
        HoofdmenuController controller = loader.getController();
        controller.initialize(medewerker, productList);
        controller.initLogin(loginInstance);

        switcher.CallStage();

    }
}
