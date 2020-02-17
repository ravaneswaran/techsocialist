import com.google.gson.annotations.SerializedName;
import com.techsocialist.plugin.pg.paytm.response.body.CreateLinkResponseBody;
import com.techsocialist.plugin.pg.paytm.response.head.CreateLinkResponseHead;

public class CreateLinkResponse extends AbstractPaytmResponse {

    @SerializedName("head")
    private CreateLinkResponseHead createLinkResponseHead;

    @SerializedName("body")
    private CreateLinkResponseBody createLinkResponseBody;

    public CreateLinkResponseHead getCreateLinkResponseHead() {
        return createLinkResponseHead;
    }

    public CreateLinkResponseBody getCreateLinkResponseBody() {
        return createLinkResponseBody;
    }

    @Override
    public boolean ok() {
        return this.getCreateLinkResponseBody().ok();
    }
}
