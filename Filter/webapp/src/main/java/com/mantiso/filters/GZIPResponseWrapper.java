package com.mantiso.filters;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.io.IOException;
import java.io.PrintWriter;

public class GZIPResponseWrapper extends HttpServletResponseWrapper
{
    protected  HttpServletResponse origRes = null;
    protected ServletOutputStream stream = null;
    protected PrintWriter writer = null;
    public GZIPResponseWrapper(HttpServletResponse response)
    {
        super(response);
        origRes = response;
    }

    public void finishResponse() throws IOException
    {
        if (writer != null) writer.close();
        else if (stream != null) stream.close();
    }

    @Override
    public ServletOutputStream getOutputStream() throws IOException
    {
        if(writer != null) throw new IllegalStateException("...");
        if (stream == null) return createOutputStream();
        return stream;
    }

    private ServletOutputStream createOutputStream() throws IOException
    {
        return new GZIPResponseStream(origRes);
    }

    @Override
    public PrintWriter getWriter() throws IOException
    {
        if (writer != null) return writer;
        else if (stream != null) throw new IllegalStateException("...");
        stream = createOutputStream();
        writer = new PrintWriter(stream);
        return writer;
    }

    @Override
    public void flushBuffer() throws IOException
    {
        stream.flush();
    }
}
