package com.mantiso.filters;

import javax.servlet.ServletOutputStream;
import javax.servlet.WriteListener;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.GZIPOutputStream;

public class GZIPResponseStream extends ServletOutputStream
{
    protected ByteArrayOutputStream baos = null;
    protected GZIPOutputStream gzipOutputStream = null;
    protected boolean closed = false;
    protected HttpServletResponse response = null;
    protected ServletOutputStream output = null;

    public GZIPResponseStream(HttpServletResponse origRes) throws IOException
    {
        super();
        this.response = origRes;
        this.output = origRes.getOutputStream();
        baos = new ByteArrayOutputStream();
        gzipOutputStream = new GZIPOutputStream(baos);
    }

    @Override
    public boolean isReady()
    {
        return false;
    }

    @Override
    public void setWriteListener(WriteListener writeListener)
    {

    }

    @Override
    public void write(int b) throws IOException
    {
        gzipOutputStream.write(b);
    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException
    {
        if (closed) throw new IOException("Cannot write to ops");
        gzipOutputStream.write(b, off, len);
    }

    @Override
    public void close() throws IOException
    {
        if (closed) throw new IOException("Cannot write to ops");
        gzipOutputStream.finish();

        byte[] bytes = baos.toByteArray();
        response.addHeader("Content-Encoding", "gzip");
        response.addHeader("Content-Length", Integer.toString(bytes.length));

        output.write(bytes);
        output.flush();
        output.close();

        closed = true;
    }
}

