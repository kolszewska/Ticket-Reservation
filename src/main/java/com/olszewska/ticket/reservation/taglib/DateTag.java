package com.olszewska.ticket.reservation.taglib;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class DateTag extends SimpleTagSupport {

    private Timestamp date;

    public void setDate(Timestamp dateProvided) {
        this.date = dateProvided;
    }

    public void doTag() throws JspException, IOException {
        if (date != null) {
            String formattedDate = new SimpleDateFormat("YYYY-MM-dd HH:mm").format(date);
            JspWriter out = getJspContext().getOut();
            out.println(formattedDate);
        }
    }
}
