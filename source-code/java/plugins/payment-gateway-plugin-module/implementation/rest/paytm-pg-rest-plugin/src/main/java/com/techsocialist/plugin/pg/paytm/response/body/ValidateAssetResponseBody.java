package com.techsocialist.plugin.pg.paytm.response.body;

public class ValidateAssetResponseBody extends AbstractPaytmResponseBody {

    @Override
    public boolean ok() {
        return "1".equals(this.getResultInfo().getResultCode());
    }
}
