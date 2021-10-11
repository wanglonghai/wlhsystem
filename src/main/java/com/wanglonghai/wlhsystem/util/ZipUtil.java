package com.wanglonghai.wlhsystem.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class ZipUtil {

  public static String compress(String str) throws IOException {

    if (str == null || str.length() == 0) {

      return str;

    }

    ByteArrayOutputStream out = new ByteArrayOutputStream();

    GZIPOutputStream gzip = new GZIPOutputStream(out);

    gzip.write(str.getBytes());

    gzip.close();

    return out.toString("ISO-8859-1");

  }

  public static String uncompress(String str) throws IOException {

    if (str == null || str.length() == 0) {

      return str;

    }

    ByteArrayOutputStream out = new ByteArrayOutputStream();

    ByteArrayInputStream in = new ByteArrayInputStream(str

        .getBytes("ISO-8859-1"));

    GZIPInputStream gunzip = new GZIPInputStream(in);

    byte[] buffer = new byte[256];

    int n;

    while ((n = gunzip.read(buffer)) >= 0) {

      out.write(buffer, 0, n);

    }

    return out.toString();

  }

  public static void main(String[] args) throws IOException {



  String str="?userId=650&userType=VISITOR_BIND&uuid=4e366f78-6873-e618-49ca-ef05e6ea08ed&token=eyJhbGciOiJIUzI1NiJ9.eyJMT0dJTl9VU0VSX0tFWSI6ImQ2YzNlNWQxLWQxOTctNGVhZC1iNGVlLTliODVhNzk3OTkxMiJ9.OMNryPEk_OVh0b4FXoCZIi1yOQU7sHqvWxRIXagND3s";



  System.out.println("原长度："+str.length()); 



  System.out.println("压缩后："+ZipUtil.compress(str));



    System.out.println("解压缩："+ZipUtil.uncompress(ZipUtil.compress(str)));

  }

}