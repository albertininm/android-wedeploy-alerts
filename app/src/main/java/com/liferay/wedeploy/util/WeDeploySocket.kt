package com.liferay.wedeploy.util

import android.content.Context
import android.util.Log
import io.socket.client.IO
import io.socket.client.Manager
import io.socket.client.Socket
import io.socket.emitter.Emitter


/**
 * @author Albertinin Santos
 */

class WeDeploySocket (context: Context) {
    private val socket: Socket
    private val opts = IO.Options()

    init {
        opts.forceNew = false
        opts.transports = Array<String>(1){"websocket"}
        opts.query = "accessToken=" + PreferencesUtil.getStringByToken(context, KeysConstants.TOKEN)
        socket = IO.socket(Constants.SOCKET_URL, opts)
    }

    fun connect() {
        socket.connect()
    }

    fun disconnect() {
        socket.disconnect()
    }

    fun onConnect (listener: Emitter.Listener): WeDeploySocket {
        socket.on("connect", listener)
        Log.d("connected", "connected")
        return this
    }

    fun onChanges (listener: Emitter.Listener): WeDeploySocket {
        socket.on("changes", listener)
        Log.d("changes", "connected")
        return this
    }

    fun onDisconnect (listener: Emitter.Listener): WeDeploySocket {
        socket.on("disconnect", listener)
        Log.d("changes", "connected")
        return this
    }

    fun onError(listener: Emitter.Listener): WeDeploySocket {
        socket.on("error", listener)
        return this
    }

    fun onEventTransport(listener: Emitter.Listener): WeDeploySocket {
        socket.on(Manager.EVENT_TRANSPORT, listener)
        return this
    }
}