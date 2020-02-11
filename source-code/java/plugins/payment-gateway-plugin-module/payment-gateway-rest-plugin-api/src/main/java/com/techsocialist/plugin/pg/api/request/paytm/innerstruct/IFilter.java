package com.techsocialist.plugin.pg.api.request.paytm.innerstruct;

public interface IFilter {

    public IFilter setBankCode(String bankCode);

    public IFilter setCardType(String cardType);

    public String getBankCode();

    public String getCardType();

}
