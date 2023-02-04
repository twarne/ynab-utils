package com.kickthedrawer.ynab.amazon.helper;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.lang3.StringUtils;

import com.opencsv.bean.AbstractBeanField;
import com.opencsv.exceptions.CsvConstraintViolationException;
import com.opencsv.exceptions.CsvDataTypeMismatchException;

public class LocalDateConverter extends AbstractBeanField<LocalDate> {
    
    @Override
    protected Object convert(String value) throws CsvDataTypeMismatchException, CsvConstraintViolationException {
        if (StringUtils.isNotBlank(value)) {
            if(StringUtils.trim(value).length() == 8) {
            return LocalDate.parse(StringUtils.trim(value), DateTimeFormatter.ofPattern("MM/dd/yy"));
            } else if(StringUtils.trim(value).length() == 19) {
                return LocalDate.from(LocalDateTime.parse(StringUtils.trim(value)));
            }
        }
        return null;
    }
}
