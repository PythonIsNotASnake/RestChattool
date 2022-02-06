package model;

import java.util.ArrayList;
import java.util.List;

public class ChatHistory {

    private List<String> chatHistory;

    public ChatHistory() {
        this.chatHistory = new ArrayList<String>();
    }

    public List<String> getChatHistory() {
        return chatHistory;
    }

    public void setChatHistory(List<String> chatHistory) {
        this.chatHistory = chatHistory;
    }

    @Override
    public String toString() {
        String str = "";
        for (int i = 0; i < chatHistory.size(); i++) {
            str = str + chatHistory.get(i).toString() + System.getProperty("line.separator");
        }
        return str;
    }
}
