import com.google.gson.annotations.SerializedName;
import com.techsocialist.plugin.pg.paytm.response.body.FetchSubscriptionStatusResponseBody;
import com.techsocialist.plugin.pg.paytm.response.head.FetchSubscriptionStatusResponseHead;

public class FetchSubscriptionStatusResponse extends AbstractPaytmResponse {

    @SerializedName("head")
    private FetchSubscriptionStatusResponseHead fetchSubscriptionStatusResponseHead;

    @SerializedName("body")
    private FetchSubscriptionStatusResponseBody fetchSubscriptionStatusResponseBody;

    public FetchSubscriptionStatusResponseHead getFetchSubscriptionStatusResponseHead() {
        return fetchSubscriptionStatusResponseHead;
    }

    public FetchSubscriptionStatusResponseBody getFetchSubscriptionStatusResponseBody() {
        return fetchSubscriptionStatusResponseBody;
    }
}
