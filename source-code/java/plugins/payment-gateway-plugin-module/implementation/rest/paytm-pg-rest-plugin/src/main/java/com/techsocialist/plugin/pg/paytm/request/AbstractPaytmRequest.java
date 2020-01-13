package com.techsocialist.plugin.pg.paytm.request;

import com.paytm.pgplus.signature.encryption.Encryption;
import com.paytm.pgplus.signature.encryption.EncryptionFactory;
import com.paytm.pgplus.signature.utility.CryptoUtils;
import org.json.JSONObject;

import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public abstract class AbstractPaytmRequest {

    private String merchantId;

    private String merchantKey;

    private String channelId = "WEB";

    private String orderId;

    private String version = "v1";

    private String clientId = "C11";

    private String transactionToken;

    public String dataAsJsonString(){
        return data().toString();
    }

    protected String getStagingUrlEndPointPrefix(){
        return "https://securegw-stage.paytm.in/theia/api";
    }

    protected String getProductionUrlEndPointPrefix(){
        return "https://securegw.paytm.in/theia/api";
    }

    public String getUrlEndPointPrefix(boolean production){
        return production ? getProductionUrlEndPointPrefix() : getStagingUrlEndPointPrefix();
    }

    public abstract String url(boolean production);

    public abstract JSONObject dataHead();

    public abstract JSONObject dataBody();

    public JSONObject data(){
        JSONObject paytmRequestData = new JSONObject();

        JSONObject head = dataHead();
        JSONObject body = dataBody();

        if(null != head){
            paytmRequestData.put("head", head);
        }

        if(null != body){
            paytmRequestData.put("body", body);
        }

        return paytmRequestData;
    }

    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public long getRequestTimestamp() {
        return System.currentTimeMillis();
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getTransactionToken() {
        return transactionToken;
    }

    public void setTransactionToken(String transactionToken) {
        this.transactionToken = transactionToken;
    }

    public String getMerchantKey() {
        return merchantKey;
    }

    public void setMerchantKey(String merchantKey) {
        this.merchantKey = merchantKey;
    }

    public String genrateCheckSum(String key, JSONObject jsonObject) throws Exception {
        StringBuilder response = getCheckSumString(jsonObject.toMap());
        String checkSumValue = null;

        try {
            Encryption encryption = EncryptionFactory.getEncryptionInstance("AES");
            String randomNo = CryptoUtils.generateRandomString(4);
            response.append(randomNo);
            String checkSumHash = CryptoUtils.getSHA256(response.toString());
            checkSumHash = checkSumHash.concat(randomNo);
            System.out.println("-----------------------------1");
            System.out.println(checkSumHash);
            System.out.println("-----------------------------2");
            checkSumValue = encryption.encrypt(checkSumHash, key.getBytes());
            if (checkSumValue != null) {
                checkSumValue = checkSumValue.replaceAll("\r\n", "");
                checkSumValue = checkSumValue.replaceAll("\r", "");
                checkSumValue = checkSumValue.replaceAll("\n", "");
            }
        } catch (SecurityException se) {
            se.printStackTrace();
        }

        return checkSumValue;
    }

    public StringBuilder getCheckSumString(Map<String, Object> paramMap) throws Exception {
        Set<String> keys = paramMap.keySet();
        StringBuilder checkSumStringBuffer = new StringBuilder("");
        TreeSet<String> parameterSet = new TreeSet();
        Iterator iterator = keys.iterator();

        while(iterator.hasNext()) {
            String paramName = (String)iterator.next();
            if (!"CHECKSUMHASH".equalsIgnoreCase(paramName)) {
                parameterSet.add(paramName);
            }
        }

        for(iterator = parameterSet.iterator(); iterator.hasNext(); ) {
            String paramName = (String)iterator.next();
            //value = (String)paramMap.get(paramName);
            String value = String.valueOf(paramMap.get(paramName));
            if (value == null || value.trim().equalsIgnoreCase("NULL")) {
                value = "";
            }
            System.out.println(String.format("%s : %s",paramName, value));
            checkSumStringBuffer.append(value).append("|");
        }

        return checkSumStringBuffer;
    }
}
