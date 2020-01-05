package com.hemalatha.okhttp;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import okio.ByteString;

public class WebsocketClient {

	private static OkHttpClient okHttpClient = new OkHttpClient();
	public static void main(String[] args) throws InterruptedException {
		Request requestCoinPrice = new Request.Builder().url("wss://ws-feed.gdax.com").build();

		WebSocketListener webSocketListener = new WebSocketListener() {
			@Override
			public void onOpen(WebSocket webSocket, Response response) {
				webSocket.send("{"+
						"  \"type\":\"subscribe\"," +
						"  \"channels\":[{\"name\":\"ticker\",\"product_ids\":[\"ETH-USD\"]}]"+"}");
			}

			@Override
			public void onMessage(WebSocket webSocket, String text) {
				System.out.println("onTextMessage: "+text);
			}

			@Override
			public void onMessage(WebSocket webSocket, ByteString bytes) {
				System.out.println("onByteMessage "+ bytes);
			}

			@Override
			public void onClosing(WebSocket webSocket, int code, String reason) {
				System.out.println("onClosing "+reason);
			}

			@Override
			public void onClosed(WebSocket webSocket, int code, String reason) {
				System.out.println("onClosed "+reason);
			}

			@Override
			public void onFailure(WebSocket webSocket, Throwable t, Response response) {
				System.out.println("onFailure "+t);
			}
		};

//		ExecutorService executorService = Executors.newFixedThreadPool(2);
//		Callable c = ()->{
//			System.out.println(Thread.currentThread().getName() +" Running");
//			okHttpClient.newWebSocket(requestCoinPrice, webSocketListener);
//			okHttpClient.dispatcher().executorService().shutdown();
//			return 0;
//		};
//	executorService.invokeAll(Collections.synchronizedCollection(Arrays.asList(c,c)));
//		executorService.shutdown();
		okHttpClient.newWebSocket(requestCoinPrice, webSocketListener);
		okHttpClient.dispatcher().executorService().shutdown();

	}
}
