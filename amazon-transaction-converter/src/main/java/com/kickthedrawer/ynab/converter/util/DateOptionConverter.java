package com.kickthedrawer.ynab.converter.util;

import java.time.LocalDate;

import picocli.CommandLine.ITypeConverter;

public class DateOptionConverter implements ITypeConverter<LocalDate> {

    @Override
    public LocalDate convert(String value) throws Exception {
        return LocalDate.parse(value);
    }

}