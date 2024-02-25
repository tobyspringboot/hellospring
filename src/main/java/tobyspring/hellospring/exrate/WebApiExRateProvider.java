package tobyspring.hellospring.exrate;

import tobyspring.hellospring.api.ApiTemplate;
import tobyspring.hellospring.api.ErApiExtractor;
import tobyspring.hellospring.api.HttpClientApiExecutor;
import tobyspring.hellospring.payment.ExRateProvider;

import java.math.BigDecimal;


public class WebApiExRateProvider implements ExRateProvider {
    private final ApiTemplate apiTemplate = new ApiTemplate();

    @Override
    public BigDecimal getExRate(String currency) {
        String url = "https://open.er-api.com/v6/latest/" + currency;

        return apiTemplate.getForExRate(url, new HttpClientApiExecutor(), new ErApiExtractor());
    }
}
