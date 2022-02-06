package chat;

import model.ChatHistory;
import retrofit2.Call;

import javax.swing.*;
import java.io.IOException;

public class RestListener implements NetworkListener, Runnable{
    private JTextArea textArea;

    public RestListener(JTextArea textArea) {
        this.textArea = textArea;
    }

    @Override
    public void messageReceived(String msg) {
        textArea.setText(msg);
    }

    @Override
    public void run() {
        while(true) {
            IChat service = Globals.getInstance().getRetrofit().create(IChat.class);
            Call<ChatHistory> call = service.getChat();
            try {
                ChatHistory chat = call.execute().body();
                if(chat != null) {
                    messageReceived(chat.toString());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
