import com.google.gson.annotations.SerializedName;
import com.techsocialist.plugin.pg.paytm.response.body.RefundResponseBody;
import com.techsocialist.plugin.pg.paytm.response.head.RefundResponseHead;

public class RefundResponse extends AbstractPaytmResponse{

    @SerializedName("head")
    private RefundResponseHead refundResponseHead;

    @SerializedName("body")
    private RefundResponseBody refundResponseBody;

    public RefundResponseHead getRefundResponseHead() {
        return refundResponseHead;
    }

    public RefundResponseBody getRefundResponseBody() {
        return refundResponseBody;
    }
}
