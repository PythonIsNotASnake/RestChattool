package chat;

import model.ChatHistory;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface IChat {

    @GET("/chat")
    Call<ChatHistory> getChat();

    @POST("/chat/{message}")
    Call<ChatHistory> postMessage(@Path("message") String message);
}
