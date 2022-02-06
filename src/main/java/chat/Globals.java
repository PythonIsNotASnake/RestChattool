package chat;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;

public class Globals {

    private static final Globals instance = new Globals();
    private Retrofit retrofit;

    private Globals() {
        Gson gson = new GsonBuilder().setLenient().create();

        /*OkHttpClient okClient = new OkHttpClient.Builder()
                .addInterceptor(
                        new Interceptor() {
                            @Override
                            public Response intercept(Interceptor.Chain chain) throws IOException {
                                Request original = chain.request();

                                // Request customization: add request headers
                                Request.Builder requestBuilder = original.newBuilder()
                                        .method(original.method(), original.body());

                                Request request = requestBuilder.build();
                                return chain.proceed(request);
                            }
                        })
                .build();*/

        this.retrofit = new Retrofit.Builder().baseUrl("http://localhost:4567/").addConverterFactory(GsonConverterFactory.create(gson)).build();
    }

    public static Globals getInstance() {
        return instance;
    }

    public Retrofit getRetrofit() {
        return retrofit;
    }

}
