package com.example.opt3_opdracht_2;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.text.Text;

public class VerhuurController {

    private Medewerker medewerker;
    private ProductList productList;
    private Product product;

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
    private Button VerhuurBtn;
    @FXML
    private Button cancelBtn;

    public void initialize(Medewerker medewerker, ProductList productlist, Product product) {
        this.medewerker = medewerker;
        this.productList = productlist;
        this.product = product;
        setDetailsArea();
        showVerhuurArea();
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
        DetailsArea.setText(product.printDetails());
        DetailsArea.setEditable(false);
    }

    private void setVerhuurArea(){
        String info = product.getHuurgegevens().printinfo();
        VerhuurArea.setText(info);
        VerhuurArea.setEditable(false);
    }

    @FXML
    protected void OnVerhuurBtnClick(){
        String naam = NaamField.getText();
        String achternaam = AchternaamField.getText();
        int dagen = Integer.parseInt(DagenField.getText());
        Klant klant = new Klant(naam, achternaam);
        product.getHuurgegevens().setKlant(klant);
        product.getHuurgegevens().setDagen(dagen);
        product.getHuurgegevens().setMedewerker(medewerker);

        product.setVerzekerd(VerzekerBtn.isSelected());
        product.berekenPrijs();
        product.setStatus("verhuurd");
        setDetailsArea();
//        setVerhuurArea();
        showVerhuurArea();
    }



}
