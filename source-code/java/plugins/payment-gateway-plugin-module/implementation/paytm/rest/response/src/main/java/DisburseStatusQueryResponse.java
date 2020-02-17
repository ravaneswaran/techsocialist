import com.google.gson.annotations.SerializedName;
import com.techsocialist.plugin.pg.paytm.response.body.DisburseStatusQueryResponseBody;
import com.techsocialist.plugin.pg.paytm.response.head.DisburseStatusQueryResponseHead;

public class DisburseStatusQueryResponse extends AbstractPaytmResponse {

    @SerializedName("head")
    private DisburseStatusQueryResponseHead disburseStatusQueryResponseHead;

    @SerializedName("body")
    private DisburseStatusQueryResponseBody disburseStatusQueryResponseBody;

    public DisburseStatusQueryResponseHead getDisburseStatusQueryResponseHead() {
        return disburseStatusQueryResponseHead;
    }

    public DisburseStatusQueryResponseBody getDisburseStatusQueryResponseBody() {
        return disburseStatusQueryResponseBody;
    }
}
