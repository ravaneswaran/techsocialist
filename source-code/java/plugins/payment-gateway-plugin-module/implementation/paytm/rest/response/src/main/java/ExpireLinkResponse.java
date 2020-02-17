import com.google.gson.annotations.SerializedName;
import com.techsocialist.plugin.pg.paytm.response.body.ExpireLinkResponseBody;
import com.techsocialist.plugin.pg.paytm.response.head.ExpireLinkResponseHead;

public class ExpireLinkResponse extends AbstractPaytmResponse {

    @SerializedName("head")
    private ExpireLinkResponseHead expireLinkResponseHead;

    @SerializedName("body")
    private ExpireLinkResponseBody expireLinkResponseBody;

    public ExpireLinkResponseHead getExpireLinkResponseHead() {
        return expireLinkResponseHead;
    }

    public ExpireLinkResponseBody getExpireLinkResponseBody() {
        return expireLinkResponseBody;
    }

    @Override
    public boolean ok() {
        return this.getExpireLinkResponseBody().ok();
    }
}
