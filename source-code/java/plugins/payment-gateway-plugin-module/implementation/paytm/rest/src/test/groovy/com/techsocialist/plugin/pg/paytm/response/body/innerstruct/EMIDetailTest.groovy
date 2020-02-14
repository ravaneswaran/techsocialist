package com.techsocialist.plugin.pg.paytm.response.body.innerstruct

import spock.lang.Specification

class EMIDetailTest extends Specification{

    def "test EMIDetail -> emiChannelInfos"(){

        setup:
        def emiChannelInfos = ["channel1", "channel2"]
        EMIDetail emiDetail = new EMIDetail(emiChannelInfos, true)

        when:
        String result = emiDetail.getEmiChannelInfos()

        then:
        null != result && result.size() > 0
    }


    def "test EMIDetail -> isHybridDisabled"(){

        setup:
        def emiChannelInfos = ["channel1", "channel2"]
        EMIDetail emiDetail = new EMIDetail(emiChannelInfos: emiChannelInfos, isHybridDisabled: true)

        when:
        boolean result = emiDetail.isHybridDisabled()

        then:
        true == result
    }
}
