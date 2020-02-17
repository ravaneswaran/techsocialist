import com.google.gson.annotations.SerializedName;
import com.techsocialist.plugin.pg.paytm.response.body.WalletTransferResponseBody;
import com.techsocialist.plugin.pg.paytm.response.head.WalletTransferResponseHead;

public class WalletTransferResponse extends AbstractPaytmResponse {

    @SerializedName("com/techsocialist/plugin/pg/paytm/response/head")
    private WalletTransferResponseHead walletTransferResponseHead;

    @SerializedName("com/techsocialist/plugin/pg/paytm/response/body")
    private WalletTransferResponseBody walletTransferResponseBody;

    public WalletTransferResponseHead getWalletTransferResponseHead() {
        return walletTransferResponseHead;
    }

    public WalletTransferResponseBody getWalletTransferResponseBody() {
        return walletTransferResponseBody;
    }
}
