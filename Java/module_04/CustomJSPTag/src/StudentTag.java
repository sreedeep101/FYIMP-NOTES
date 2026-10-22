package beans;

import java.io.IOException;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class StudentTag extends SimpleTagSupport {

    private String name;
    private String course;
    private int mark;

    public void setName(String name) {
        this.name = name;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    @Override
    public void doTag() throws JspException, IOException {

        JspWriter out = getJspContext().getOut();

        out.println("<h3>Student Information</h3>");
        out.println("<p>Name: " + escapeHtml(name) + "</p>");
        out.println("<p>Course: " + escapeHtml(course) + "</p>");
        out.println("<p>Mark: " + mark + "</p>");

        if (mark >= 40) {
            out.println("<p>Result: Passed</p>");
        } else {
            out.println("<p>Result: Failed</p>");
        }
    }

    private String escapeHtml(String value) {
        if (value == null) {
            return "";
        }

        return value.replace("&", "&amp;")
                    .replace("<", "&lt;")
                    .replace(">", "&gt;")
                    .replace("\"", "&quot;")
                    .replace("'", "&#39;");
    }
}
