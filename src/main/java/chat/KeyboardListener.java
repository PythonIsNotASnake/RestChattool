package chat;

import model.ChatHistory;
import retrofit2.Call;

import javax.swing.JTextArea;
import java.io.IOException;

public class KeyboardListener implements InputListener {

	private JTextArea textArea;
	private String nick;
	
	public KeyboardListener(JTextArea textArea, String nick) {
		this.textArea = textArea;
		this.nick = nick;
	}
	
	@Override
	public void inputReceived(String str) {
		IChat service = Globals.getInstance().getRetrofit().create(IChat.class);
		String message = "<" + nick + "> " + str;
		Call<ChatHistory> call = service.postMessage(message);
		try {
			ChatHistory chat = call.execute().body();
			textArea.setText(chat.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
