package com.hemalatha.okhttp;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

public class OkHttpClientTest {

	private final OkHttpClient client = new OkHttpClient();
	public static void main(String[] args) throws Exception {
		System.out.println(getList().size());

        OkHttpClientTest test = new OkHttpClientTest();
        //test.downloadFile();
        //test.asynchronousGet();
		//test.retrieveHeaders();
		//test.uploadFile();
	}

	public static List<String> getList(){
		List<String> s = Arrays.asList("test","mark");
		return Optional.ofNullable(s).orElse(Collections.emptyList());
	}

	public void downloadFile() throws Exception{
		Request request = new Request.Builder()
				.url("https://publicobject.com/helloworld.txt")
				.build();

		try(Response response = client.newCall(request).execute()){
			if(!response.isSuccessful()) throw new IOException("Unexpected code "+ response);

			Headers responseHeaders = response.headers();
			IntStream.range(0,responseHeaders.size()).forEach(i -> {
				System.out.println(responseHeaders.name(i) +": "+responseHeaders.value(i));
			});

			System.out.println("Body: " + response.body().toString());
		}

	}

	public void asynchronousGet() {
		Request request = new Request.Builder()
				.url("https://publicobject.com/helloworld.txt")
				.build();

		client.newCall(request).enqueue(new Callback() {
			@Override
			public void onFailure(Call call, IOException e) {
				e.printStackTrace();
			}

			@Override
			public void onResponse(Call call, Response response) throws IOException {
                 try(ResponseBody responseBody = response.body()){
                 	if(!response.isSuccessful()) throw new IOException("Unexpected code "+ response);

					 Headers responseHeaders = response.headers();
					 IntStream.range(0,responseHeaders.size()).forEach(i -> {
						 System.out.println(responseHeaders.name(i) +": "+responseHeaders.value(i));
					 });

					 System.out.println("Body: " + response.body().toString());
				 }
			}
		});
	}

	public void retrieveHeaders(){
		Request request = new Request.Builder()
				.url("https://api.github.com/repos/square/okhttp/issues")
				.header("UserData-Agent", "OkHttp Headers.java")
				.addHeader("Accept", "application/json; q=0.5")
				.addHeader("Accept", "application/vnd.github.v3+json")
				.build();

		try(Response response = client.newCall(request).execute()) {
			if(!response.isSuccessful()) throw  new IOException("Unexpected code "+response);

			System.out.println("Server: "+ response.header("Server"));
			System.out.println("Date: "+response.header("Date"));
			System.out.println("Vary: "+response.headers("Vary"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void uploadFile(){

		final MediaType MEDIA_TYPE_MARKDOWN = MediaType.parse("text/x-markdown; charset=utf-8");
		File file = new File("/Users/helangovan/demos/voiceTech/src/main/resources/application2.properties");

		Request request = new Request.Builder()
				.url("https://api.github.com/markdown/raw")
				.post(RequestBody.create(MEDIA_TYPE_MARKDOWN, file))
				.build();

		try(Response response = client.newCall(request).execute()){
			if(!response.isSuccessful()) throw  new IOException("Unexpected code "+response);

			System.out.println("Response:" + response.body().string());
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
