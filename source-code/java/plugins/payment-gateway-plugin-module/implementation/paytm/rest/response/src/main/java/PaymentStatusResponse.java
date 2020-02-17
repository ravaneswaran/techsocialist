import com.google.gson.annotations.SerializedName;
import com.techsocialist.plugin.pg.paytm.response.body.PaymentStatusResponseBody;
import com.techsocialist.plugin.pg.paytm.response.head.PaymentStatusResponseHead;

public class PaymentStatusResponse extends AbstractPaytmResponse{

    @SerializedName("head")
    private PaymentStatusResponseHead paymentStatusResponseHead;

    @SerializedName("body")
    private PaymentStatusResponseBody paymentStatusResponseBody;

    public PaymentStatusResponseHead getPaymentStatusResponseHead() {
        return paymentStatusResponseHead;
    }

    public PaymentStatusResponseBody getPaymentStatusResponseBody() {
        return paymentStatusResponseBody;
    }
}
