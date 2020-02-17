import com.google.gson.annotations.SerializedName;
import com.techsocialist.plugin.pg.paytm.response.body.MandateFormDownloadResponseBody;
import com.techsocialist.plugin.pg.paytm.response.head.MandateFormDownloadResponseHead;

public class MandateFormDownloadResponse extends AbstractPaytmResponse {

    @SerializedName("com/techsocialist/plugin/pg/paytm/response/head")
    private MandateFormDownloadResponseHead mandateFormDownloadResponseHead;

    @SerializedName("com/techsocialist/plugin/pg/paytm/response/body")
    private MandateFormDownloadResponseBody mandateFormDownloadResponseBody;

    public MandateFormDownloadResponseHead getMandateFormDownloadResponseHead() {
        return mandateFormDownloadResponseHead;
    }

    public MandateFormDownloadResponseBody getMandateFormDownloadResponseBody() {
        return mandateFormDownloadResponseBody;
    }

    @Override
    public boolean ok() {
        return this.getMandateFormDownloadResponseBody().ok();
    }
}
