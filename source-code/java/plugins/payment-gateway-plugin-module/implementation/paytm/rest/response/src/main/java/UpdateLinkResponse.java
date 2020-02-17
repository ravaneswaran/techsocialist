import com.google.gson.annotations.SerializedName;
import com.techsocialist.plugin.pg.paytm.response.body.UpdateLinkResponseBody;
import com.techsocialist.plugin.pg.paytm.response.head.UpdateLinkResponseHead;

public class UpdateLinkResponse extends AbstractPaytmResponse {

    @SerializedName("com/techsocialist/plugin/pg/paytm/response/head")
    private UpdateLinkResponseHead updateLinkResponseHead;

    @SerializedName("com/techsocialist/plugin/pg/paytm/response/body")
    private UpdateLinkResponseBody updateLinkResponseBody;

    public UpdateLinkResponseHead getUpdateLinkResponseHead() {
        return updateLinkResponseHead;
    }

    public UpdateLinkResponseBody getUpdateLinkResponseBody() {
        return updateLinkResponseBody;
    }

    @Override
    public boolean ok() {
        return this.getUpdateLinkResponseBody().ok();
    }
}
