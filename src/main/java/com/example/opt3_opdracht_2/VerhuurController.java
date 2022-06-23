package com.example.opt3_opdracht_2;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;

import java.io.IOException;

public class VerhuurController {

    private Medewerker medewerker;
    private ProductList productList;
    private Product product;
    private Huurinfo huurinfo;
    private int dagen;
    private Klant klant;
    private FXMLLoader loader;
    private SceneSwitcher switcher;
    private Login loginInstance;

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

    public void initialize(Medewerker medewerker, ProductList productlist, Product product) {
        this.medewerker = medewerker;
        this.productList = productlist;
        this.product = product;
        this.switcher = new SceneSwitcher();

        initHuurinfo();
        setDetailsArea();
        showVerhuurArea();
        setMedewerkersLabel();

        if(product.getStatus().equals("verhuurd")) {
            setRetourBtnVisible(true);
        }
        else{
            setRetourBtnVisible(false);
        }
    }

    public void initLogin(Login login){
        this.loginInstance = login;
    }

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
            VerhuurArea.setVisible(true);
            setVerhuurArea();
        }
        else{
            VerhuurArea.setVisible(false);
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
        setRetourBtnVisible(false);
    }

    private void NaarOverzicht() throws IOException {
        loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("overzicht-view.fxml"));

        switcher.setLoader(loader);
        switcher.setNode(VerzekerBtn);
        switcher.PrepareStage();

        //acces the controller and call a method
        OverzichtController controller = loader.getController();
        controller.initialize(medewerker, productList);
        controller.initLogin(loginInstance);
        switcher.CallStage();


    }

    private void setRetourBtnVisible(boolean beslissing){
        RetourBtn.setVisible(beslissing);
    }

    @FXML
    protected void OnVerhuurBtnClick(){
        String naam = NaamField.getText();
        String achternaam = AchternaamField.getText();

        klant = new Klant(naam, achternaam);
        dagen = Integer.parseInt(DagenField.getText());



        setHuurinfo();
        setProduct();
        setProductList();

        setDetailsArea();
        showVerhuurArea();
        setRetourBtnVisible(true);
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
