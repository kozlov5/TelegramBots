import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;

//TODO remove
public class TestBot extends TelegramLongPollingBot {


    @Override
    public void onUpdateReceived(Update update) {

    }

    @Override
    public String getBotUsername() {
        return "realestate-devbot";
    }

    @Override
    public String getBotToken() {
        return "589670221:AAEOcdGjKi4YVeAdSAiVbrVQ7RAO1HcfnP4";
    }
}
