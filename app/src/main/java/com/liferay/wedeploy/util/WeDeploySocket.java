package com.liferay.wedeploy.util;

import android.content.Context;
import android.util.Log;
import io.socket.client.IO;
import io.socket.client.Manager;
import io.socket.client.Socket;
import io.socket.emitter.Emitter;
import java.net.URISyntaxException;

/**
 * @author Albertinin Santos
 */
public class WeDeploySocket {
	private Socket socket;
	private IO.Options opts;

	public WeDeploySocket(Context context) throws URISyntaxException {
		opts = new IO.Options();
		opts.forceNew = false;
		opts.transports = new String[] { "websocket" };
		opts.query = "accessToken=" + PreferencesUtil.Companion.getStringByToken(context, KeysConstants.TOKEN);
		socket = IO.socket("https://api.wedeploy.com/subscribe/user/projects", opts);
	}

	public void connect() {
		socket.connect();
	}

	public void disconnect() {
		socket.disconnect();
	}

	public WeDeploySocket onChanges(Emitter.Listener listener) {
		socket.on("changes", listener);
		return this;
	}

	public WeDeploySocket onConnect(Emitter.Listener listener) {
		socket.on("connect", listener);
		Log.d("connected", "connected");
		return this;
	}

	public WeDeploySocket onDisconnect(Emitter.Listener listener) {
		socket.on("disconnect", listener);
		return this;
	}

	public WeDeploySocket onError(Emitter.Listener listener) {
		socket.on("error", listener);
		return this;
	}

	public WeDeploySocket onEventTransport(Emitter.Listener listener) {
		socket.on(Manager.EVENT_TRANSPORT, listener);
		return this;
	}
}
