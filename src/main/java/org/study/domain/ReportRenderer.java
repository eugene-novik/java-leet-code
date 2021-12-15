package org.study.domain;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

public class ReportRenderer {
  public static final int FORMAT_CSV = 1;
  public static final int FORMAT_XML = 2;
  public static final int FORMAT_HTML = 3;

  private int format;
  private boolean removeLineEndings;
  private boolean writeBom;
  private String reportName;
  private String title;

  private OutputStream tempFile;

  public ReportRenderer(int format, boolean removeLineEndings, boolean writeBom, String reportName, String title) {
    this.format = format;
    this.removeLineEndings = removeLineEndings;
    this.writeBom = writeBom;
    this.reportName = reportName;
    this.title = title;
    begin();
  }

  private void begin() {
    try {
      tempFile = new FileOutputStream(File.createTempFile("temp-file-name", ".tmp"));
      if (writeBom) {
        //assume unique logic here
      }
      writeTitle();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void writeTitle() {
    switch (format) {
      case FORMAT_CSV:
        //assume unique logic is implemented here
        break;
      case FORMAT_XML:
        //assume unique logic is implemented here
        break;
      case FORMAT_HTML:
        //assume unique logic is implemented here
        break;
    }
  }

  public void writeHeader(List<String> headers) {
    if (removeLineEndings) {
      //assume unique logic is implemented here
    }
    switch (format) {
      case FORMAT_CSV:
        //assume unique logic is implemented here
        break;
      case FORMAT_XML:
        //assume unique logic is implemented here
        break;
      case FORMAT_HTML:
        //assume unique logic is implemented here
        break;
    }
  }

  public void writeRow(List<String> rowValues) {
    if (removeLineEndings) {
      //assume unique logic is implemented here
    }
    if (rowValues != null) {
      switch (format) {
        case FORMAT_CSV:
          //assume unique logic is implemented here
          break;
        case FORMAT_XML:
          //assume unique logic is implemented here
          break;
        case FORMAT_HTML:
          //assume unique logic is implemented here
          break;
      }
    }
  }

  public String getExtension() {
    switch (format) {
      case FORMAT_CSV:
        return "csv";
      case FORMAT_XML:
        return "xml";
      case FORMAT_HTML:
        return "html";
    }
    return null;
  }

  public void finish() {
    OutputStream outputStream = null;
    try {
      outputStream = new FileOutputStream(new File("report-storage", reportName + '.' + getExtension()));
      //assume unique logic is implemented here
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } finally {
      if (outputStream != null) {
        try {
          outputStream.close();
        } catch (IOException e) {
        }

        try {
          tempFile.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }
  }

}
