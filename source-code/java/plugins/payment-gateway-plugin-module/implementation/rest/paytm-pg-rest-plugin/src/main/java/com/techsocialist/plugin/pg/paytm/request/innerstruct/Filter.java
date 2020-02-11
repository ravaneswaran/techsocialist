package com.techsocialist.plugin.pg.paytm.request.innerstruct;

import com.techsocialist.plugin.pg.api.request.paytm.innerstruct.IFilter;

public class Filter implements IFilter {

    private String bankCode;

    private String cardType;

    @Override
    public IFilter setBankCode(String bankCode) {
        this.bankCode = bankCode;
        return this;
    }

    @Override
    public IFilter setCardType(String cardType) {
        this.cardType = cardType;
        return this;
    }

    @Override
    public String getBankCode() {
        return this.bankCode;
    }

    @Override
    public String getCardType() {
        return this.cardType;
    }
}
