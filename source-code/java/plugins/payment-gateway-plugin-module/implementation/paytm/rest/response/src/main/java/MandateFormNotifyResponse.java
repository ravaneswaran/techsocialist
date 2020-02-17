import com.google.gson.annotations.SerializedName;
import com.techsocialist.plugin.pg.paytm.response.body.MandateFormNotifyResponseBody;
import com.techsocialist.plugin.pg.paytm.response.head.MandateFormNotifyResponseHead;

public class MandateFormNotifyResponse extends AbstractPaytmResponse {

    @SerializedName("com/techsocialist/plugin/pg/paytm/response/head")
    private MandateFormNotifyResponseHead mandateFormNotifyResponseHead;

    @SerializedName("com/techsocialist/plugin/pg/paytm/response/body")
    private MandateFormNotifyResponseBody mandateFormNotifyResponseBody;

    public MandateFormNotifyResponseHead getMandateFormNotifyResponseHead() {
        return mandateFormNotifyResponseHead;
    }

    public MandateFormNotifyResponseBody getMandateFormNotifyResponseBody() {
        return mandateFormNotifyResponseBody;
    }
}
