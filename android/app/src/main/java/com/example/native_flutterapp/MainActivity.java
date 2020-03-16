package com.example.native_flutterapp;


import io.flutter.embedding.android.FlutterActivity;

import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugins.GeneratedPluginRegistrant;

public class MainActivity extends FlutterActivity {


    final String CHANNEL = "flutter.native/helper";

  @java.lang.Override
  protected void onCreate(android.os.Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    GeneratedPluginRegistrant.registerWith(getFlutterEngine());
    new MethodChannel(getFlutterEngine().getDartExecutor().getBinaryMessenger(), CHANNEL).setMethodCallHandler(
            new MethodChannel.MethodCallHandler() {
              @Override
              public void onMethodCall(MethodCall call, MethodChannel.Result result) {
                if (call.method.equals("helloFromNativeCode")) {
                  String greetings = helloFromNativeCode();
                  result.success(greetings);
                }
              }});
  }

    //GeneratedPluginRegistrant.registerWith(flutterEngine);

  private String helloFromNativeCode() {
    return "Hello from Native Android Code";
  }
}
