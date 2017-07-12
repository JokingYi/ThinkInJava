package com.lzh.servletContainer2;

import com.lzh.servletContainer2.HttpRequest;
import com.lzh.servletContainer2.HttpResponse;
import java.io.IOException;

public class StaticResourceProcessor {

  public void process(HttpRequest request, HttpResponse response) {
    try {
      response.sendStaticResource();
    }
    catch (IOException e) {
      e.printStackTrace();
    }
  }

}
