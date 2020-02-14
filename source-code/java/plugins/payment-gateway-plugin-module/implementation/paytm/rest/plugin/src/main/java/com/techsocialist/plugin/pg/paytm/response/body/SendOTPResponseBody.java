package com.techsocialist.plugin.pg.paytm.response.body;

public class SendOTPResponseBody extends AbstractPaytmResponseBody {

    @Override
    public boolean ok() {
        return "01".equals(this.getResultInfo().getResultCode());
    }
}
