package com.techsocialist.plugin.pg.paytm.response.body;

public class FetchLinkResponseBody extends AbstractPaytmResponseBody {

    @Override
    public boolean ok() {
        return "200".equals(this.getResultInfo().getResultCode());
    }
}
