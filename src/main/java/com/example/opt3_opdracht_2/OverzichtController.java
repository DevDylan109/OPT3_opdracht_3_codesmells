package com.example.opt3_opdracht_2;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;

public class OverzichtController implements Observer {

    private SceneSwitcher switcher;
    private FXMLLoader loader;
    private Medewerker medewerker;
    private ProductList productlist;
    private Product Selected;
    private Login loginInstance;
    @FXML
    private Label MedewerkersLabel;

    @FXML
    private TableView<Product> ProductView;
    @FXML
    private TableColumn<Product, String> SoortColumn;
    @FXML
    private TableColumn<Product, String> BeschrijvingColumn;
    @FXML
    private TableColumn<Product, String> StatusColumn;


    protected void initialize(Medewerker medewerker, ProductList productlist){
        this.switcher = new currentSceneSwitcher();
        this.medewerker = medewerker;
        this.productlist = productlist;
        productlist.addObserver(this);
        setMedewerkersLabel();
        initProductView();
        setColumns();
    }

    public void initLogin(Login login){
        this.loginInstance = login;
    }

    private void setMedewerkersLabel(){
        String Text = medewerker.getNaam();
        this.MedewerkersLabel.setText(Text);
    }


    private void initProductView(){
        ProductView.setItems(productlist.getAllProducts());
    }

    private void setColumns(){
        SoortColumn.setCellValueFactory(new PropertyValueFactory<>("naam"));
        BeschrijvingColumn.setCellValueFactory(new PropertyValueFactory<>("beschrijving"));
        StatusColumn.setCellValueFactory(new PropertyValueFactory<>("status"));
    }

    @Override
    public void update() {
        initProductView();
    }

    private void SelectProduct(){
        Selected = ProductView.getSelectionModel().getSelectedItem();
    }

    @FXML
    protected void OnVerhuurBtnClick() throws IOException {
        SelectProduct();
        NaarVerhuur();
    }
    @FXML
    protected void OnDeleteBtnClick(){
        SelectProduct();
        productlist.removeProduct(Selected);
    }

    @FXML
    protected void OnHoofdmenuBtnClick() throws IOException {
        NaarHoofdmenu();
    }



    protected void NaarVerhuur() throws IOException {

        setSceneSwitch("verhuur-view.fxml");
        //acces the controller and call a method
        VerhuurController controller = switcher.getLoader().getController();
        controller.initialize(medewerker, productlist, Selected);
        controller.initLogin(loginInstance);
        SwitchScenes();
    }


    private void NaarHoofdmenu() throws IOException {

        setSceneSwitch("hoofdmenu-view.fxml");
        //acces the controller and call a method
        HoofdmenuController controller = switcher.getLoader().getController();
        controller.initialize(medewerker, productlist);
        controller.initLogin(loginInstance);
        SwitchScenes();
    }


    private void setSceneSwitch(String fxmlPath) throws IOException {
        switcher.PrepareScene(fxmlPath, MedewerkersLabel);
    }

    private void SwitchScenes(){
        switcher.SwitchToScene();
    }


}
