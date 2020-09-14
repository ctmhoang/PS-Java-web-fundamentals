package com.mantiso;

public class ApplicationSettings
{
    private CssClass _formCssClass;
    private String[] _tabNames;

    public String[] getTabNames()
    {
        return _tabNames;
    }

    public void setTabNames(String[] _tabName)
    {
        this._tabNames = _tabName;
    }

    public CssClass getFormCssClass()
    {
        return _formCssClass;
    }

    public void setFormCssClass(CssClass formCssClass)
    {
        this._formCssClass = formCssClass;
    }
}
