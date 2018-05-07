import org.telegram.telegrambots.ApiContext;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import java.net.Authenticator;
import java.net.PasswordAuthentication;

public class RealEstateBotApplication {

    private static String PROXY_HOST = "148.251.99.150" /* proxy host */;
    private static Integer PROXY_PORT = 8080 /* proxy port */;
    private static String PROXY_USER = "fuckrkn" /* proxy user */;
    private static String PROXY_PASSWORD = "navalny2018" /* proxy password */;


    public static void main(String[] args) {
        try {

            ApiContextInitializer.init();
            System.getProperties().put( "socksProxyHost", PROXY_HOST);
            System.getProperties().put( "socksProxyPort", PROXY_PORT);

            Authenticator.setDefault(new Authenticator(){
                protected PasswordAuthentication getPasswordAuthentication(){
                    return new PasswordAuthentication(PROXY_USER, PROXY_PASSWORD.toCharArray());
                }
            });

            TelegramBotsApi botsApi = new TelegramBotsApi();

            DefaultBotOptions botOptions = ApiContext.getInstance(DefaultBotOptions.class);

            TestBot testBot = new TestBot();
            testBot.getOptions().setProxyHost(PROXY_HOST);
            testBot.getOptions().setProxyPort(PROXY_PORT);
            testBot.getOptions().setProxyType(DefaultBotOptions.ProxyType.SOCKS5);


           /* // Create the TelegramBotsApi object to register your bots


            // Set up Http proxy

            HttpHost httpHost = new HttpHost(PROXY_HOST, PROXY_PORT);

            RequestConfig requestConfig = RequestConfig.custom().setProxy(httpHost).setAuthenticationEnabled(false).build();
            botOptions.setRequestConfig(requestConfig);
            botOptions.setHttpProxy(httpHost);*/

            // Register your newly created AbilityBot

            botsApi.registerBot(testBot);

        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
