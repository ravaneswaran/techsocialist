import com.google.gson.annotations.SerializedName;
import com.techsocialist.plugin.pg.paytm.response.body.MandateFormUploadResponseBody;
import com.techsocialist.plugin.pg.paytm.response.head.MandateFormUploadResponseHead;

public class MandateFormUploadResponse extends AbstractPaytmResponse {

    @SerializedName("com/techsocialist/plugin/pg/paytm/response/head")
    private MandateFormUploadResponseHead mandateFormUploadResponseHead;

    @SerializedName("com/techsocialist/plugin/pg/paytm/response/body")
    private MandateFormUploadResponseBody mandateFormUploadResponseBody;

    public MandateFormUploadResponseHead getMandateFormUploadResponseHead() {
        return mandateFormUploadResponseHead;
    }

    public MandateFormUploadResponseBody getMandateFormUploadResponseBody() {
        return mandateFormUploadResponseBody;
    }
}
