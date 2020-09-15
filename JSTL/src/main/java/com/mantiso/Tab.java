package com.mantiso;

public class Tab
{
    private String url;
    private String name;

    public Tab(String name, String url)
    {
        this.url = url;
        this.name = name;
    }

    @Override
    public String toString()
    {
        return "Tab{" +
                "url='" + url + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    public String getUrl()
    {
        return url;
    }

    public void setUrl(String url)
    {
        this.url = url;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }
}
