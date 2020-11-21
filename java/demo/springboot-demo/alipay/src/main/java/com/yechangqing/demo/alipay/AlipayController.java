package com.yechangqing.demo.alipay;

import com.alibaba.fastjson.JSON;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;

@RestController
public class AlipayController {

  private final static Logger logger = LoggerFactory.getLogger(AlipayController.class);

  private final String serverUrl = "https://openapi.alipaydev.com/gateway.do";

  private final String appId = "2016110200786683";
  private final String privateKey =
    "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQCzLqFHSSjvwFp6tO6AnairN9Y3/QVNsVoss" +
      "+B8CEtjwL3acMK+mMK" +
      "+LELrGZ44QLf78sTg0f1ljFoHBAN07E7lgRiICMGJjejEF42PQZzCiMkqdPtFba474MwzaHyjjL2xb3ZuTLKLi7NQYgL5PxuHWLmFx4+ILEj2fPdf13gjcty3JxxjvQqlaXbBDt4XmeLn8ThyG4LGD4eBrFakvsZifHsQBcpWpHSNV7g9at2F5neP3sczPwcpNAjqe5biq+iWdvXS68BeQyIe8IEKk6W/pmn4+jRebvXpRXPBqwnaT4p9Iptgi3sv/wBGRxHexsNqxUc3xtClvl+MJ9tS84bTAgMBAAECggEAex4UNS4g0bQCt4OwyXELHzKLoAbb6Qluo36pRbBRVOZvzTNjrKC8Vv2EsZP1skNN5/Fks/G1wlvQ1Dc+xM1GXM36dCZIDWMTyAFDBGcZ9lUUnHaq3IbDjGMnDD/EPICNKukioCFVIStJd3cRAgAJw1MEjtaTWgbLz4oIU7Ny2i9/YJYBss6FFa8UE3BrzMZKPV8cWR6akTFI9AJpROglpxBVh3+E7txZdlTgRqGSrKs3/1pLDkf3stSjgggBn7grt2vpeSoXC8b6drCNagqT+ugffIbVepVVMwp+dIitNfZEBqXlfe0xzEu1kW6Y5ABR4aFFqYpo//UOBUhi+Afh2QKBgQDt+erpVPIcoJnzcOIeuoLeNfJU9ZvCjdrnfDxxOrTEEtCMz9CB7rqCW/1g6vnuO8DvLH1Egv9LDEyK0fWsWVpA9cdBjN7nQ8yexsYI/zojX/c3fHCKNj30f3pIyld2DhFNwlFRrTrgoNJXepr9MRJoMxTCI/RMNohZAksDsxYMDQKBgQDAwMNqNuYgleD5DTyyvHdYLOQzAxjCC6ua5Ee/Tlhg/kTAL7ok1TebTL8x2u1E3q2yCHcVKJUoRr5mT855tVPXTd6ppG3MYwgO8NdnuxPvu5qmRMQvjXEdvrqWb0dVVs5RNpRvZgSgKuTzK9mAerEq73MgS5jhR4BONnY4rn/GXwKBgAqE/qZb0+wCCWwidExpcDmEZvbseHssLB4Jdt6GetEkB8YBtbTYqbPzfwrWuD+Yspmf/NWXeNOHcqa8S0DYHk46zxkNshjE/XmTTdO9/ILtzg7M2Gizpx90tyIal60nSAqI6XFT2ANv+HxXdhx1G9wxTdybHER2MKbGnCxIsVPNAoGAakceuCay9k6Nb+TLjeV6jEScQkA3224h3VJ2+NVSx5ALCkiGgx6I/XjwhqWmY23AKcSfHCx3KXDwNGtWdibzpmgKGFFQNPx5iftjWY9965XuLDUIUwvSzcrHCIEsvLITKhZE+7MtY76i5C1OTJfZrcm/GZR1I+mPphBDWPdl/lMCgYBCjnsR1XE+f8MazSC1L8durW8roZJI+uaNiH7p+zSkU1HnsbBGziqEffaIjNS0NZXKjvAOd0RWsuT9ksIiCovbsg7WVig8s3gs1go6RbkplzzMlqT9wwr3PTH+sXYWHXY88uCXVf10HwJTnmTlbcDy08+M8x3xZ5Xumv/uDMA5HQ==";

  private final String alipayPublicKey =
    "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAk36FFbOjT42nBaBy8cZi1Jtmr4oMQR8U20cUSrP2V0dTHhcPn/O1QIoffyWVFiVxky8iRolJP7ZpGHbaAxtDNnFxNDr1RyU9U71I66qp3YZin9Z8n4jlYFdkyb1s2XKtfYRYHS+Yv8P6BY6TgmAwJb9yUH9wPqfEvwaLhQVKiqvLetRMNzTjFmVcVQ3fARbHzPYh10Ppry70HWPq1Wy+9tl8F6B/4XNs9j9o9F2RY2XTC+ZWxFYTGJVBduzfRQrFupp8iOw6VKddkoWc4dAc1waCIJv+KnE1qgBrdk0fSsSXqBeebn0CQKsz7Ur0qCxqrVT5OvW0j/HYxgQaesYY0wIDAQAB";

  @GetMapping("pay")
  public void pay(HttpServletResponse httpResponse) throws AlipayApiException, IOException {
    AlipayClient alipayClient = new DefaultAlipayClient(serverUrl, appId, privateKey, "json",
      "utf-8", alipayPublicKey, "RSA2");
    AlipayTradePagePayRequest request = new AlipayTradePagePayRequest();
    var content = new AlipayTradePagePayBizContent();

    content.setOutTradeNo("" + System.currentTimeMillis());
    content.setSubject("测试应用");
    content.setProductCode("FAST_INSTANT_TRADE_PAY");
    content.setTotalAmount(BigDecimal.valueOf(0.01));
    var contentJson = JSON.toJSONString(content);
    request.setBizContent(contentJson);
    var response = alipayClient.pageExecute(request);
    var form = response.getBody();
     httpResponse.setContentType("text/html;charset=utf-8");
    httpResponse.getWriter().write(form);
    httpResponse.getWriter().flush();
    httpResponse.getWriter().close();
  }

}
