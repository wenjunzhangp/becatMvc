package com.baozi.view;

import org.springframework.web.servlet.view.InternalResourceView;

import java.io.File;
import java.util.Locale;

public class HtmlResourceView extends InternalResourceView {

    @Override
    public boolean checkResource(Locale locale) {
        File file = new File(this.getServletContext().getRealPath("/") + getUrl());
        return file.exists();
    }
}
