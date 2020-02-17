import com.google.gson.annotations.SerializedName;
import com.techsocialist.plugin.pg.paytm.response.body.TenuresEMISubventionResponseBody;
import com.techsocialist.plugin.pg.paytm.response.head.TenuresEMISubventionResponseHead;

public class TenuresEMISubventionResponse extends AbstractPaytmResponse {

    @SerializedName("com/techsocialist/plugin/pg/paytm/response/head")
    private TenuresEMISubventionResponseHead tenuresEMISubventionResponseHead;

    @SerializedName("com/techsocialist/plugin/pg/paytm/response/body")
    private TenuresEMISubventionResponseBody tenuresEMISubventionResponseBody;

    public TenuresEMISubventionResponseHead getTenuresEMISubventionResponseHead() {
        return tenuresEMISubventionResponseHead;
    }

    public TenuresEMISubventionResponseBody getTenuresEMISubventionResponseBody() {
        return tenuresEMISubventionResponseBody;
    }
}
