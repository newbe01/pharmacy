package com.example.pharmacy.api.service

import com.example.pharmacy.AbstractIntegrationContainerBaseTest
import org.springframework.beans.factory.annotation.Autowired

class KakaoAddressSearchServiceTest extends AbstractIntegrationContainerBaseTest {

    @Autowired
    private KakaoAddressSearchService kakaoAddressSearchService

    def "address 파라미터 값이 null이면, requestAddressSearch method는 null 리턴"() {
        given:
        def address = null

        when:
        def result = kakaoAddressSearchService.requestAddressSearch(address)

        then:
        result == null

    }

    def "주소값이 valid하면, requestAddressSearch 정상 document 반환"() {
        given:
        def address = "서울 성북구 종암로 10길"

        when:
        def result = kakaoAddressSearchService.requestAddressSearch(address)

        then:
        result.documentList.size() > 0
        result.metaDto.totalCount > 0
        result.documentList.get(0).addressName != null
    }

}
