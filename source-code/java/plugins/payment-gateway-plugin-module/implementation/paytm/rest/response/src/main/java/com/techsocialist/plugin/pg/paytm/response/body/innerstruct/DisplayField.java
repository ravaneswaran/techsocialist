package com.techsocialist.plugin.pg.paytm.response.body.innerstruct;

import com.google.gson.annotations.SerializedName;

public class DisplayField {

    @SerializedName("amount")
    private String amount;

    @SerializedName("headerText")
    private String headerText;

    @SerializedName("bankName")
    private String bankName;

    @SerializedName("bankLogo")
    private String bankLogo;

    @SerializedName("descriptionText")
    private String descriptionText;

    public DisplayField(){}

    public DisplayField(String amount, String headerText, String bankName, String bankLogo, String descriptionText){
        this.amount = amount;
        this.headerText = headerText;
        this.bankName = bankName;
        this.bankLogo = bankLogo;
        this.descriptionText = descriptionText;
    }

    public String getAmount() {
        return amount;
    }

    public String getHeaderText() {
        return headerText;
    }

    public String getBankName() {
        return bankName;
    }

    public String getBankLogo() {
        return bankLogo;
    }

    public String getDescriptionText() {
        return descriptionText;
    }
}
