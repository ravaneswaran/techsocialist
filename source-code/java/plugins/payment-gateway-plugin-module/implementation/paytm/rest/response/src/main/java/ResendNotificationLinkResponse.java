import com.google.gson.annotations.SerializedName;
import com.techsocialist.plugin.pg.paytm.response.body.ResendNotificationLinkResponseBody;
import com.techsocialist.plugin.pg.paytm.response.head.ResendNotificationLinkResponseHead;

public class ResendNotificationLinkResponse extends AbstractPaytmResponse {

    @SerializedName("com/techsocialist/plugin/pg/paytm/response/head")
    private ResendNotificationLinkResponseHead resendNotificationLinkResponseHead;

    @SerializedName("com/techsocialist/plugin/pg/paytm/response/body")
    private ResendNotificationLinkResponseBody resendNotificationLinkResponseBody;

    public ResendNotificationLinkResponseHead getResendNotificationLinkResponseHead() {
        return resendNotificationLinkResponseHead;
    }

    public ResendNotificationLinkResponseBody getResendNotificationLinkResponseBody() {
        return resendNotificationLinkResponseBody;
    }

    @Override
    public boolean ok() {
        return this.getResendNotificationLinkResponseBody().ok();
    }
}
