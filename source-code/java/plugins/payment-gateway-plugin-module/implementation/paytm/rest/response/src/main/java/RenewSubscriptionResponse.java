import com.google.gson.annotations.SerializedName;
import com.techsocialist.plugin.pg.paytm.response.body.RenewSubscriptionResponseBody;
import com.techsocialist.plugin.pg.paytm.response.head.RenewSubscriptionResponseHead;

public class RenewSubscriptionResponse extends AbstractPaytmResponse {

    @SerializedName("head")
    private RenewSubscriptionResponseHead renewSubscriptionResponseHead;

    @SerializedName("body")
    private RenewSubscriptionResponseBody renewSubscriptionResponseBody;

    public RenewSubscriptionResponseHead getRenewSubscriptionResponseHead() {
        return renewSubscriptionResponseHead;
    }

    public RenewSubscriptionResponseBody getRenewSubscriptionResponseBody() {
        return renewSubscriptionResponseBody;
    }

    @Override
    public boolean ok() {
        return this.renewSubscriptionResponseBody.ok();
    }
}