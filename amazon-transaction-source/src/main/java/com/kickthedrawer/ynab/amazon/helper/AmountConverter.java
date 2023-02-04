package com.kickthedrawer.ynab.amazon.helper;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;

import com.opencsv.bean.AbstractBeanField;
import com.opencsv.exceptions.CsvConstraintViolationException;
import com.opencsv.exceptions.CsvDataTypeMismatchException;

public class AmountConverter extends AbstractBeanField<Float> {

    private static final Pattern AMOUNT_PATTERN = Pattern.compile("^\\$([0-9]+\\.[0-9]{2})");

    @Override
    public Object convert(String value) throws CsvDataTypeMismatchException, CsvConstraintViolationException {
        if (StringUtils.isNotBlank(value)) {
            Matcher matcher = AMOUNT_PATTERN.matcher(value);
            if(matcher.matches()) {
                String amountValue = matcher.group(1);
                return Float.parseFloat(amountValue);
            }
        }
        return 0.0f;
    }

}
