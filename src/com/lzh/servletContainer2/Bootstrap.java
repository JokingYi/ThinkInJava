package com.lzh.servletContainer2;

import com.lzh.servletContainer2.HttpConnector;

public final class Bootstrap {
  public static void main(String[] args) {
    HttpConnector connector = new HttpConnector();
    connector.start();
  }
}