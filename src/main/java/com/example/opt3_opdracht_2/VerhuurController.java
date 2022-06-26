package com.example.opt3_opdracht_2;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.*;

import java.io.IOException;

public class VerhuurController {

    private Medewerker medewerker;
    private ProductList productList;
    private Product product;
    private Huurinfo huurinfo;
    private int dagen;
    private Klant klant;
    //private SceneSwitcher switcher;
    private Login loginInstance;
    private Data data;

    @FXML
    private TextArea DetailsArea;
    @FXML
    private TextArea VerhuurArea;
    @FXML
    private TextField NaamField;
    @FXML
    private TextField AchternaamField;
    @FXML
    private TextField DagenField;
    @FXML
    private ToggleButton VerzekerBtn;
    @FXML
    private Label Medewerkerslabel;
    @FXML
    private Button RetourBtn;
    @FXML
    private Button VerhuurBtn;

    public void initialize(Data data) {
        this.data = data;
        this.product = data.getProduct();
        this.medewerker = data.getMedewerker();
        this.productList = data.getProductList();
        this.loginInstance = data.getLogin();

        initHuurinfo();
        setDetailsArea();
        showVerhuurArea();
        setMedewerkersLabel();
        checkIfVerhuurd();
    }

    private void checkIfVerhuurd() {
        if(product.getStatus().equals("verhuurd")) {
            NodeVisibility(RetourBtn, true);
            NodeVisibility(VerhuurBtn, false);
            NodeVisibility(VerzekerBtn, false);
        }
        else{
            NodeVisibility(RetourBtn, false);
            NodeVisibility(VerhuurBtn, true);
            NodeVisibility(VerzekerBtn, true);
        }
    }

    private void NodeVisibility(Node node, boolean beslissing){
        node.setVisible(beslissing);
    }

//    public void initLogin(Login login){
//        this.loginInstance = login;
//    }


    private void setMedewerkersLabel(){
        String Text = medewerker.getNaam();
        this.Medewerkerslabel.setText(Text);
    }

    private void initHuurinfo(){
        this.huurinfo = product.getHuurgegevens();
    }

    private void setHuurinfo(){
        huurinfo.setKlant(klant);
        huurinfo.setDagen(dagen);
        huurinfo.setMedewerker(medewerker);
    }

    private void setProduct(){
        product.berekenPrijzen(VerzekerBtn.isSelected());
        product.setStatus("verhuurd");
    }

    private void setProductList(){
        productList.setProduct(product);
    }

    private void showVerhuurArea(){
        String status = product.getStatus();

        if(status.equals("verhuurd")){
            NodeVisibility(VerhuurArea, true);
            setVerhuurArea();
        }
        else{
            NodeVisibility(VerhuurArea, false);
        }
    }

    private void setDetailsArea(){
        DetailsArea.setText(String.valueOf(product));
        DetailsArea.setEditable(false);
    }

    private void setVerhuurArea(){
        String info = String.valueOf(product.getHuurgegevens());
        VerhuurArea.setText(info);
        VerhuurArea.setEditable(false);
    }

    private void Retourneer() throws IOException {
        product.setStatus("op voorraad");
        product.setPrijsPerDag(0);
        product.getHuurgegevens().resetInfo();
        setProductList();
        NaarOverzicht();
        NodeVisibility(RetourBtn, false);
    }


    private void NaarOverzicht() throws IOException {
        SceneSwitcher switcher = new currentSceneSwitcher();
        switcher.PrepareScene("overzicht-view.fxml", VerzekerBtn);
        //acces the controller and call a method
        OverzichtController controller = switcher.getLoader().getController();
        controller.initialize(data);
        //controller.initLogin(loginInstance);
        switcher.SwitchToScene();
    }


    @FXML
    protected void OnVerhuurBtnClick(){
        String naam = NaamField.getText();
        String achternaam = AchternaamField.getText();

        klant = new Klant(naam, achternaam);
        dagen = Integer.parseInt(DagenField.getText());

        UpdateProductList();
        setTextOfAreas();

        NodeVisibility(RetourBtn, true);
        NodeVisibility(VerhuurBtn, false);
        NodeVisibility(VerzekerBtn, false);
    }

    private void UpdateProductList(){
        setHuurinfo();
        setProduct();
        setProductList();
    }

    private void setTextOfAreas(){
        setDetailsArea();
        showVerhuurArea();
    }

    @FXML
    protected void OnTerugBtnClick() throws IOException {
        NaarOverzicht();
    }

    @FXML
    protected void OnRetourneerBtnClick() throws IOException {
        Retourneer();
    }

}
