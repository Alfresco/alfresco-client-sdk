package com.alfresco.client.api.core.model.parameters;

import java.util.ArrayList;
import java.util.List;

/**
 * Utility class to transform list of string to comma-separated value as
 * required by API
 */
public class FieldsParam
{
    private List<String> fieldValues = new ArrayList<>(0);

    public FieldsParam(List<String> fieldValues)
    {
        this.fieldValues = fieldValues;
    }

    public List<String> getValues()
    {
        return fieldValues;
    }

    public void setValues(List<String> fieldValues)
    {
        this.fieldValues = fieldValues;
    }

    @Override
    public String toString()
    {
        return join(fieldValues, ",");
    }

    private static String join(List<String> list, String delim)
    {

        StringBuilder sb = new StringBuilder();

        String loopDelim = "";

        for (String s : list)
        {

            sb.append(loopDelim);
            sb.append(s);

            loopDelim = delim;
        }

        return sb.toString();
    }
}
