import com.google.gson.annotations.SerializedName;
import com.techsocialist.plugin.pg.paytm.response.body.RefundStatusResponseBody;
import com.techsocialist.plugin.pg.paytm.response.head.RefundStatusResponseHead;

public class RefundStatusResponse extends AbstractPaytmResponse {

    @SerializedName("com/techsocialist/plugin/pg/paytm/response/head")
    private RefundStatusResponseHead refundStatusResponseHead;

    @SerializedName("com/techsocialist/plugin/pg/paytm/response/body")
    private RefundStatusResponseBody refundStatusResponseBody;

    public RefundStatusResponseHead getRefundStatusResponseHead() {
        return refundStatusResponseHead;
    }

    public RefundStatusResponseBody getRefundStatusResponseBody() {
        return refundStatusResponseBody;
    }
}
