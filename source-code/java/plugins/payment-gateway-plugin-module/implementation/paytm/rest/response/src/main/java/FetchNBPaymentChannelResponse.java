import com.google.gson.annotations.SerializedName;
import com.techsocialist.plugin.pg.paytm.response.body.FetchNBPaymentChannelResponseBody;
import com.techsocialist.plugin.pg.paytm.response.head.FetchNBPaymentChannelResponseHead;

public class FetchNBPaymentChannelResponse extends AbstractPaytmResponse {

    @SerializedName("head")
    private FetchNBPaymentChannelResponseHead fetchNBPaymentChannelResponseHead;

    @SerializedName("body")
    private FetchNBPaymentChannelResponseBody fetchNBPaymentChannelResponseBody;

    public FetchNBPaymentChannelResponseHead getFetchNBPaymentChannelResponseHead() {
        return fetchNBPaymentChannelResponseHead;
    }

    public FetchNBPaymentChannelResponseBody getFetchNBPaymentChannelResponseBody() {
        return fetchNBPaymentChannelResponseBody;
    }

    @Override
    public boolean ok() {
        return this.fetchNBPaymentChannelResponseBody.ok();
    }
}
