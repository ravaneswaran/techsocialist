import com.google.gson.annotations.SerializedName;
import com.techsocialist.plugin.pg.paytm.response.body.InitiateSubscriptionResponseBody;
import com.techsocialist.plugin.pg.paytm.response.head.InitiateSubscriptionResponseHead;

public class InitiateSubscriptionResponse extends AbstractPaytmResponse {

    @SerializedName("head")
    private InitiateSubscriptionResponseHead initiateSubscriptionResponseHead;

    @SerializedName("body")
    private InitiateSubscriptionResponseBody initiateSubscriptionResponseBody;

    public InitiateSubscriptionResponseHead getInitiateSubscriptionResponseHead() {
        return initiateSubscriptionResponseHead;
    }

    public InitiateSubscriptionResponseBody getInitiateSubscriptionResponseBody() {
        return initiateSubscriptionResponseBody;
    }
}
