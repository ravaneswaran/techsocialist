import com.google.gson.annotations.SerializedName;
import com.techsocialist.plugin.pg.paytm.response.body.ExpireLinkResponseBody;
import com.techsocialist.plugin.pg.paytm.response.head.ExpireLinkResponseHead;

public class ExpireLinkResponse extends AbstractPaytmResponse {

    @SerializedName("com/techsocialist/plugin/pg/paytm/response/head")
    private ExpireLinkResponseHead expireLinkResponseHead;

    @SerializedName("com/techsocialist/plugin/pg/paytm/response/body")
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
